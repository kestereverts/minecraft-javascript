package mave.bukkittest.events.player;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerKickEvent extends ScriptableObject
{
	private static final long serialVersionUID = 5441780929463808832L;
	public PlayerKickEvent event = null;

	public JS_PlayerKickEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerKickEvent.class, DONTENUM);
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
		return "PlayerKickEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	public String jsGet_leaveMessage()
	{
		return event.getLeaveMessage();
	}
	
	public String jsGet_reason()
	{
		return event.getReason();
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_leaveMessage(String sMessage)
	{
		event.setLeaveMessage(sMessage);
	}
	
	public void jsSet_reason(String sReason)
	{
		event.setReason(sReason);
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
}
