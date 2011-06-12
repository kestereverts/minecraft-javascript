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

public class JS_World extends ScriptableObject
{
	private static final long serialVersionUID = 8424835903715717677L;
	public World world = null;

	public JS_World()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_World.class, DONTENUM);
	}
	
	public void jsConstructor()
	{
		if (!MinecraftJS.m_bInternalConstruction)
		{
			throw Context.reportRuntimeError("This internal class cannot be instantiated");
		}
	}
	
	@Override
	public String toString()
	{
		return world.toString();
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
		
		return ConvertUtility.toScriptable(caller.world.dropItem(location.location, itemStack.itemStack), cx, thisObj);
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

		return ConvertUtility.toScriptable(caller.world.dropItemNaturally(location.location, itemStack.itemStack), cx, thisObj);
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
		return caller.world.generateTree(location.location, treeType);
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
			
			block = caller.world.getBlockAt(location.location);
		}
		else
		{
			block = caller.world.getBlockAt((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2]));
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
			
			return caller.world.getBlockTypeIdAt(location.location);
		}
		
		return caller.world.getBlockTypeIdAt((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2]));
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
				return ConvertUtility.toScriptable(caller.world.getChunkAt(block.block), cx, thisObj);
			}
			else if (args[0] instanceof JS_Location)
			{
				JS_Location location = (JS_Location)args[0];
				return ConvertUtility.toScriptable(caller.world.getChunkAt(location.location), cx, thisObj);
			}
			
			throw new IllegalArgumentException();
		}
		
		return ConvertUtility.toScriptable(caller.world.getChunkAt((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1])), cx, thisObj);
	}
	
	public Scriptable jsGet_entities()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<Entity> entities = world.getEntities();
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
		return world.getEnvironment().toString().toLowerCase();
	}
	
	public long jsGet_fullTime()
	{
		return world.getFullTime();
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
			return caller.world.getHighestBlockYAt(location.location);
		}
		
		return caller.world.getHighestBlockYAt((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
	}
	
	public long jsGet_id()
	{
		return world.getId();
	}
	
	public Scriptable jsGet_livingEntities()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<LivingEntity> entities = world.getLivingEntities();
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
		
		Chunk[] chunks = world.getLoadedChunks();
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
		return world.getName();
	}
	
	public Scriptable jsGet_players()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		List<Player> players = world.getPlayers();
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
		return world.getPVP();
	}
	
	public long jsGet_seed()
	{
		return world.getSeed();
	}
	
	public Scriptable jsGet_spawnLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(world.getSpawnLocation(), cx, scope);
	}
	
	public int jsGet_thunderDuration()
	{
		return world.getThunderDuration();
	}
	
	public long jsGet_time()
	{
		return world.getTime();
	}
	
	public int jsGet_weatherDuration()
	{
		return world.getWeatherDuration();
	}
	
	public boolean jsGet_storm()
	{
		return world.hasStorm();
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
			return caller.world.isChunkLoaded(chunk.chunk);
		}
		
		return caller.world.isChunkLoaded((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
	}
	
	public boolean jsGet_thundering()
	{
		return world.isThundering();
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
			caller.world.loadChunk(chunk.chunk);
			return;
		}
		
		if (args.length < 3)
		{		
			caller.world.loadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
			return;
		}
		
		caller.world.loadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), Context.toBoolean(args[2]));
	}
	
	public static boolean jsFunction_refreshChunk(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		return caller.world.refreshChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
	}
	
	public static boolean jsFunction_regenerateChunk(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_World caller = (JS_World)thisObj;
		
		return caller.world.regenerateChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
	}
	
	public void jsFunction_save()
	{
		world.save();
	}
	
	public void jsSet_fullTime(long lFullTime)
	{
		world.setFullTime(lFullTime);
	}
	
	public void jsSet_pvp(boolean bPVP)
	{
		world.setPVP(bPVP);
	}
	
	// Tolerance (a setter)
	public void jsSet_spawnLocation(Scriptable spawnLocation)
	{
		if (!(spawnLocation instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		
		JS_Location location = (JS_Location)spawnLocation;
		world.setSpawnLocation((int)location.location.getX(), (int)location.location.getY(), (int)location.location.getZ());
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
			return caller.world.setSpawnLocation((int)location.location.getX(), (int)location.location.getY(), (int)location.location.getZ());
		}
		
		return caller.world.setSpawnLocation((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2]));
	}
	
	public void jsSet_storm(boolean bStorm)
	{
		world.setStorm(bStorm);
	}
	
	public void jsSet_thunderDuration(int iDuration)
	{
		world.setThunderDuration(iDuration);
	}
	
	public void jsSet_thundering(boolean bThundering)
	{
		world.setThundering(bThundering);
	}
	
	public void jsSet_time(long lTime)
	{
		world.setTime(lTime);
	}
	
	public void jsSet_weatherDuration(int iDuration)
	{
		world.setWeatherDuration(iDuration);
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
			return caller.world.unloadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
		}
		
		if (args.length < 4)
		{
			return caller.world.unloadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), Context.toBoolean(args[2]));
		}

		return caller.world.unloadChunk((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), Context.toBoolean(args[2]), Context.toBoolean(args[3]));
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
			return caller.world.unloadChunkRequest((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]));
		}

		return caller.world.unloadChunkRequest((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), Context.toBoolean(args[2]));
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
			
			return caller.world.createExplosion(location.location, (float)Context.toNumber(args[1]));
		}
		
		return caller.world.createExplosion(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2]), (float)Context.toNumber(args[3]));
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
			caller.world.playEffect(location.location, effect, (int)Context.toNumber(args[2]));
			return;
		}
		
		caller.world.playEffect(location.location, effect, (int)Context.toNumber(args[2]), (int)Context.toNumber(args[3]));
	}
}
