package mave.minecraftjs.entity;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.entity.Ghast;
import org.mozilla.javascript.Context;

public class JS_Ghast extends JS_LivingEntity<Ghast>
{
	private static final long serialVersionUID = 2103388763706316682L;

	public JS_Ghast()
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
		return "Ghast";
	}
	
	
}

