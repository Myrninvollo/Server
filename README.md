Raft
==========

Raft is a mod API for Minecraft servers; it does not require a client mod. Raft focuses on independence, speed, and community. Why is Raft better than Sponge, Granite, Ingot, and Glowstone? Raft is a very simple, yet extensive API. All of the API provides access to 'NMS' code, so if you can't get your way with just our tools, you can break into the source code of a vanilla server. With Raft being a 'wrapper' API, it can be updated very quickly to the latest Minecraft server version. (And hey, we're not named after a block!) Raft also provides UUID support.

### Example Plugin
##### MyPlugin.class
```
package com.me;
import org.raftpowered.*;

public class MyPlugin extends Plugin {
  public void onEnable() {
    Raft.logInfo("Registering my command!");
    Raft.addCommand(new MyCommand());
  }
  public String getName() { return "MyPlugin"; }
  public String getDescription() { return "An example plugin"; }
  public String getVersion() { return "1.0"; }
}
```
##### MyCommand.class
```
package com.me;
import org.raftpowered.*;

public class MyCommand extends Command {
  public void process(CommandSender sender, String[] args) {
    sender.sendMessage(ChatColor.GREEN + "Hey there, " + sender.getName());
  }
  public String getName() { return "mycommand"; }
  public String getDescription() { return "My new command."; }
  public String getUsage() { return "/mycommand"; }
}
```
##### main.txt
```
com.me.MyPlugin
```
##### (Yes, that's it!)
