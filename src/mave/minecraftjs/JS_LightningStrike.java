package mave.minecraftjs;

import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Entity;
import org.mozilla.javascript.*;

public class JS_LightningStrike extends ScriptableObject
{
	private static final long serialVersionUID = -5849434430974260998L;
	public LightningStrike strike = null;
	
	public JS_LightningStrike()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_LightningStrike.class, DONTENUM);
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
		return strike.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "LightningStrike";
	}
	
	// TODO: jsGet_uniqueId
	
	public boolean jsGet_effect()
	{
		return strike.isEffect();
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_LightningStrike caller = (JS_LightningStrike)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.strike.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.strike.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_LightningStrike caller = (JS_LightningStrike)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.strike.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.strike.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_LightningStrike caller = (JS_LightningStrike)thisObj;
		
		return cx.newArray(thisObj, caller.strike.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return strike.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return strike.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(strike.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return strike.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		strike.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		strike.remove();
	}
	
	public boolean jsGet_dead()
	{
		return strike.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(strike.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(strike.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(strike.getWorld(), cx, scope);
	}
	
	public void jsSet_velocity(Scriptable velocity)
	{
		if (!(velocity instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector = (JS_Vector)velocity;
		
		strike.setVelocity(vector.vector);
	}
	
	public boolean jsGet_empty()
	{
		return strike.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return strike.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return strike.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		strike.setFallDistance(fFallDistance);
	}
}

