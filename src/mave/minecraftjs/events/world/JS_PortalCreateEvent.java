package mave.minecraftjs.events.world;

import java.util.ArrayList;
import java.util.List;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;

import org.bukkit.block.Block;
import org.bukkit.event.world.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PortalCreateEvent extends ScriptableObject
{
	private static final long serialVersionUID = 4061069457734797449L;
	public PortalCreateEvent event = null;

	public JS_PortalCreateEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PortalCreateEvent.class, DONTENUM);
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
		return "PortalCreateEvent";
	}
	
	public Scriptable jsGet_blocks()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<Scriptable> lstBlocks = new ArrayList<Scriptable>();
		for (Block b : event.getBlocks())
		{
			lstBlocks.add(ConvertUtility.toScriptable(b, cx, scope));
		}
		return cx.newArray(scope, lstBlocks.toArray());
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getWorld(), cx, scope);
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
