package mave.minecraftjs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import mave.minecraftjs.events.block.*;
import mave.minecraftjs.events.entity.*;
import mave.minecraftjs.events.player.*;

import org.mozilla.javascript.*;

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
