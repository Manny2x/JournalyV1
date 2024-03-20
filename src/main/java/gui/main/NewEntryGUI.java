package gui.main;

import data.Account;
import data.Entry;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.SortedSet;

public class NewEntryGUI {
    NewEntryGUI(Account account, JFrame mainFrame, Entry current){
        JFrame frame = new JFrame();
        frame.setTitle("Journaly Version 1.0 | " + account.getUsername());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize((int) (width * 0.2), (int) (height * 0.5));

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Create Journal Entry");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 40));
        titlePanel.add(titleLabel);

        JPanel textPanel = new JPanel();
        JTextArea field = new JTextArea();
        JScrollPane scrollTextArea = new JScrollPane(field, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        field.setEditable(true);
        field.setMargin( new Insets(15,15,15,15) );
        field.setLineWrap(true);
        field.setWrapStyleWord(true);
        textPanel.setLayout(new GridLayout(1,1));
        textPanel.add(scrollTextArea);

        JPanel right = new JPanel();
        right.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5, 5, 5);
        JButton newEntry = new JButton("Save");
        newEntry.addActionListener(e -> {
            SortedSet<Entry> entries = account.getEntries();
            Entry en = new Entry(field.getText());
            entries.add(new Entry(field.getText()));
            account.setEntries(entries);
            try {
                account.update();
                frame.setVisible(false);
                JButton button = new JButton(en.getEntryDate());
                button.setSize(100, 200);
                button.addActionListener(a-> {
                    field.setText(en.getEntryData());
                    textPanel.repaint();
                });
                mainFrame.repaint();
                mainFrame.setVisible(true);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> {
            field.setText("");
            frame.repaint();
        });

        JButton quit = new JButton("Quit");
        quit.addActionListener(e -> {
            frame.setVisible(false);
            mainFrame.setVisible(true);
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        right.add(newEntry, gbc);
        gbc.gridy++;
        right.add(reset, gbc);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(textPanel, BorderLayout.CENTER);
        frame.add(right, BorderLayout.EAST);

    }
}
