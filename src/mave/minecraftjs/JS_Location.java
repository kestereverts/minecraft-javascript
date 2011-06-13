package mave.minecraftjs;

import org.bukkit.Location;
import org.mozilla.javascript.*;

public class JS_Location extends JSDelegate<Location>
{
	private static final long serialVersionUID = -3997078490396540883L;

	public JS_Location()
	{
	}
	
	public static Scriptable jsConstructor(Context cx, Object[] args, Function ctorObj, boolean inNewExpr)
	{
		if (MinecraftJS.m_bInternalConstruction)
		{
			return new JS_Location();
		}
		
		if (args.length < 4)
		{
			throw new IllegalArgumentException();
		}
		
		if (!(args[0] instanceof JS_World))
		{
			throw new IllegalArgumentException();
		}
		
		JS_Location location = new JS_Location();
		JS_World world = (JS_World)args[0];
		
		if (args.length < 6)
		{
			location.setDelegate(new Location(world.getDelegate(), Context.toNumber(args[1]), Context.toNumber(args[2]), Context.toNumber(args[3])));
		}
		else
		{
			location.setDelegate(new Location(world.getDelegate(), Context.toNumber(args[1]), Context.toNumber(args[2]), Context.toNumber(args[3]), (float)Context.toNumber(args[4]), (float)Context.toNumber(args[5])));
		}
		
		return location;
	}
	
	@Override
	public String getClassName()
	{
		return "Location";
	}
	
	public double jsGet_x()
	{
		return getDelegate().getX();
	}
	
	public double jsGet_y()
	{
		return getDelegate().getY();
	}
	
	public double jsGet_z()
	{
		return getDelegate().getZ();
	}

	public float jsGet_yaw()
	{
		return getDelegate().getYaw();
	}
	
	public float jsGet_pitch()
	{
		return getDelegate().getPitch();
	}
	
	public int jsGet_blockX()
	{
		return getDelegate().getBlockX();
	}
	
	public int jsGet_blockY()
	{
		return getDelegate().getBlockY();
	}
	
	public int jsGet_blockZ()
	{
		return getDelegate().getBlockZ();
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getWorld(), cx, scope);
	}
	
	public void jsSet_x(double x)
	{
		getDelegate().setX(x);
	}
	
	public void jsSet_y(double y)
	{
		getDelegate().setY(y);
	}
	
	public void jsSet_z(double z)
	{
		getDelegate().setZ(z);
	}

	public void jsSet_yaw(float yaw)
	{
		getDelegate().setYaw(yaw);
	}
	
	public void jsSet_pitch(float pitch)
	{
		getDelegate().setPitch(pitch);
	}
	
	public void jsSet_world(Scriptable world)
	{
		if (!(world instanceof JS_World))
		{
			throw new IllegalArgumentException();
		}
		
		JS_World world_ = (JS_World)world;
		getDelegate().setWorld(world_.getDelegate());
	}
	
	public static Scriptable jsFunction_add(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Location caller = (JS_Location)thisObj;
		
		if (args.length < 3)
		{
			if (!(args[0] instanceof JS_Location))
			{
				throw new IllegalArgumentException();
			}
			JS_Location other = (JS_Location)args[0];
			
			return ConvertUtility.toScriptable(caller.getDelegate().add(other.getDelegate()), cx, thisObj);
		}
		
		return ConvertUtility.toScriptable(caller.getDelegate().add(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])), cx, thisObj);
	}
	
	public static Scriptable jsFunction_subtract(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Location caller = (JS_Location)thisObj;
		
		if (args.length < 3)
		{
			if (!(args[0] instanceof JS_Location))
			{
				throw new IllegalArgumentException();
			}
			JS_Location other = (JS_Location)args[0];
			
			return ConvertUtility.toScriptable(caller.getDelegate().subtract(other.getDelegate()), cx, thisObj);
		}
		
		return ConvertUtility.toScriptable(caller.getDelegate().subtract(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])), cx, thisObj);
	}
	
	public double jsGet_length()
	{
		return getDelegate().length();
	}
	
	public double jsGet_lengthSquared()
	{
		return getDelegate().lengthSquared();
	}
	
	public static double jsFunction_distance(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Location caller = (JS_Location)thisObj;
		
		if (!(args[0] instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location other = (JS_Location)args[0];
		
		return caller.getDelegate().distance(other.getDelegate());
	}
	
	public static double jsFunction_distanceSquared(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Location caller = (JS_Location)thisObj;
		
		if (!(args[0] instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location other = (JS_Location)args[0];
		
		return caller.getDelegate().distanceSquared(other.getDelegate());
	}
	
	public static Scriptable jsFunction_multiply(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Location caller = (JS_Location)thisObj;
		
		return ConvertUtility.toScriptable(caller.getDelegate().multiply(Context.toNumber(args[0])), cx, thisObj);
	}
	
	public Scriptable jsFunction_zero()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().zero(), cx, scope);
	}
}
