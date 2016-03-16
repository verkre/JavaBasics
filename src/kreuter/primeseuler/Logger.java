package kreuter.primeseuler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Vera Kreuter
 */
public class Logger {
    
    public static FileWriter getLogFileWriter() {
        String logFilePath = "src/kreuter/primeseuler/log.txt";
        FileWriter logFileWriter = null;
        try {
            logFileWriter = new FileWriter(logFilePath, true);
        } catch (IOException ex) {
            System.out.println("log file not found, could not create PrintWriter");
        }
        return logFileWriter;
    }
    
    public static boolean writeToLogFile(String stringToLog) {
        // write: Date, time, String

        try (FileWriter logFileWriter = getLogFileWriter()) {
            if (logFileWriter == null) {
                System.out.println("logPrintWriter is null");
                return false;
            }
            String stringToWrite = new Date() + " - " + stringToLog + "\n";
            logFileWriter.write(stringToWrite);
        } catch (IOException ex) {
            System.out.println("Logger could not write to logFileWriter");
        }
        return true;

    }

}
