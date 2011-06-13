package mave.minecraftjs.entity;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.entity.Zombie;
import org.mozilla.javascript.Context;

public class JS_Zombie extends JS_Creature<Zombie>
{
	private static final long serialVersionUID = -7777689951607478459L;

	public JS_Zombie()
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
		return "Zombie";
	}
}

