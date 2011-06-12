package mave.minecraftjs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.mozilla.javascript.*;

public class JS_Chunk extends ScriptableObject
{
	private static final long serialVersionUID = -1497062392483365857L;
	public Chunk chunk = null;

	public JS_Chunk()
	{
	}
	
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				JS_Chunk.class, DONTENUM);
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
		return chunk.toString();
	}
	
	@Override
	public String getClassName()
	{
		return "Chunk";
	}
	
	public static Scriptable jsFunction_getBlock(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 3)
		{
			throw new IllegalArgumentException();
		}
		JS_Chunk caller = (JS_Chunk)thisObj;
		
		return ConvertUtility.toScriptable(caller.chunk.getBlock((int)Context.toNumber(args[0]), (int)Context.toNumber(args[1]), (int)Context.toNumber(args[2])), cx, thisObj);
	}
	
	// TODO: jsGet_chunkSnapshot
	
	public Scriptable jsGet_entities()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		Entity[] entities = chunk.getEntities();
		List<Object> res = new ArrayList<Object>();
		
		for (Entity e : entities)
		{
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
	
	public int jsGet_x()
	{
		return chunk.getX();
	}
	
	public int jsGet_z()
	{
		return chunk.getZ();
	}

	public Scriptable jsGet_world()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(chunk.getWorld(), cx, scope);
	}
}
