package mave.minecraftjs;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.mozilla.javascript.*;

public class JS_PluginManager extends JS_Delegate<PluginManager>
{
	private static final long serialVersionUID = 7329123953244324368L;

	public JS_PluginManager()
	{
	}
	
	public void jsConstructor()
	{
		if (!MinecraftJS.m_bInternalConstruction)
		{
			throw Context.reportRuntimeError("This internal class cannot be instantiated");
		}
	}

	@Override
	public String getClassName()
	{
		return "PluginManager";
	}
	
	public void jsFunction_clearPlugins()
	{
		getDelegate().clearPlugins();
	}
	
	public void jsFunction_disablePlugins()
	{
		getDelegate().disablePlugins();
	}
	
	public static boolean jsFunction_isPluginEnabled(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_PluginManager caller = (JS_PluginManager)thisObj;
		
		return caller.getDelegate().isPluginEnabled(Context.toString(args[0]));
	}
	
	public static void jsFunction_registerEvent(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		
		if (!(args[1] instanceof Function))
		{
			throw new IllegalArgumentException("second argument isnt a function");
		}
		JS_PluginManager caller = (JS_PluginManager)thisObj;
		
		String sEvent = Context.toString(args[0]).toLowerCase();
		int idx = sEvent.indexOf('_');
		if (idx == -1)
		{
			throw new IllegalArgumentException("1");
		}
		
		String category = sEvent.substring(0, idx);
		
		if (category.length() == 0)
		{
			throw new IllegalArgumentException("2");
		}

		EventRegistration reg = new EventRegistration();
		if (category.equals("block"))
		{
			reg.m_listener = new JSBlockListener(reg);
		}
		else if (category.equals("player"))
		{
			reg.m_listener = new JSPlayerListener(reg);
		}
		else if (category.equals("entity"))
		{
			reg.m_listener = new JSEntityListener(reg);
		}
		else if (category.equals("world"))
		{
			reg.m_listener = new JSWorldListener(reg);
		}
		else
		{
			throw new IllegalArgumentException(category);
		}
		Event.Type event = EventRegistration.stringToEventType(sEvent);
		Priority priority = args.length >= 3 ? EventRegistration.stringToPriority(Context.toString(args[2])) : Priority.Normal;
		
		reg.m_script = MinecraftJS.m_currentScript;
		reg.m_eventType = event;
		reg.m_priority = priority;
		reg.m_scriptFunction = (Function)args[1];
		
		//BukkitTest.m_lstEventRegistrations.add(reg);
		
		caller.getDelegate().registerEvent(event, reg.m_listener, priority, MinecraftJS.m_singleton);
	}
}
