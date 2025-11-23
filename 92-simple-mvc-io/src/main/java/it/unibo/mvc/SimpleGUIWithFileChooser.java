package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame("Simple GUI with File Choser");

    /**
     * Creates the GUI and initializes all its components.
     */
    public SimpleGUIWithFileChooser() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel firstPanel = new JPanel(new BorderLayout());
        final JPanel secondPanel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton browseButton = new JButton("Browse...");
        final JButton save = new JButton("Save");
        final JTextField path = new JTextField(controller.getFilePath());
        path.setEditable(false);
        firstPanel.add(textArea, BorderLayout.CENTER);
        firstPanel.add(save, BorderLayout.SOUTH);
        secondPanel.add(path, BorderLayout.CENTER);
        secondPanel.add(browseButton, BorderLayout.LINE_END);
        firstPanel.add(secondPanel, BorderLayout.NORTH);
        frame.add(firstPanel);
        /*
        * Handlers
        */
        save.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(final ActionEvent e) {
                try {
                    controller.saveOnFile(textArea.getText());
                } catch (final IOException error) {
                    JOptionPane.showMessageDialog(null, error.getMessage(), "An error occured", JOptionPane.ERROR_MESSAGE);
                }
           } 
        });

       browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                chooser.setSelectedFile(controller.getFile());
                final int result = chooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    final File selectedFile = chooser.getSelectedFile();
                    controller.setAsCurrentFile(selectedFile);
                    textArea.setText(selectedFile.getPath());
                } else if (result != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, result, "Sbagliato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * @param args not used
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
