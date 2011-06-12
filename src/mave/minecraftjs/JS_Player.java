package mave.minecraftjs;

import mave.minecraftjs.events.entity.JS_EntityDamageEvent;

import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.mozilla.javascript.*;

public class JS_Player extends ScriptableObject
{
	private static final long serialVersionUID = -657071278805801306L;
	public Player player = null;
	
	public JS_Player()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Player.class, DONTENUM);
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
		return player.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Player";
	}
	
	public java.util.UUID jsGet_uniqueId()
	{
		return player.getUniqueId();
	}
	
	public String jsGet_displayName()
	{
		return player.getDisplayName();
	}
	
	public void jsSet_displayName(String sDisplayName)
	{
		player.setDisplayName(sDisplayName);
	}
	
	public boolean jsGet_online()
	{
		return player.isOnline();
	}
	
	public static void jsFunction_sendRawMessage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		caller.player.sendRawMessage(Context.toString(args[0]));
	}
	
	public static void jsFunction_kickPlayer(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		caller.player.kickPlayer(Context.toString(args[0]));
	}
	
	public static void jsFunction_chat(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		caller.player.chat(Context.toString(args[0]));
	}
	
	public static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		if (args.length < 2)
		{
			caller.player.damage((int)Context.toNumber(args[0]));
			return;
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.player.damage((int)Context.toNumber(args[0]), entity);
	}
	
	public Scriptable jsGet_compassTarget()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(player.getCompassTarget(), cx, scope);
	}
	
	public void jsSet_compassTarget(Scriptable compassTarget)
	{
		if (!(compassTarget instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		
		JS_Location location = (JS_Location)compassTarget;
		player.setCompassTarget(location.location);
	}

	public static boolean jsFunction_performCommand(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		return caller.player.performCommand(Context.toString(args[0]));
	}
	
	public static void jsFunction_playNote(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		if (!(args[0] instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)args[0];
		
		caller.player.playNote(location.location, (byte)Context.toNumber(args[1]), (byte)Context.toNumber(args[2]));
	}
	
	public static void jsFunction_playEffect(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		if (!(args[0] instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)args[0];
		
		Effect effect = Effect.valueOf(Context.toString(args[0]).toUpperCase());
		caller.player.playEffect(location.location, effect, (int)Context.toNumber(args[2]));
	}
	
	// TODO: sendChunkChange
	
	public boolean jsGet_sneaking()
	{
		return player.isSneaking();
	}
	
	public void jsSet_sneaking(boolean bSneaking)
	{
		player.setSneaking(bSneaking);
	}
	
	public void jsSet_velocity(Scriptable vector)
	{
		if (!(vector instanceof JS_Vector))
		{
			throw new IllegalArgumentException();
		}
		JS_Vector vector_ = (JS_Vector)vector;
		
		player.setVelocity(vector_.vector);
	}
	
	public void jsFunction_saveData()
	{
		player.saveData();
	}
	
	public static void jsFunction_sendBlockChange(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		if (!(args[0] instanceof JS_Location))
		{
			throw new IllegalArgumentException();
		}
		JS_Location location = (JS_Location)args[0];
		
		if (args[1] instanceof JS_Material)
		{
			JS_Material material = (JS_Material)args[1];
			caller.player.sendBlockChange(location.location, material.material, (byte)Context.toNumber(args[2]));
			return;
		}
		
		caller.player.sendBlockChange(location.location, (int)Context.toNumber(args[1]), (byte)Context.toNumber(args[2]));
	}
	
	public void jsFunction_loadData()
	{
		player.loadData();
	}
	
	public void jsSet_sleepingIgnored(boolean bSleepingIgnored)
	{
		player.setSleepingIgnored(bSleepingIgnored);
	}
	
	public boolean jsGet_sleepingIgnored()
	{
		return player.isSleepingIgnored();
	}
	
	public void jsFunction_updateInventory()
	{
		player.updateInventory();
	}
	
	public int jsGet_health()
	{
		return player.getHealth();
	}
	
	public Scriptable jsGet_itemInHand()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(player.getItemInHand(), cx, scope);
	}
	
	public void jsSet_health(int iHealth)
	{
		player.setHealth(iHealth);
	}
	
	public static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_Player caller = (JS_Player)thisObj;
		if (args.length < 1)
		{
			return caller.player.getEyeHeight();
		}
		return caller.player.getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(player.getEyeLocation(), cx, scope);
	}
	
	public boolean jsGet_insideVehicle()
	{
		return player.isInsideVehicle();
	}
	
	public boolean jsFunction_leaveVehicle()
	{
		return player.leaveVehicle();
	}
	
	public int jsGet_remainingAir()
	{
		return player.getRemainingAir();
	}
	
	public void jsSet_remainingAir(int iRemainingAir)
	{
		player.setRemainingAir(iRemainingAir);
	}
	
	public int jsGet_maximumAir()
	{
		return player.getMaximumAir();
	}
	
	public void jsSet_maximumAir(int iMaximumAir)
	{
		player.setMaximumAir(iMaximumAir);
	}
	
	public int jsGet_maximumNoDamageTicks()
	{
		return player.getMaximumNoDamageTicks();
	}
	
	public void jsSet_maximumNoDamageTicks(int iTicks)
	{
		player.setMaximumNoDamageTicks(iTicks);
	}
	
	public int jsGet_lastDamage()
	{
		return player.getLastDamage();
	}
	
	public Scriptable jsGet_lastDamageCause()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(player.getLastDamageCause(), cx, scope);		
	}
	
	public void jsSet_lastDamageCause(Scriptable cause)
	{
		if (!(cause instanceof JS_EntityDamageEvent))
		{
			throw new IllegalArgumentException();
		}
		JS_EntityDamageEvent event = (JS_EntityDamageEvent)cause;
		
		player.setLastDamageCause(event.event);
	}
	
	public void jsSet_lastDamage(int iLastDamage)
	{
		player.setLastDamage(iLastDamage);
	}
	
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public int jsGet_noDamageTicks()
	{
		return player.getNoDamageTicks();
	}
	
	public void jsSet_noDamageTicks(int iTicks)
	{
		player.setNoDamageTicks(iTicks);
	}
	
	public int jsGet_sleepTicks()
	{
		return player.getSleepTicks();
	}
	
	public boolean jsGet_sleeping()
	{
		return player.isSleeping();
	}
	
	public static boolean jsFunction_teleport(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			return caller.player.teleport(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.player.teleport(entity);
	}
	
	public static void jsFunction_teleportTo(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		if (args[0] instanceof JS_Location)
		{
			JS_Location location = (JS_Location)args[0];
			caller.player.teleportTo(location.location);
		}
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		caller.player.teleportTo(entity);
	}
	
	public static Scriptable jsFunction_getNearbyEntities(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		return cx.newArray(thisObj, caller.player.getNearbyEntities(Context.toNumber(args[0]), Context.toNumber(args[1]), Context.toNumber(args[2])).toArray());
	}
	
	public int jsGet_entityId()
	{
		return player.getEntityId();
	}
	
	public int jsGet_fireTicks()
	{
		return player.getFireTicks();
	}
	
	public Scriptable jsGet_location()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(player.getLocation(), cx, scope);
	}
	
	public int jsGet_maxFireTicks()
	{
		return player.getMaxFireTicks();
	}
	
	public void jsSet_fireTicks(int iTicks)
	{
		player.setFireTicks(iTicks);
	}
	
	public void jsFunction_remove()
	{
		player.remove();
	}
	
	public boolean jsGet_dead()
	{
		return player.isDead();
	}
	
	public Scriptable jsGet_server()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(player.getServer(), cx, scope);
	}
	
	public Scriptable jsGet_velocity()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(player.getVelocity(), cx, scope);
	}
	
	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(player.getWorld(), cx, scope);
	}
	
	public Scriptable jsGet_passenger()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity entity = player.getPassenger();
		return ConvertUtility.entityToScriptable(entity, cx, scope);
	}
	
	public static boolean jsFunction_setPassenger(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[0]);
		return caller.player.setPassenger(entity);
	}
	
	public boolean jsGet_empty()
	{
		return player.isEmpty();
	}
	
	public boolean jsFunction_eject()
	{
		return player.eject();
	}
	
	public float jsGet_fallDistance()
	{
		return player.getFallDistance();
	}
	
	public void jsSet_fallDistance(float fFallDistance)
	{
		player.setFallDistance(fFallDistance);
	}
	
	public static void jsFunction_sendMessage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_Player caller = (JS_Player)thisObj;
		
		caller.player.sendMessage(Context.toString(args[0]));
	}
	
	public boolean jsGet_op()
	{
		return player.isOp();
	}
}

