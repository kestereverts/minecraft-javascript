package mave.minecraftjs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.world.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class JSWorldListener extends WorldListener
{
	private EventRegistration m_eventRegistration = null;
	
	public JSWorldListener(EventRegistration eventRegistration)
	{
		m_eventRegistration = eventRegistration;
	}
	
	@Override
	public void onChunkLoad(ChunkLoadEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.CHUNK_LOAD)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			Scriptable chunk = ConvertUtility.toScriptable(event.getChunk(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world, chunk } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onChunkUnload(ChunkUnloadEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.CHUNK_UNLOAD)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			Scriptable chunk = ConvertUtility.toScriptable(event.getChunk(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world, chunk } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onPortalCreate(PortalCreateEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.PORTAL_CREATE)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			
			List<Scriptable> lstBlocks = new ArrayList<Scriptable>();
			for (Block b : event.getBlocks())
			{
				lstBlocks.add(ConvertUtility.toScriptable(b, cx, scope));
			}
			Scriptable blocks = cx.newArray(scope, lstBlocks.toArray());
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world, blocks } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onSpawnChange(SpawnChangeEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.SPAWN_CHANGE)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			Scriptable previousLocation = ConvertUtility.toScriptable(event.getPreviousLocation(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world, previousLocation } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onWorldInit(WorldInitEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.WORLD_INIT)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world } );
			globalScope.delete("_event");
		}
	}
	
	/*@Override
	public void onWorldLoad(WorldEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.WORLD_LOAD)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world } );
			globalScope.delete("_event");
		}
	}*/
	
	@Override
	public void onWorldLoad(WorldLoadEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.WORLD_LOAD)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onWorldSave(WorldSaveEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.WORLD_SAVE)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onWorldUnload(WorldUnloadEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.WORLD_UNLOAD)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable world = ConvertUtility.toScriptable(event.getWorld(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { world } );
			globalScope.delete("_event");
		}
	}
}