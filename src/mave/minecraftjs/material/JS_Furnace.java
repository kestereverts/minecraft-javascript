package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.Furnace;
import org.mozilla.javascript.*;

public class JS_Furnace extends JS_FurnaceAndDispenser<Furnace>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Furnace()
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
		return "Furnace";
	}
}
