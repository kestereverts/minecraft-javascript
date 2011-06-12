package mave.minecraftjs.events.block;

import mave.minecraftjs.MinecraftJS;
import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_ItemStack;
import mave.minecraftjs.JS_Vector;

import org.bukkit.event.block.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_BlockDispenseEvent extends ScriptableObject
{
	private static final long serialVersionUID = -6759827010454371377L;
	public BlockDispenseEvent event = null;

	public JS_BlockDispenseEvent()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_BlockDispenseEvent.class, DONTENUM);
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
		return "BlockDispenseEvent";
	}
	
	public Scriptable jsGet_block()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getBlock(), cx, scope);
	}
	
	public Scriptable jsGet_item()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getItem(), cx, scope);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(event.getVelocity(), cx, scope);
	}
	
	public boolean jsGet_cancelled()
	{
		return event.isCancelled();
	}
	
	public void jsSet_cancelled(boolean bCancelled)
	{
		event.setCancelled(bCancelled);
	}
	
	public void jsSet_item(Scriptable itemStack)
	{
		if (!(itemStack instanceof JS_ItemStack))
		{
			throw new IllegalArgumentException();
		}
		JS_ItemStack item_ = (JS_ItemStack)itemStack;
		
		event.setItem(item_.getDelegate());
	}
	
	public void jsSet_velocity(Scriptable velocity)
	{
		if (!(velocity instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector = (JS_Vector)velocity;
		
		event.setVelocity(vector.getDelegate());
	}
}
