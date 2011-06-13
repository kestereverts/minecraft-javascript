package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.ExtendedRails;
import org.mozilla.javascript.*;

public class JS_ExtendedRails<D extends ExtendedRails> extends JS_Rails<D>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_ExtendedRails()
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
		return "ExtendedRails";
	}
	
	public final boolean jsGet_curve()
	{
		return getDelegate().isCurve();
	}
}
