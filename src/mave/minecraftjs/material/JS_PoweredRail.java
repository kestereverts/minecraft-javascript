package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.PoweredRail;
import org.mozilla.javascript.*;

public class JS_PoweredRail<D extends PoweredRail> extends JS_ExtendedRails<D>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_PoweredRail()
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
		return "PoweredRail";
	}
	
	public final boolean jsGet_powered()
	{
		return getDelegate().isPowered();
	}
	
	public final void jsSet_powered(boolean bPowered)
	{
		getDelegate().setPowered(bPowered);
	}
}
