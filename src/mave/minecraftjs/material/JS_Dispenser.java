package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.Dispenser;
import org.mozilla.javascript.*;

public class JS_Dispenser extends JS_FurnaceAndDispenser<Dispenser>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Dispenser()
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
		return "Dispenser";
	}
}
