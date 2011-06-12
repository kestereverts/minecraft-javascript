package mave.minecraftjs;

import org.bukkit.block.BlockState;
import org.mozilla.javascript.*;

public class JS_BlockState extends ScriptableObject
{
	private static final long serialVersionUID = 3946571721478265651L;
	public BlockState blockState = null;

	public JS_BlockState()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_BlockState.class, DONTENUM);
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
		return blockState.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "BlockState";
	}
	
	public Scriptable jsGet_block()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(blockState.getBlock(), cx, scope);
	}
	
	public Scriptable jsGet_chunk()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(blockState.getChunk(), cx, scope);
	}
	
	// TODO: jsGet_data
	
	public int jsGet_lightLevel()
	{
		return (int)blockState.getLightLevel();
	}
	
	public int jsGet_rawData()
	{
		return (int)blockState.getRawData();
	}
	
	public Scriptable jsGet_type()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(blockState.getType(), cx, scope);
	}
	
	public int jsGet_typeId()
	{
		return blockState.getTypeId();
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(blockState.getWorld(), cx, scope);
	}
	
	public int jsGet_x()
	{
		return blockState.getX();
	}
	
	public int jsGet_y()
	{
		return blockState.getY();
	}
	
	public int jsGet_z()
	{
		return blockState.getZ();
	}
	
	// TODO: jsSet_data
	
	public void jsSet_type(Scriptable material)
	{
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		
		blockState.setType(material_.material);
	}
	
	public void jsSet_typeId(int iTypeId)
	{
		blockState.setTypeId(iTypeId);
	}
	
	public static boolean jsFunction_update(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_BlockState caller = (JS_BlockState)thisObj;
		if (args.length < 1)
		{
			return caller.blockState.update();
		}
		
		return caller.blockState.update(Context.toBoolean(args[0]));
	}
}
