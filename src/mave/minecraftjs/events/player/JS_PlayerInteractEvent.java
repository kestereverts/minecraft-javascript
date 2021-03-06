package mave.minecraftjs.events.player;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;

import org.bukkit.event.Event.Result;
import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerInteractEvent extends ScriptableObject
{
	private static final long serialVersionUID = -7286927917313326106L;
	public PlayerInteractEvent event = null;

	public JS_PlayerInteractEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerInteractEvent.class, DONTENUM);
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
		return "PlayerInteractEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	public boolean jsGet_hasItem()
	{
		return event.hasItem();
	}
	
	public boolean jsGet_hasBlock()
	{
		return event.hasBlock();
	}
	
	public Scriptable jsGet_item()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getItem(), cx, scope);
	}
	
	public Scriptable jsGet_clickedBlock()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getClickedBlock(), cx, scope);
	}
	
	public Scriptable jsGet_blockFace()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlockFace(), cx, scope);
	}
	
	public Scriptable jsGet_material()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getMaterial(), cx, scope);
	}
	
	public boolean jsGet_blockInHand()
	{
		return event.isBlockInHand();
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public String jsGet_useInteractedBlock()
	{
		return event.useInteractedBlock().toString().toLowerCase();
	}
	
	public String jsGet_useItemInHand()
	{
		return event.useItemInHand().toString().toLowerCase();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
	
	public void jsSet_useInteractedBlock(String sUseInteractedBlock)
	{
		event.setUseInteractedBlock(Result.valueOf(sUseInteractedBlock.toUpperCase()));
	}
	
	public void jsSet_useItemInHand(String sUseItemInHand)
	{
		event.setUseItemInHand(Result.valueOf(sUseItemInHand.toUpperCase()));
	}
}
