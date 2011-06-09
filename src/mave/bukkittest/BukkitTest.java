package mave.bukkittest;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.command.*;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitTest extends JavaPlugin
{
	public static BukkitTest m_singleton = null;
	
	public static boolean m_bInternalConstruction = false;
	
	public static Script m_currentScript = null;
	private List<Script> m_lstScripts = new ArrayList<Script>();
	
	public BukkitTest()
	{
		m_singleton = this;
	}
	
	public void onEnable()
	{
		try
		{
			Script s = new Script();
			s.load(new File("test.js"));
			m_lstScripts.add(s);
			
			Script s2 = new Script();
			s2.load(new File("test2.js"));
			m_lstScripts.add(s2);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onDisable()
	{
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		return false;
	}
}
