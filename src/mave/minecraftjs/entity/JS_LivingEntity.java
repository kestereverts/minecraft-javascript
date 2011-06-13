package mave.minecraftjs.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JSDelegate;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_LivingEntity<D extends LivingEntity> extends JS_Entity<D>
{
	private static final long serialVersionUID = -5122206787930826515L;
	
	public JS_LivingEntity()
	{	
	}
	
	public void jsConstructor()
	{
		throw Context.reportRuntimeError("This internal class cannot be instantiated");
	}
	
	@Override
	public String getClassName()
	{
		return "LivingEntity";
	}
	
	@SuppressWarnings("unchecked")
	public final static void jsFunction_damage(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 1)
		{
			throw new IllegalArgumentException();
		}
		JS_LivingEntity<LivingEntity> caller = (JS_LivingEntity<LivingEntity>)thisObj;
		
		if (args.length < 2)
		{
			caller.getDelegate().damage((int)Context.toNumber(args[0]));
			return;
		}

		if (!(args[1] instanceof JSDelegate))
		{
			throw new IllegalArgumentException();
		}
		JSDelegate<?> delegate = (JSDelegate<?>)args[1];
		if (!(delegate.getDelegate() instanceof Entity))
		{
			throw new IllegalArgumentException();
		}
		JSDelegate<Entity> entity = (JSDelegate<Entity>)delegate;
		
		caller.getDelegate().damage((int)Context.toNumber(args[0]), entity.getDelegate());
	}
	
	public final int jsGet_health()
	{
		return getDelegate().getHealth();
	}
	
	public final void jsSet_health(int iHealth)
	{
		getDelegate().setHealth(iHealth);
	}
	
	@SuppressWarnings("unchecked")
	public final static double jsFunction_getEyeHeight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		JS_LivingEntity<LivingEntity> caller = (JS_LivingEntity<LivingEntity>)thisObj;
		if (args.length < 1)
		{
			return caller.getDelegate().getEyeHeight();
		}
		return caller.getDelegate().getEyeHeight(Context.toBoolean(args[0]));
	}
	
	public final Scriptable jsGet_eyeLocation()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.toScriptable(getDelegate().getEyeLocation(), cx, scope);
	}
	
	public final boolean jsGet_insideVehicle()
	{
		return getDelegate().isInsideVehicle();
	}
	
	public final boolean jsFunction_leaveVehicle()
	{
		return getDelegate().leaveVehicle();
	}
	
	public final int jsGet_remainingAir()
	{
		return getDelegate().getRemainingAir();
	}
	
	public final void jsSet_remainingAir(int iRemainingAir)
	{
		getDelegate().setRemainingAir(iRemainingAir);
	}
	
	public final int jsGet_maximumAir()
	{
		return getDelegate().getMaximumAir();
	}
	
	public final void jsSet_maximumAir(int iMaximumAir)
	{
		getDelegate().setMaximumAir(iMaximumAir);
	}
	
	public final int jsGet_maximumNoDamageTicks()
	{
		return getDelegate().getMaximumNoDamageTicks();
	}
	
	public final void jsSet_maximumNoDamageTicks(int iTicks)
	{
		getDelegate().setMaximumNoDamageTicks(iTicks);
	}
	
	public final int jsGet_lastDamage()
	{
		return getDelegate().getLastDamage();
	}
	
	public final void jsSet_lastDamage(int iLastDamage)
	{
		getDelegate().setLastDamage(iLastDamage);
	}

	
	@SuppressWarnings("unchecked")
	public final static Scriptable jsFunction_getLastTwoTargetBlocks(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_LivingEntity<LivingEntity> caller = (JS_LivingEntity<LivingEntity>)thisObj;

		if (!(args[0] == null || args[0] instanceof NativeArray))
		{
			throw new IllegalArgumentException();
		}

		HashSet<Byte> hashSet = null;
		if (args[0] != null)
		{
			hashSet = new HashSet<Byte>();

			NativeArray arr = (NativeArray)args[0];
			for (Object o : arr.getIds())
			{
			    hashSet.add(new Byte((byte)Context.toNumber(arr.get((Integer)o, null))));
			}
		}

		List<Block> lstBlocks = caller.getDelegate().getLastTwoTargetBlocks(hashSet, (int)Context.toNumber(args[1]));
		List<Scriptable> lstObjects = new ArrayList<Scriptable>();
		for (Block b : lstBlocks)
		{
			lstObjects.add(ConvertUtility.toScriptable(b, cx, thisObj));
		}
		return cx.newArray(thisObj, lstObjects.toArray());
	}

	@SuppressWarnings("unchecked")
	public final static Scriptable jsFunction_getLineOfSight(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_LivingEntity<LivingEntity> caller = (JS_LivingEntity<LivingEntity>)thisObj;

		if (!(args[0] == null || args[0] instanceof NativeArray))
		{
			throw new IllegalArgumentException();
		}

		HashSet<Byte> hashSet = null;
		if (args[0] != null)
		{
			hashSet = new HashSet<Byte>();

			NativeArray arr = (NativeArray)args[0];
			for (Object o : arr.getIds())
			{
			    hashSet.add(new Byte((byte)Context.toNumber(arr.get((Integer)o, null))));
			}
		}

		List<Block> lstBlocks = caller.getDelegate().getLineOfSight(hashSet, (int)Context.toNumber(args[1]));
		List<Scriptable> lstObjects = new ArrayList<Scriptable>();
		for (Block b : lstBlocks)
		{
			lstObjects.add(ConvertUtility.toScriptable(b, cx, thisObj));
		}
		return cx.newArray(thisObj, lstObjects.toArray());
	}
	
	@SuppressWarnings("unchecked")
	public final static Scriptable jsFunction_getTargetBlock(Context cx, Scriptable thisObj, Object[] args, Function funObj)
	{
		if (args.length < 2)
		{
			throw new IllegalArgumentException();
		}
		JS_LivingEntity<LivingEntity> caller = (JS_LivingEntity<LivingEntity>)thisObj;

		if (!(args[0] == null || args[0] instanceof NativeArray))
		{
			throw new IllegalArgumentException();
		}

		HashSet<Byte> hashSet = null;
		if (args[0] != null)
		{
			hashSet = new HashSet<Byte>();

			NativeArray arr = (NativeArray)args[0];
			for (Object o : arr.getIds())
			{
			    hashSet.add(new Byte((byte)Context.toNumber(arr.get((Integer)o, null))));
			}
		}

		return ConvertUtility.toScriptable(caller.getDelegate().getTargetBlock(hashSet, (int)Context.toNumber(args[1])), cx, thisObj);
	}
	
	public final int jsGet_noDamageTicks()
	{
		return getDelegate().getNoDamageTicks();
	}
	
	public final void jsSet_noDamageTicks(int iTicks)
	{
		getDelegate().setNoDamageTicks(iTicks);
	}
}
