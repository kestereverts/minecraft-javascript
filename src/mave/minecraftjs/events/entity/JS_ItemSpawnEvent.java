package mave.minecraftjs.events.entity;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;

import org.bukkit.event.entity.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_ItemSpawnEvent extends ScriptableObject
{
	private static final long serialVersionUID = 878225275493284476L;
	public ItemSpawnEvent event = null;

	public JS_ItemSpawnEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_ItemSpawnEvent.class, DONTENUM);
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
		return event.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "ItemSpawnEvent";
	}
	
	public Scriptable jsGet_entity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getLocation(), cx, scope);
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
}
