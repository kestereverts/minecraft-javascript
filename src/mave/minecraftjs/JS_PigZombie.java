package mave.minecraftjs;

import mave.minecraftjs.events.entity.JS_EntityDamageEvent;

import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.*;

public class JS_PigZombie extends ScriptableObject
{
	private static final long serialVersionUID = -6162219401777036269L;
	public PigZombie pigZombie = null;
	
	public JS_PigZombie()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PigZombie.class, DONTENUM);
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
		return pigZombie.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "PigZombie";
	}
	
	public java.util.UUID jsGet_uniqueId()
	{
		return pigZombie.getUniqueId();
	}
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_PigZombie caller = (JS_PigZombie)thisObj;
		
		if (args.length < 2)
		{
			caller.pigZombie.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.pigZombie.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		pigZombie.setVelocity(vector_.vector);
	}
	
	public int jsGet_health()
	{
		return pigZombie.getHealth();
	}
	
	public void jsSet_health(int iHealth)
	{
		pigZombie.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_PigZombie caller = (JS_PigZombie)thisObj;
		if (args.length < 1)
		{
			return caller.pigZombie.getEyeHeight();
		}
		return caller.pigZombie.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(pigZombie.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return pigZombie.isInsideVehicle();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return pigZombie.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return pigZombie.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		pigZombie.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return pigZombie.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		pigZombie.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return pigZombie.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		pigZombie.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return pigZombie.getLastDamage();
	}
	
	public Scriptable jsGet_lastDamageCause()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(pigZombie.getLastDamageCause(), cx, scope);		
	}
	
	public void jsSet_lastDamageCause(Scriptable cause)
	{
		if (!(cause instanceof JS_EntityDamageEvent))
		{
			throw new IllegalArgumentException();
		}
		JS_EntityDamageEvent event = (JS_EntityDamageEvent)cause;
		
		pigZombie.setLastDamageCause(event.event);
	}
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		pigZombie.setLastDamage(iLastDamage);
	}
	
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return pigZombie.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		pigZombie.setNoDamageTicks(iTicks);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_PigZombie caller = (JS_PigZombie)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.pigZombie.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.pigZombie.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_PigZombie caller = (JS_PigZombie)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.pigZombie.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.pigZombie.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_PigZombie caller = (JS_PigZombie)thisObj;
		
		return cx.newArray(thisObj, caller.pigZombie.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return pigZombie.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return pigZombie.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(pigZombie.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return pigZombie.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		pigZombie.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		pigZombie.remove();
	}
	
	public boolean jsGet_dead()
	{
		return pigZombie.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(pigZombie.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_target()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(pigZombie.getTarget(), cx, scope);
	}
	
	public void jsSet_target(Scriptable target)
	{
		Entity entity = ConvertUtility.scriptableToEntity(target);
		if (!(entity instanceof LivingEntity))
		{
			throw new IllegalArgumentException();
		}
		
		pigZombie.setTarget((LivingEntity)entity);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(pigZombie.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(pigZombie.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = pigZombie.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_PigZombie caller = (JS_PigZombie)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.pigZombie.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return pigZombie.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return pigZombie.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return pigZombie.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		pigZombie.setFallDistance(fFallDistance);
	}
}

