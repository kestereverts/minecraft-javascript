package mave.minecraftjs;

import org.bukkit.Location;
import org.mozilla.javascript.*;

public class JS_Location extends ScriptableObject
{
	private static final long serialVersionUID = -3997078490396540883L;
	public Location location = null;

	public JS_Location()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Location.class, DONTENUM);
	}
	
	public static void jsConstructor(Context cx, Object[] args, Function ctorObj, boolean inNewExpr)
	{
		if (MinecraftJS.m_bInternalConstruction)
		{
			return;
		}
		JS_Location caller = (JS_Location)ctorObj;
		
		if (args.length < 4)
		{
			throw new IllegalArgumentException();
		}
		
		if (!(args[0] instanceof JS_World))
		{
			throw new IllegalArgumentException();
		}
		JS_World world = (JS_World)args[0];
		
		if (args.length < 6)
		{
			caller.location = new Location(world.world, Context.toNumber(args[1]), Context.toNumber(args[2]), Context.toNumber(args[3]));
		}
		else
		{
			caller.location = new Location(world.world, Context.toNumber(args[1]), Context.toNumber(args[2]), Context.toNumber(args[3]), (float)Context.toNumber(args[4]), (float)Context.toNumber(args[5]));
		}
	}
	
	@Override
	public String toString()
	{
		return location.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Location";
	}
	
	public double jsGet_x()
	{
		return location.getX();
	}
	
	public double jsGet_y()
	{
		return location.getY();
	}
	
	public double jsGet_z()
	{
		return location.getZ();
	}

	public float jsGet_yaw()
	{
		return location.getYaw();
	}
	
	public float jsGet_pitch()
	{
		return location.getPitch();
	}
	
	public int jsGet_blockX()
	{
		return location.getBlockX();
	}
	
	public int jsGet_blockY()
	{
		return location.getBlockY();
	}
	
	public int jsGet_blockZ()
	{
		return location.getBlockZ();
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(location.getWorld(), cx, scope);
	}
	
	public void jsSet_x(double x)
	{
		location.setX(x);
	}
	
	public void jsSet_y(double y)
	{
		location.setY(y);
	}
	
	public void jsSet_z(double z)
	{
		location.setZ(z);
	}

	public void jsSet_yaw(float yaw)
	{
		location.setYaw(yaw);
	}
	
	public void jsSet_pitch(float pitch)
	{
		location.setPitch(pitch);
	}
	
	public void jsSet_world(Scriptable world)
	{
		if (!(world instanceof JS_World))
		{
			throw new IllegalArgumentException();
		}
		
		JS_World world_ = (JS_World)world;
		location.setWorld(world_.world);
	}
}
