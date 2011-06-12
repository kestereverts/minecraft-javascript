package mave.minecraftjs;

import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
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
	
	public final void jsSet_target(Scriptable target)
	{
		Entity entity = ConvertUtility.scriptableToEntity(target);
		if (!(entity instanceof LivingEntity))
		{
			throw new IllegalArgumentException();
		}
		
		getDelegate().setTarget((LivingEntity)entity);
	}
}
