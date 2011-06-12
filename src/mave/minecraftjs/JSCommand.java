package mave.minecraftjs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class JSCommand extends Command
{
	private Script m_script = null;
	
	public JSCommand(String name, Script script)
	{
		super(name);
		m_script = script;
	}

	@Override
	public boolean execute(CommandSender commandSender, String commandLabel, String[] args)
	{
		return m_script.handleCommand(commandSender, this, commandLabel, args);
	}
}
