package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.TreeSpecies;
import org.bukkit.material.Leaves;
import org.mozilla.javascript.*;

public class JS_Leaves extends JS_MaterialData<Leaves>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Leaves()
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
		return "Leaves";
	}
	
	public final String jsGet_species()
	{
		return getDelegate().getSpecies().toString().toLowerCase();
	}
	
	public final void jsSet_species(String sSpecies)
	{
		getDelegate().setSpecies(TreeSpecies.valueOf(sSpecies.toUpperCase()));
	}
}
