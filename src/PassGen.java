import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class PassGen extends JFrame implements ActionListener, ItemListener{
    public JTextField textOutput;
    public JTextField lengthOfPass;
    public JButton generatePass;
    public JButton shuffleOutput;
    public JButton copyOutputToClipboard;
    public JCheckBox includeCapsCB;
    public JCheckBox includeLowerCaseCB;
    public JCheckBox includeNumbersCB;
    public boolean includeCaps;
    public boolean includeLowerCase;
    public boolean includeNumbers;
    public PassGen() {
        super("Random Password Generator");
        textOutput = new JTextField(30);
        textOutput.addActionListener(this);
        lengthOfPass = new JTextField("8",2);
        lengthOfPass.addActionListener(this);
        generatePass = new JButton("Generate Password");
        generatePass.addActionListener(this);
        shuffleOutput = new JButton("Shuffle Output");
        shuffleOutput.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textOutput.getText();
                textOutput.setText(PassShuffler.shuffler(txt));
            }
        });
        copyOutputToClipboard = new JButton("Copy To Clipboard");
        copyOutputToClipboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String theString = textOutput.getText();
                StringSelection selection = new StringSelection(theString);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
            }
        });

        JPanel optionsPanel = new JPanel(new FlowLayout());
        includeCapsCB = new JCheckBox("Include Caps", true);
        includeLowerCaseCB = new JCheckBox("Include Lower Case Characters", true);
        includeNumbersCB = new JCheckBox("Include Numbers", true);
        includeCapsCB.addItemListener(this);
        includeLowerCaseCB.addItemListener(this);
        includeNumbersCB.addItemListener(this);
        includeCaps = true;
        includeLowerCase = true;
        includeNumbers = true;
        optionsPanel.add(includeCapsCB);
        optionsPanel.add(includeLowerCaseCB);
        optionsPanel.add(includeNumbersCB);
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
        new PassGen();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int length = Integer.parseInt(lengthOfPass.getText())-1;
            if (!lengthOfPass.getText().equals("")&&length>0) {
                textOutput.setText(RandomGenerator.nextWord(length,includeCaps,includeLowerCase,includeNumbers));
            }
        } catch (NumberFormatException nuEx) {

        }
    }
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();

        if (source.equals(includeCapsCB)) {
            includeCaps = !includeCaps;
            System.out.println("" + includeCaps);
        } else if (source.equals(includeLowerCaseCB)) {
            includeLowerCase = !includeLowerCase;
            System.out.println("" + includeLowerCase);
        } else if (source.equals(includeNumbersCB)) {
            includeNumbers = !includeNumbers;
            System.out.println("" + includeNumbers);
        }
        if (!includeCaps&&!includeNumbers&&!includeLowerCase) {
            generatePass.setEnabled(false);
        }else{
            generatePass.setEnabled(true);
        }
    }
}
