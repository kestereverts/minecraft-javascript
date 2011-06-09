package mave.bukkittest;

import java.net.InetAddress;

import org.bukkit.event.Event;
import org.bukkit.event.player.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class BukkitTestPlayerListener extends PlayerListener
{
	private EventRegistration m_eventRegistration = null;
	
    public BukkitTestPlayerListener(EventRegistration eventRegistration)
    {
        m_eventRegistration = eventRegistration;
    }
    
    @Override
    public void onPlayerAnimation(PlayerAnimationEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_ANIMATION)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			String animationType = event.getAnimationType().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { animationType } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerBedEnter(PlayerBedEnterEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_BED_ENTER)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Block bed = (JS_Block)ConvertUtility.toScriptable(event.getBed(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { bed } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerBedLeave(PlayerBedLeaveEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_BED_LEAVE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Block bed = (JS_Block)ConvertUtility.toScriptable(event.getBed(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { bed } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_BUCKET_EMPTY)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Material bucket = (JS_Material)ConvertUtility.toScriptable(event.getBucket(), cx, scope);
			JS_ItemStack itemStack = (JS_ItemStack)ConvertUtility.toScriptable(event.getItemStack(), cx, scope);
			JS_Block blockClicked = (JS_Block)ConvertUtility.toScriptable(event.getBlockClicked(), cx, scope);
			JS_BlockFace face = (JS_BlockFace)ConvertUtility.toScriptable(event.getBlockFace(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { bucket, itemStack, blockClicked, face } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerBucketFill(PlayerBucketFillEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_BUCKET_FILL)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Material bucket = (JS_Material)ConvertUtility.toScriptable(event.getBucket(), cx, scope);
			JS_ItemStack itemStack = (JS_ItemStack)ConvertUtility.toScriptable(event.getItemStack(), cx, scope);
			JS_Block blockClicked = (JS_Block)ConvertUtility.toScriptable(event.getBlockClicked(), cx, scope);
			JS_BlockFace face = (JS_BlockFace)ConvertUtility.toScriptable(event.getBlockFace(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { bucket, itemStack, blockClicked, face } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerChat(PlayerChatEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_CHAT)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			
			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));			
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { cx.newArray(scope, event.getRecipients().toArray()), event.getMessage(), event.getFormat() } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_COMMAND_PREPROCESS)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { cx.newArray(scope, event.getRecipients().toArray()), event.getMessage(), event.getFormat() } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerDropItem(PlayerDropItemEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_DROP_ITEM)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Item item = (JS_Item)ConvertUtility.toScriptable(event.getItemDrop(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { item } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerEggThrow(PlayerEggThrowEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_EGG_THROW)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			// TODO: getEgg
			String hatchType = event.getHatchType().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { null, event.isHatching(), event.getNumHatches(), hatchType } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerInteract(PlayerInteractEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_INTERACT)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			String action = event.getAction().toString().toLowerCase();
			JS_Block clickedBlock = (JS_Block)ConvertUtility.toScriptable(event.getClickedBlock(), cx, scope);
			JS_ItemStack item = (JS_ItemStack)ConvertUtility.toScriptable(event.getItem(), cx, scope);
			JS_Material material = (JS_Material)ConvertUtility.toScriptable(event.getMaterial(), cx, scope);
			JS_BlockFace face = (JS_BlockFace)ConvertUtility.toScriptable(event.getBlockFace(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { action, clickedBlock, item, material, face } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_INTERACT_ENTITY)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			Scriptable entity = null;
			try
			{
				entity = ConvertUtility.entityToScriptable(event.getRightClicked(), cx, scope);
			}
			catch (IllegalArgumentException ex)
			{
			}

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { entity } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onInventoryOpen(PlayerInventoryEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_INVENTORY)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			// TODO: getInventory

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { null } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onItemHeldChange(PlayerItemHeldEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_ITEM_HELD)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { event.getPreviousSlot(), event.getNewSlot() } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerJoin(PlayerJoinEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_JOIN)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { event.getJoinMessage() } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerKick(PlayerKickEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_KICK)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { event.getReason(), event.getLeaveMessage() } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerLogin(PlayerLoginEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_LOGIN)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			String result = event.getResult().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { event.getKickMessage(), result } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerMove(PlayerMoveEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_MOVE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Location from = (JS_Location)ConvertUtility.toScriptable(event.getFrom(), cx, scope);
			JS_Location to = (JS_Location)ConvertUtility.toScriptable(event.getTo(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { from, to } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerPickupItem(PlayerPickupItemEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_PICKUP_ITEM)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Item item = (JS_Item)ConvertUtility.toScriptable(event.getItem(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { item } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerPreLogin(PlayerPreLoginEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_PRELOGIN)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			InetAddress address = event.getAddress();
			String result = event.getResult().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, scope, new Object[] { event.getName(), address, event.getKickMessage(), result } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerQuit(PlayerQuitEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_QUIT)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { event.getQuitMessage() } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_RESPAWN)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Location respawnLocation = (JS_Location)ConvertUtility.toScriptable(event.getRespawnLocation(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { respawnLocation } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerTeleport(PlayerTeleportEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_TELEPORT)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Location from = (JS_Location)ConvertUtility.toScriptable(event.getFrom(), cx, scope);
			JS_Location to = (JS_Location)ConvertUtility.toScriptable(event.getTo(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { from, to } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.PLAYER_TOGGLE_SNEAK)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = BukkitTest.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));	
			m_eventRegistration.m_scriptFunction.call(cx, BukkitTest.m_currentScript.m_globalScope, player, new Object[] { } );
			globalScope.delete("_event");
		}
    }
}