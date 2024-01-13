package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountGUI implements ActionListener {

    public CreateAccountGUI(JFrame loginFrame){
        JFrame frame1 = new JFrame();
        frame1.setTitle("Journaly Version 1.0 | Create Account");

        //frame.setResizable(false);
        frame1.setSize(600, 350);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.setLayout(new BorderLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
