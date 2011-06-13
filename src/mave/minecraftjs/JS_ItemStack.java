package mave.minecraftjs;

import org.bukkit.inventory.ItemStack;
import org.mozilla.javascript.*;

public class JS_ItemStack extends JSDelegate<ItemStack>
{
	private static final long serialVersionUID = 8927586649880286359L;

	public JS_ItemStack()
	{
	}
	
	public void jsConstructor(Scriptable material, int iCount)
	{
		if (MinecraftJS.m_bInternalConstruction)
		{
			return;
		}
		
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		setDelegate(new ItemStack(material_.getDelegate(), iCount));
	}
	
	@Override
	public String getClassName()
	{
		return "ItemStack";
	}
	
	public int jsGet_amount()
	{
		return getDelegate().getAmount();
	}
	
	public int jsGet_durability()
	{
		return (int)getDelegate().getDurability();
	}
	
	public int jsGet_maxStackSize()
	{
		return getDelegate().getMaxStackSize();
	}
	
	public Scriptable jsGet_type()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getType(), cx, scope);
	}

	public int jsGet_typeId()
	{
		return getDelegate().getTypeId();
	}
	
	public void jsSet_amount(int iAmount)
	{
		getDelegate().setAmount(iAmount);
	}
	
	public void jsSet_durability(int iDurability)
	{
		getDelegate().setDurability((short)iDurability);
	}
	
	public void jsSet_type(Scriptable material)
	{
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		
		getDelegate().setType(material_.getDelegate());
	}
}
