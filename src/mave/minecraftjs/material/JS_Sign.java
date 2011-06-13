package mave.minecraftjs.material;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_BlockFace;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.Sign;
import org.mozilla.javascript.*;

public class JS_Sign extends JS_MaterialData<Sign>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Sign()
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
		return "Sign";
	}

	public final Scriptable jsGet_attachedFace()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getAttachedFace(), cx, scope);
	}
	
	public final Scriptable jsGet_facing()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getFacing(), cx, scope);
	}
	
	public final boolean jsGet_wallSign()
	{
		return getDelegate().isWallSign();
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
