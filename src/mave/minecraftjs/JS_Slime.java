package mave.minecraftjs;

import mave.minecraftjs.events.entity.JS_EntityDamageEvent;

import org.bukkit.entity.Slime;
import org.bukkit.entity.Entity;
import org.mozilla.javascript.*;

public class JS_Slime extends ScriptableObject
{
	private static final long serialVersionUID = -7511545792433451852L;
	public Slime slime = null;
	
	public JS_Slime()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Slime.class, DONTENUM);
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
		return slime.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Slime";
	}
	
	public java.util.UUID jsGet_uniqueId()
	{
		return slime.getUniqueId();
	}
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Slime caller = (JS_Slime)thisObj;
		
		if (args.length < 2)
		{
			caller.slime.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.slime.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		slime.setVelocity(vector_.vector);
	}
	
	public int jsGet_health()
	{
		return slime.getHealth();
	}
	
	public void jsSet_health(int iHealth)
	{
		slime.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Slime caller = (JS_Slime)thisObj;
		if (args.length < 1)
		{
			return caller.slime.getEyeHeight();
		}
		return caller.slime.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(slime.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return slime.isInsideVehicle();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return slime.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return slime.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		slime.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return slime.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		slime.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return slime.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		slime.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return slime.getLastDamage();
	}
	
	public Scriptable jsGet_lastDamageCause()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(slime.getLastDamageCause(), cx, scope);		
	}
	
	public void jsSet_lastDamageCause(Scriptable cause)
	{
		if (!(cause instanceof JS_EntityDamageEvent))
		{
			throw new IllegalArgumentException();
		}
		JS_EntityDamageEvent event = (JS_EntityDamageEvent)cause;
		
		slime.setLastDamageCause(event.event);
	}
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		slime.setLastDamage(iLastDamage);
	}
	
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return slime.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		slime.setNoDamageTicks(iTicks);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Slime caller = (JS_Slime)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.slime.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.slime.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Slime caller = (JS_Slime)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.slime.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.slime.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Slime caller = (JS_Slime)thisObj;
		
		return cx.newArray(thisObj, caller.slime.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return slime.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return slime.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(slime.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return slime.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		slime.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		slime.remove();
	}
	
	public boolean jsGet_dead()
	{
		return slime.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(slime.getServer(), cx, scope);
	}
	
	public int jsGet_size()
	{
		return slime.getSize();
	}
	
	public void jsSet_size(int iSize)
	{
		slime.setSize(iSize);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(slime.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(slime.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = slime.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Slime caller = (JS_Slime)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.slime.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return slime.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return slime.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return slime.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		slime.setFallDistance(fFallDistance);
	}
}

