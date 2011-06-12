package mave.minecraftjs.events.player;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;

import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerItemHeldEvent extends ScriptableObject
{
	private static final long serialVersionUID = 2118862255947476005L;
	public PlayerItemHeldEvent event = null;

	public JS_PlayerItemHeldEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerItemHeldEvent.class, DONTENUM);
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
		return "PlayerItemHeldEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	public int jsGet_previousSlot()
	{
		return event.getPreviousSlot();
	}
	
	public int jsGet_newSlot()
	{
		return event.getNewSlot();
	}
}
