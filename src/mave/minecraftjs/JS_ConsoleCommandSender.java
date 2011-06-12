package mave.minecraftjs;

import org.bukkit.command.ConsoleCommandSender;
import org.mozilla.javascript.*;

public class JS_ConsoleCommandSender extends JS_Delegate<ConsoleCommandSender>
{
	private static final long serialVersionUID = -2546432603116252436L;


	public JS_ConsoleCommandSender()
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
		return "ConsoleCommandSender";
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getServer(), cx, scope);
	}
	
	public boolean jsGet_op()
	{
		return getDelegate().isOp();
	}
	
	public boolean jsGet_player()
	{
		return getDelegate().isPlayer();
	}
		
	public static void jsFunction_sendMessage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_ConsoleCommandSender caller = (JS_ConsoleCommandSender)thisObj;
		
		caller.getDelegate().sendMessage(Context.toString(args[0]));
	}
}
