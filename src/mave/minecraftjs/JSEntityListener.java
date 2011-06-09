package mave.minecraftjs;

import org.bukkit.event.Event;
import org.bukkit.event.entity.*;
import org.bukkit.event.painting.PaintingBreakEvent;
import org.bukkit.event.painting.PaintingPlaceEvent;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class JSEntityListener extends EntityListener
{
	private EventRegistration m_eventRegistration = null;
	
	public JSEntityListener(EventRegistration eventRegistration)
	{
		m_eventRegistration = eventRegistration;
	}

	@Override
	public void onCreatureSpawn(CreatureSpawnEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.CREATURE_SPAWN)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			String creatureType = event.getCreatureType().toString().toLowerCase();
			JS_Location location = (JS_Location)ConvertUtility.toScriptable(event.getLocation(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { creatureType, location } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onCreeperPower(CreeperPowerEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.CREEPER_POWER)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}

			// TODO: getLightning
			String cause = event.getCause().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { null, cause } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onEntityCombust(EntityCombustEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.ENTITY_COMBUST)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onEntityDamage(EntityDamageEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.ENTITY_DAMAGE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			String cause = event.getCause().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { event.getDamage(), cause } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onEntityDeath(EntityDeathEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.ENTITY_DEATH)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			Scriptable drops = cx.newArray(scope, event.getDrops().toArray());

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { drops } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onEntityExplode(EntityExplodeEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.ENTITY_EXPLODE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			Scriptable blockList = cx.newArray(scope, event.blockList().toArray());
			JS_Location location = (JS_Location)ConvertUtility.toScriptable(event.getLocation(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { blockList, location, event.getYield() } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onEntityInteract(EntityInteractEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.ENTITY_INTERACT)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { block } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onEntityTarget(EntityTargetEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.ENTITY_TARGET)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			Scriptable target = null;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
				target = ConvertUtility.entityToScriptable(event.getTarget(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}

			String reason = event.getReason().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { target, reason } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onExplosionPrime(ExplosionPrimeEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.EXPLOSION_PRIME)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			Scriptable entity = scope;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getEntity(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, entity, new Object[] { event.getRadius(), event.getFire() } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onPaintingBreak(PaintingBreakEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.PAINTING_BREAK)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			// TODO: getPainting
			String cause = event.getCause().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { cause } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onPaintingPlace(PaintingPlaceEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.PAINTING_PLACE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			// TODO: getPainting
			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
			JS_BlockFace face = (JS_BlockFace)ConvertUtility.toScriptable(event.getBlockFace(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { player, block, face } );
			globalScope.delete("_event");
		}
	}
	
	@Override
	public void onPigZap(PigZapEvent event)
	{
		if (m_eventRegistration.m_eventType == Event.Type.PIG_ZAP)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();
			
			// TODO: getPigZombie
			// TODO: getLighting

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, scope, new Object[] { null, null } );
			globalScope.delete("_event");
		}
	}
}