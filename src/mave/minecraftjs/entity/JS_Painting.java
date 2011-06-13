package mave.minecraftjs.entity;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.entity.Painting;
import org.mozilla.javascript.Context;

public class JS_Painting extends JS_Entity<Painting>
{
	private static final long serialVersionUID = -6825212931451891644L;
	
	public JS_Painting()
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
		return "Painting";
	}
}

