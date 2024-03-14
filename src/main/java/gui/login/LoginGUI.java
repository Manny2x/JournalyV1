package gui.login;

import data.Account;
import data.exceptions.AccountNotFoundException;
import gui.main.MainMenuGUI;
import logger.ConsoleLogger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginGUI {
    public LoginGUI() {
        ConsoleLogger logger = new ConsoleLogger();

        JFrame frame = new JFrame();
        frame.setTitle("Journaly Version 1.0");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize((int) (width * 0.25), (int) (height * 0.25));
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Journaly Version 1.0");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 50));
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);


        // Inputs
        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.red);
        errorLabel.setVisible(false);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        JLabel userNameLabel = new JLabel("User: ");
        userNameLabel.setFont(new Font("Courier", Font.BOLD, 25));
        JTextField userInput = new JTextField(20);

        JLabel passwordLabel =  new JLabel("Password: ");
        passwordLabel.setFont(new Font("Courier", Font.BOLD, 25));
        JPasswordField passwordField = new JPasswordField(20);

        JButton passwordButton = new JButton("Submit");
        passwordButton.addActionListener(e -> {
            logger.setInfo("Password attempted to submit");
            logger.logAction();

            try {
                LoginRequest loginRequest = new LoginRequest(userInput.getText(),
                        new String(passwordField.getPassword()));
                loginRequest.check();
                new MainMenuGUI(Account.getAccount(loginRequest));
            } catch (AccountNotFoundException | IOException ex) {
                logger.setInfo(ex.toString());
                logger.logError();

                errorLabel.setText(ex.toString());
                errorLabel.setVisible(true);
            }
        });

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(e -> {
            logger.setInfo("Account attempted to create");
            logger.logAction();
            frame.setVisible(false);

            new CreateAccountGUI(frame);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(userNameLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(userInput, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        inputPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(passwordField, gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        inputPanel.add(passwordButton, gbc);
        gbc.gridy = 3;
        inputPanel.add(createAccountButton, gbc);
        gbc.gridy = 4;
        inputPanel.add(errorLabel, gbc);



        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(inputPanel, BorderLayout.CENTER);
    }

}
