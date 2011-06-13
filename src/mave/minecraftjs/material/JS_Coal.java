package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.CoalType;
import org.bukkit.material.Coal;
import org.mozilla.javascript.*;

public class JS_Coal extends JS_MaterialData<Coal>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Coal()
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
		return "Coal";
	}
	
	public final String jsGet_type()
	{
		return getDelegate().getType().toString().toLowerCase();
	}
	
	public final void jsSet_type(String sType)
	{
		getDelegate().setType(CoalType.valueOf(sType.toUpperCase()));
	}
}
