package mave.minecraftjs;

import java.lang.reflect.*;

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
		defineFunctionProperties(new String[] { "getServer", "registerCommand", "objcast" },
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
			globalServer.setDelegate(MinecraftJS.m_singleton.getServer());
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
	
	public static Scriptable objcast(Context cx, Scriptable thisObj, Object[] args, Function funObj) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		if (args.length < 2 || !(args[0] instanceof Scriptable))
		{
			throw new IllegalArgumentException();
		}
		
		Scriptable obj = (Scriptable)args[0];
		String sTarget = Context.toString(args[1]);
		Field[] fields = obj.getClass().getFields();
		Object originalObject = fields[0].get(obj);
		
		MinecraftJS.m_bInternalConstruction = true;
		Scriptable newObj = cx.newObject(thisObj, sTarget);
		MinecraftJS.m_bInternalConstruction = false;
		
		Field[] fields2 = newObj.getClass().getFields();
		fields2[0].set(newObj, fields2[0].getType().cast(originalObject));
		
		return newObj;
	}

	@Override
	public String getClassName()
	{
		return "global";
	}
}
