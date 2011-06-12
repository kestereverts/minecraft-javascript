package mave.minecraftjs;

import org.bukkit.entity.Skeleton;
import org.mozilla.javascript.Context;

public class JS_Skeleton extends JS_Creature<Skeleton>
{
	private static final long serialVersionUID = 4919154045823478334L;

	public JS_Skeleton()
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
		return "Skeleton";
	}
}

