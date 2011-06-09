package mave.minecraftjs;

import org.bukkit.entity.Giant;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.*;

public class JS_Giant extends ScriptableObject
{
	private static final long serialVersionUID = -6521629923797126661L;
	public Giant giant = null;
	
	public JS_Giant()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Giant.class, DONTENUM);
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
		return giant.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Giant";
	}
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Giant caller = (JS_Giant)thisObj;
		
		if (args.length < 2)
		{
			caller.giant.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.giant.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		giant.setVelocity(vector_.vector);
	}
	
	public int jsGet_health()
	{
		return giant.getHealth();
	}
	
	public void jsSet_health(int iHealth)
	{
		giant.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Giant caller = (JS_Giant)thisObj;
		if (args.length < 1)
		{
			return caller.giant.getEyeHeight();
		}
		return caller.giant.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(giant.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return giant.isInsideVehicle();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return giant.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return giant.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		giant.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return giant.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		giant.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return giant.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		giant.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return giant.getLastDamage();
	}
	
	// TODO: jsGet_lastDamageCause
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		giant.setLastDamage(iLastDamage);
	}
	
	// TODO: jsSet_lastDamageCause
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return giant.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		giant.setNoDamageTicks(iTicks);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Giant caller = (JS_Giant)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.giant.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.giant.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Giant caller = (JS_Giant)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.giant.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.giant.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Giant caller = (JS_Giant)thisObj;
		
		return cx.newArray(thisObj, caller.giant.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return giant.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return giant.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(giant.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return giant.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		giant.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		giant.remove();
	}
	
	public boolean jsGet_dead()
	{
		return giant.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(giant.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_target()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(giant.getTarget(), cx, scope);
	}
	
	public void jsSet_target(Scriptable target)
	{
		Entity entity = ConvertUtility.scriptableToEntity(target);
		if (!(entity instanceof LivingEntity))
		{
			throw new IllegalArgumentException();
		}
		
		giant.setTarget((LivingEntity)entity);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(giant.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(giant.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = giant.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Giant caller = (JS_Giant)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.giant.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return giant.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return giant.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return giant.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		giant.setFallDistance(fFallDistance);
	}
}

