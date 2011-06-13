package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.PressurePlate;
import org.mozilla.javascript.*;

public class JS_PressurePlate extends JS_MaterialData<PressurePlate>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_PressurePlate()
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
		return "PressurePlate";
	}
	
	public final boolean jsGet_pressed()
	{
		return getDelegate().isPressed();
	}
}
