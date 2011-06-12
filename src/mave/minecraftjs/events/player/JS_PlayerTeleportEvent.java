package mave.minecraftjs.events.player;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_Location;

import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerTeleportEvent extends ScriptableObject
{
	private static final long serialVersionUID = 7901015004585366120L;
	public PlayerTeleportEvent event = null;

	public JS_PlayerTeleportEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerTeleportEvent.class, DONTENUM);
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
		return "PlayerTeleportEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	public Scriptable jsGet_from()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getFrom(), cx, scope);
	}
	
	public Scriptable jsGet_to()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getTo(), cx, scope);
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_from(Scriptable from)
	{
		if (!(from instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)from;
		
		event.setFrom(location.getDelegate());
	}
	
	public void jsSet_to(Scriptable to)
	{
		if (!(to instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)to;
		
		event.setTo(location.getDelegate());
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
}
