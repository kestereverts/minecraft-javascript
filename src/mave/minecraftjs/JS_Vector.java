package mave.minecraftjs;

import org.bukkit.util.Vector;
import org.mozilla.javascript.*;

public class JS_Vector extends JS_Delegate<Vector>
{
	private static final long serialVersionUID = -2515348271765295694L;

	public JS_Vector()
	{
	}
	
	public static void jsConstructor(Context cx, Object[] args, Function ctorObj, boolean inNewExp)
	{
		if (MinecraftJS.m_bInternalConstruction)
		{
			return;
		}
		
		JS_Vector caller = (JS_Vector)ctorObj;
		
		if (args.length < 3)
		{
			caller.setDelegate(new Vector());
		}
		else
		{
			caller.setDelegate(new Vector(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])));
		}
	}
	
	@Override
	public String getClassName()
	{
		return "Vector";
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

	public double jsGet_length()
	{
		return getDelegate().length();
	}
	
	public double jsGet_lengthSquared()
	{
		return getDelegate().lengthSquared();
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
	
	public static Scriptable jsFunction_add(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return ConvertUtility.toScriptable(caller.getDelegate().add(otherVector.getDelegate()), cx, thisObj);
	}
	
	public static Scriptable jsFunction_subtract(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return ConvertUtility.toScriptable(caller.getDelegate().subtract(otherVector.getDelegate()), cx, thisObj);
	}
	
	public static Scriptable jsFunction_multiply(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			return ConvertUtility.toScriptable(caller.getDelegate().multiply(Context.toNumber(args[0])), cx, thisObj);
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return ConvertUtility.toScriptable(caller.getDelegate().multiply(otherVector.getDelegate()), cx, thisObj);
	}
	
	public static Scriptable jsFunction_divide(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return ConvertUtility.toScriptable(caller.getDelegate().divide(otherVector.getDelegate()), cx, thisObj);
	}
	
	public static float jsFunction_angle(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return caller.getDelegate().angle(otherVector.getDelegate());
	}
	
	public Scriptable jsFunction_clone()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().clone(), cx, scope);
	}
	
	public static Scriptable jsFunction_copy(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return ConvertUtility.toScriptable(caller.getDelegate().copy(otherVector.getDelegate()), cx, thisObj);
	}
	
	public static Scriptable jsFunction_crossProduct(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return ConvertUtility.toScriptable(caller.getDelegate().crossProduct(otherVector.getDelegate()), cx, thisObj);
	}
	
	public static double jsFunction_distance(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return caller.getDelegate().distance(otherVector.getDelegate());
	}
	
	public static double jsFunction_distanceSquared(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return caller.getDelegate().distanceSquared(otherVector.getDelegate());
	}
	
	public static double jsFunction_dot(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return caller.getDelegate().dot(otherVector.getDelegate());
	}
	
	public static Scriptable jsFunction_midpoint(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return ConvertUtility.toScriptable(caller.getDelegate().getMidpoint(otherVector.getDelegate()), cx, thisObj);
	}
	
	public static boolean jsFunction_isInAABB(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector) || !(args[1] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		JS_Vector otherVector2 = (JS_Vector)args[1];
		
		return caller.getDelegate().isInAABB(otherVector.getDelegate(), otherVector2.getDelegate());
	}
	
	public static boolean jsFunction_isInSphere(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector otherVector = (JS_Vector)args[0];
		
		return caller.getDelegate().isInSphere(otherVector.getDelegate(), Context.toNumber(args[1]));
	}
	
	public Scriptable jsFunction_normalize()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().normalize(), cx, scope);
	}
	
	public static Scriptable jsFunction_toLocation(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Vector caller = (JS_Vector)thisObj;
		
		if (!(args[0] instanceof JS_World))
		{
			throw new IllegalArgumentException();
		}
		JS_World world = (JS_World)args[0];
		
		if (args.length < 3)
		{
			return ConvertUtility.toScriptable(caller.getDelegate().toLocation(world.getDelegate()), cx, thisObj);
		}
		
		return ConvertUtility.toScriptable(caller.getDelegate().toLocation(world.getDelegate(), (float)Context.toNumber(args[1]), (float)Context.toNumber(args[2])), cx, thisObj);
	}
	
	public Scriptable jsFunction_zero()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().zero(), cx, scope);
	}
}
