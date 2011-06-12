package mave.minecraftjs;

import org.bukkit.command.ConsoleCommandSender;
import org.mozilla.javascript.*;

public class JS_ConsoleCommandSender extends ScriptableObject
{
	private static final long serialVersionUID = -2546432603116252436L;
	public ConsoleCommandSender sender = null;

	public JS_ConsoleCommandSender()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_ConsoleCommandSender.class, DONTENUM);
	}
	
	public void jsConstructor() throws Error
	{
		if (!MinecraftJS.m_bInternalConstruction)
		{
			throw new Error("i am not to be constructed");
		}
	}
	
	@Override
	public String toString()
	{
		return sender.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "ConsoleCommandSender";
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(sender.getServer(), cx, scope);
	}
	
	public boolean jsGet_op()
	{
		return sender.isOp();
	}
	
	public boolean jsGet_player()
	{
		return sender.isPlayer();
	}
		
	public static void jsFunction_sendMessage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_ConsoleCommandSender caller = (JS_ConsoleCommandSender)thisObj;
		
		caller.sender.sendMessage(Context.toString(args[0]));
	}
}
