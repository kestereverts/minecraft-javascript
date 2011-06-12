package mave.minecraftjs;

import org.mozilla.javascript.ScriptableObject;


public abstract class JS_Delegate<D> extends ScriptableObject
{

	private static final long serialVersionUID = 3691607879200730246L;

	private D delegate = null;
	
	public JS_Delegate()
	{	
	}
	
	/**
	 * Get the underlying bukkit object for this Javascript object
	 * @return D
	 */
	public final D getDelegate()
	{
		return delegate;
	}
	
	/**
	 * Set the underlying bukkit object for this Javascript object
	 * @param delegate
	 */
	protected final void setDelegate(D delegate)
	{
		this.delegate = delegate;
	}
	
	/**
	 * Initializer that runs when the object is created through ConvertUtility
	 */
	public void initializeFunctionProperties()
	{
		defineFunctionProperties(new String[] { "toString" },
				this.getClass(), DONTENUM);
	}
	
	
	@Override
	public String toString()
	{
		return delegate.toString();
	}

}
