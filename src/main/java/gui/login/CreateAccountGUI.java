package gui.login;

import data.Account;
import logger.ConsoleLogger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CreateAccountGUI {

    public CreateAccountGUI(JFrame loginFrame){
        ConsoleLogger logger = new ConsoleLogger();

        JFrame frame1 = new JFrame();
        frame1.setTitle("Journaly Version 1.0 | Create Account");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame1.setSize((int) (width * 0.25), (int) (height * 0.25));
        frame1.setLocationRelativeTo(null);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Journaly | Create Account");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 40));
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        JLabel userNameLabel = new JLabel("Enter Username: ");
        userNameLabel.setFont(new Font("Courier", Font.BOLD, 15));
        JTextField userInput = new JTextField(20);

        JLabel passwordLabel =  new JLabel("Enter Password: ");
        passwordLabel.setFont(new Font("Courier", Font.BOLD, 15));
        JPasswordField passwordField = new JPasswordField(20);

        JLabel confirmLabel =  new JLabel("Confirm Password: ");
        passwordLabel.setFont(new Font("Courier", Font.BOLD, 15));
        JPasswordField confirmField = new JPasswordField(20);

        JButton createButton = new JButton("Create");

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.red);
        errorLabel.setVisible(false);


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
        gbc.gridx = 0;
        inputPanel.add(confirmLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(confirmField, gbc);
        gbc.gridy = 3;
        inputPanel.add(createButton, gbc);
        gbc.gridy = 4;
        inputPanel.add(errorLabel, gbc);

        frame1.add(titlePanel, BorderLayout.NORTH);
        frame1.add(inputPanel, BorderLayout.CENTER);
        createButton.addActionListener(e -> {
            logger.setInfo("Account attempted to create");

            if(!new String(passwordField.getPassword()).equals(new String(confirmField.getPassword()))){
                logger.setInfo("Attempted to create account, passwords do not match");
                errorLabel.setText("Passwords do not match!");
                errorLabel.setVisible(true);

            } else {
                try{
                    Account account = new Account(userInput.getText(),
                            new String(passwordField.getPassword()));
                    account.create();
                    frame1.setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                loginFrame.setVisible(true);
            }

            logger.logAction();
        });
    }

}
