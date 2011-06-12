package mave.minecraftjs;

import org.bukkit.block.BlockFace;
import org.mozilla.javascript.*;

public class JS_BlockFace extends JS_Delegate<BlockFace>
{
	private static final long serialVersionUID = -5381627693919188543L;

	public JS_BlockFace()
	{
	}
	
	public static Scriptable jsConstructor(Context cx, Object[] args, Function ctorObj, boolean inNewExpr)
	{
		if (MinecraftJS.m_bInternalConstruction)
		{
			return new JS_BlockFace();
		}
		
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}

		JS_BlockFace blockFace = new JS_BlockFace();
		blockFace.setDelegate(ConvertUtility.stringToBlockFace(Context.toString(args[0])));
		return blockFace;
	}
	
	@Override
	public String getClassName()
	{
		return "BlockFace";
	}
	
	public int jsGet_modX()
	{
		return getDelegate().getModX();
	}
	
	public int jsGet_modY()
	{
		return getDelegate().getModY();
	}
	
	public int jsGet_modZ()
	{
		return getDelegate().getModZ();
	}
	
	public Scriptable jsGet_oppositeFace()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getOppositeFace(), cx, scope);
	}
}
