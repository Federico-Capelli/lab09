package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 *
 */

public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("Simple GUI");
    private final Controller controller = new Controller();

    /**
     *
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        panel.add(textArea);
        final JButton saveButton = new JButton("Save");
        panel.add(saveButton, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.saveOnFile(textArea.getText());
                } catch (final IOException error) {
                    JOptionPane.showMessageDialog(null, error.getMessage(), "Occured an error", JOptionPane.ERROR_MESSAGE);
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
        new SimpleGUI().display();
    }

}
