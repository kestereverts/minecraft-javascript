package mave.minecraftjs.material;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JSDelegate;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.MaterialData;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_MaterialData<D extends MaterialData> extends JSDelegate<D>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_MaterialData()
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
		return "MaterialData";
	}
	
	public final int jsGet_data()
	{
		return (int)getDelegate().getData();
	}
	
	public final Scriptable jsGet_itemType()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getItemType(), cx, scope);
	}
	
	public final int jsGet_itemTypeId()
	{
		return getDelegate().getItemTypeId();
	}
	
	public final void jsSet_data(int iData)
	{
		getDelegate().setData((byte)iData);
	}
	
	@SuppressWarnings("unchecked")
	public final static Scriptable jsFunction_toItemStack(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_MaterialData<MaterialData> caller = (JS_MaterialData<MaterialData>)thisObj;
		
		if (args.length < 1)
		{
			return ConvertUtility.toScriptable(caller.getDelegate().toItemStack(), cx, thisObj);
		}
		
		return ConvertUtility.toScriptable(caller.getDelegate().toItemStack((int)Context.toNumber(args[0])), cx, thisObj);
	}
}
