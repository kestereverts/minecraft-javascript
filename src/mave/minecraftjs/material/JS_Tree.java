package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.TreeSpecies;
import org.bukkit.material.Tree;
import org.mozilla.javascript.*;

public class JS_Tree extends JS_MaterialData<Tree>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Tree()
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
		return "Tree";
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
