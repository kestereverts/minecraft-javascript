package mave.minecraftjs;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.*;

public class JS_Creeper extends ScriptableObject
{
	private static final long serialVersionUID = 1642527063738339322L;
	public Creeper creeper = null;
	
	public JS_Creeper()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Creeper.class, DONTENUM);
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
		return creeper.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Creeper";
	}
	
	public java.util.UUID jsGet_uniqueId()
	{
		return creeper.getUniqueId();
	}
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Creeper caller = (JS_Creeper)thisObj;
		
		if (args.length < 2)
		{
			caller.creeper.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.creeper.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		creeper.setVelocity(vector_.vector);
	}
	
	public int jsGet_health()
	{
		return creeper.getHealth();
	}
	
	public void jsSet_health(int iHealth)
	{
		creeper.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Creeper caller = (JS_Creeper)thisObj;
		if (args.length < 1)
		{
			return caller.creeper.getEyeHeight();
		}
		return caller.creeper.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(creeper.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return creeper.isInsideVehicle();
	}
	
	public boolean jsGet_powered()
	{
		return creeper.isPowered();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return creeper.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return creeper.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		creeper.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return creeper.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		creeper.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return creeper.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		creeper.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return creeper.getLastDamage();
	}
	
	// TODO: jsGet_lastDamageCause
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		creeper.setLastDamage(iLastDamage);
	}
	
	// TODO: jsSet_lastDamageCause
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return creeper.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		creeper.setNoDamageTicks(iTicks);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Creeper caller = (JS_Creeper)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.creeper.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.creeper.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Creeper caller = (JS_Creeper)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.creeper.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.creeper.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Creeper caller = (JS_Creeper)thisObj;
		
		return cx.newArray(thisObj, caller.creeper.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return creeper.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return creeper.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(creeper.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return creeper.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		creeper.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		creeper.remove();
	}
	
	public boolean jsGet_dead()
	{
		return creeper.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(creeper.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_target()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(creeper.getTarget(), cx, scope);
	}
	
	public void jsSet_target(Scriptable target)
	{
		Entity entity = ConvertUtility.scriptableToEntity(target);
		if (!(entity instanceof LivingEntity))
		{
			throw new IllegalArgumentException();
		}
		
		creeper.setTarget((LivingEntity)entity);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(creeper.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(creeper.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = creeper.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Creeper caller = (JS_Creeper)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.creeper.setPassenger(entity);
	}
	
	public void jsSet_powered(boolean bPowered)
	{
		creeper.setPowered(bPowered);
	}
	
	public boolean jsGet_empty()
	{
		return creeper.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return creeper.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return creeper.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		creeper.setFallDistance(fFallDistance);
	}
}

