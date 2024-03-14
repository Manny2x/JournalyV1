package gui.login;

import data.exceptions.AccountNotFoundException;
import logger.ConsoleLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoginRequest {
    ConsoleLogger logger = new ConsoleLogger();
    public final String userName;
    public final String password;



    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void check() throws AccountNotFoundException, IOException {
        logger.setInfo(this.userName);
        logger.logAction();
        logger.setInfo(this.password);
        logger.logAction();
        File user = new File("C:\\Users\\Emman\\Projects\\" +
                "IdeaProjects\\JournalyV1Database\\" + userName + ".txt");
        if(!user.exists()) throw new AccountNotFoundException("Username does not exist!");
        if(!Files.readString(Path.of(user.getAbsolutePath())).contains("\"password\":\"" + this.password + "\""))
            throw new AccountNotFoundException("Password is not correct");
    }
}
