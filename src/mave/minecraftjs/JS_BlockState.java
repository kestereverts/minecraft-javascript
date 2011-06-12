package mave.minecraftjs;

import org.bukkit.block.BlockState;
import org.mozilla.javascript.*;

public class JS_BlockState extends JS_Delegate<BlockState>
{
	private static final long serialVersionUID = 3946571721478265651L;

	public JS_BlockState()
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
		return "BlockState";
	}
	
	public Scriptable jsGet_block()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getBlock(), cx, scope);
	}
	
	public Scriptable jsGet_chunk()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getChunk(), cx, scope);
	}
	
	// TODO: jsGet_data
	
	public int jsGet_lightLevel()
	{
		return (int)getDelegate().getLightLevel();
	}
	
	public int jsGet_rawData()
	{
		return (int)getDelegate().getRawData();
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
	
	// TODO: jsSet_data
	
	public void jsSet_type(Scriptable material)
	{
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		
		getDelegate().setType(material_.getDelegate());
	}
	
	public void jsSet_typeId(int iTypeId)
	{
		getDelegate().setTypeId(iTypeId);
	}
	
	public static boolean jsFunction_update(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_BlockState caller = (JS_BlockState)thisObj;
		if (args.length < 1)
		{
			return caller.getDelegate().update();
		}
		
		return caller.getDelegate().update(Context.toBoolean(args[0]));
	}
}
