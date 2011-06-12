package mave.minecraftjs.events.player;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_ItemStack;

import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerBucketEmptyEvent extends ScriptableObject
{
	private static final long serialVersionUID = -8416827062576193185L;
	public PlayerBucketEmptyEvent event = null;

	public JS_PlayerBucketEmptyEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerBucketEmptyEvent.class, DONTENUM);
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
		return "PlayerBucketEmptyEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	public Scriptable jsGet_blockClicked()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlockClicked(), cx, scope);
	}
	
	public Scriptable jsGet_blockFace()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlockFace(), cx, scope);
	}
	
	public Scriptable jsGet_bucket()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBucket(), cx, scope);
	}
	
	public Scriptable jsGet_itemStack()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getItemStack(), cx, scope);
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
	
	public void jsSet_itemStack(Scriptable itemStack)
	{
		if (!(itemStack instanceof JS_ItemStack))
		{
			throw new IllegalArgumentException();
		}
		JS_ItemStack itemStack_ = (JS_ItemStack)itemStack;
		
		event.setItemStack(itemStack_.getDelegate());
	}
}
