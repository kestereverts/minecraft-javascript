package mave.minecraftjs.events.player;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_Player;

import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerChatEvent extends ScriptableObject
{
	private static final long serialVersionUID = 2932953794008583258L;
	public PlayerChatEvent event = null;

	public JS_PlayerChatEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerChatEvent.class, DONTENUM);
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
		return "PlayerChatEvent";
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
