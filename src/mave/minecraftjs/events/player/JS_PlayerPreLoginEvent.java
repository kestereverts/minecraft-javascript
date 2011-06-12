package mave.minecraftjs.events.player;

import java.net.InetAddress;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.event.player.*;
import org.bukkit.event.player.PlayerPreLoginEvent.Result;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerPreLoginEvent extends ScriptableObject
{
	private static final long serialVersionUID = 5364723781689755029L;
	public PlayerPreLoginEvent event = null;

	public JS_PlayerPreLoginEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerPreLoginEvent.class, DONTENUM);
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
		return "PlayerPreLoginEvent";
	}
	
	public String jsGet_name()
	{
		return event.getName();
	}
	
	public String jsGet_kickMessage()
	{
		return event.getKickMessage();
	}
	
	public InetAddress jsGet_address()
	{
		return event.getAddress();
	}
	
	public String jsGet_result()
	{
		return event.getResult().toString().toLowerCase();
	}
	
	public void jsSet_kickMessage(String sMessage)
	{
		event.setKickMessage(sMessage);
	}
	
	public void jsSet_result(String sResult)
	{
		event.setResult(Result.valueOf(sResult.toUpperCase()));
	}
	
	public void jsFunction_allow()
	{
		event.allow();
	}
	
	public static void jsFunction_disallow(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_PlayerPreLoginEvent caller = (JS_PlayerPreLoginEvent)thisObj;
		
		caller.event.disallow(Result.valueOf(Context.toString(args[0]).toUpperCase()), Context.toString(args[1]));
	}
}
