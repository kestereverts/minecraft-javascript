package mave.minecraftjs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.mozilla.javascript.*;

public class JS_World extends JS_Delegate<World>
{
	private static final long serialVersionUID = 8424835903715717677L;

	public JS_World()
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
		return "World";
	}
	
	public static Scriptable jsFunction_dropItem(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (!(args[0] instanceof JS_Location) || !(args[1] instanceof JS_ItemStack))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)args[0];
		JS_ItemStack itemStack = (JS_ItemStack)args[1];
		
		return ConvertUtility.toScriptable(caller.getDelegate().dropItem(location.getDelegate(), itemStack.getDelegate()), cx, thisObj);
	}
	
	public static Scriptable jsFunction_dropItemNaturally(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (!(args[0] instanceof JS_Location) || !(args[1] instanceof JS_ItemStack))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)args[0];
		JS_ItemStack itemStack = (JS_ItemStack)args[1];

		return ConvertUtility.toScriptable(caller.getDelegate().dropItemNaturally(location.getDelegate(), itemStack.getDelegate()), cx, thisObj);
	}
	
	public static boolean isFunction_generateTree(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (!(args[0] instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)args[0];
		
		TreeType treeType = ConvertUtility.stringToTreeType(Context.toString(args[1]));
		return caller.getDelegate().generateTree(location.getDelegate(), treeType);
	}
	
	public static Scriptable jsFunction_getBlockAt(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		Block block = null;
		if (args.length < 3)
		{
			if (!(args[0] instanceof Location))
			{
				throw new IllegalArgumentException();
			}
			JS_Location location = (JS_Location)args[0];
			
			block = caller.getDelegate().getBlockAt(location.getDelegate());
		}
		else
		{
			block = caller.getDelegate().getBlockAt((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2]));
		}
		
		return ConvertUtility.toScriptable(block, cx, thisObj);
	}
	
	public static int jsFunction_getBlockTypeIdAt(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 3)
		{
			if (!(args[0] instanceof Location))
			{
				throw new IllegalArgumentException();
			}
			JS_Location location = (JS_Location)args[0];
			
			return caller.getDelegate().getBlockTypeIdAt(location.getDelegate());
		}
		
		return caller.getDelegate().getBlockTypeIdAt((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2]));
	}
	
	public static Scriptable jsFunction_getChunkAt(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 2)
		{		
			if (args[0] instanceof JS_Block)
			{
				JS_Block block = (JS_Block)args[0];
				return ConvertUtility.toScriptable(caller.getDelegate().getChunkAt(block.getDelegate()), cx, thisObj);
			}
			else if (args[0] instanceof JS_Location)
			{
				JS_Location location = (JS_Location)args[0];
				return ConvertUtility.toScriptable(caller.getDelegate().getChunkAt(location.getDelegate()), cx, thisObj);
			}
			
			throw new IllegalArgumentException();
		}
		
		return ConvertUtility.toScriptable(caller.getDelegate().getChunkAt((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1])), cx, thisObj);
	}
	
	public Scriptable jsGet_entities()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<Entity> entities = getDelegate().getEntities();
		List<Object> res = new ArrayList<Object>();
		
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext())
		{
			Entity e = it.next();
			Scriptable entity = null;
			try
			{
				entity = ConvertUtility.entityToScriptable(e, cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			if (entity != null)
			{
				res.add(entity);
			}
		}
		return cx.newArray(scope, res.toArray());
	}
	
	public String jsGet_environment()
	{
		return getDelegate().getEnvironment().toString().toLowerCase();
	}
	
	public long jsGet_fullTime()
	{
		return getDelegate().getFullTime();
	}
	
	public static int jsFunction_getHighestBlockYAt(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 2)
		{
			if (!(args[0] instanceof JS_Location))
			{
				throw new IllegalArgumentException();
			}
			
			JS_Location location = (JS_Location)args[0];
			return caller.getDelegate().getHighestBlockYAt(location.getDelegate());
		}
		
		return caller.getDelegate().getHighestBlockYAt((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
	}
	
	public long jsGet_id()
	{
		return getDelegate().getId();
	}
	
	public Scriptable jsGet_livingEntities()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<LivingEntity> entities = getDelegate().getLivingEntities();
		List<Object> res = new ArrayList<Object>();
		
		Iterator<LivingEntity> it = entities.iterator();
		while (it.hasNext())
		{
			LivingEntity e = it.next();
			Scriptable entity = null;
			try
			{
				entity = ConvertUtility.entityToScriptable(e, cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			if (entity != null)
			{
				res.add(entity);
			}
		}
		return cx.newArray(scope, res.toArray());
	}
	
	public Scriptable jsGet_loadedChunks()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Chunk[] chunks = getDelegate().getLoadedChunks();
		List<Object> res = new ArrayList<Object>();
		
		for (Chunk c : chunks)
		{
			Scriptable entity = null;
			try
			{
				entity = ConvertUtility.toScriptable(c, cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			if (entity != null)
			{
				res.add(entity);
			}
		}
		return cx.newArray(scope, res.toArray());
	}
	
	public String jsGet_name()
	{
		return getDelegate().getName();
	}
	
	public Scriptable jsGet_players()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<Player> players = getDelegate().getPlayers();
		List<Object> res = new ArrayList<Object>();
		
		Iterator<Player> it = players.iterator();
		while (it.hasNext())
		{
			Player p = it.next();
			Scriptable player = null;
			try
			{
				player = ConvertUtility.entityToScriptable(p, cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			if (player != null)
			{
				res.add(player);
			}
		}
		return cx.newArray(scope, res.toArray());
	}
	
	public boolean jsGet_pvp()
	{
		return getDelegate().getPVP();
	}
	
	public long jsGet_seed()
	{
		return getDelegate().getSeed();
	}
	
	public Scriptable jsGet_spawnLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getSpawnLocation(), cx, scope);
	}
	
	public int jsGet_thunderDuration()
	{
		return getDelegate().getThunderDuration();
	}
	
	public long jsGet_time()
	{
		return getDelegate().getTime();
	}
	
	public int jsGet_weatherDuration()
	{
		return getDelegate().getWeatherDuration();
	}
	
	public boolean jsGet_storm()
	{
		return getDelegate().hasStorm();
	}
	
	public static boolean jsFunction_isChunkLoaded(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 2)
		{
			if (!(args[0] instanceof JS_Chunk))
			{
				throw new IllegalArgumentException();
			}
			JS_Chunk chunk = (JS_Chunk)args[0];
			return caller.getDelegate().isChunkLoaded(chunk.getDelegate());
		}
		
		return caller.getDelegate().isChunkLoaded((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
	}
	
	public boolean jsGet_thundering()
	{
		return getDelegate().isThundering();
	}
	
	public static void jsFunction_loadChunk(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 2)
		{
			if (!(args[0] instanceof JS_Chunk))
			{
				throw new IllegalArgumentException();
			}
			JS_Chunk chunk = (JS_Chunk)args[0];
			caller.getDelegate().loadChunk(chunk.getDelegate());
			return;
		}
		
		if (args.length < 3)
		{		
			caller.getDelegate().loadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
			return;
		}
		
		caller.getDelegate().loadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), Context.toBoolean(args[2]));
	}
	
	public static boolean jsFunction_refreshChunk(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		return caller.getDelegate().refreshChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
	}
	
	public static boolean jsFunction_regenerateChunk(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		return caller.getDelegate().regenerateChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
	}
	
	public void jsFunction_save()
	{
		getDelegate().save();
	}
	
	public void jsSet_fullTime(long lFullTime)
	{
		getDelegate().setFullTime(lFullTime);
	}
	
	public void jsSet_pvp(boolean bPVP)
	{
		getDelegate().setPVP(bPVP);
	}
	
	// Tolerance (a setter)
	public void jsSet_spawnLocation(Scriptable spawnLocation)
	{
		if (!(spawnLocation instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		
		JS_Location location = (JS_Location)spawnLocation;
		getDelegate().setSpawnLocation((int)location.getDelegate().getX(), (int)location.getDelegate().getY(), (int)location.getDelegate().getZ());
	}
	
	// Tolerance (we accept a Location here too)
	public static boolean jsFunction_setSpawnLocation(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 3)
		{
			if (!(args[0] instanceof JS_Location))
			{
				throw new IllegalArgumentException();
			}
			JS_Location location = (JS_Location)args[0];
			return caller.getDelegate().setSpawnLocation((int)location.getDelegate().getX(), (int)location.getDelegate().getY(), (int)location.getDelegate().getZ());
		}
		
		return caller.getDelegate().setSpawnLocation((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2]));
	}
	
	public void jsSet_storm(boolean bStorm)
	{
		getDelegate().setStorm(bStorm);
	}
	
	public void jsSet_thunderDuration(int iDuration)
	{
		getDelegate().setThunderDuration(iDuration);
	}
	
	public void jsSet_thundering(boolean bThundering)
	{
		getDelegate().setThundering(bThundering);
	}
	
	public void jsSet_time(long lTime)
	{
		getDelegate().setTime(lTime);
	}
	
	public void jsSet_weatherDuration(int iDuration)
	{
		getDelegate().setWeatherDuration(iDuration);
	}
	
	public static boolean jsFunction_unloadChunk(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 3)
		{
			return caller.getDelegate().unloadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
		}
		
		if (args.length < 4)
		{
			return caller.getDelegate().unloadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), Context.toBoolean(args[2]));
		}

		return caller.getDelegate().unloadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), Context.toBoolean(args[2]), Context.toBoolean(args[3]));
	}
	
	public static boolean jsFunction_unloadChunkRequest(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 3)
		{
			return caller.getDelegate().unloadChunkRequest((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
		}

		return caller.getDelegate().unloadChunkRequest((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), Context.toBoolean(args[2]));
	}
	
	public static boolean jsFunction_createExplosion(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (args.length < 4)
		{
			if (!(args[0] instanceof JS_Location))
			{
				throw new IllegalArgumentException();
			}
			JS_Location location = (JS_Location)args[0];
			
			return caller.getDelegate().createExplosion(location.getDelegate(), (float)Context.toNumber(args[1]));
		}
		
		return caller.getDelegate().createExplosion(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2]), (float)Context.toNumber(args[3]));
	}
	
	// TODO: jsGet_generator
	// TODO: jsGet_populators
	
	public static void jsFunction_playEffect(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		if (!(args[0] instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)args[0];
		
		Effect effect = Effect.valueOf(Context.toString(args[0]).toUpperCase());
		
		if (args.length < 4)
		{
			caller.getDelegate().playEffect(location.getDelegate(), effect, (int)Context.toNumber(args[2]));
			return;
		}
		
		caller.getDelegate().playEffect(location.getDelegate(), effect, (int)Context.toNumber(args[2]), (int)Context.toNumber(args[3]));
	}
}
