package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.DetectorRail;
import org.mozilla.javascript.*;

public class JS_DetectorRail<D extends DetectorRail> extends JS_ExtendedRails<D>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_DetectorRail()
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
		return "DetectorRail";
	}
	
	public final boolean jsGet_pressed()
	{
		return getDelegate().isPressed();
	}
}
