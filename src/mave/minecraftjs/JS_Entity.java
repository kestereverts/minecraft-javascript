package mave.minecraftjs;

import mave.minecraftjs.events.entity.JS_EntityDamageEvent;

import org.bukkit.entity.Entity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_Entity<D extends Entity> extends JS_Delegate<D>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Entity()
	{	
	}
	
	public void jsConstructor()
	{
		throw Context.reportRuntimeError("This internal class cannot be instantiated");
	}
	
	@Override
	public String getClassName()
	{
		return "Entity";
	}
	
	public final java.util.UUID jsGet_uniqueId()
	{
		return getDelegate().getUniqueId();
	}
	
	public final void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		getDelegate().setVelocity(vector_.getDelegate());
	}
	
	public final Scriptable jsGet_lastDamageCause()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getLastDamageCause(), cx, scope);		
	}
	
	public final void jsSet_lastDamageCause(Scriptable cause)
	{
		if (!(cause instanceof JS_EntityDamageEvent))
		{
			throw new IllegalArgumentException();
		}
		JS_EntityDamageEvent event = (JS_EntityDamageEvent)cause;
		
		getDelegate().setLastDamageCause(event.event);
	}
	
	@SuppressWarnings("unchecked")
	public final static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Entity<Entity> caller = (JS_Entity<Entity>)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.getDelegate().teleport(location.getDelegate());
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.getDelegate().teleport(entity);
	}
	
	@SuppressWarnings("unchecked")
	public final static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Entity<Entity> caller = (JS_Entity<Entity>)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.getDelegate().teleportTo(location.getDelegate());
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.getDelegate().teleportTo(entity);
	}
	
	@SuppressWarnings("unchecked")
	public final static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Entity<Entity> caller = (JS_Entity<Entity>)thisObj;
		
		return cx.newArray(thisObj, caller.getDelegate().getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public final int jsGet_entityId()
	{
		return getDelegate().getEntityId();
	}
	
	public final int jsGet_fireTicks()
	{
		return getDelegate().getFireTicks();
	}
	
	public final Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getLocation(), cx, scope);
	}
	
	public final int jsGet_maxFireTicks()
	{
		return getDelegate().getMaxFireTicks();
	}
	
	public final void jsSet_fireTicks(int iTicks)
	{
		getDelegate().setFireTicks(iTicks);
	}
	
	public final void jsFunction_remove()
	{
		getDelegate().remove();
	}
	
	public final boolean jsGet_dead()
	{
		return getDelegate().isDead();
	}
	
	public final Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getServer(), cx, scope);
	}
	
	public final Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getVelocity(), cx, scope);
	}
	
	public final Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getWorld(), cx, scope);
	}
	
	public final Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = getDelegate().getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	@SuppressWarnings("unchecked")
	public final static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Entity<Entity> caller = (JS_Entity<Entity>)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.getDelegate().setPassenger(entity);
	}
	
	public final boolean jsGet_empty()
	{
		return getDelegate().isEmpty();
	}
	
	public final boolean jsFunction_eject()
	{
		return getDelegate().eject();
	}
	
	public final float jsGet_fallDistance()
	{
		return getDelegate().getFallDistance();
	}
	
	public final void jsSet_fallDistance(float fFallDistance)
	{
		getDelegate().setFallDistance(fFallDistance);
	}
}
