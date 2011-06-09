package mave.bukkittest.events.block;

import mave.bukkittest.BukkitTest;
import mave.bukkittest.ConvertUtility;
import mave.bukkittest.JS_Material;

import org.bukkit.event.block.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_SnowFormEvent extends ScriptableObject
{
	private static final long serialVersionUID = -2494103372237496359L;
	public SnowFormEvent event = null;

	public JS_SnowFormEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_SnowFormEvent.class, DONTENUM);
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
		return "SnowFormEvent";
	}
	
	public Scriptable jsGet_block()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlock(), cx, scope);
	}
	
	public int jsGet_data()
	{
		return (int)event.getData();
	}
	
	public Scriptable jsGet_material()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getMaterial(), cx, scope);
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
	
	public void jsSet_data(int iData)
	{
		event.setData((byte)iData);
	}
	
	public void jsSet_material(Scriptable material)
	{
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		
		event.setMaterial(material_.material);
	}
}
