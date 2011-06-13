package mave.minecraftjs.material;

import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.Cake;
import org.mozilla.javascript.*;

public class JS_Cake extends JS_MaterialData<Cake>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Cake()
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
		return "Cake";
	}
	
	public final int jsGet_slicesEaten()
	{
		return getDelegate().getSlicesEaten();
	}
	
	public final int jsGet_slicesRemaining()
	{
		return getDelegate().getSlicesRemaining();
	}
	
	public final void jsSet_slicesEaten(int iSlices)
	{
		getDelegate().setSlicesEaten(iSlices);
	}
	
	public final void jsSet_slicesRemaining(int iSlices)
	{
		getDelegate().setSlicesRemaining(iSlices);
	}
}
