package mave.minecraftjs;

import java.lang.Error;
import java.util.List;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.mozilla.javascript.*;

public class JS_Server extends ScriptableObject
{
	private static final long serialVersionUID = -2837646882964431104L;
	public Server server;

	public JS_Server()
	{
		server = null;
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Server.class, DONTENUM);
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
		return server.toString();
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
			return caller.server.dispatchCommand(sender.player, Context.toString(args[1]));
		}
		
		throw new IllegalArgumentException();
	}
	
	public String jsGet_ip()
	{
		return server.getIp();
	}

	public int jsGet_port()
	{
		return server.getPort();
	}
	
	public int jsGet_maxPlayers()
	{
		return server.getMaxPlayers();
	}
	
	public String jsGet_name()
	{
		return server.getName();
	}
	
	public String jsGet_serverId()
	{
		return server.getServerId();
	}
	
	public String jsGet_serverName()
	{
		return server.getServerName();
	}
	
	public String jsGet_updateFolder()
	{
		return server.getUpdateFolder();
	}
	
	public String jsGet_version()
	{
		return server.getVersion();
	}
	
	public static Scriptable jsFunction_getWorld(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Server caller = (JS_Server)thisObj;
		
		return ConvertUtility.toScriptable(caller.server.getWorld(Context.toString(args[0])), cx, thisObj);
	}
	
	public Scriptable jsGet_worlds()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<World> worlds = server.getWorlds();
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
		
		return ConvertUtility.toScriptable(caller.server.getPlayer(Context.toString(args[0])), cx, thisObj);
	}
	
	public Scriptable jsGet_onlinePlayers()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Player[] plrs = server.getOnlinePlayers();
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
		
		return caller.server.broadcastMessage(Context.toString(args[0]));
	}
	
	public static Scriptable jsFunction_matchPlayer(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Server caller = (JS_Server)thisObj;
		
		List<Player> players = caller.server.matchPlayer(Context.toString(args[0]));
		return cx.newArray(thisObj, players.toArray());
	}
	
	public void jsFunction_reload()
	{
		server.reload();
	}
	
	public void jsFunction_savePlayers()
	{
		server.savePlayers();
	}
	
	public Scriptable jsGet_pluginManager()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(server.getPluginManager(), cx, scope);
	}
	
	// TODO: createWorld
	// TODO: unloadWorld
	// TODO: more..
}
