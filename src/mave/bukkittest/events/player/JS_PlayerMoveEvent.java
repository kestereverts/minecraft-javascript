package mave.bukkittest.events.player;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import mave.bukkittest.JS_Location;
import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerMoveEvent extends ScriptableObject
{
	private static final long serialVersionUID = -3305877575651918856L;
	public PlayerMoveEvent event = null;

	public JS_PlayerMoveEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerMoveEvent.class, DONTENUM);
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
		return "PlayerMoveEvent";
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
		
		event.setFrom(location.location);
	}
	
	public void jsSet_to(Scriptable to)
	{
		if (!(to instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)to;
		
		event.setTo(location.location);
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
}
