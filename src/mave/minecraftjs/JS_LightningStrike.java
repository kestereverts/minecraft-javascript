package mave.minecraftjs;

import org.bukkit.entity.LightningStrike;
import org.mozilla.javascript.Context;

public class JS_LightningStrike extends JS_Entity<LightningStrike>
{
	private static final long serialVersionUID = -5849434430974260998L;

	public JS_LightningStrike()
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
		return "LightningStrike";
	}
	
	public boolean jsGet_effect()
	{
		return getDelegate().isEffect();
	}
}

