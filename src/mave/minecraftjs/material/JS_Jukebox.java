package mave.minecraftjs.material;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JS_Material;
import mave.minecraftjs.MinecraftJS;

import org.bukkit.material.Jukebox;
import org.mozilla.javascript.*;

public class JS_Jukebox extends JS_MaterialData<Jukebox>
{
	private static final long serialVersionUID = -4403484561023154666L;

	public JS_Jukebox()
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
		return "Jukebox";
	}
	
	public final Scriptable jsGet_playing()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getPlaying(), cx, scope);
	}
	
	public final void jsSet_playing(Scriptable rec)
	{
		if (!(rec instanceof JS_Material))
		{
			throw new IllegalArgumentException();
		}
		JS_Material material = (JS_Material)rec;
		
		getDelegate().setPlaying(material.getDelegate());
	}
}
