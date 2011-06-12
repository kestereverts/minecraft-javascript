package mave.minecraftjs;

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
		defineFunctionProperties(new String[] { "getServer", "registerCommand" },
				JSGlobal.class, ScriptableObject.DONTENUM);
	}
	
	public static Scriptable getServer(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{		
		if (globalServer == null)
		{
			globalServer = (JS_Server)ConvertUtility.toScriptable(MinecraftJS.m_singleton.getServer(), cx, thisObj);
		}
		else
		{
			globalServer.server = MinecraftJS.m_singleton.getServer();
		}
		return globalServer;
	}
	
	public static void registerCommand(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2 || !(args[1] instanceof Function))
		{
			throw new IllegalArgumentException();
		}
		
		String sCommand = Context.toString(args[0]);
		
		JSCommandHandler h = new JSCommandHandler();
		h.m_sCommand = sCommand;
		h.m_scriptFunction = (Function)args[1];
		
		MinecraftJS.m_currentScript.m_lstCommandHandlers.add(h);
	}

	@Override
	public String getClassName()
	{
		return "global";
	}
}
