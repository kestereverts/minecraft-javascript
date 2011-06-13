package mave.minecraftjs.material;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.Door;
import org.mozilla.javascript.*;

public class JS_Door extends JS_MaterialData<Door>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Door()
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
		return "Door";
	}

	public final Scriptable jsGet_hingeCorner()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getHingeCorner(), cx, scope);
	}
	
	public final boolean jsGet_open()
	{
		return getDelegate().isOpen();
	}
	
	public final boolean jsGet_topHalf()
	{
		return getDelegate().isTopHalf();
	}
}
