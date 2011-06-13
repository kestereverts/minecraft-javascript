package mave.minecraftjs.material;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.Rails;
import org.mozilla.javascript.*;

public class JS_Rails<D extends Rails> extends JS_MaterialData<D>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Rails()
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
		return "Rails";
	}
	
	public Scriptable jsGet_direction()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getDirection(), cx, scope);
	}
	
	public boolean jsGet_curve()
	{
		return getDelegate().isCurve();
	}
	
	public final boolean jsGet_onSlope()
	{
		return getDelegate().isOnSlope();
	}
}
