package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.DyeColor;
import org.bukkit.material.Dye;
import org.mozilla.javascript.*;

public class JS_Dye extends JS_MaterialData<Dye>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Dye()
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
		return "Dye";
	}

	public final String jsGet_color()
	{
		return getDelegate().getColor().toString().toLowerCase();
	}
	
	public final void jsSet_color(String sColor)
	{
		getDelegate().setColor(DyeColor.valueOf(sColor.toUpperCase()));
	}
}
