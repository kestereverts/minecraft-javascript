package mave.minecraftjs;

import mave.minecraftjs.events.entity.JS_EntityDamageEvent;

import org.bukkit.entity.Ghast;
import org.bukkit.entity.Entity;
import org.mozilla.javascript.*;

public class JS_Ghast extends ScriptableObject
{
	private static final long serialVersionUID = 2103388763706316682L;
	public Ghast ghast = null;
	
	public JS_Ghast()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Ghast.class, DONTENUM);
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
		return ghast.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Ghast";
	}
	
	public java.util.UUID jsGet_uniqueId()
	{
		return ghast.getUniqueId();
	}
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Ghast caller = (JS_Ghast)thisObj;
		
		if (args.length < 2)
		{
			caller.ghast.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.ghast.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		ghast.setVelocity(vector_.vector);
	}
	
	public int jsGet_health()
	{
		return ghast.getHealth();
	}
	
	public void jsSet_health(int iHealth)
	{
		ghast.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Ghast caller = (JS_Ghast)thisObj;
		if (args.length < 1)
		{
			return caller.ghast.getEyeHeight();
		}
		return caller.ghast.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(ghast.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return ghast.isInsideVehicle();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return ghast.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return ghast.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		ghast.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return ghast.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		ghast.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return ghast.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		ghast.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return ghast.getLastDamage();
	}
	
	public Scriptable jsGet_lastDamageCause()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(ghast.getLastDamageCause(), cx, scope);		
	}
	
	public void jsSet_lastDamageCause(Scriptable cause)
	{
		if (!(cause instanceof JS_EntityDamageEvent))
		{
			throw new IllegalArgumentException();
		}
		JS_EntityDamageEvent event = (JS_EntityDamageEvent)cause;
		
		ghast.setLastDamageCause(event.event);
	}
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		ghast.setLastDamage(iLastDamage);
	}
	
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return ghast.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		ghast.setNoDamageTicks(iTicks);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Ghast caller = (JS_Ghast)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.ghast.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.ghast.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Ghast caller = (JS_Ghast)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.ghast.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.ghast.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Ghast caller = (JS_Ghast)thisObj;
		
		return cx.newArray(thisObj, caller.ghast.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return ghast.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return ghast.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(ghast.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return ghast.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		ghast.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		ghast.remove();
	}
	
	public boolean jsGet_dead()
	{
		return ghast.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(ghast.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(ghast.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(ghast.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = ghast.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Ghast caller = (JS_Ghast)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.ghast.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return ghast.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return ghast.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return ghast.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		ghast.setFallDistance(fFallDistance);
	}
}

