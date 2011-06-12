package mave.minecraftjs;

import java.io.File;

import org.bukkit.plugin.Plugin;
import org.mozilla.javascript.*;

public class JS_Plugin extends JS_Delegate<Plugin>
{
	private static final long serialVersionUID = -5012701233247549412L;

	public JS_Plugin()
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
		return "Plugin";
	}
	
	// TODO: jsGet_configuration
	// TODO: jsGet_database
	
	public File jsGet_dataFolder()
	{
		return getDelegate().getDataFolder();
	}
	
	// TODO: jsGet_description
	// TODO: jsGet_pluginLoader
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getServer(), cx, scope);
	}
	
	public boolean jsGet_enabled()
	{
		return getDelegate().isEnabled();
	}
	
	public boolean jsGet_naggable()
	{
		return getDelegate().isNaggable();
	}
	
	// TODO: onCommand
	
	public void jsFunction_onEnable()
	{
		getDelegate().onEnable();
	}
	
	public void jsFunction_onDisable()
	{
		getDelegate().onDisable();
	}
	
	public void jsFunction_onLoad()
	{
		getDelegate().onLoad();
	}
	
	public void jsSet_naggable(boolean bNaggable)
	{
		getDelegate().setNaggable(bNaggable);
	}
}
