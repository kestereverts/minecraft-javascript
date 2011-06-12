package mave.minecraftjs;

import org.bukkit.block.Block;
import org.mozilla.javascript.*;

public class JS_Block extends ScriptableObject
{
	private static final long serialVersionUID = -7163858349183207062L;
	public Block block = null;

	public JS_Block()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Block.class, DONTENUM);
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
		return block.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Block";
	}
	
	public int jsGet_blockPower()
	{
		return block.getBlockPower();
	}
	
	public static int jsFunction_getBlockPower(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Block caller = (JS_Block)thisObj;
		
		if (args.length < 1)
		{
			return caller.block.getBlockPower();
		}
		
		if (!(args[0] instanceof JS_BlockFace))
		{
			throw new IllegalArgumentException();
		}
		JS_BlockFace face = (JS_BlockFace)args[0];
		
		return caller.block.getBlockPower(face.blockFace);
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
			return ConvertUtility.toScriptable(caller.block.getFace(block.block), cx, thisObj);
		}
		else if (args[0] instanceof JS_BlockFace)
		{
			JS_BlockFace face = (JS_BlockFace)args[0];
			if (args.length < 2)
			{
				return ConvertUtility.toScriptable(caller.block.getFace(face.blockFace), cx, thisObj);
			}
			
			return ConvertUtility.toScriptable(caller.block.getFace(face.blockFace, (int)Context.toNumber(args[1])), cx, thisObj);
		}
		
		throw new IllegalArgumentException();
	}
	
	public int jsGet_lightLevel()
	{
		return block.getLightLevel();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(block.getLocation(), cx, scope);
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
			
			return ConvertUtility.toScriptable(caller.block.getRelative(face.blockFace), cx, thisObj);
		}
		
		return ConvertUtility.toScriptable(caller.block.getRelative((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2])), cx, thisObj);
	}
	
	public Scriptable jsGet_type()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(block.getType(), cx, scope);
	}
	
	public int jsGet_typeId()
	{
		return block.getTypeId();
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(block.getWorld(), cx, scope);
	}
	
	public int jsGet_x()
	{
		return block.getX();
	}
	
	public int jsGet_y()
	{
		return block.getY();
	}
	
	public int jsGet_z()
	{
		return block.getZ();
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
		
		return caller.block.isBlockFaceIndirectlyPowered(face.blockFace);
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
		
		return caller.block.isBlockFacePowered(face.blockFace);
	}
	
	public boolean jsGet_indirectlyPowered()
	{
		return block.isBlockIndirectlyPowered();
	}
	
	public boolean jsGet_powered()
	{
		return block.isBlockPowered();
	}
	
	public void jsSet_type(Scriptable material)
	{
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		
		block.setType(material_.material);
	}
}
