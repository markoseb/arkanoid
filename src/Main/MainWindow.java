package Main;

import Elements.PlayingPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    JPanel scorePanel;
    JLabel scoreLabel, numberOfLifesLabel, numberOfRoundsLabel;

    public MainWindow() {
        this.setSize(new Dimension(1000, 830));
        scoreLabel = new JLabel("0");
        scoreLabel.setVerticalTextPosition(0);
        numberOfLifesLabel = new JLabel("0");
        numberOfRoundsLabel = new JLabel("0");
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(new PlayingPanel(this), BorderLayout.CENTER);
        this.setVisible(true);
        this.add(drawScorePanel(), BorderLayout.PAGE_START);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setScoreText(int score) {
        scoreLabel.setText(Integer.toString(score));
    }

    public String getScoreText() {
        return scoreLabel.getText();
    }

    public void setNumberOfLives(int numberOfLives) {
        numberOfLifesLabel.setText(Integer.toString(numberOfLives));
    }

    public void setNumberOfRound(int numberOfRound) {
        numberOfRoundsLabel.setText(Integer.toString(numberOfRound));
    }

    private JPanel drawScorePanel() {
        scorePanel = new JPanel();
        scorePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
        scorePanel.add(new Label("Score: "));
        scorePanel.add(scoreLabel);
        scorePanel.add(new Label("Number of balls: "));
        scorePanel.add(numberOfLifesLabel);
        scorePanel.add(new Label("Number of Rounds left: "));
        scorePanel.add(numberOfRoundsLabel);
        return scorePanel;
    }
}
