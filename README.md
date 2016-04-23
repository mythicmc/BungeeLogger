# BungeeLogger
Simple logging API for BungeeCord plugins

BungeeLogger is an API for BungeeCord plugins built on log4j, aimed at providing better logging than BungeeCord's built-in logger. This is not the same thing as the BungeeLogger class inside BungeeCord! Instead of spitting out one huge proxy.log.0 file, BungeeLogger mimics Minecraft/Bukkit/Spigot server logging by rolling over the log file at midnight and storing the logs in logs/ under the Bungee directory, with the format bungee.log.yyyy-mm-dd. The main difference, however, is that a new log file is not started upon every Bungee restart; there is only one log file per day.


## Usage
To create a logger for your plugin, add BungeeLogger as a dependency and use the createLogger() method in the BungeeLoggerPlugin instance, passing in your plugin class as the single argument. This will return a BungeeLog object that you can invoke in a similar manner to other loggers.

The JavaDocs can be found at http://kyzderp.github.io/bungeelogger/doc/

Example Bungee plugin class:

    import io.github.kyzderp.bungeelogger.BungeeLog;
    import io.github.kyzderp.bungeelogger.BungeeLoggerPlugin;
    import net.md_5.bungee.api.plugin.Plugin;
    
    public class ExampleBungeePlugin extends Plugin
    {
      private BungeeLog exampleLogger;
      
      public void onLoad()
      {
        this.exampleLogger = BungeeLoggerPlugin.instance.createLogger(this);
        this.exampleLogger.info("Plugin loaded!");
      }
      
      public void onEnable()
      {
        this.exampleLogger.info("Plugin enabled!");
      }
      
      public void onDisable()
      {
        this.exampleLogger.info("Plugin disabled!");
      }
    }

## License
    Copyright © 2016 Hannah Chu 
    
    BungeeLogger is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    
    BungeeLogger is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    
    You should have received a copy of the GNU General Public License
    along with BungeeLogger.  If not, see <http://www.gnu.org/licenses/>.
