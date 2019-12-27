/*
 * Author 		:	Noopur R K
 * UFID   		:	1980 - 9834
 * Class name	:	MyFormatter.java
 * Description	:	This class is responsible for formatting the log messages.
 * Institution	:	University of Florida
 */

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        String message = record.getMessage();
        //Define a format for the message and use it here!
        return new Date(record.getMillis())+":" + "Peer" + " " + record.getMessage()+"\n";
    }

}

