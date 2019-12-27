/*
 * Author 		:	Noopur R K
 * UFID   		:	1980 - 9834
 * Class name	:	LoggingUtil.java
 * Description	:	This class is responsible for the logging of messages.
 * Institution	:	University of Florida
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingUtil 
{
	static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	LoggingUtil(int peerID)
	{
		boolean append = true;
        FileHandler handler;
        String currentDir = System.getProperty("user.dir");
        String path = currentDir+File.separator+ "log_peer_"+ peerID + ".log";
        
		try {
			handler = new FileHandler(path, append);
			LoggingUtil.LOGGER.addHandler(handler);
			handler.setFormatter(new MyFormatter());	
		} 
		catch (SecurityException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logMessage(String message) 
    { 
		LoggingUtil.LOGGER.log(Level.INFO, message);
        
    }

	/**
	 * @return the lOGGER
	 */
	public static Logger getLOGGER() {
		return LOGGER;
	}

	/**
	 * @param lOGGER the lOGGER to set
	 */
	public static void setLOGGER(Logger lOGGER) {
		LOGGER = lOGGER;
	} 
}
