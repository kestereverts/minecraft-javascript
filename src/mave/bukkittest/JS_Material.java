package mave.bukkittest;

import org.bukkit.Material;
import org.mozilla.javascript.*;

public class JS_Material extends ScriptableObject
{
	private static final long serialVersionUID = 1425962778799611571L;
	public Material material = null;

	public JS_Material()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Material.class, DONTENUM);
	}
	
	public void jsConstructor(int iMaterialId)
	{
		if (BukkitTest.m_bInternalConstruction)
		{
			return;
		}
		
		material = Material.getMaterial(iMaterialId);
	}
	
	@Override
	public String toString()
	{
		return material.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Material";
	}
	
	public String jsGet_name()
	{
		return material.name();
	}
	
	public boolean jsGet_block()
	{
		return material.isBlock();
	}
	
	public int jsGet_id()
	{
		return material.getId();
	}
	
	public short jsGet_maxDurability()
	{
		return material.getMaxDurability();
	}
	
	public int jsGet_maxStackSize()
	{
		return material.getMaxStackSize();
	}
}
