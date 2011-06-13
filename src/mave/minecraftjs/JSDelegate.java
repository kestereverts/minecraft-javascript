package mave.minecraftjs;

import org.mozilla.javascript.ScriptableObject;


public abstract class JSDelegate<D> extends ScriptableObject
{

	private static final long serialVersionUID = 3691607879200730246L;

	private D delegate = null;
	
	public JSDelegate()
	{	
	}
	
	/**
	 * Get the underlying Bukkit object for this JavaScript object
	 * @return D
	 */
	public final D getDelegate()
	{
		return delegate;
	}
	
	/**
	 * Set the underlying Bukkit object for this JavaScript object
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
				JSDelegate.class, DONTENUM);
	}
	
	
	@Override
	public String toString()
	{
		return delegate.toString();
	}

}
