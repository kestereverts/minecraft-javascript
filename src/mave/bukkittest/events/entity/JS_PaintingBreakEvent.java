package mave.bukkittest.events.entity;

import mave.bukkittest.BukkitTest;
import org.bukkit.event.painting.*;
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
	
	public void jsConstructor() throws Error
	{
		if (!BukkitTest.m_bInternalConstruction)
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
		return "PaintingBreakEvent";
	}
	
	public String jsGet_cause()
	{
		return event.getCause().toString().toLowerCase();
	}
	
	// TODO: jsGet_painting
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
}
