package mave.minecraftjs.entity;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.entity.Slime;
import org.mozilla.javascript.Context;

public class JS_Slime extends JS_LivingEntity<Slime>
{
	private static final long serialVersionUID = -7511545792433451852L;

	public JS_Slime()
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
		return "Slime";
	}
	
	public int jsGet_size()
	{
		return getDelegate().getSize();
	}
	
	public void jsSet_size(int iSize)
	{
		getDelegate().setSize(iSize);
	}
}

