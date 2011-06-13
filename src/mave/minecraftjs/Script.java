package mave.minecraftjs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mave.minecraftjs.entity.JS_Creeper;
import mave.minecraftjs.entity.JS_Ghast;
import mave.minecraftjs.entity.JS_Giant;
import mave.minecraftjs.entity.JS_Item;
import mave.minecraftjs.entity.JS_LightningStrike;
import mave.minecraftjs.entity.JS_Painting;
import mave.minecraftjs.entity.JS_PigZombie;
import mave.minecraftjs.entity.JS_Player;
import mave.minecraftjs.entity.JS_Skeleton;
import mave.minecraftjs.entity.JS_Slime;
import mave.minecraftjs.entity.JS_Spider;
import mave.minecraftjs.entity.JS_Zombie;
import mave.minecraftjs.events.block.*;
import mave.minecraftjs.events.entity.*;
import mave.minecraftjs.events.player.*;
import mave.minecraftjs.events.world.*;

import mave.minecraftjs.material.*;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.*;
import org.mozilla.javascript.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

public class Script
{
	public JSGlobal m_jsGlobal = null;
	public Context m_scriptContext = null;
	public Scriptable m_globalScope = null;
	
	public List<JSCommandHandler> m_lstCommandHandlers = new ArrayList<JSCommandHandler>();
	
	Script()
	{
		m_jsGlobal = new JSGlobal();
	}
	
	@SuppressWarnings("unchecked")
	public void load(File file) throws FileNotFoundException, IOException, InvalidDescriptionException
	{
		m_scriptContext = Context.enter();
		MinecraftJS.m_currentScript = this;
		
		m_scriptContext.setLanguageVersion(Context.VERSION_1_8);
		m_globalScope = m_scriptContext.initStandardObjects(m_jsGlobal);
		
		String sRawName = file.getName();
		int idx = sRawName.lastIndexOf('.');
		if (idx != -1)
		{
			sRawName = sRawName.substring(0, idx);
		}
		
		try
		{
			Yaml yaml = new Yaml(new SafeConstructor());
			Map<String, Object> map = (Map<String, Object>)yaml.load(new FileReader(new File("plugins/", sRawName + ".yml")));
			String name = map.get("name").toString();
			if (!name.matches("^[A-Za-z0-9 _.-]+$"))
			{
				throw new InvalidDescriptionException("Invalid plugin name");
			}
			if (map.containsKey("commands"))
			{
				Map<String, Map<String, Object>> cmds = (Map<String, Map<String, Object>>)map.get("commands");
				if (cmds != null)
				{
					for (Entry<String, Map<String, Object>> entry : cmds.entrySet())
					{
						Command newCmd = new JSCommand(entry.getKey(), this);
						Object description = entry.getValue().get("description");
						Object usage = entry.getValue().get("usage");
						Object aliases = entry.getValue().get("aliases");
	
						if (description != null)
						{
							newCmd.setDescription(description.toString());
						}
	
						if (usage != null)
						{
							newCmd.setUsage(usage.toString());
						}
	
						if (aliases != null)
						{						   
							List<String> aliasList = new ArrayList<String>();
	
							if (aliases instanceof List)
							{
								for (Object o : (List<Object>) aliases)
								{
									aliasList.add(o.toString());
								}
							}
							else
							{
								aliasList.add(aliases.toString());
							}
	
							newCmd.setAliases(aliasList);
						}
	
						try
						{
							MinecraftJS.m_singleton.addCommand(newCmd);
						}
						catch (SecurityException e)
						{
							e.printStackTrace();
						}
						catch (IllegalArgumentException e)
						{
							e.printStackTrace();
						}
						catch (ClassNotFoundException e)
						{
							e.printStackTrace();
						}
						catch (NoSuchFieldException e)
						{
							e.printStackTrace();
						}
						catch (IllegalAccessException e)
						{
							e.printStackTrace();
						}
						catch (InstantiationException e)
						{
							e.printStackTrace();
						}
						catch (InvocationTargetException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
		}
		catch (FileNotFoundException ex)
		{
			throw new InvalidDescriptionException("Plugin description file not found (plugins/" + sRawName + ".yml)");
		}
		
		m_jsGlobal.initializeFunctionProperties();
		try
		{
			ScriptableObject.defineClass(m_globalScope, JS_Player.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Creeper.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Ghast.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Giant.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_PigZombie.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Skeleton.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Slime.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Spider.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Zombie.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Item.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_LightningStrike.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Painting.class, false, true);
			
			ScriptableObject.defineClass(m_globalScope, JS_Bed.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Button.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Cake.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Coal.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Crops.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_DetectorRail.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Diode.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Dispenser.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Door.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Dye.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_ExtendedRails.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Furnace.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Jukebox.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Ladder.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Leaves.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Lever.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_LongGrass.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_MaterialData.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_PoweredRail.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_PressurePlate.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Pumpkin.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Rails.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_RedstoneTorch.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_RedstoneWire.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Sign.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Stairs.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Step.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Torch.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_TrapDoor.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Tree.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Wool.class, false, true);
			
			ScriptableObject.defineClass(m_globalScope, JS_Server.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_World.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Location.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_PluginManager.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Material.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_ItemStack.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Block.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_BlockFace.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_BlockState.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Chunk.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Vector.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_ConsoleCommandSender.class, false, true);
			ScriptableObject.defineClass(m_globalScope, JS_Plugin.class, false, true);
			
			ScriptableObject.defineClass(m_globalScope, JS_PlayerAnimationEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerBedEnterEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerBedLeaveEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerBucketEmptyEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerChatEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerCommandPreprocessEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerDropItemEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerEggThrowEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerInteractEntityEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerInventoryEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerItemHeldEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerJoinEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerKickEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerLoginEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerMoveEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerPickupItemEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerPreLoginEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerQuitEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerRespawnEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerTeleportEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PlayerToggleSneakEvent.class);
			
			ScriptableObject.defineClass(m_globalScope, JS_BlockBreakEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockBurnEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockCanBuildEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockDamageEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockDispenseEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockFromToEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockIgniteEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockPhysicsEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockPlaceEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_BlockRedstoneEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_LeavesDecayEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_SignChangeEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_SnowFormEvent.class);
			
			ScriptableObject.defineClass(m_globalScope, JS_CreatureSpawnEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_CreeperPowerEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_EntityCombustEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_EntityDamageEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_EntityDeathEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_EntityExplodeEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_EntityInteractEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_EntityTargetEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_ExplosionPrimeEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PaintingBreakEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PaintingPlaceEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PigZapEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_EntityPortalEnterEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_EntityTameEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_ItemSpawnEvent.class);
			
			ScriptableObject.defineClass(m_globalScope, JS_ChunkLoadEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_ChunkUnloadEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_PortalCreateEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_SpawnChangeEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_WorldInitEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_WorldLoadEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_WorldSaveEvent.class);
			ScriptableObject.defineClass(m_globalScope, JS_WorldUnloadEvent.class);
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		m_scriptContext.evaluateReader(m_globalScope, reader, file.getName(), 1, null);
	}
	
	public void enterContext()
	{
		MinecraftJS.m_currentScript = this;
		ContextFactory.getGlobal().enterContext(m_scriptContext);
	}
	
	public boolean handleCommand(CommandSender commandSender, JSCommand command, String commandLabel, String[] args)
	{
		boolean bHandled = false;
		enterContext();
		
		for (JSCommandHandler h : m_lstCommandHandlers)
		{
			if (h.m_sCommand.equalsIgnoreCase(command.getName()))
			{
				Scriptable scope = h.m_scriptFunction.getParentScope();
				
				Scriptable sender = null;
				if (commandSender instanceof Player)
				{
					sender = ConvertUtility.toScriptable((Player)commandSender, m_scriptContext, scope);
				}
				else if (commandSender instanceof ConsoleCommandSender)
				{
					sender = ConvertUtility.toScriptable((ConsoleCommandSender)commandSender, m_scriptContext, scope);
				}
				
				// TODO: _command
				Object[] argss = new Object[args.length + 1];
				argss[0] = sender;
				for (int i = 0; i < args.length; ++i)
				{
					argss[i + 1] = args[i];
				}
				h.m_scriptFunction.call(m_scriptContext, m_globalScope, scope, argss);
				
				bHandled = true;
			}
		}
		return bHandled;
	}
}
