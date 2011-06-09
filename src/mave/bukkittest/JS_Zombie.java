package mave.bukkittest;

import org.bukkit.entity.Zombie;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.*;

public class JS_Zombie extends ScriptableObject
{
	private static final long serialVersionUID = -7777689951607478459L;
	public Zombie zombie = null;
	
	public JS_Zombie()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Zombie.class, DONTENUM);
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
		return zombie.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Zombie";
	}
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Zombie caller = (JS_Zombie)thisObj;
		
		if (args.length < 2)
		{
			caller.zombie.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.zombie.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		zombie.setVelocity(vector_.vector);
	}
	
	public int jsGet_health()
	{
		return zombie.getHealth();
	}
	
	public void jsSet_health(int iHealth)
	{
		zombie.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Zombie caller = (JS_Zombie)thisObj;
		if (args.length < 1)
		{
			return caller.zombie.getEyeHeight();
		}
		return caller.zombie.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(zombie.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return zombie.isInsideVehicle();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return zombie.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return zombie.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		zombie.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return zombie.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		zombie.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return zombie.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		zombie.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return zombie.getLastDamage();
	}
	
	// TODO: jsGet_lastDamageCause
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		zombie.setLastDamage(iLastDamage);
	}
	
	// TODO: jsSet_lastDamageCause
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return zombie.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		zombie.setNoDamageTicks(iTicks);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Zombie caller = (JS_Zombie)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.zombie.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.zombie.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Zombie caller = (JS_Zombie)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.zombie.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.zombie.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Zombie caller = (JS_Zombie)thisObj;
		
		return cx.newArray(thisObj, caller.zombie.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return zombie.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return zombie.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(zombie.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return zombie.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		zombie.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		zombie.remove();
	}
	
	public boolean jsGet_dead()
	{
		return zombie.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(zombie.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_target()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(zombie.getTarget(), cx, scope);
	}
	
	public void jsSet_target(Scriptable target)
	{
		Entity entity = ConvertUtility.scriptableToEntity(target);
		if (!(entity instanceof LivingEntity))
		{
			throw new IllegalArgumentException();
		}
		
		zombie.setTarget((LivingEntity)entity);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(zombie.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(zombie.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = zombie.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Zombie caller = (JS_Zombie)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.zombie.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return zombie.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return zombie.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return zombie.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		zombie.setFallDistance(fFallDistance);
	}
}

