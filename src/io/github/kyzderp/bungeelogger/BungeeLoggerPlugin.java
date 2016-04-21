/**
 * This file is part of BungeeLogger.
 * 
 * BungeeLogger is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * BungeeLogger is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with BungeeLogger.  If not, see <http://www.gnu.org/licenses/>.
 * */

package io.github.kyzderp.bungeelogger;

import net.md_5.bungee.api.plugin.Plugin;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class BungeeLoggerPlugin extends Plugin 
{
	public static BungeeLoggerPlugin instance;

	private DailyRollingFileAppender rollingAppender;
	private Logger selfLogger;

	public void onLoad() 
	{
		instance = this;
		this.initializeAppender();
	}

	public void onEnable() 
	{
	}

	public void onDisable() 
	{
	}

	/**
	 * Creates a new logger for a Bungee plugin
	 * @param plugin The plugin for which to create the logger for
	 * @return The created logger
	 */
	public BungeeLog createLogger(Plugin plugin) {
		this.selfLogger.info("Creating new Bungee logger for plugin: "
				+ plugin.getDescription().getName());
		return new BungeeLog(plugin);
	}
	
	/**
	 * Initialize the base appender and logger
	 */
	private void initializeAppender() 
	{
		// Create the logging format
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern("[%d{HH:mm:ss}] [%t/%p]: %m%n");

		// Create daily rolling file appender
		this.rollingAppender = new DailyRollingFileAppender();
		this.rollingAppender.setFile("logs/bungee.log");
		this.rollingAppender.setDatePattern("'.'yyyy-MM-dd");
		this.rollingAppender.setLayout(layout);
		this.rollingAppender.activateOptions();
		
		// Configure root logger
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.DEBUG);
		rootLogger.addAppender(rollingAppender);

		// Create custom logger for this plugin
		this.selfLogger = Logger.getLogger(BungeeLoggerPlugin.class);

		this.selfLogger.info("Initialized self logger.");
	}
}
