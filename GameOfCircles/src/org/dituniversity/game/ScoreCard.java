package org.dituniversity.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ScoreCard extends JPanel {
    private Timer timer;
    private int scoreNumber = 5;
    private JTextField scoreRealtime;

    public ScoreCard() {
        setLayout(new BorderLayout());
        scoreRealtime = new JTextField(String.valueOf(scoreNumber)); 
        scoreRealtime.setEditable(false);
        scoreRealtime.setFont(new Font("Yatra One", Font.BOLD, 24));
        scoreRealtime.setHorizontalAlignment(JTextField.CENTER);

        JLabel scoreLabel = new JLabel("SCORE");
        scoreLabel.setFont(new Font("Yatra One", Font.BOLD, 24));


        setPreferredSize(new Dimension(180, 50));
        setBackground(Color.white);


        add(scoreLabel, BorderLayout.WEST);
        add(scoreRealtime, BorderLayout.CENTER);

        gameLoop();
    }

    private void gameLoop() {
        // Create a timer that fires every 50 milliseconds
        timer = new Timer(50, e -> increaseScore());
        timer.start();
    }
    public void stopScoring() {
            timer.stop();
            
    }
    private void increaseScore() {
        scoreNumber += 5; 
        scoreRealtime.setText(String.valueOf(scoreNumber));
    }
}
