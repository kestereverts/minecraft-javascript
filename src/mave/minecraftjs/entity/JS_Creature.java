package mave.minecraftjs.entity;

import mave.minecraftjs.ConvertUtility;
import mave.minecraftjs.JSDelegate;

import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JS_Creature<D extends Creature> extends JS_LivingEntity<D>
{

	private static final long serialVersionUID = 5147376327996533412L;

	public JS_Creature()
	{	
	}
	
	public void jsConstructor()
	{
		throw Context.reportRuntimeError("This internal class cannot be instantiated");
	}
	
	@Override
	public String getClassName()
	{
		return "Creature";
	}
	
	public final Scriptable jsGet_target()
	{
		Context cx = Context.getCurrentContext();
		Scriptable scope = ScriptableObject.getTopLevelScope(this);
		
		return ConvertUtility.entityToScriptable(getDelegate().getTarget(), cx, scope);
	}
	
	@SuppressWarnings("unchecked")
	public final void jsSet_target(Scriptable target)
	{
		if (!(target instanceof JSDelegate))
		{
			throw new IllegalArgumentException();
		}
		JSDelegate<?> delegate = (JSDelegate<?>)target;
		if (!(delegate.getDelegate() instanceof LivingEntity))
		{
			throw new IllegalArgumentException();
		}
		JSDelegate<LivingEntity> entity = (JSDelegate<LivingEntity>)delegate;
		getDelegate().setTarget(entity.getDelegate());
	}
}
