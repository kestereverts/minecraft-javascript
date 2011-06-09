package mave.minecraftjs;

import org.bukkit.inventory.ItemStack;
import org.mozilla.javascript.*;

public class JS_ItemStack extends ScriptableObject
{
	private static final long serialVersionUID = 8927586649880286359L;
	public ItemStack itemStack = null;

	public JS_ItemStack()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_ItemStack.class, DONTENUM);
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
		itemStack = new ItemStack(material_.material, iCount);
	}
	
	@Override
	public String toString()
	{
		return itemStack.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "ItemStack";
	}
	
	public int jsGet_amount()
	{
		return itemStack.getAmount();
	}
	
	public int jsGet_durability()
	{
		return (int)itemStack.getDurability();
	}
	
	public int jsGet_maxStackSize()
	{
		return itemStack.getMaxStackSize();
	}
	
	public Scriptable jsGet_type()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(itemStack.getType(), cx, scope);
	}

	public int jsGet_typeId()
	{
		return itemStack.getTypeId();
	}
	
	public void jsSet_amount(int iAmount)
	{
		itemStack.setAmount(iAmount);
	}
	
	public void jsSet_durability(int iDurability)
	{
		itemStack.setDurability((short)iDurability);
	}
	
	public void jsSet_type(Scriptable material)
	{
		if (!(material instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material_ = (JS_Material)material;
		
		itemStack.setType(material_.material);
	}
}
