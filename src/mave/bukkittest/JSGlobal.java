package mave.bukkittest;

import org.mozilla.javascript.*;

public class JSGlobal extends ScriptableObject
{
	private static final long serialVersionUID = -7126640870335622289L;
	
	private static JS_Server globalServer = null;
	
	public JSGlobal()
	{
	}
	
	public void initializeFunctionProperties()
	{
        defineFunctionProperties(new String[] { "getServer" },
        		JSGlobal.class, ScriptableObject.DONTENUM);
	}
	
	public static Scriptable getServer(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{		
		if (globalServer == null)
		{
	        globalServer = (JS_Server)ConvertUtility.toScriptable(BukkitTest.m_singleton.getServer(), cx, thisObj);
		}
		else
		{
			globalServer.server = BukkitTest.m_singleton.getServer();
		}
        return globalServer;
	}

	@Override
	public String getClassName()
	{
		return "global";
	}
}
