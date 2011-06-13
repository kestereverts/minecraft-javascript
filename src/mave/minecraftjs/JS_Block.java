package mave.minecraftjs;

import org.bukkit.block.Block;
import org.mozilla.javascript.*;

public class JS_Block extends JSDelegate<Block>
{
	private static final long serialVersionUID = -7163858349183207062L;

	public JS_Block()
	{
	}
	
	
	public void jsConstructor()
	{
		if (!MinecraftJS.m_bInternalConstruction)
		{
			throw Context.reportRuntimeError("This internal class cannot be instantiated");
		}
	}
	
	@Override
	public String getClassName()
	{
		return "Block";
	}
	
	public int jsGet_blockPower()
	{
		return getDelegate().getBlockPower();
	}
	
	public static int jsFunction_getBlockPower(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Block caller = (JS_Block)thisObj;
		
		if (args.length < 1)
		{
			return caller.getDelegate().getBlockPower();
		}
		
		if (!(args[0] instanceof JS_BlockFace))
		{
			throw new IllegalArgumentException();
		}
		JS_BlockFace face = (JS_BlockFace)args[0];
		
		return caller.getDelegate().getBlockPower(face.getDelegate());
	}
	
	public static Scriptable jsFunction_getFace(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Block caller = (JS_Block)thisObj;
		
		if (args[0] instanceof JS_Block)
		{
			JS_Block block = (JS_Block)args[0];
			return ConvertUtility.toScriptable(caller.getDelegate().getFace(block.getDelegate()), cx, thisObj);
		}
		else if (args[0] instanceof JS_BlockFace)
		{
			JS_BlockFace face = (JS_BlockFace)args[0];
			if (args.length < 2)
			{
				return ConvertUtility.toScriptable(caller.getDelegate().getFace(face.getDelegate()), cx, thisObj);
			}
			
			return ConvertUtility.toScriptable(caller.getDelegate().getFace(face.getDelegate(), (int)Context.toNumber(args[1])), cx, thisObj);
		}
		
		throw new IllegalArgumentException();
	}
	
	public int jsGet_lightLevel()
	{
		return getDelegate().getLightLevel();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getLocation(), cx, scope);
	}
	
	public static Scriptable jsFunction_getRelative(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Block caller = (JS_Block)thisObj;
		
		if (args.length < 3)
		{
			if (!(args[0] instanceof JS_BlockFace))
			{
				throw new IllegalArgumentException();
			}
			JS_BlockFace face = (JS_BlockFace)args[0];
			
			return ConvertUtility.toScriptable(caller.getDelegate().getRelative(face.getDelegate()), cx, thisObj);
		}
		
		return ConvertUtility.toScriptable(caller.getDelegate().getRelative((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2])), cx, thisObj);
	}
	
	public Scriptable jsGet_state()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getState(), cx, scope);
	}
	
	public Scriptable jsGet_type()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getType(), cx, scope);
	}
	
	public int jsGet_typeId()
	{
		return getDelegate().getTypeId();
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getWorld(), cx, scope);
	}
	
	public int jsGet_x()
	{
		return getDelegate().getX();
	}
	
	public int jsGet_y()
	{
		return getDelegate().getY();
	}
	
	public int jsGet_z()
	{
		return getDelegate().getZ();
	}
	
	public static boolean jsFunction_isBlockFaceIndirectlyPowered(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Block caller = (JS_Block)thisObj;
		
		if (!(args[0] instanceof JS_BlockFace))
		{
			throw new IllegalArgumentException();
		}
		JS_BlockFace face = (JS_BlockFace)args[0];
		
		return caller.getDelegate().isBlockFaceIndirectlyPowered(face.getDelegate());
	}
	
	public static boolean jsFunction_isBlockFacePowered(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Block caller = (JS_Block)thisObj;
		
		if (!(args[0] instanceof JS_BlockFace))
		{
			throw new IllegalArgumentException();
		}
		JS_BlockFace face = (JS_BlockFace)args[0];
		
		return caller.getDelegate().isBlockFacePowered(face.getDelegate());
	}
	
	public boolean jsGet_indirectlyPowered()
	{
		return getDelegate().isBlockIndirectlyPowered();
	}
	
	public boolean jsGet_powered()
	{
		return getDelegate().isBlockPowered();
	}
	
	public void jsSet_type(Scriptable material)
	{
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		
		getDelegate().setType(material_.getDelegate());
	}
}
