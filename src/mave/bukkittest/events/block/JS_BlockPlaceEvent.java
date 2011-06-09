package mave.bukkittest.events.block;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;

import org.bukkit.event.block.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_BlockPlaceEvent extends ScriptableObject
{
	private static final long serialVersionUID = -369836974953748476L;
	public BlockPlaceEvent event = null;

	public JS_BlockPlaceEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_BlockPlaceEvent.class, DONTENUM);
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
		return "BlockPlaceEvent";
	}
	
	public boolean jsGet_canBuild()
	{
		return event.canBuild();
	}
	
	public Scriptable jsGet_block()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlock(), cx, scope);
	}
	
	public Scriptable jsGet_blockAgainst()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlockAgainst(), cx, scope);
	}
	
	public Scriptable jsGet_blockPlaced()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlockPlaced(), cx, scope);
	}
	
	public Scriptable jsGet_itemInHand()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getItemInHand(), cx, scope);
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	// TODO: jsGet_blockReplacedState
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
	
	public void jsSet_canBuild(boolean bCanBuild)
	{
		event.setBuild(bCanBuild);
	}
}