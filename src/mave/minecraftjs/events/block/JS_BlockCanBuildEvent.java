package mave.minecraftjs.events.block;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;

import org.bukkit.event.block.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_BlockCanBuildEvent extends ScriptableObject
{
	private static final long serialVersionUID = 4020060004343481991L;
	public BlockCanBuildEvent event = null;

	public JS_BlockCanBuildEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_BlockCanBuildEvent.class, DONTENUM);
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
		return event.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "BlockCanBuildEvent";
	}
	
	public Scriptable jsGet_block()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlock(), cx, scope);
	}
	
	public Scriptable jsGet_material()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getMaterial(), cx, scope);
	}
	
	public int jsGet_materialId()
	{
		return event.getMaterialId();
	}
	
	public boolean jsGet_buildable()
	{
		return event.isBuildable();
	}
	
	public void jsSet_buildable(boolean bBuildable)
	{
		event.setBuildable(bBuildable);
	}
}
