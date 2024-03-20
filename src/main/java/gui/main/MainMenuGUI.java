package gui.main;

import data.Account;
import data.Entry;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.SortedSet;

public class MainMenuGUI {
    Entry current;
    public MainMenuGUI(Account account){
        SortedSet<Entry> entries = account.getEntries();
        current = entries.first();

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
        JLabel titleLabel = new JLabel("Journal Entry: " + current.getEntryDate());
        titleLabel.setFont(new Font("Courier", Font.BOLD, 40));
        titlePanel.add(titleLabel);

        JPanel textPanel = new JPanel();
        JTextArea field = new JTextArea();
        JScrollPane scrollTextArea = new JScrollPane(field, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        field.setEditable(false);
        field.setMargin( new Insets(15,15,15,15) );
        field.setLineWrap(true);
        field.setWrapStyleWord(true);
        field.setText(current.getEntryData());
                textPanel.setLayout(new GridLayout(1,1));
        textPanel.add(scrollTextArea);

        JPanel left = new JPanel();
        left.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        for(Entry e : entries){
            JButton button = new JButton(e.getEntryDate());
            button.setSize(100, 200);
            button.addActionListener(a-> {
                field.setText(e.getEntryData());
                titleLabel.setText("Journal Entry: " + e.getEntryDate());
                this.current = e;
                textPanel.repaint();
            });
            left.add(button, gbc);
            gbc.gridy++;
        }

        JPanel right = new JPanel();
        JButton newEntry = new JButton("New Entry");
        newEntry.setSize(200, 200);
        newEntry.addActionListener(e -> {
            frame.setVisible(false);
            Entry first = current;
            new NewEntryGUI(account, frame, current);
            if(first != current){
                JButton button = new JButton(current.getEntryDate());
                button.setSize(100, 200);
                button.addActionListener(a-> {
                    field.setText(current.getEntryData());
                    titleLabel.setText("Journal Entry: " + current.getEntryDate());
                    textPanel.repaint();
                });
                left.add(button, gbc);
                gbc.gridy++;
            }

        });
        right.add(newEntry);

        JPanel foot = new JPanel();
        foot.add(new JButton("Edit"));


        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(textPanel, BorderLayout.CENTER);
        frame.add(left, BorderLayout.WEST);
        frame.add(right, BorderLayout.EAST);
        frame.add(foot, BorderLayout.SOUTH);
    }


}
