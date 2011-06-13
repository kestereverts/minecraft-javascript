package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.RedstoneTorch;
import org.mozilla.javascript.*;

public class JS_RedstoneTorch extends JS_Torch<RedstoneTorch>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_RedstoneTorch()
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
		return "RedstoneTorch";
	}

	public final boolean jsGet_powered()
	{
		return getDelegate().isPowered();
	}
}
