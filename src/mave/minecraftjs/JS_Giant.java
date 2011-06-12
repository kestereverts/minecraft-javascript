package mave.minecraftjs;

import org.bukkit.entity.Giant;
import org.mozilla.javascript.Context;

public class JS_Giant extends JS_Creature<Giant>
{
	private static final long serialVersionUID = -6521629923797126661L;

	public JS_Giant()
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
		return "Giant";
	}
}

