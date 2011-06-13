package mave.minecraftjs.material;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_BlockFace;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.FurnaceAndDispenser;
import org.mozilla.javascript.*;

public class JS_FurnaceAndDispenser<D extends FurnaceAndDispenser> extends JS_MaterialData<D>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_FurnaceAndDispenser()
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
		return "FurnaceAndDispenser";
	}
	
	public Scriptable jsGet_facing()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getFacing(), cx, scope);
	}
	
	public final void jsSet_facingDirection(Scriptable facing)
	{
		if (!(facing instanceof JS_BlockFace))
		{
			throw new IllegalArgumentException();
		}
		JS_BlockFace face = (JS_BlockFace)facing;
		getDelegate().setFacingDirection(face.getDelegate());
	}
}
