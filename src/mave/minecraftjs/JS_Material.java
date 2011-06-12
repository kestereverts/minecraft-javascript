package mave.minecraftjs;

import org.bukkit.Material;

public class JS_Material extends JS_Delegate<Material>
{
	private static final long serialVersionUID = 1425962778799611571L;

	public JS_Material()
	{
	}
	
	public void jsConstructor(int iMaterialId)
	{
		if (MinecraftJS.m_bInternalConstruction)
		{
			return;
		}
		
		setDelegate(Material.getMaterial(iMaterialId));
	}
	
	@Override
	public String getClassName()
	{
		return "Material";
	}
	
	public String jsGet_name()
	{
		return getDelegate().name();
	}
	
	public boolean jsGet_block()
	{
		return getDelegate().isBlock();
	}
	
	public int jsGet_id()
	{
		return getDelegate().getId();
	}
	
	public short jsGet_maxDurability()
	{
		return getDelegate().getMaxDurability();
	}
	
	public int jsGet_maxStackSize()
	{
		return getDelegate().getMaxStackSize();
	}
}
