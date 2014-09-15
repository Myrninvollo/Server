package net.minecraft.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;
import org.raftpowered.events.EventListener;
import org.raftpowered.events.PlayerCommandEvent;

public class CommandHandler implements ICommandManager
{
    private static final Logger logger = LogManager.getLogger();

    /** Map of Strings to the ICommand objects they represent */
    private final Map commandMap = new HashMap();

    /** The set of ICommand objects currently loaded. */
    private final Set commandSet = new HashSet();
    private static final String __OBFID = "CL_00001765";

    public boolean isCommand(Command command, String name) {
    	if(command.getName() == null) return false;
    	if(command.getName().equalsIgnoreCase(name)) return true;
    	for(String alias : command.getAliases()) if(alias.equalsIgnoreCase(name)) return true;
    	return false;
    }
    
    public boolean partOfCommand(Command command, String name) {
    	if(command.getName() == null) return false;
    	if(command.getName().toLowerCase().startsWith(name.toLowerCase())) return true;
    	for(String alias : command.getAliases()) if(alias.toLowerCase().startsWith(name.toLowerCase())) return true;
    	return false;
    }
    
    public int executeCommand(ICommandSender sender, String message) {
        message = message.trim();
        if(sender instanceof EntityPlayerMP) Raft.logInfo(sender.getCommandSenderName() + ": " + message);
        if(message.startsWith("/")) message = message.substring(1);
        
        String[] args = message.split(" ");
        String name = args[0];
        args = dropFirstString(args);
        
        CommandSender send = (sender instanceof EntityPlayerMP)
    			? new CommandSender(sender.getCommandSenderName())
    			: new CommandSender();
        
    	boolean cancelled = false;
    	for(EventListener listener : Raft.getListeners()) {
        	if(listener.onPlayerCommand(new PlayerCommandEvent(send, name, args)).getCancelled()) {
        		cancelled = true;
        	}
        }
        
        if(!cancelled) {
	        boolean found = false;
	        for(Command command : Raft.getCommands()) {
	        	if(isCommand(command, name)) {
	        		command.process(send, args);
	        		found = true;
	        		break;
	        	}
	        }
	        if(!found) sender.addChatMessage(new ChatComponentTranslation("Unknown command. Try 'help' for a command list."));
        }
        
        return 1;
    }

    /**
     * adds the command and any aliases it has to the internal map of available commands
     */
    public ICommand registerCommand(ICommand p_71560_1_) {
    	return p_71560_1_;
    }

    /**
     * creates a new array and sets elements 0..n-2 to be 0..n-1 of the input (n elements)
     */
    private static String[] dropFirstString(String[] p_71559_0_) {
        String[] var1 = new String[p_71559_0_.length - 1];
        for(int var2 = 1; var2 < p_71559_0_.length; ++var2) var1[var2 - 1] = p_71559_0_[var2];
        return var1;
    }

    /**
     * Performs a "begins with" string match on each token in par2. Only returns commands that par1 can use.
     */
    public List<String> getPossibleCommands(ICommandSender sender, String message) {
        String[] args = message.split(" ", -1);
        String name = args[0];
        args = dropFirstString(args);
        List<String> completions = new ArrayList<String>();
        if(args.length == 0) {
        	for(Command command : Raft.getCommands())
        		if(partOfCommand(command, name))
        			completions.add(command.getName());
        }
        else {
        	CommandSender send = (sender instanceof EntityPlayerMP)
        			? new CommandSender(sender.getCommandSenderName())
        			: new CommandSender();
        	for(Command command : Raft.getCommands())
        		if(isCommand(command, name))
        			completions = Arrays.asList(command.getTabCompletions(send, args));
        }
        return completions;
    }

    /**
     * returns all commands that the commandSender can use
     */
    public List getPossibleCommands(ICommandSender p_71557_1_)
    {
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.commandSet.iterator();

        while (var3.hasNext())
        {
            ICommand var4 = (ICommand)var3.next();

            if (var4.canCommandSenderUseCommand(p_71557_1_))
            {
                var2.add(var4);
            }
        }

        return var2;
    }

    /**
     * returns a map of string to commads. All commands are returned, not just ones which someone has permission to use.
     */
    public Map getCommands()
    {
        return this.commandMap;
    }

    /**
     * Return a command's first parameter index containing a valid username.
     */
    private int getUsernameIndex(ICommand p_82370_1_, String[] p_82370_2_)
    {
        if (p_82370_1_ == null)
        {
            return -1;
        }
        else
        {
            for (int var3 = 0; var3 < p_82370_2_.length; ++var3)
            {
                if (p_82370_1_.isUsernameIndex(p_82370_2_, var3) && PlayerSelector.matchesMultiplePlayers(p_82370_2_[var3]))
                {
                    return var3;
                }
            }

            return -1;
        }
    }
}
