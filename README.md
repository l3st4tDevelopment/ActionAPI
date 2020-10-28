# ActionAPI
A small ActionAPI for use in my own personal plugins.

# Available Actions
* [ActionBarMessage] (Message) - Sends an actionbar message to the player. The message supports the MiniMessage format. See below.
* [ActionBarBroadcast] (Message) - Same as ActionBarMessage, but broadcasts it to the entire server.
* [ConsoleCommand] (Command) - Execute a command as console.
* [Kick] (Message) - Kick a player. This uses the Spigot kick function, and supports the standard color codes.
* [Message] (Message) - Sends a message to the player. Supports the MiniMessage format.
* [Broadcast] (Message) - Broadcasts a message to the server. Same as Message though.
* [PlayerCommand] (Command) - Executes a command as the player.
* [Sound] (Sound) - Plays a sound to the player.
* [VaultGive] (Amount) - Give a certain amount to the player.
* [VaultTake] (Amount) - Take a certain amount from the player.

# Sounds
https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Sound.html

These can be used in the Sound action.

# MiniMessage
ActionBarBroadcast, ActionBarMessage, Message and Broadcast use the MiniMessage format. You can find out more here: 

https://docs.adventure.kyori.net/minimessage.html

# Usage
You can use this as a plugin dependency, or shade it into your plugin.
Maven Repository:

            <repository>
                <id>l3tplay-repo</id>
                <url>https://nexus.l3tplay.com/repository/maven-snapshots/</url>
            </repository>
            
Dependency usage:

            <dependency>
                <groupId>com.l3tplay</groupId>
                <artifactId>ActionAPI</artifactId>
                <version>1.1.0-SNAPSHOT</version>
                <scope>provided</scope>
            </dependency>

You can access the ActionManager with:

    ActionAPIPlugin.getInstance().getActionManager()
    
Remember to depend on the ActionAPI on your plugin.yml.

    depend: [ActionAPI]
    
If you want to shade it, you need to remove the scope tag in the dependency, like this:

            <dependency>
                <groupId>com.l3tplay</groupId>
                <artifactId>ActionAPI</artifactId>
                <version>1.1.0-SNAPSHOT</version>
            </dependency>
            
You'll need to initialize your ActionManager object like this:

    ActionManager actionManager = new ActionManager(JavaPlugin);
   
