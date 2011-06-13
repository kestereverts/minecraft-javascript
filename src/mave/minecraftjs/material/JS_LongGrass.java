package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.GrassSpecies;
import org.bukkit.material.LongGrass;
import org.mozilla.javascript.*;

public class JS_LongGrass extends JS_MaterialData<LongGrass>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_LongGrass()
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
		return "LongGrass";
	}
	
	public final String jsGet_species()
	{
		return getDelegate().getSpecies().toString().toLowerCase();
	}
	
	public final void jsSet_species(String sSpecies)
	{
		getDelegate().setSpecies(GrassSpecies.valueOf(sSpecies.toUpperCase()));
	}
}
