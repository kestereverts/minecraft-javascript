package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.CropState;
import org.bukkit.material.Crops;
import org.mozilla.javascript.*;

public class JS_Crops extends JS_MaterialData<Crops>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Crops()
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
		return "Crops";
	}
	
	@SuppressWarnings("deprecation")
	public final String jsGet_species()
	{
		return getDelegate().getSpecies().toString().toLowerCase();
	}
	
	public final String jsGet_state()
	{
		return getDelegate().getState().toString().toLowerCase();		
	}
	
	@SuppressWarnings("deprecation")
	public final void jsSet_species(String sSpecies)
	{
		getDelegate().setSpecies(CropState.valueOf(sSpecies.toUpperCase()));
	}

	public final void jsSet_state(String sState)
	{
		getDelegate().setState(CropState.valueOf(sState.toUpperCase()));
	}
}
