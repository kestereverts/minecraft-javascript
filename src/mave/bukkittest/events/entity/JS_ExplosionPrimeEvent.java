package mave.bukkittest.events.entity;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import org.bukkit.event.entity.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_ExplosionPrimeEvent extends ScriptableObject
{
	private static final long serialVersionUID = -7365322135350234374L;
	public ExplosionPrimeEvent event = null;

	public JS_ExplosionPrimeEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_ExplosionPrimeEvent.class, DONTENUM);
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
		return "ExplosionPrimeEvent";
	}
	
	public Scriptable jsGet_entity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
	}
	
	public boolean jsGet_fire()
	{
		return event.getFire();
	}
	
	public float jsGet_radius()
	{
		return event.getRadius();
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
	
	public void jsSet_fire(boolean bFire)
	{
		event.setFire(bFire);
	}
	
	public void jsSet_radius(float fRadius)
	{
		event.setRadius(fRadius);
	}
}
