package mave.minecraftjs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
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
		
		Entity entity = ConvertUtility.scriptableToEntity((Scriptable)args[1]); // this can throw IllegalArgumentException
		
		caller.getDelegate().damage((int)Context.toNumber(args[0]), entity);
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
	
	// TODO: getLastTwoTargetBlocks
	// TODO: getLineOfSight
	
	public final int jsGet_noDamageTicks()
	{
		return getDelegate().getNoDamageTicks();
	}
	
	public final void jsSet_noDamageTicks(int iTicks)
	{
		getDelegate().setNoDamageTicks(iTicks);
	}
}
