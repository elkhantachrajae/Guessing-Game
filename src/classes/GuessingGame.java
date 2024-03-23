package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends JFrame {

    private int randomNumber;
    private JTextField guessField;
    private JLabel infoLabel;
    private JButton guess;
    private JButton newGame;
    private int attempts;
    public GuessingGame(){
        setTitle("Guessing Game");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image =new ImageIcon("logo.png");
        setLocationRelativeTo(null);
        setIconImage(image.getImage());
        setResizable(false);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(5, 1));
        randomNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
        setVisible(true);
        infoLabel = new JLabel("Enter a number between (1-100):");
        guessField = new JTextField(10);
        guess = new JButton("Guess");
        newGame = new JButton("New Game");
        guessField.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font
        guessField.setForeground(Color.white); // Set text color
        guessField.setBackground(Color.decode("#795695")); // Set background color
        guessField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        guessField.setPreferredSize(new Dimension(100, 20));
        guess.setFont(new Font("serif",Font.BOLD,16));
        guess.setBackground(Color.black);
        guess.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        guess.setPreferredSize(new Dimension(80,30));
        guess.setForeground(Color.decode("#C8A4D4"));
        newGame.setFont(new Font("serif",Font.BOLD,16));
        newGame.setBackground(Color.black);
        newGame.setForeground(Color.decode("#C8A4D4"));
        newGame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newGame.setPreferredSize(new Dimension(80,30));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Align buttons to the center
        buttonPanel.add(guess);
        buttonPanel.add(newGame);
        contentPanel.add(infoLabel);
        contentPanel.add(guessField);
        contentPanel.add(buttonPanel);
        add(contentPanel, BorderLayout.CENTER);
        guess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });
    }
    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            attempts++;

            if (guess == randomNumber) {
                JOptionPane.showMessageDialog(this, "Congratulations! You've guessed the number in " + attempts + " attempts.");
                startNewGame();
            } else if (guess < randomNumber) {
                JOptionPane.showMessageDialog(this, "Try a higher number.");
            } else {
                JOptionPane.showMessageDialog(this, "Try a lower number.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }

        guessField.setText("");
    }
    private void startNewGame(){
        randomNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
        JOptionPane.showMessageDialog(this, "New game started! Guess a number between 1 and 100.");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessingGame();
            }
        });
    }
}