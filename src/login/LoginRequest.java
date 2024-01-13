package login;

import logger.ConsoleLogger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginRequest {
    ConsoleLogger logger = new ConsoleLogger();
    private final String userName;
    private final String password;



    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean exists(){
        logger.setInfo(this.userName);
        logger.logAction();
        logger.setInfo(this.password);
        logger.logAction();

        return false;
    }
}
