package mave.bukkittest;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Listener;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

public class EventRegistration
{
	public Script m_script;
	public Event.Type m_eventType;
	public Function m_scriptFunction;
	public Priority m_priority;
	public Scriptable m_scope;
	
	public Listener m_listener;
	
	public static Event.Type stringToEventType(String s)
	{
		s = s.toLowerCase();
		int idx = s.indexOf('_');
		if (idx == -1)
		{
			throw new IllegalArgumentException();
		}
		
		String category = s.substring(0, idx);
		String event = s.substring(idx + 1);
		if (category.length() == 0 || event.length() == 0)
		{
			throw new IllegalArgumentException();
		}
		
		if (category.equals("block"))
		{
			if (event.equals("break"))
			{
				return Event.Type.BLOCK_BREAK;
			}
			else if (event.equals("burn"))
			{
				return Event.Type.BLOCK_BURN;
			}
			else if (event.equals("canbuild"))
			{
				return Event.Type.BLOCK_CANBUILD;
			}
			else if (event.equals("damage"))
			{
				return Event.Type.BLOCK_DAMAGE;
			}
			else if (event.equals("dispense"))
			{
				return Event.Type.BLOCK_DISPENSE;
			}
			else if (event.equals("fromto"))
			{
				return Event.Type.BLOCK_FROMTO;
			}
			else if (event.equals("ignite"))
			{
				return Event.Type.BLOCK_IGNITE;
			}
			else if (event.equals("physics"))
			{
				return Event.Type.BLOCK_PHYSICS;
			}
			else if (event.equals("place"))
			{
				return Event.Type.BLOCK_PLACE;
			}
			else if (event.equals("leaves_decay"))
			{
				return Event.Type.LEAVES_DECAY;
			}
			else if (event.equals("snow_form"))
			{
				return Event.Type.SNOW_FORM;
			}
			else if (event.equals("sign_change"))
			{
				return Event.Type.SIGN_CHANGE;
			}
			else if (event.equals("redstone_change"))
			{
				return Event.Type.REDSTONE_CHANGE;
			}
		}
		else if (category.equals("player"))
		{
			if (event.equals("animation"))
			{
				return Event.Type.PLAYER_ANIMATION;
			}
			else if (event.equals("bed_enter"))
			{
				return Event.Type.PLAYER_BED_ENTER;
			}
			else if (event.equals("bed_leave"))
			{
				return Event.Type.PLAYER_BED_LEAVE;
			}
			else if (event.equals("bucket_empty"))
			{
				return Event.Type.PLAYER_BUCKET_EMPTY;
			}
			else if (event.equals("bucket_fill"))
			{
				return Event.Type.PLAYER_BUCKET_FILL;
			}
			else if (event.equals("chat"))
			{
				return Event.Type.PLAYER_CHAT;
			}
			else if (event.equals("command_preprocess"))
			{
				return Event.Type.PLAYER_COMMAND_PREPROCESS;
			}
			else if (event.equals("drop_item"))
			{
				return Event.Type.PLAYER_DROP_ITEM;
			}
			else if (event.equals("egg_throw"))
			{
				return Event.Type.PLAYER_EGG_THROW;
			}
			else if (event.equals("interact"))
			{
				return Event.Type.PLAYER_INTERACT;
			}
			else if (event.equals("interact_entity"))
			{
				return Event.Type.PLAYER_INTERACT_ENTITY;
			}
			else if (event.equals("inventory"))
			{
				return Event.Type.PLAYER_INVENTORY;
			}
			else if (event.equals("item_held"))
			{
				return Event.Type.PLAYER_ITEM_HELD;
			}
			else if (event.equals("join"))
			{
				return Event.Type.PLAYER_JOIN;
			}
			else if (event.equals("kick"))
			{
				return Event.Type.PLAYER_KICK;
			}
			else if (event.equals("login"))
			{
				return Event.Type.PLAYER_LOGIN;
			}
			else if (event.equals("move"))
			{
				return Event.Type.PLAYER_MOVE;
			}
			else if (event.equals("pickup_item"))
			{
				return Event.Type.PLAYER_PICKUP_ITEM;
			}
			else if (event.equals("prelogin"))
			{
				return Event.Type.PLAYER_PRELOGIN;
			}
			else if (event.equals("quit"))
			{
				return Event.Type.PLAYER_QUIT;
			}
			else if (event.equals("respawn"))
			{
				return Event.Type.PLAYER_RESPAWN;
			}
			else if (event.equals("teleport"))
			{
				return Event.Type.PLAYER_TELEPORT;
			}
			else if (event.equals("toggle_sneak"))
			{
				return Event.Type.PLAYER_TOGGLE_SNEAK;
			}
		}
		
		throw new IllegalArgumentException();
	}
	
	public static Priority stringToPriority(String s)
	{
		s = s.toLowerCase();
		if (s.equals("high"))
		{
			return Priority.High;
		}
		else if (s.equals("highest"))
		{
			return Priority.Highest;
		}
		else if (s.equals("normal"))
		{
			return Priority.Normal;
		}
		else if (s.equals("low"))
		{
			return Priority.Low;
		}
		else if (s.equals("lowest"))
		{
			return Priority.Lowest;
		}
		else if (s.equals("monitor"))
		{
			return Priority.Monitor;
		}
		
		throw new IllegalArgumentException();
	}
}
