package mave.minecraftjs;

import mave.minecraftjs.events.entity.JS_EntityDamageEvent;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Painting;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.*;

public class JS_Painting extends ScriptableObject
{
	private static final long serialVersionUID = -6825212931451891644L;
	public Painting painting = null;
	
	public JS_Painting()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Painting.class, DONTENUM);
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
		return painting.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Painting";
	}
	
	public java.util.UUID jsGet_uniqueId()
	{
		return painting.getUniqueId();
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		painting.setVelocity(vector_.vector);
	}
	
	public Scriptable jsGet_lastDamageCause()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(painting.getLastDamageCause(), cx, scope);		
	}
	
	public void jsSet_lastDamageCause(Scriptable cause)
	{
		if (!(cause instanceof JS_EntityDamageEvent))
		{
			throw new IllegalArgumentException();
		}
		JS_EntityDamageEvent event = (JS_EntityDamageEvent)cause;
		
		painting.setLastDamageCause(event.event);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Painting caller = (JS_Painting)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.painting.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.painting.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Painting caller = (JS_Painting)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.painting.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.painting.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Painting caller = (JS_Painting)thisObj;
		
		return cx.newArray(thisObj, caller.painting.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return painting.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return painting.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(painting.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return painting.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		painting.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		painting.remove();
	}
	
	public boolean jsGet_dead()
	{
		return painting.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(painting.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(painting.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(painting.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = painting.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Painting caller = (JS_Painting)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.painting.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return painting.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return painting.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return painting.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		painting.setFallDistance(fFallDistance);
	}
}

