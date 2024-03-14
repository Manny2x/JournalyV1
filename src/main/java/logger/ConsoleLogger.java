package logger;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger {
    String info;


    public static String exceptionAsString(Exception exc){
        StringWriter sw = new StringWriter();
        exc.printStackTrace(new PrintWriter(sw));

        return sw.toString();
    }
    public void logAction(){
        String log = (this.info + " @ " +
                DateTimeFormatter
                        .ofPattern("dd/MM/yyyy HH:mm:ss")
                        .format(LocalDateTime.now()));
        System.out.println(log);
    }
    public void logError() {
        String log = ("ERROR: " + this.info + " @ " +
                DateTimeFormatter
                        .ofPattern("dd/MM/yyyy HH:mm:ss")
                        .format(LocalDateTime.now()) );
        System.out.println(log);
    }

    public void setInfo(String desc){
        this.info = desc;
    }
}
