package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;
    private final SimpleController controller = new SimpleController();
    private final JFrame frame = new JFrame();

    /**
     * Create the GUI and initializes all its component.
     */
    public SimpleGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show history");
        final JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.LINE_AXIS));

        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        secondPanel.add(printButton);
        secondPanel.add(historyButton);
        panel.add(secondPanel, BorderLayout.SOUTH);
        frame.add(panel);

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextString(textField.getText());
                controller.printCurrentString();
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final StringBuilder stringText = new StringBuilder();
                for (final String string : controller.getHistoryPrint()) {
                    stringText.append(string).append('\n');
                }
                textArea.setText(stringText.toString());
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
