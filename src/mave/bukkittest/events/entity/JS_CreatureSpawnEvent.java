package mave.bukkittest.events.entity;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import org.bukkit.event.entity.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_CreatureSpawnEvent extends ScriptableObject
{
	private static final long serialVersionUID = -7146681493407653079L;
	public CreatureSpawnEvent event = null;

	public JS_CreatureSpawnEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_CreatureSpawnEvent.class, DONTENUM);
	}
	
	public void jsConstructor() throws Error
	{
		if (!BukkitTest.m_bInternalConstruction)
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
		return "CreatureSpawnEvent";
	}
	
	public String jsGet_creatureType()
	{
		return event.getCreatureType().toString();
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
