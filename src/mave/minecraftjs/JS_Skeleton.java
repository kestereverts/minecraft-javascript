package mave.minecraftjs;

import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.*;

public class JS_Skeleton extends ScriptableObject
{
	private static final long serialVersionUID = 4919154045823478334L;
	public Skeleton skeleton = null;
	
	public JS_Skeleton()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Skeleton.class, DONTENUM);
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
		return skeleton.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Skeleton";
	}
	
	public java.util.UUID jsGet_uniqueId()
	{
		return skeleton.getUniqueId();
	}
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Skeleton caller = (JS_Skeleton)thisObj;
		
		if (args.length < 2)
		{
			caller.skeleton.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.skeleton.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		skeleton.setVelocity(vector_.vector);
	}
	
	public int jsGet_health()
	{
		return skeleton.getHealth();
	}
	
	public void jsSet_health(int iHealth)
	{
		skeleton.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Skeleton caller = (JS_Skeleton)thisObj;
		if (args.length < 1)
		{
			return caller.skeleton.getEyeHeight();
		}
		return caller.skeleton.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(skeleton.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return skeleton.isInsideVehicle();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return skeleton.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return skeleton.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		skeleton.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return skeleton.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		skeleton.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return skeleton.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		skeleton.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return skeleton.getLastDamage();
	}
	
	// TODO: jsGet_lastDamageCause
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		skeleton.setLastDamage(iLastDamage);
	}
	
	// TODO: jsSet_lastDamageCause
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return skeleton.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		skeleton.setNoDamageTicks(iTicks);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Skeleton caller = (JS_Skeleton)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.skeleton.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.skeleton.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Skeleton caller = (JS_Skeleton)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.skeleton.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.skeleton.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Skeleton caller = (JS_Skeleton)thisObj;
		
		return cx.newArray(thisObj, caller.skeleton.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return skeleton.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return skeleton.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(skeleton.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return skeleton.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		skeleton.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		skeleton.remove();
	}
	
	public boolean jsGet_dead()
	{
		return skeleton.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(skeleton.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_target()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(skeleton.getTarget(), cx, scope);
	}
	
	public void jsSet_target(Scriptable target)
	{
		Entity entity = ConvertUtility.scriptableToEntity(target);
		if (!(entity instanceof LivingEntity))
		{
			throw new IllegalArgumentException();
		}
		
		skeleton.setTarget((LivingEntity)entity);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(skeleton.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(skeleton.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = skeleton.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Skeleton caller = (JS_Skeleton)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.skeleton.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return skeleton.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return skeleton.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return skeleton.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		skeleton.setFallDistance(fFallDistance);
	}
}

