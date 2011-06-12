package mave.minecraftjs.events.entity;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.event.painting.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PaintingBreakEvent extends ScriptableObject
{
	private static final long serialVersionUID = -2002579394380518546L;
	public PaintingBreakEvent event = null;

	public JS_PaintingBreakEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PaintingBreakEvent.class, DONTENUM);
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
		return "PaintingBreakEvent";
	}
	
	public String jsGet_cause()
	{
		return event.getCause().toString().toLowerCase();
	}
	
	public Scriptable jsGet_painting()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPainting(), cx, scope);
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
}
