package mave.minecraftjs;

import java.util.List;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.mozilla.javascript.*;

public class JS_Server extends JS_Delegate<Server>
{
	private static final long serialVersionUID = -2837646882964431104L;

	public JS_Server()
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
		return "Server";
	}
	
	public static boolean jsFunction_dispatchCommand(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_Server caller = (JS_Server)thisObj;
		
		if (args[0] instanceof JS_Player)
		{
			JS_Player sender = (JS_Player)args[0];
			return caller.getDelegate().dispatchCommand(sender.getDelegate(), Context.toString(args[1]));
		}
		
		throw new IllegalArgumentException();
	}
	
	public String jsGet_ip()
	{
		return getDelegate().getIp();
	}

	public int jsGet_port()
	{
		return getDelegate().getPort();
	}
	
	public int jsGet_maxPlayers()
	{
		return getDelegate().getMaxPlayers();
	}
	
	public String jsGet_name()
	{
		return getDelegate().getName();
	}
	
	public String jsGet_serverId()
	{
		return getDelegate().getServerId();
	}
	
	public String jsGet_serverName()
	{
		return getDelegate().getServerName();
	}
	
	public String jsGet_updateFolder()
	{
		return getDelegate().getUpdateFolder();
	}
	
	public String jsGet_version()
	{
		return getDelegate().getVersion();
	}
	
	public static Scriptable jsFunction_getWorld(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Server caller = (JS_Server)thisObj;
		
		return ConvertUtility.toScriptable(caller.getDelegate().getWorld(Context.toString(args[0])), cx, thisObj);
	}
	
	public Scriptable jsGet_worlds()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<World> worlds = getDelegate().getWorlds();
		Object[] res = new Object[worlds.size()];
		int i = 0;
		for (World w : worlds)
		{
			res[i] = ConvertUtility.toScriptable(w, cx, scope);
			++i;
		}
		
		return cx.newArray(scope, res);
	}
	
	public static Scriptable jsFunction_getPlayer(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Server caller = (JS_Server)thisObj;
		
		return ConvertUtility.toScriptable(caller.getDelegate().getPlayer(Context.toString(args[0])), cx, thisObj);
	}
	
	public Scriptable jsGet_onlinePlayers()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Player[] plrs = getDelegate().getOnlinePlayers();
		Object[] res = new Object[plrs.length];
		int i = 0;
		MinecraftJS.m_bInternalConstruction = true;
		for (Player p : plrs)
		{
			res[i] = ConvertUtility.toScriptable(p, cx, scope);
			++i;
		}
		MinecraftJS.m_bInternalConstruction = false;
		
		return cx.newArray(scope, res);
	}
	
	public static int jsFunction_broadcastMessage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Server caller = (JS_Server)thisObj;
		
		return caller.getDelegate().broadcastMessage(Context.toString(args[0]));
	}
	
	public static Scriptable jsFunction_matchPlayer(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Server caller = (JS_Server)thisObj;
		
		List<Player> players = caller.getDelegate().matchPlayer(Context.toString(args[0]));
		return cx.newArray(thisObj, players.toArray());
	}
	
	public void jsFunction_reload()
	{
		getDelegate().reload();
	}
	
	public void jsFunction_savePlayers()
	{
		getDelegate().savePlayers();
	}
	
	public Scriptable jsGet_pluginManager()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getPluginManager(), cx, scope);
	}
	
	// TODO: createWorld

	public static boolean jsFuncton_unloadWorld(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_Server caller = (JS_Server)thisObj;
		
		if (args[0] instanceof JS_World)
		{
			JS_World world = (JS_World)args[0];
			return caller.getDelegate().unloadWorld(world.getDelegate(), Context.toBoolean(args[1]));
		}
		
		return caller.getDelegate().unloadWorld(Context.toString(args[0]), Context.toBoolean(args[1]));
	}
	
	// TODO: more..
}
