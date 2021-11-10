package Elements;

import Dimensions.Border;
import Dimensions.Point;
import Dimensions.Rectangle;
import Main.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PlayingPanel extends JPanel implements KeyListener, ActionListener {
    private Arkanoid arkanoid = new Arkanoid(3);
    private Ball ball = new Ball();
    private Rounds rounds = new Rounds();
    private Blocks blocks;
    // private BonusBoxList bonusList = new BonusBoxList();
    private Timer timer;
    private int deley = 1;
    private int roundsNumber = 2;
    private int currentRound = 2;
    private Border border;
    private MainWindow window;
    private boolean endgame = false;
    private boolean roundCleared = false;
    private int totalScore = 0;

    public PlayingPanel(MainWindow window) {
        this.setFocusable(true);
        this.requestFocus();
        this.requestFocusInWindow();
        roundsNumber = rounds.getNumberOfRounds();
        blocks = new Blocks(rounds.getRoundDefinition(currentRound));
        addKeyListener(this);
        this.window = window;
        border = new Border();
        timer = new Timer(deley, this);
        window.setNumberOfRound(roundsNumber);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (!endgame) {
            drawPanel(g2);
            drawBorder(g2);
            arkanoid.drawMe(g2);
            ball.drawMe(g2);
            blocks.drawMe(g2);
            if (!timer.isRunning()) {
                //kolejny problem bochatersko rozwiązany rysowanie odbywa się warstwami dlatego ostatnia warstwa musi być
                // rysowana na końcu!!
                if (isAllBlockDestroyded() && roundsNumber > 0) {
                    currentRound += 1;

                    createNewObjects();
                }
                drawStartString(g2);
            }
        } else {
            drawEndString(g2);
        }
    }

    private void drawStartString(Graphics2D g) {
        g.setColor(Color.blue);
        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        String startString = "Round: " + currentRound + " Press space to start.";
        g.drawString(startString, 400, 600);
    }

    private void drawPanel(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 800);
    }

    private void drawBorder(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, border.getBorderPixelSize(), 800);
        g.fillRect(3, 0, 1000, border.getBorderPixelSize());
        g.fillRect(985, 0, border.getBorderPixelSize(), 800);
    }

    private void createNewObjects() {
        blocks = null;
        ball = null;
        blocks = new Blocks(rounds.getRoundDefinition(currentRound));
        ball = new Ball();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            arkanoid.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            arkanoid.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!endgame && !timer.isRunning()) {
                timer.start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ball.move(arkanoid, blocks) == 0) {
            timer.stop();//rozbudowa o ilość piłek chwilowo pierwszy kill kończy grę
            window.setScoreText(ball.getGamePoints());
            endgame = true;
            repaint();
        } else {
            window.setScoreText(ball.getGamePoints());
            roundCleared = isAllBlockDestroyded();
            if (roundCleared) {
                timer.stop();
                roundsNumber -= 1;
                window.setNumberOfRound(roundsNumber);
                totalScore += Integer.parseInt(window.getScoreText());
                if (roundsNumber == 0)
                    endgame = true;
                //go to next round or if last round print score and u won message
            }
            repaint();
        }
    }

    private boolean isAllBlockDestroyded() {
        for (int i = 0; i < blocks.listOfBlocks.length; i++) {
            for (int j = 0; j < blocks.listOfBlocks[i].length; j++) {
                if (!blocks.listOfBlocks[i][j].isDeleted()) {
                    return false;
                }
            }
        }
        return true;
    }


    private void drawEndString(Graphics2D g) {
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.BOLD, 35));
        String finalMessage = "Your scores: " + totalScore;
        g.drawString(finalMessage, 400, 600);
    }
}