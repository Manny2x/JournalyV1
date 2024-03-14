package gui.main;

import data.Account;

import javax.swing.*;
import java.awt.*;

public class MainMenuGUI {
    public MainMenuGUI(Account account){
        JFrame frame = new JFrame();
        frame.setTitle("Journaly Version 1.0 | " + account.getUsername());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize((int) (width * 0.35), (int) (height * 0.75));

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());


    }
}
