package kreuter.primeseuler.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Vera Kreuter
 */
public class Logger {
    
    private static FileWriter logFileWriter;
    
    public static FileWriter getLogFileWriter() {
        if (logFileWriter != null) {
            return logFileWriter;
        }
        String logFilePath = "src/log.txt";
        try {
            logFileWriter = new FileWriter(logFilePath, true);
        } catch (IOException ex) {
            System.out.println("log file not found, could not create PrintWriter");
        }
        return logFileWriter;
    }
    
    public static boolean writeToLogFile(String stringToLog) {
        // write: Date, time, String
        
        try {
            FileWriter writer = getLogFileWriter();
            if (writer == null) {
                System.out.println("logFileWriter is null");
                return false;
            }
            String stringToWrite = new Date() + " - " + stringToLog + "\n";
            writer.write(stringToWrite);
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Logger could not write to logFileWriter");
            return false;
        }
        return true;

    }

}
