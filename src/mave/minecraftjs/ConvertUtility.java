package mave.minecraftjs;

import mave.minecraftjs.events.block.*;
import mave.minecraftjs.events.entity.*;
import mave.minecraftjs.events.player.*;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.painting.PaintingBreakEvent;
import org.bukkit.event.painting.PaintingPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.util.Vector;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class ConvertUtility
{
	public static TreeType stringToTreeType(String s)
	{
		s = s.toLowerCase();
		if (s.equals("tree"))
		{
			return TreeType.TREE;
		}
		else if (s.equals("big") || s.equals("bigtree") || s.equals("big_tree"))
		{
			return TreeType.BIG_TREE;
		}
		else if (s.equals("birch"))
		{
			return TreeType.BIRCH;
		}
		else if (s.equals("redwood"))
		{
			return TreeType.REDWOOD;
		}
		else if (s.equals("tallredwood") || s.equals("tall_redwood"))
		{
			return TreeType.TALL_REDWOOD;
		}
		
		throw new IllegalArgumentException();
	}
	
	public static BlockFace stringToBlockFace(String s)
	{
		s = s.toLowerCase();
		if (s.equals("north"))
		{
			return BlockFace.NORTH;
		}
		else if (s.equals("east"))
		{
			return BlockFace.EAST;
		}
		else if (s.equals("south"))
		{
			return BlockFace.SOUTH;
		}
		else if (s.equals("west"))
		{
			return BlockFace.WEST;
		}
		else if (s.equals("northeast") || s.equals("north-east") || s.equals("north_east"))
		{
			return BlockFace.NORTH_EAST;
		}
		else if (s.equals("northwest") || s.equals("north-west") || s.equals("north_west"))
		{
			return BlockFace.NORTH_WEST;
		}
		else if (s.equals("southeast") || s.equals("south-east") || s.equals("south_east"))
		{
			return BlockFace.SOUTH_EAST;
		}
		else if (s.equals("southwest") || s.equals("south-west") || s.equals("south_west"))
		{
			return BlockFace.SOUTH_WEST;
		}
		else if (s.equals("self"))
		{
			return BlockFace.SELF;
		}
		else if (s.equals("up"))
		{
			return BlockFace.UP;
		}
		else if (s.equals("down"))
		{
			return BlockFace.DOWN;
		}
		
		throw new IllegalArgumentException();
	}
	
	public static Entity scriptableToEntity(Scriptable s)
	{
		if (s instanceof JS_Player)
		{
			JS_Player entity = (JS_Player)s;
			return entity.player;
		}
		else if (s instanceof JS_Zombie)
		{
			JS_Zombie entity = (JS_Zombie)s;
			return entity.zombie;
		}
		else if (s instanceof JS_Skeleton)
		{
			JS_Skeleton entity = (JS_Skeleton)s;
			return entity.skeleton;
		}
		else if (s instanceof JS_Spider)
		{
			JS_Spider entity = (JS_Spider)s;
			return entity.spider;
		}
		else if (s instanceof JS_Creeper)
		{
			JS_Creeper entity = (JS_Creeper)s;
			return entity.creeper;
		}
		else if (s instanceof JS_Slime)
		{
			JS_Slime entity = (JS_Slime)s;
			return entity.slime;
		}
		else if (s instanceof JS_Ghast)
		{
			JS_Ghast entity = (JS_Ghast)s;
			return entity.ghast;
		}
		else if (s instanceof JS_PigZombie)
		{
			JS_PigZombie entity = (JS_PigZombie)s;
			return entity.pigZombie;
		}
		else if (s instanceof JS_Giant)
		{
			JS_Giant entity = (JS_Giant)s;
			return entity.giant;
		}
		else if (s instanceof JS_Item)
		{
			JS_Item entity = (JS_Item)s;
			return entity.item;
		}
		else if (s instanceof JS_LightningStrike)
		{
			JS_LightningStrike entity = (JS_LightningStrike)s;
			return entity.strike;
		}

		throw new IllegalArgumentException();
	}
	
	public static Scriptable entityToScriptable(Entity e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		if (e instanceof Player)
		{
			return toScriptable((Player)e, cx, scope);
		}
		if (e instanceof Zombie)
		{
			return toScriptable((Zombie)e, cx, scope);
		}
		if (e instanceof Skeleton)
		{
			return toScriptable((Skeleton)e, cx, scope);
		}
		if (e instanceof Spider)
		{
			return toScriptable((Spider)e, cx, scope);
		}
		if (e instanceof Creeper)
		{
			return toScriptable((Creeper)e, cx, scope);
		}
		if (e instanceof Slime)
		{
			return toScriptable((Slime)e, cx, scope);
		}
		if (e instanceof Ghast)
		{
			return toScriptable((Ghast)e, cx, scope);
		}
		if (e instanceof PigZombie)
		{
			return toScriptable((PigZombie)e, cx, scope);
		}
		if (e instanceof Giant)
		{
			return toScriptable((Giant)e, cx, scope);
		}
		else if (e instanceof Item)
		{
			return toScriptable((Item)e, cx, scope);
		}
		else if (e instanceof LightningStrike)
		{
			return toScriptable((LightningStrike)e, cx, scope);
		}
		
		throw new IllegalArgumentException();
	}
	
	public static Scriptable toScriptable(Player p, Context cx, Scriptable scope)
	{
		if (p == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Player entity = (JS_Player)cx.newObject(scope, "Player");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.player = p;
		return entity;
	}
	
	public static Scriptable toScriptable(Zombie z, Context cx, Scriptable scope)
	{
		if (z == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Zombie entity = (JS_Zombie)cx.newObject(scope, "Zombie");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.zombie = z;
		return entity;
	}
	
	public static Scriptable toScriptable(Skeleton s, Context cx, Scriptable scope)
	{
		if (s == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Skeleton entity = (JS_Skeleton)cx.newObject(scope, "Skeleton");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.skeleton = s;
		return entity;
	}
	
	public static Scriptable toScriptable(Spider s, Context cx, Scriptable scope)
	{
		if (s == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Spider entity = (JS_Spider)cx.newObject(scope, "Spider");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.spider = s;
		return entity;
	}
	
	public static Scriptable toScriptable(Creeper c, Context cx, Scriptable scope)
	{
		if (c == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Creeper entity = (JS_Creeper)cx.newObject(scope, "Creeper");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.creeper = c;
		return entity;
	}
	
	public static Scriptable toScriptable(Slime s, Context cx, Scriptable scope)
	{
		if (s == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Slime entity = (JS_Slime)cx.newObject(scope, "Slime");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.slime = s;
		return entity;
	}
	
	public static Scriptable toScriptable(Ghast g, Context cx, Scriptable scope)
	{
		if (g == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Ghast entity = (JS_Ghast)cx.newObject(scope, "Ghast");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.ghast = g;
		return entity;
	}
	
	public static Scriptable toScriptable(PigZombie p, Context cx, Scriptable scope)
	{
		if (p == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PigZombie entity = (JS_PigZombie)cx.newObject(scope, "PigZombie");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.pigZombie = p;
		return entity;
	}
	
	public static Scriptable toScriptable(Giant g, Context cx, Scriptable scope)
	{
		if (g == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Giant entity = (JS_Giant)cx.newObject(scope, "Giant");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.giant = g;
		return entity;
	}
	
	public static Scriptable toScriptable(Item i, Context cx, Scriptable scope)
	{
		if (i == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Item entity = (JS_Item)cx.newObject(scope, "Item");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.item = i;
		return entity;
	}
	
	public static Scriptable toScriptable(LightningStrike s, Context cx, Scriptable scope)
	{
		if (s == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_LightningStrike entity = (JS_LightningStrike)cx.newObject(scope, "LightningStrike");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.strike = s;
		return entity;
	}
	
	public static Scriptable toScriptable(Block b, Context cx, Scriptable scope)
	{
		if (b == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Block entity = (JS_Block)cx.newObject(scope, "Block");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.block = b;
		return entity;
	}
	
	public static Scriptable toScriptable(Location l, Context cx, Scriptable scope)
	{
		if (l == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Location entity = (JS_Location)cx.newObject(scope, "Location");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.location = l;
		return entity;
	}
	
	public static Scriptable toScriptable(Server s, Context cx, Scriptable scope)
	{
		if (s == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Server entity = (JS_Server)cx.newObject(scope, "Server");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.server = s;
		return entity;
	}
	
	public static Scriptable toScriptable(World w, Context cx, Scriptable scope)
	{
		if (w == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_World entity = (JS_World)cx.newObject(scope, "World");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.world = w;
		return entity;
	}
	
	public static Scriptable toScriptable(ItemStack i, Context cx, Scriptable scope)
	{
		if (i == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_ItemStack entity = (JS_ItemStack)cx.newObject(scope, "ItemStack");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.itemStack = i;
		return entity;
	}
	
	public static Scriptable toScriptable(PluginManager p, Context cx, Scriptable scope)
	{
		if (p == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PluginManager entity = (JS_PluginManager)cx.newObject(scope, "PluginManager");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.pluginManager = p;
		return entity;
	}
	
	public static Scriptable toScriptable(Material m, Context cx, Scriptable scope)
	{
		if (m == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Material entity = (JS_Material)cx.newObject(scope, "Material");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.material = m;
		return entity;
	}
	
	public static Scriptable toScriptable(Chunk c, Context cx, Scriptable scope)
	{
		if (c == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Chunk entity = (JS_Chunk)cx.newObject(scope, "Chunk");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.chunk = c;
		return entity;
	}
	
	public static Scriptable toScriptable(Vector v, Context cx, Scriptable scope)
	{
		if (v == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_Vector entity = (JS_Vector)cx.newObject(scope, "Vector");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.vector = v;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockFace b, Context cx, Scriptable scope)
	{
		if (b == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockFace entity = (JS_BlockFace)cx.newObject(scope, "BlockFace");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.blockFace = b;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockState b, Context cx, Scriptable scope)
	{
		if (b == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockState entity = (JS_BlockState)cx.newObject(scope, "BlockState");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.blockState = b;
		return entity;
	}
	
	public static Scriptable toScriptable(ConsoleCommandSender s, Context cx, Scriptable scope)
	{
		if (s == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_ConsoleCommandSender entity = (JS_ConsoleCommandSender)cx.newObject(scope, "ConsoleCommandSender");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.sender = s;
		return entity;
	}
	
	// player events
	public static Scriptable toScriptable(PlayerAnimationEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerAnimationEvent entity = (JS_PlayerAnimationEvent)cx.newObject(scope, "PlayerAnimationEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerBedEnterEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerBedEnterEvent entity = (JS_PlayerBedEnterEvent)cx.newObject(scope, "PlayerBedEnterEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerBedLeaveEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerBedLeaveEvent entity = (JS_PlayerBedLeaveEvent)cx.newObject(scope, "PlayerBedLeaveEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerBucketEmptyEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerBucketEmptyEvent entity = (JS_PlayerBucketEmptyEvent)cx.newObject(scope, "PlayerBucketEmptyEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerBucketFillEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerBucketFillEvent entity = (JS_PlayerBucketFillEvent)cx.newObject(scope, "PlayerBucketFillEventEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerChatEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerChatEvent entity = (JS_PlayerChatEvent)cx.newObject(scope, "PlayerChatEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerCommandPreprocessEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerCommandPreprocessEvent entity = (JS_PlayerCommandPreprocessEvent)cx.newObject(scope, "PlayerCommandPreprocessEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerDropItemEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerDropItemEvent entity = (JS_PlayerDropItemEvent)cx.newObject(scope, "PlayerDropItemEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerEggThrowEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerEggThrowEvent entity = (JS_PlayerEggThrowEvent)cx.newObject(scope, "PlayerEggThrowEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerInteractEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerInteractEvent entity = (JS_PlayerInteractEvent)cx.newObject(scope, "PlayerInteractEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerInteractEntityEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerInteractEntityEvent entity = (JS_PlayerInteractEntityEvent)cx.newObject(scope, "PlayerInteractEntityEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerInventoryEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerInventoryEvent entity = (JS_PlayerInventoryEvent)cx.newObject(scope, "PlayerInventoryEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerItemHeldEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerItemHeldEvent entity = (JS_PlayerItemHeldEvent)cx.newObject(scope, "PlayerItemHeldEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerJoinEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerJoinEvent entity = (JS_PlayerJoinEvent)cx.newObject(scope, "PlayerJoinEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerKickEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerKickEvent entity = (JS_PlayerKickEvent)cx.newObject(scope, "PlayerKickEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerLoginEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerLoginEvent entity = (JS_PlayerLoginEvent)cx.newObject(scope, "PlayerLoginEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerMoveEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerMoveEvent entity = (JS_PlayerMoveEvent)cx.newObject(scope, "PlayerMoveEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerPickupItemEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerPickupItemEvent entity = (JS_PlayerPickupItemEvent)cx.newObject(scope, "PlayerPickupItemEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerPreLoginEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerPreLoginEvent entity = (JS_PlayerPreLoginEvent)cx.newObject(scope, "PlayerPreLoginEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerQuitEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerQuitEvent entity = (JS_PlayerQuitEvent)cx.newObject(scope, "PlayerQuitEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerRespawnEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerRespawnEvent entity = (JS_PlayerRespawnEvent)cx.newObject(scope, "PlayerRespawnEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerTeleportEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerTeleportEvent entity = (JS_PlayerTeleportEvent)cx.newObject(scope, "PlayerTeleportEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PlayerToggleSneakEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PlayerToggleSneakEvent entity = (JS_PlayerToggleSneakEvent)cx.newObject(scope, "PlayerToggleSneakEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	// block events
	public static Scriptable toScriptable(BlockPhysicsEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockPhysicsEvent entity = (JS_BlockPhysicsEvent)cx.newObject(scope, "BlockPhysicsEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockCanBuildEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockCanBuildEvent entity = (JS_BlockCanBuildEvent)cx.newObject(scope, "BlockCanBuildEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockBreakEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockBreakEvent entity = (JS_BlockBreakEvent)cx.newObject(scope, "BlockBreakEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockBurnEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockBurnEvent entity = (JS_BlockBurnEvent)cx.newObject(scope, "BlockBurnEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockDamageEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockDamageEvent entity = (JS_BlockDamageEvent)cx.newObject(scope, "BlockDamageEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockDispenseEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockDispenseEvent entity = (JS_BlockDispenseEvent)cx.newObject(scope, "BlockDispenseEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockFromToEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockFromToEvent entity = (JS_BlockFromToEvent)cx.newObject(scope, "BlockFromToEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockIgniteEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockIgniteEvent entity = (JS_BlockIgniteEvent)cx.newObject(scope, "BlockIgniteEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockPlaceEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockPlaceEvent entity = (JS_BlockPlaceEvent)cx.newObject(scope, "BlockPlaceEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(LeavesDecayEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_LeavesDecayEvent entity = (JS_LeavesDecayEvent)cx.newObject(scope, "LeavesDecayEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(SnowFormEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_SnowFormEvent entity = (JS_SnowFormEvent)cx.newObject(scope, "SnowFormEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(SignChangeEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_SignChangeEvent entity = (JS_SignChangeEvent)cx.newObject(scope, "SignChangeEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(BlockRedstoneEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_BlockRedstoneEvent entity = (JS_BlockRedstoneEvent)cx.newObject(scope, "BlockRedstoneEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	// entity events
	
	public static Scriptable toScriptable(CreatureSpawnEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_CreatureSpawnEvent entity = (JS_CreatureSpawnEvent)cx.newObject(scope, "CreatureSpawnEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(CreeperPowerEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_CreeperPowerEvent entity = (JS_CreeperPowerEvent)cx.newObject(scope, "CreeperPowerEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(EntityCombustEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_EntityCombustEvent entity = (JS_EntityCombustEvent)cx.newObject(scope, "EntityCombustEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(EntityDamageEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_EntityDamageEvent entity = (JS_EntityDamageEvent)cx.newObject(scope, "EntityDamageEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(EntityDeathEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_EntityDeathEvent entity = (JS_EntityDeathEvent)cx.newObject(scope, "EntityDeathEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(EntityExplodeEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_EntityExplodeEvent entity = (JS_EntityExplodeEvent)cx.newObject(scope, "EntityExplodeEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(EntityInteractEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_EntityInteractEvent entity = (JS_EntityInteractEvent)cx.newObject(scope, "EntityInteractEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(EntityTargetEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_EntityTargetEvent entity = (JS_EntityTargetEvent)cx.newObject(scope, "EntityTargetEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(ExplosionPrimeEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_ExplosionPrimeEvent entity = (JS_ExplosionPrimeEvent)cx.newObject(scope, "ExplosionPrimeEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PaintingBreakEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PaintingBreakEvent entity = (JS_PaintingBreakEvent)cx.newObject(scope, "PaintingBreakEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PaintingPlaceEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PaintingPlaceEvent entity = (JS_PaintingPlaceEvent)cx.newObject(scope, "PaintingPlaceEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(PigZapEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PigZapEvent entity = (JS_PigZapEvent)cx.newObject(scope, "PigZapEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(EntityPortalEnterEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_EntityPortalEnterEvent entity = (JS_EntityPortalEnterEvent)cx.newObject(scope, "EntityPortalEnterEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(EntityTameEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_EntityTameEvent entity = (JS_EntityTameEvent)cx.newObject(scope, "EntityTameEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	/*public static Scriptable toScriptable(Event e, Context cx, Scriptable scope)
	{
		BukkitTest.m_bInternalConstruction = true;
		JS_ entity = (JS_)cx.newObject(scope, "Event");
		BukkitTest.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}*/
}
