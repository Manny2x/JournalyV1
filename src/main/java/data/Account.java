package data;


<<<<<<< HEAD
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.logic.IDCreator;
import gui.login.LoginRequest;

import java.io.File;
import java.io.IOException;
=======
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.exceptions.AccountNotFoundException;
import data.logic.IDCreator;
import gui.login.LoginRequest;

import java.io.*;
>>>>>>> origin/master
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Account {
    String username;
    String password;
    String id;
    private static final String dbLocation = "C:\\Users\\Emman\\Projects\\" +
            "IdeaProjects\\JournalyV1Database\\";

    SortedSet<Entry> entries = new TreeSet<>(Comparator
            .comparingLong(a -> a.timeMillis));

    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.id = IDCreator.createID(5);
    }
    public Account() {}

    public static Account getAccount(LoginRequest loginRequest) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(dbLocation + loginRequest.userName+ ".txt"),
                Account.class);
    }

    public void create() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Files.createFile(Path.of(dbLocation + username + ".txt"));
        mapper.writeValue(new File(dbLocation + username + ".txt"), this);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public SortedSet<Entry> getEntries() {
        return entries;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntries(SortedSet<Entry> entries) {
        this.entries = entries;
    }
}
