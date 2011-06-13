package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.RedstoneWire;
import org.mozilla.javascript.*;

public class JS_RedstoneWire extends JS_MaterialData<RedstoneWire>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_RedstoneWire()
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
		return "RedstoneWire";
	}
	
	public final boolean jsGet_powered()
	{
		return getDelegate().isPowered();
	}
}
