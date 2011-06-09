package mave.bukkittest.events.player;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerInventoryEvent extends ScriptableObject
{
	private static final long serialVersionUID = -8926251953497246283L;
	public PlayerInventoryEvent event = null;

	public JS_PlayerInventoryEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerInventoryEvent.class, DONTENUM);
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
		return "PlayerInventoryEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}

	// TODO: jsGet_inventory
}
