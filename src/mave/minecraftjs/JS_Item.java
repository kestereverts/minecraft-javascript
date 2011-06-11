package mave.minecraftjs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.mozilla.javascript.*;

public class JS_Item extends ScriptableObject
{
	private static final long serialVersionUID = 4601241001478987302L;
	public Item item = null;
	
	public JS_Item()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Item.class, DONTENUM);
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
		return item.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Item";
	}
	
	public java.util.UUID jsGet_uniqueId()
	{
		return item.getUniqueId();
	}
	
	public Scriptable jsGet_itemStack()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(item.getItemStack(), cx, scope);
	}
	
	public void jsSet_itemStack(Scriptable itemStack)
	{
		if (!(itemStack instanceof JS_ItemStack))
		{
			throw new IllegalArgumentException();
		}
		JS_ItemStack itemStack_ = (JS_ItemStack)itemStack;
		
		item.setItemStack(itemStack_.itemStack);
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Item caller = (JS_Item)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.item.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.item.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Item caller = (JS_Item)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.item.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.item.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Item caller = (JS_Item)thisObj;
		
		return cx.newArray(thisObj, caller.item.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return item.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return item.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(item.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return item.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		item.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		item.remove();
	}
	
	public boolean jsGet_dead()
	{
		return item.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(item.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(item.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(item.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = item.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Item caller = (JS_Item)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.item.setPassenger(entity);
	}
	
	public void jsSet_velocity(Scriptable velocity)
	{
		if (!(velocity instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector = (JS_Vector)velocity;
		
		item.setVelocity(vector.vector);
	}
	
	public boolean jsGet_empty()
	{
		return item.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return item.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return item.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		item.setFallDistance(fFallDistance);
	}
}

