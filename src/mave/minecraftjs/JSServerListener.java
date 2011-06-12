package mave.minecraftjs;

import org.bukkit.event.Event;
import org.bukkit.event.server.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class JSServerListener extends ServerListener
{
	private EventRegistration m_eventRegistration = null;
	
	public JSServerListener(EventRegistration eventRegistration)
	{
		m_eventRegistration = eventRegistration;
	}
	
	@Override
	public void onPluginDisable(PluginDisableEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.PLUGIN_DISABLE)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable plugin = ConvertUtility.toScriptable(event.getPlugin(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { plugin } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onPluginEnable(PluginEnableEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.PLUGIN_ENABLE)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			Scriptable plugin = ConvertUtility.toScriptable(event.getPlugin(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { plugin } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onServerCommand(ServerCommandEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.SERVER_COMMAND)
		{
			m_eventRegistration.m_script.enterContext();
			Context cx = Context.getCurrentContext();
			Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
			
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { } );
			globalScope.delete("_event");
		}
	}
}