package mave.minecraftjs;

import org.bukkit.event.Event;
import org.bukkit.event.block.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class JSBlockListener extends BlockListener
{
	private EventRegistration m_eventRegistration = null;
	
    public JSBlockListener(EventRegistration eventRegistration)
    {
    	m_eventRegistration = eventRegistration;
    }

    @Override
    public void onBlockPhysics(BlockPhysicsEvent event)
    {
		if (m_eventRegistration.m_eventType == Event.Type.BLOCK_PHYSICS)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
	    	JS_Material material = (JS_Material)ConvertUtility.toScriptable(event.getChangedType(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
	    	m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { material } );
	    	globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockCanBuild(BlockCanBuildEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.BLOCK_CANBUILD)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
	    	JS_Material material = (JS_Material)ConvertUtility.toScriptable(event.getMaterial(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
	    	m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { material, event.isBuildable() } );
	    	globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockBreak(BlockBreakEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.BLOCK_BREAK)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
	    	JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
	    	m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { player } );
	    	globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockBurn(BlockBurnEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.BLOCK_BURN)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockDamage(BlockDamageEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.BLOCK_DAMAGE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_ItemStack itemInHand = (JS_ItemStack)ConvertUtility.toScriptable(event.getItemInHand(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { player, itemInHand, event.getInstaBreak() } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockDispense(BlockDispenseEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.BLOCK_DISPENSE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
			JS_ItemStack item = (JS_ItemStack)ConvertUtility.toScriptable(event.getItem(), cx, scope);
			JS_Vector velocity = (JS_Vector)ConvertUtility.toScriptable(event.getVelocity(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { item, velocity } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockFromTo(BlockFromToEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.BLOCK_FROMTO)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
			JS_Block toBlock = (JS_Block)ConvertUtility.toScriptable(event.getToBlock(), cx, scope);
			JS_BlockFace face = (JS_BlockFace)ConvertUtility.toScriptable(event.getFace(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { toBlock, face } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockIgnite(BlockIgniteEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.BLOCK_IGNITE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			String cause = event.getCause().toString().toLowerCase();

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { player, cause } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockPlace(BlockPlaceEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.BLOCK_PLACE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			JS_Block blockPlaced = (JS_Block)ConvertUtility.toScriptable(event.getBlockPlaced(), cx, scope);
			JS_Block blockAgainst = (JS_Block)ConvertUtility.toScriptable(event.getBlockAgainst(), cx, scope);
			JS_ItemStack itemInHand = (JS_ItemStack)ConvertUtility.toScriptable(event.getItemInHand(), cx, scope);
			// TODO: getBlockReplacedState

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { player, blockPlaced, blockAgainst, itemInHand } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onLeavesDecay(LeavesDecayEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.LEAVES_DECAY)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onSnowForm(SnowFormEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.SNOW_FORM)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
			JS_Material material = (JS_Material)ConvertUtility.toScriptable(event.getMaterial(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { material } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onSignChange(SignChangeEvent event)
    {
    	if (m_eventRegistration.m_eventType == Event.Type.SIGN_CHANGE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);
			JS_Player player = (JS_Player)ConvertUtility.toScriptable(event.getPlayer(), cx, scope);
			Object[] lines_ = event.getLines();
			Scriptable lines = cx.newArray(scope, lines_);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { player, lines } );
			globalScope.delete("_event");
		}
    }
    
    @Override
    public void onBlockRedstoneChange(BlockRedstoneEvent event)
    {    	
    	if (m_eventRegistration.m_eventType == Event.Type.REDSTONE_CHANGE)
		{
    		m_eventRegistration.m_script.enterContext();
        	Context cx = Context.getCurrentContext();
        	Scriptable globalScope = MinecraftJS.m_currentScript.m_globalScope;
        	
			Scriptable scope = m_eventRegistration.m_scriptFunction.getParentScope();

			JS_Block block = (JS_Block)ConvertUtility.toScriptable(event.getBlock(), cx, scope);

			globalScope.put("_event", globalScope, ConvertUtility.toScriptable(event, cx, scope));
			m_eventRegistration.m_scriptFunction.call(cx, MinecraftJS.m_currentScript.m_globalScope, block, new Object[] { event.getOldCurrent(), event.getNewCurrent() } );
			globalScope.delete("_event");
		}
    }
}