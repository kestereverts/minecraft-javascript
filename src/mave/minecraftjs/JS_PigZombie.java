package mave.minecraftjs;

import org.bukkit.entity.PigZombie;
import org.mozilla.javascript.Context;

public class JS_PigZombie extends JS_Creature<PigZombie>
{
	private static final long serialVersionUID = -6162219401777036269L;

	public JS_PigZombie()
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
		return "PigZombie";
	}
}

