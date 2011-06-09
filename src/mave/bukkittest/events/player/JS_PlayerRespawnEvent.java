package mave.bukkittest.events.player;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import mave.bukkittest.JS_Location;
import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerRespawnEvent extends ScriptableObject
{
	private static final long serialVersionUID = -8728754240246548851L;
	public PlayerRespawnEvent event = null;

	public JS_PlayerRespawnEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerRespawnEvent.class, DONTENUM);
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
		return "PlayerRespawnEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	public Scriptable jsGet_respawnLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getRespawnLocation(), cx, scope);
	}
	
	public void jsSet_respawnLocation(Scriptable respawnLocation)
	{
		if (!(respawnLocation instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)respawnLocation;
		
		event.setRespawnLocation(location.location);
	}
}
