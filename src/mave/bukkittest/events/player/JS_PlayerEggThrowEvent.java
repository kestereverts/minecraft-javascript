package mave.bukkittest.events.player;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import org.bukkit.entity.CreatureType;
import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_PlayerEggThrowEvent extends ScriptableObject
{
	private static final long serialVersionUID = 7840419276127369793L;
	public PlayerEggThrowEvent event = null;

	public JS_PlayerEggThrowEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_PlayerEggThrowEvent.class, DONTENUM);
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
		return "PlayerEggThrowEvent";
	}
	
	public Scriptable jsGet_player()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
	}
	
	// TODO: jsGet_egg

	public boolean jsGet_hatching()
	{
		return event.isHatching();
	}
	
	public int jsGet_numHatches()
	{
		return (int)event.getNumHatches();
	}
	
	public String jsGet_hatchType()
	{
		return event.getHatchType().toString().toLowerCase();
	}
	
	public void jsSet_hatching(boolean bHatching)
	{
		event.setHatching(bHatching);
	}
	
	public void jsSet_numHatches(int iNumHatches)
	{
		event.setNumHatches((byte)iNumHatches);
	}
	
	public void jsSet_hatchType(String sHatchType)
	{
		event.setHatchType(CreatureType.valueOf(sHatchType.toUpperCase()));
	}
}
