package mave.minecraftjs;

import java.io.File;

import org.bukkit.plugin.Plugin;
import org.mozilla.javascript.*;

public class JS_Plugin extends ScriptableObject
{
	private static final long serialVersionUID = -5012701233247549412L;
	public Plugin plugin = null;

	public JS_Plugin()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Plugin.class, DONTENUM);
	}
	
	public void jsConstructor()
	{
		if (!MinecraftJS.m_bInternalConstruction)
		{
			throw Context.reportRuntimeError("This internal class cannot be instantiated");
		}
	}
	
	@Override
	public String toString()
	{
		return plugin.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Plugin";
	}
	
	// TODO: jsGet_configuration
	// TODO: jsGet_database
	
	public File jsGet_dataFolder()
	{
		return plugin.getDataFolder();
	}
	
	// TODO: jsGet_description
	// TODO: jsGet_pluginLoader
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(plugin.getServer(), cx, scope);
	}
	
	public boolean jsGet_enabled()
	{
		return plugin.isEnabled();
	}
	
	public boolean jsGet_naggable()
	{
		return plugin.isNaggable();
	}
	
	// TODO: onCommand
	
	public void jsFunction_onEnable()
	{
		plugin.onEnable();
	}
	
	public void jsFunction_onDisable()
	{
		plugin.onDisable();
	}
	
	public void jsFunction_onLoad()
	{
		plugin.onLoad();
	}
	
	public void jsSet_naggable(boolean bNaggable)
	{
		plugin.setNaggable(bNaggable);
	}
}
