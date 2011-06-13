package mave.minecraftjs.entity;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.entity.Creeper;
import org.mozilla.javascript.Context;

public class JS_Creeper extends JS_Creature<Creeper>
{
	private static final long serialVersionUID = 1642527063738339322L;

	public JS_Creeper()
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
		return "Creeper";
	}

	public void jsSet_powered(boolean bPowered)
	{
		getDelegate().setPowered(bPowered);
	}
}

