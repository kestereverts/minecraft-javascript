package mave.minecraftjs.entity;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.entity.Spider;
import org.mozilla.javascript.Context;

public class JS_Spider extends JS_Creature<Spider>
{
	private static final long serialVersionUID = -7023433934480942162L;
	
	public JS_Spider()
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
		return "Spider";
	}
}

