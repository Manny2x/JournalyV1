package data;

import data.logic.IDCreator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry implements Comparable<Entry>{
    String entryData;
    String entryDate;
    String entryId;
    public Long timeMillis;

    public Entry(String data){
        this.entryId = IDCreator.createID(8);
        this.entryData = data;
        this.entryDate = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm:ss")
                .format(LocalDateTime.now());
        this.timeMillis = System.currentTimeMillis();
    }

    public Entry(){}

    public String getEntryData() {
        return entryData;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryData(String entryData) {
        this.entryData = entryData;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
    }

    @Override
    public int compareTo(Entry o) {
        return o.timeMillis.compareTo(this.timeMillis);
    }
}
