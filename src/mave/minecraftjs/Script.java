package mave.minecraftjs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import mave.minecraftjs.events.block.JS_BlockBreakEvent;
import mave.minecraftjs.events.block.JS_BlockBurnEvent;
import mave.minecraftjs.events.block.JS_BlockCanBuildEvent;
import mave.minecraftjs.events.block.JS_BlockDamageEvent;
import mave.minecraftjs.events.block.JS_BlockDispenseEvent;
import mave.minecraftjs.events.block.JS_BlockFromToEvent;
import mave.minecraftjs.events.block.JS_BlockIgniteEvent;
import mave.minecraftjs.events.block.JS_BlockPhysicsEvent;
import mave.minecraftjs.events.block.JS_BlockPlaceEvent;
import mave.minecraftjs.events.block.JS_BlockRedstoneEvent;
import mave.minecraftjs.events.block.JS_LeavesDecayEvent;
import mave.minecraftjs.events.block.JS_SignChangeEvent;
import mave.minecraftjs.events.block.JS_SnowFormEvent;
import mave.minecraftjs.events.entity.JS_CreatureSpawnEvent;
import mave.minecraftjs.events.entity.JS_CreeperPowerEvent;
import mave.minecraftjs.events.entity.JS_EntityCombustEvent;
import mave.minecraftjs.events.entity.JS_EntityDamageEvent;
import mave.minecraftjs.events.entity.JS_EntityDeathEvent;
import mave.minecraftjs.events.entity.JS_EntityExplodeEvent;
import mave.minecraftjs.events.entity.JS_EntityInteractEvent;
import mave.minecraftjs.events.entity.JS_EntityTargetEvent;
import mave.minecraftjs.events.entity.JS_ExplosionPrimeEvent;
import mave.minecraftjs.events.entity.JS_PaintingBreakEvent;
import mave.minecraftjs.events.entity.JS_PaintingPlaceEvent;
import mave.minecraftjs.events.entity.JS_PigZapEvent;
import mave.minecraftjs.events.player.JS_PlayerAnimationEvent;
import mave.minecraftjs.events.player.JS_PlayerBedEnterEvent;
import mave.minecraftjs.events.player.JS_PlayerBedLeaveEvent;
import mave.minecraftjs.events.player.JS_PlayerBucketEmptyEvent;
import mave.minecraftjs.events.player.JS_PlayerChatEvent;
import mave.minecraftjs.events.player.JS_PlayerCommandPreprocessEvent;
import mave.minecraftjs.events.player.JS_PlayerDropItemEvent;
import mave.minecraftjs.events.player.JS_PlayerEggThrowEvent;
import mave.minecraftjs.events.player.JS_PlayerInteractEntityEvent;
import mave.minecraftjs.events.player.JS_PlayerInventoryEvent;
import mave.minecraftjs.events.player.JS_PlayerItemHeldEvent;
import mave.minecraftjs.events.player.JS_PlayerJoinEvent;
import mave.minecraftjs.events.player.JS_PlayerKickEvent;
import mave.minecraftjs.events.player.JS_PlayerLoginEvent;
import mave.minecraftjs.events.player.JS_PlayerMoveEvent;
import mave.minecraftjs.events.player.JS_PlayerPickupItemEvent;
import mave.minecraftjs.events.player.JS_PlayerPreLoginEvent;
import mave.minecraftjs.events.player.JS_PlayerQuitEvent;
import mave.minecraftjs.events.player.JS_PlayerRespawnEvent;
import mave.minecraftjs.events.player.JS_PlayerTeleportEvent;
import mave.minecraftjs.events.player.JS_PlayerToggleSneakEvent;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class Script
{
	public JSGlobal m_jsGlobal = null;
	public Context m_scriptContext = null;
	public Scriptable m_globalScope = null;
	
	Script()
	{
		m_jsGlobal = new JSGlobal();
	}
	
	void load(File file) throws FileNotFoundException, IOException
	{
		m_scriptContext = Context.enter();
		MinecraftJS.m_currentScript = this;
		
		m_scriptContext.setLanguageVersion(Context.VERSION_1_8);
		m_globalScope = m_scriptContext.initStandardObjects(m_jsGlobal);
		
		m_jsGlobal.initializeFunctionProperties();
		try
		{
			ScriptableObject.defineClass(m_globalScope, JS_Server.class);
			ScriptableObject.defineClass(m_globalScope, JS_World.class);
			ScriptableObject.defineClass(m_globalScope, JS_Player.class);
			ScriptableObject.defineClass(m_globalScope, JS_Location.class);
			ScriptableObject.defineClass(m_globalScope, JS_PluginManager.class);
			ScriptableObject.defineClass(m_globalScope, JS_Material.class);
			ScriptableObject.defineClass(m_globalScope, JS_ItemStack.class);
			ScriptableObject.defineClass(m_globalScope, JS_Item.class);
			ScriptableObject.defineClass(m_globalScope, JS_Block.class);
			ScriptableObject.defineClass(m_globalScope, JS_Chunk.class);
			ScriptableObject.defineClass(m_globalScope, JS_Vector.class);
			
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
	
	void enterContext()
	{
		MinecraftJS.m_currentScript = this;
		ContextFactory.getGlobal();
	}
}
