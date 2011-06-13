package mave.minecraftjs.entity;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_ItemStack;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.entity.Item;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_Item extends JS_Entity<Item>
{
	private static final long serialVersionUID = 4601241001478987302L;

	public JS_Item()
	{
	}
	
	public void jsConstructor()
	{
		if (!MinecraftJS.m_bInternalConstruction)
		{
			throw Context.reportRuntimeError("This internal class cannot be instantiated");
		}
	}

	@Override
	public String getClassName()
	{
		return "Item";
	}
	
	public Scriptable jsGet_itemStack()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getItemStack(), cx, scope);
	}
	
	public void jsSet_itemStack(Scriptable itemStack)
	{
		if (!(itemStack instanceof JS_ItemStack))
		{
			throw new IllegalArgumentException();
		}
		JS_ItemStack itemStack_ = (JS_ItemStack)itemStack;
		
		getDelegate().setItemStack(itemStack_.getDelegate());
	}
}

