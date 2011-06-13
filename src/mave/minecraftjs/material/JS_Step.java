package mave.minecraftjs.material;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_Material;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.Step;
import org.mozilla.javascript.*;

public class JS_Step extends JS_MaterialData<Step>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Step()
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
		return "Step";
	}
	
	public final Scriptable jsGet_material()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getMaterial(), cx, scope);
	}
	
	public final void jsSet_material(Scriptable material)
	{
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		getDelegate().setMaterial(material_.getDelegate());
	}
}
