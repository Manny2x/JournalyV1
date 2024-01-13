package logger;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    String info;

    public FileLogger(String loggingInfo){
        this.info = loggingInfo;
    }

    public static String exceptionAsString(Exception exc){
        StringWriter sw = new StringWriter();
        exc.printStackTrace(new PrintWriter(sw));

        return sw.toString();
    }
    public void logAction() throws IOException {
        FileWriter fileWriter = new FileWriter(
                new File("/db/ActionLogs.log")
                , true);
        fileWriter.write(this.info + ">>Happened at>> " +
                DateTimeFormatter
                        .ofPattern("dd/MM/yyyy HH:mm:ss")
                        .format(LocalDateTime.now()) + "\n\n");
        fileWriter.close();
    }
    public void logAction(FileWriter fileWriter) throws IOException {
        fileWriter.write(this.info + ">>Happened at>> " +
                DateTimeFormatter
                        .ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
    public void logError() throws IOException {
        FileWriter fileWriter = new FileWriter(
                new File("/db/ErrorLogs.log")
                , true);
        fileWriter.write(this.info + ">>Happened at>> " +
                DateTimeFormatter
                        .ofPattern("dd/MM/yyyy HH:mm:ss")
                        .format(LocalDateTime.now()) + "\n\n");
        fileWriter.close();
    }

    public void setInfo(String desc){
        this.info = desc;
    }
}
