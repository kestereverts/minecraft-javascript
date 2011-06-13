package mave.minecraftjs;

import mave.minecraftjs.events.block.*;
import mave.minecraftjs.events.entity.*;
import mave.minecraftjs.events.player.*;
import mave.minecraftjs.events.world.*;
import mave.minecraftjs.events.server.*;

import org.bukkit.event.painting.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.world.*;
import org.bukkit.event.server.*;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.util.Vector;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class ConvertUtility
{	
	public static <T extends Entity> Scriptable entityToScriptable(T e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		if (e instanceof Player)
		{
			return toScriptable((Player)e, cx, scope);
		}
		else if (e instanceof Zombie)
		{
			return toScriptable((Zombie)e, cx, scope);
		}
		else if (e instanceof Skeleton)
		{
			return toScriptable((Skeleton)e, cx, scope);
		}
		else if (e instanceof Spider)
		{
			return toScriptable((Spider)e, cx, scope);
		}
		else if (e instanceof Creeper)
		{
			return toScriptable((Creeper)e, cx, scope);
		}
		else if (e instanceof Slime)
		{
			return toScriptable((Slime)e, cx, scope);
		}
		else if (e instanceof Ghast)
		{
			return toScriptable((Ghast)e, cx, scope);
		}
		else if (e instanceof PigZombie)
		{
			return toScriptable((PigZombie)e, cx, scope);
		}
		else if (e instanceof Giant)
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
		else if (e instanceof Painting)
		{
			return toScriptable((Painting)e, cx, scope);
		}
		
		throw new IllegalArgumentException();
	}

	public static Scriptable materialDataToScriptable(MaterialData m, Context cx, Scriptable scope)
	{
		if (m == null)
		{
			return null;
		}
		
		if (m instanceof Bed)
		{
			return toScriptable("Bed", m, cx, scope);
		}
		else if (m instanceof Button)
		{
			return toScriptable("Button", m, cx, scope);
		}
		else if (m instanceof Cake)
		{
			return toScriptable("Cake", m, cx, scope);
		}
		else if (m instanceof Coal)
		{
			return toScriptable("Coal", m, cx, scope);
		}
		else if (m instanceof Crops)
		{
			return toScriptable("Crops", m, cx, scope);
		}
		else if (m instanceof DetectorRail)
		{
			return toScriptable("DetectorRail", m, cx, scope);
		}
		else if (m instanceof Diode)
		{
			return toScriptable("Diode", m, cx, scope);
		}
		else if (m instanceof org.bukkit.material.Dispenser)
		{
			return toScriptable("Dispenser", m, cx, scope);
		}
		else if (m instanceof Door)
		{
			return toScriptable("Door", m, cx, scope);
		}
		else if (m instanceof Dye)
		{
			return toScriptable("Dye", m, cx, scope);
		}
		// ExtendedRails??
		else if (m instanceof org.bukkit.material.Furnace)
		{
			return toScriptable("Furnace", m, cx, scope);
		}
		// FurnaceAndDispenser??
		else if (m instanceof Jukebox)
		{
			return toScriptable("Jukebox", m, cx, scope);
		}
		else if (m instanceof Ladder)
		{
			return toScriptable("Ladder", m, cx, scope);
		}
		else if (m instanceof Leaves)
		{
			return toScriptable("Leaves", m, cx, scope);
		}
		else if (m instanceof LongGrass)
		{
			return toScriptable("LongGrass", m, cx, scope);
		}
		else if (m instanceof PoweredRail)
		{
			return toScriptable("PoweredRail", m, cx, scope);
		}
		else if (m instanceof PressurePlate)
		{
			return toScriptable("PressurePlate", m, cx, scope);
		}
		else if (m instanceof Pumpkin)
		{
			return toScriptable("Pumpkin", m, cx, scope);
		}
		else if (m instanceof Rails)
		{
			return toScriptable("Rails", m, cx, scope);
		}
		else if (m instanceof RedstoneTorch)
		{
			return toScriptable("RedstoneTorch", m, cx, scope);
		}
		else if (m instanceof RedstoneWire)
		{
			return toScriptable("RedstoneWire", m, cx, scope);
		}
		else if (m instanceof org.bukkit.material.Sign)
		{
			return toScriptable("Sign", m, cx, scope);
		}
		// SimpleAttachableMaterialData??
		else if (m instanceof Stairs)
		{
			return toScriptable("Stairs", m, cx, scope);
		}
		else if (m instanceof Step)
		{
			return toScriptable("Step", m, cx, scope);
		}
		
		return toScriptable("MaterialData", m, cx, scope);
	}
	
	public static Scriptable commandSenderToScriptable(CommandSender s, Context cx, Scriptable scope)
	{
		if (s == null)
		{
			return null;
		}
		
		if (s instanceof Player)
		{
			return toScriptable((Player)s, cx, scope);
		}
		else if (s instanceof ConsoleCommandSender)
		{
			return toScriptable((ConsoleCommandSender)s, cx, scope);
		}
		
		throw new IllegalArgumentException();
	}
	
	// entity conversions
	public static JSDelegate<Creeper> toScriptable(Creeper obj, Context cx, Scriptable scope)
	{
		return toScriptable("Creeper", obj, cx, scope);
	}
	public static JSDelegate<Ghast> toScriptable(Ghast obj, Context cx, Scriptable scope)
	{
		return toScriptable("Ghast", obj, cx, scope);
	}
	public static JSDelegate<Giant> toScriptable(Giant obj, Context cx, Scriptable scope)
	{
		return toScriptable("Giant", obj, cx, scope);
	}
	public static JSDelegate<Item> toScriptable(Item obj, Context cx, Scriptable scope)
	{
		return toScriptable("Item", obj, cx, scope);
	}
	public static JSDelegate<LightningStrike> toScriptable(LightningStrike obj, Context cx, Scriptable scope)
	{
		return toScriptable("LightningStrike", obj, cx, scope);
	}
	public static JSDelegate<Painting> toScriptable(Painting obj, Context cx, Scriptable scope)
	{
		return toScriptable("Painting", obj, cx, scope);
	}
	public static JSDelegate<PigZombie> toScriptable(PigZombie obj, Context cx, Scriptable scope)
	{
		return toScriptable("PigZombie", obj, cx, scope);
	}
	public static JSDelegate<Player> toScriptable(Player obj, Context cx, Scriptable scope)
	{
		return toScriptable("Player", obj, cx, scope);
	}
	public static JSDelegate<Skeleton> toScriptable(Skeleton obj, Context cx, Scriptable scope)
	{
		return toScriptable("Skeleton", obj, cx, scope);
	}
	public static JSDelegate<Slime> toScriptable(Slime obj, Context cx, Scriptable scope)
	{
		return toScriptable("Slime", obj, cx, scope);
	}
	public static JSDelegate<Spider> toScriptable(Spider obj, Context cx, Scriptable scope)
	{
		return toScriptable("Spider", obj, cx, scope);
	}
	public static JSDelegate<Zombie> toScriptable(Zombie obj, Context cx, Scriptable scope)
	{
		return toScriptable("Skeleton", obj, cx, scope);
	}
	
	// non-entity conversions
	public static JSDelegate<Block> toScriptable(Block obj, Context cx, Scriptable scope)
	{
		return toScriptable("Block", obj, cx, scope);
	}
	public static JSDelegate<BlockFace> toScriptable(BlockFace obj, Context cx, Scriptable scope)
	{
		return toScriptable("BlockFace", obj, cx, scope);
	}
	public static JSDelegate<BlockState> toScriptable(BlockState obj, Context cx, Scriptable scope)
	{
		return toScriptable("BlockState", obj, cx, scope);
	}
	public static JSDelegate<Chunk> toScriptable(Chunk obj, Context cx, Scriptable scope)
	{
		return toScriptable("Chunk", obj, cx, scope);
	}
	public static JSDelegate<ConsoleCommandSender> toScriptable(ConsoleCommandSender obj, Context cx, Scriptable scope)
	{
		return toScriptable("ConsoleCommandSender", obj, cx, scope);
	}
	public static JSDelegate<ItemStack> toScriptable(ItemStack obj, Context cx, Scriptable scope)
	{
		return toScriptable("ItemStack", obj, cx, scope);
	}
	public static JSDelegate<Location> toScriptable(Location obj, Context cx, Scriptable scope)
	{
		return toScriptable("Location", obj, cx, scope);
	}
	public static JSDelegate<Material> toScriptable(Material obj, Context cx, Scriptable scope)
	{
		return toScriptable("Material", obj, cx, scope);
	}
	public static JSDelegate<Plugin> toScriptable(Plugin obj, Context cx, Scriptable scope)
	{
		return toScriptable("Plugin", obj, cx, scope);
	}
	public static JSDelegate<PluginManager> toScriptable(PluginManager obj, Context cx, Scriptable scope)
	{
		return toScriptable("PluginManager", obj, cx, scope);
	}
	public static JSDelegate<Server> toScriptable(Server obj, Context cx, Scriptable scope)
	{
		return toScriptable("Server", obj, cx, scope);
	}
	public static JSDelegate<Vector> toScriptable(Vector obj, Context cx, Scriptable scope)
	{
		return toScriptable("Vector", obj, cx, scope);
	}
	public static JSDelegate<World> toScriptable(World obj, Context cx, Scriptable scope)
	{
		return toScriptable("World", obj, cx, scope);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> JSDelegate<T> toScriptable(String s, T obj, Context cx, Scriptable scope)
	{
		if (obj == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JSDelegate<T> newObj = (JSDelegate<T>)cx.newObject(scope, s);
		MinecraftJS.m_bInternalConstruction = false;
		newObj.initializeFunctionProperties();
		newObj.setDelegate(obj);
		return newObj;
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
	
	public static Scriptable toScriptable(ItemSpawnEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_ItemSpawnEvent entity = (JS_ItemSpawnEvent)cx.newObject(scope, "ItemSpawnEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	// world events
	public static Scriptable toScriptable(ChunkLoadEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_ChunkLoadEvent entity = (JS_ChunkLoadEvent)cx.newObject(scope, "ChunkLoadEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}

	public static Scriptable toScriptable(ChunkUnloadEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_ChunkUnloadEvent entity = (JS_ChunkUnloadEvent)cx.newObject(scope, "ChunkUnloadEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}

	public static Scriptable toScriptable(PortalCreateEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PortalCreateEvent entity = (JS_PortalCreateEvent)cx.newObject(scope, "PortalCreateEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}

	public static Scriptable toScriptable(SpawnChangeEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_SpawnChangeEvent entity = (JS_SpawnChangeEvent)cx.newObject(scope, "SpawnChangeEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}

	public static Scriptable toScriptable(WorldInitEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_WorldInitEvent entity = (JS_WorldInitEvent)cx.newObject(scope, "WorldInitEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	public static Scriptable toScriptable(WorldLoadEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_WorldLoadEvent entity = (JS_WorldLoadEvent)cx.newObject(scope, "WorldLoadEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}

	public static Scriptable toScriptable(WorldSaveEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_WorldSaveEvent entity = (JS_WorldSaveEvent)cx.newObject(scope, "WorldSaveEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}

	public static Scriptable toScriptable(WorldUnloadEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_WorldUnloadEvent entity = (JS_WorldUnloadEvent)cx.newObject(scope, "WorldUnloadEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
	
	// server events
	public static Scriptable toScriptable(PluginDisableEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PluginDisableEvent entity = (JS_PluginDisableEvent)cx.newObject(scope, "PluginDisableEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}

	public static Scriptable toScriptable(PluginEnableEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_PluginEnableEvent entity = (JS_PluginEnableEvent)cx.newObject(scope, "PluginEnableEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}

	public static Scriptable toScriptable(ServerCommandEvent e, Context cx, Scriptable scope)
	{
		if (e == null)
		{
			return null;
		}
		
		MinecraftJS.m_bInternalConstruction = true;
		JS_ServerCommandEvent entity = (JS_ServerCommandEvent)cx.newObject(scope, "ServerCommandEvent");
		MinecraftJS.m_bInternalConstruction = false;
		entity.initializeFunctionProperties();
		entity.event = e;
		return entity;
	}
}
