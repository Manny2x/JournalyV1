package data;

import data.logic.IDCreator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry {
    String entryData;
    String entryDate;
    String entryId;
    public long timeMillis;

    public Entry(String data){
        this.entryId = IDCreator.createID(8);
        this.entryData = data;
        this.entryDate = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm:ss")
                .format(LocalDateTime.now());
        this.timeMillis = System.currentTimeMillis();
    }
}
