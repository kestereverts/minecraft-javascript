package mave.minecraftjs;

import org.bukkit.entity.Spider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.*;

public class JS_Spider extends ScriptableObject
{
	private static final long serialVersionUID = -7023433934480942162L;
	public Spider spider = null;
	
	public JS_Spider()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Spider.class, DONTENUM);
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
		return spider.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Spider";
	}
	
	// TODO: jsGet_uniqueId
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Spider caller = (JS_Spider)thisObj;
		
		if (args.length < 2)
		{
			caller.spider.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.spider.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		spider.setVelocity(vector_.vector);
	}
	
	public int jsGet_health()
	{
		return spider.getHealth();
	}
	
	public void jsSet_health(int iHealth)
	{
		spider.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Spider caller = (JS_Spider)thisObj;
		if (args.length < 1)
		{
			return caller.spider.getEyeHeight();
		}
		return caller.spider.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(spider.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return spider.isInsideVehicle();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return spider.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return spider.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		spider.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return spider.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		spider.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return spider.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		spider.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return spider.getLastDamage();
	}
	
	// TODO: jsGet_lastDamageCause
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		spider.setLastDamage(iLastDamage);
	}
	
	// TODO: jsSet_lastDamageCause
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return spider.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		spider.setNoDamageTicks(iTicks);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Spider caller = (JS_Spider)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.spider.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.spider.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Spider caller = (JS_Spider)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.spider.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.spider.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Spider caller = (JS_Spider)thisObj;
		
		return cx.newArray(thisObj, caller.spider.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return spider.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return spider.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(spider.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return spider.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		spider.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		spider.remove();
	}
	
	public boolean jsGet_dead()
	{
		return spider.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(spider.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_target()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(spider.getTarget(), cx, scope);
	}
	
	public void jsSet_target(Scriptable target)
	{
		Entity entity = ConvertUtility.scriptableToEntity(target);
		if (!(entity instanceof LivingEntity))
		{
			throw new IllegalArgumentException();
		}
		
		spider.setTarget((LivingEntity)entity);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(spider.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(spider.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = spider.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Spider caller = (JS_Spider)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.spider.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return spider.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return spider.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return spider.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		spider.setFallDistance(fFallDistance);
	}
}

