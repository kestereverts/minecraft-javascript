package mave.bukkittest.events.player;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import org.bukkit.event.player.*;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerLoginEvent extends ScriptableObject
{
	private static final long serialVersionUID = 4588809060669013524L;
	public PlayerLoginEvent event = null;

	public JS_PlayerLoginEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerLoginEvent.class, DONTENUM);
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
		return "PlayerLoginEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	public String jsGet_kickMessage()
	{
		return event.getKickMessage();
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
		JS_PlayerLoginEvent caller = (JS_PlayerLoginEvent)thisObj;
		
		caller.event.disallow(Result.valueOf(Context.toString(args[0]).toUpperCase()), Context.toString(args[1]));
	}
}
