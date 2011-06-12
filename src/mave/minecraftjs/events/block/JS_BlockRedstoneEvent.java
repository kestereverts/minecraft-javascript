package mave.minecraftjs.events.block;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;

import org.bukkit.event.block.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_BlockRedstoneEvent extends ScriptableObject
{
	private static final long serialVersionUID = 865298270004148382L;
	public BlockRedstoneEvent event = null;

	public JS_BlockRedstoneEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_BlockRedstoneEvent.class, DONTENUM);
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
		return event.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "BlockRedstoneEvent";
	}
	
	public Scriptable jsGet_block()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlock(), cx, scope);
	}
	
	public int jsGet_newCurrent()
	{
		return event.getNewCurrent();
	}
	
	public int jsGet_oldCurrent()
	{
		return event.getOldCurrent();
	}
	
	public void jsSet_newCurrent(int iCurrent)
	{
		event.setNewCurrent(iCurrent);
	}
}
