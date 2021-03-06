package mave.minecraftjs.events.entity;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;

import org.bukkit.event.entity.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_EntityCombustEvent extends ScriptableObject
{
	private static final long serialVersionUID = -2300630319718369609L;
	public EntityCombustEvent event = null;

	public JS_EntityCombustEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_EntityCombustEvent.class, DONTENUM);
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
		return "EntityCombustEvent";
	}
	
	public Scriptable jsGet_entity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
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
