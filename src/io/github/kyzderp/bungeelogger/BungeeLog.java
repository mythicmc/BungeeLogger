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

import org.apache.log4j.Logger;

/**
 * Logger class for BungeeLogger, to be invoked similar to other Logger classes
 * @author Kyzeragon
 *
 */
public class BungeeLog 
{
	private Logger logger;
	private String prefix;

	public BungeeLog(Plugin plugin) 
	{
		this.prefix = "[" + plugin.getDescription().getName() + "] ";
		this.logger = Logger.getLogger(plugin.getClass());
	}

	/**
	 * Logs a message with level INFO
	 * @param message
	 */
	public void info(String message) {
		this.logger.info(this.prefix + message);
	}

	/**
	 * Logs a message with level WARN
	 * @param message
	 */
	public void warn(String message) {
		this.logger.warn(this.prefix + message);
	}

	/**
	 * Logs a message with level ERROR
	 * @param message
	 */
	public void error(String message) {
		this.logger.error(this.prefix + message);
	}

	/**
	 * Logs a message with level DEBUG
	 * @param message
	 */
	public void debug(String message) {
		this.logger.debug(this.prefix + message);
	}

	/**
	 * Logs a message with level FATAL
	 * @param message
	 */
	public void fatal(String message) {
		this.logger.fatal(this.prefix + message);
	}
}
