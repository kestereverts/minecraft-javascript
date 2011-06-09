package mave.bukkittest.events.player;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import mave.bukkittest.JS_Player;

import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerCommandPreprocessEvent extends ScriptableObject
{
	private static final long serialVersionUID = 2798945334358577777L;
	public PlayerCommandPreprocessEvent event = null;

	public JS_PlayerCommandPreprocessEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerCommandPreprocessEvent.class, DONTENUM);
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
		return "PlayerCommandPreprocessEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	public String jsGet_format()
	{
		return event.getFormat();
	}
	
	public String jsGet_message()
	{
		return event.getMessage();
	}
	
	public Scriptable jsGet_recipients()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return cx.newArray(scope, event.getRecipients().toArray());		
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_player(Scriptable player)
	{
		if (!(player instanceof JS_Player))
		{
			throw new IllegalArgumentException();
		}
		JS_Player player_ = (JS_Player)player;
		
		event.setPlayer(player_.player);
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
	
	public void jsSet_format(String sFormat)
	{
		event.setFormat(sFormat);
	}
	
	public void jsSet_message(String sMessage)
	{
		event.setMessage(sMessage);
	}
}
