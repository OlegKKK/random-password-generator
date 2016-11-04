import javax.swing.*;
import java.awt.*;

public class PassGen extends JFrame {

    public JTextField textOutput;
    public JTextField lengthOfPass;

    public JButton generatePass;
    public JButton shuffleOutput;
    public JButton copyOutputToClipboard;

    public JCheckBox includeCaps;
    public JCheckBox includeLowerCase;
    public JCheckBox includeNumbers;
    public JCheckBox includeSpecialCharacters;

    public PassGen() {
        super("Random Password Generator");

        textOutput = new JTextField(30);
        textOutput.setEnabled(false);
        lengthOfPass = new JTextField("8",2);

        generatePass = new JButton("Generate Password");
        shuffleOutput = new JButton("Shuffle Output");
        copyOutputToClipboard = new JButton("Copy To Clipboard");

        JPanel optionsPanel = new JPanel(new FlowLayout());

        includeCaps = new JCheckBox("Include Caps", true);
        includeLowerCase = new JCheckBox("Include Lower Case Characters", true);
        includeNumbers = new JCheckBox("Include Numbers", true);

        optionsPanel.add(includeCaps);
        optionsPanel.add(includeLowerCase);
        optionsPanel.add(includeNumbers);
        optionsPanel.add(new JLabel("Length in Characters: "));
        optionsPanel.add(lengthOfPass);

        setLayout(new BorderLayout(5, 5));

        add(textOutput, BorderLayout.PAGE_START);
        add(shuffleOutput, BorderLayout.WEST);
        add(generatePass, BorderLayout.CENTER);
        add(copyOutputToClipboard, BorderLayout.EAST);
        add(optionsPanel, BorderLayout.PAGE_END);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

    }
}