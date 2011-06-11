package mave.minecraftjs.events.entity;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_EntityTameEvent extends ScriptableObject
{
	private static final long serialVersionUID = 1982421503416472505L;
	public EntityTameEvent event = null;

	public JS_EntityTameEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_EntityTameEvent.class, DONTENUM);
	}
	
	public void jsConstructor() throws Error
	{
		if (!MinecraftJS.m_bInternalConstruction)
		{
			throw new Error("i am not to be constructed");
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
		return "EntityTameEvent";
	}
	
	public Scriptable jsGet_entity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
	}
	
	// NOTE: AnimalTamer.. Player?
	public Scriptable jsGet_owner()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable((Player)event.getOwner(), cx, scope);
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
