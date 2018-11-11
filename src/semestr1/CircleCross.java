package semestr1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Random;

public class CircleCross extends JFrame implements ActionListener {

    static boolean weHaveAWinner = false;
    static String winnerChar = "?";
    boolean cross = true;
    int count = 0;
    int level;
    int lastX;
    int lastY;
    int lastUserX;
    int lastUserY;

    JPanel allPanel;
    JPanel titlePanel;
    JPanel panel;
    JLabel labelTxt;
    //JButton compMoveBtn;
    JButton playAgain;
    JButton[][] btn;
    JButton closeBtn;
    static JButton[] winnerBtn;

    CircleCross(int inLevel) {
        super("Circle and cross");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level = inLevel;
        allPanel = new JPanel();
        BoxLayout box = new BoxLayout(allPanel, BoxLayout.Y_AXIS);
        allPanel.setLayout(box);
        titlePanel = new JPanel();
        titlePanel.setSize(600, 50);
        titlePanel.setBackground(Color.yellow);
        labelTxt = new JLabel("Kółko i krzyżyk");
        closeBtn = new JButton("Zmień poziom");
        closeBtn.addActionListener(this);
        playAgain = new JButton("Restart");
        //compMoveBtn = new JButton("Computer move");
       // compMoveBtn.addActionListener(this);
        playAgain.addActionListener(this);
        titlePanel.add(labelTxt);
        //titlePanel.add(compMoveBtn);
        titlePanel.add(closeBtn);
        titlePanel.add(playAgain);
        allPanel.add(titlePanel);
        panel = new JPanel();
        panel.setSize(600, 600);
        GridLayout gr = new GridLayout(level, level);
        panel.setLayout(gr);
        btn = new JButton[level][level];
        for (int i = 0; i < btn.length; i++)
            for (int j = 0; j < btn[0].length; j++) {
                btn[i][j] = new JButton("?");
                btn[i][j].setPreferredSize(new Dimension(600 / level, 600 / level));
                btn[i][j].setFont(new Font("Arial", Font.PLAIN, (int) ((600 / level) * 0.5)));
                btn[i][j].setBackground(Color.white);
                btn[i][j].addActionListener(this);
                panel.add(btn[i][j]);
            }
        allPanel.add(panel);
        add(allPanel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == playAgain) {
            count = 0;
            weHaveAWinner = false;
            for (int i = 0; i < btn.length; i++)
                for (int j = 0; j < btn[0].length; j++) {
                    btn[i][j].setText("?");
                    btn[i][j].setBackground(Color.WHITE);
                    btn[i][j].setEnabled(true);
                  //  compMoveBtn.setEnabled(true);
                }
        }


        if (source == closeBtn) {
            count = 0;
            weHaveAWinner = false;
            this.dispose();
        } else {

//            if (source == compMoveBtn) {
//                this.commputerPlay();
//            }
            {
                for (int i = 0; i < btn.length; i++)
                    for (int j = 0; j < btn[0].length; j++) {
                        if (btn[i][j] == source) {
                            count++;
                            if (cross) {
                                btn[i][j].setText("X");
                                cross = false;
                            } else {
                                btn[i][j].setText("O");
                                cross = true;
                            }
                            btn[i][j].setEnabled(false);
                            lastUserX = i;
                            lastUserY = j;

                        }
                    }
                if (checkWinner(btn, count)) {
                    count=level*level;
                    JOptionPane.showMessageDialog(this, "Gratulacje. Wygrałeś z komputerem!", "Super :-)", JOptionPane.WARNING_MESSAGE);
                    for (int i = 0; i < btn.length; i++)
                        for (int j = 0; j < btn[0].length; j++)
                            btn[i][j].setEnabled(false);
                 //   compMoveBtn.setEnabled(false);

                } else if (count == (level * level)) {
                    JOptionPane.showMessageDialog(this, "Mamy remis", "Ojejku", JOptionPane.WARNING_MESSAGE);
                    for (int i = 0; i < btn.length; i++)
                        for (int j = 0; j < btn[0].length; j++)
                            btn[i][j].setEnabled(false);
                //    compMoveBtn.setEnabled(false);
                }
                if ((count>0) && (count<(level*level))) {
                    this.commputerPlay();
                    if (checkWinner(btn, count)) {
                        count=level*level;
                        JOptionPane.showMessageDialog(this, "Przegrałeś z komputerem. Żenada!", "Słabiutko :-(", JOptionPane.WARNING_MESSAGE);
                        for (int i = 0; i < btn.length; i++)
                            for (int j = 0; j < btn[0].length; j++)
                                btn[i][j].setEnabled(false);
              //          compMoveBtn.setEnabled(false);

                    }




                }
            }
        }
    }

    static boolean checkLine(JButton[] inText) {
        for (int i = 1; i < inText.length; i++) {
            if (!inText[i].getText().equals(inText[i - 1].getText()) || inText[i].getText() == "?")
                return false;
        }
        return true;
    }


    void commputerPlay() {
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "Wykonaj pierwszy ruch", "Komputer!", JOptionPane.WARNING_MESSAGE);
        }
        if (count == 1) {
            this.firstMove();
        }
        if (count % 2 != 0) {
            this.nextMove();
        }

    }

    void firstMove() {
        int indexX=0;
        int indexY=0;
        int bounds = btn.length;
        int direction;
        boolean horizontalLineOk=false;
        boolean verticalLineOk=false;

        Random rm = new Random();
        direction = rm.nextInt(2); // wylosuj czy losować z tego samego iwersza czy z kolumny

        // czy mozna losowac z wiersza
            for (int i = 0; i < btn.length; i++) {
                if (checkIfEmpty(btn[lastUserX][i]))
                    horizontalLineOk= true;
            }

        // czy mozna losowac z kolumny
        for (int i = 0; i < btn.length; i++) {
            if (checkIfEmpty(btn[i][lastUserY]))
                verticalLineOk= true;
        }
        // zmien kierunek jesli wylosowany jest niemozliwy
        if ((!horizontalLineOk)&&(!verticalLineOk)){
            direction=2;
        } else if ((horizontalLineOk)&&(verticalLineOk)){
        } else {
            if (horizontalLineOk)
                direction=0;
            else
                direction=1;
        }

        if (direction == 0) { // losuj z tego samego wiersza
            do {
                indexX = lastUserX;
                indexY = rm.nextInt(bounds);
            } while ((!checkIfEmpty(btn[indexX][indexY])));
        }
        if (direction==1) { //losuj z tej samej kolumny
            do {
                indexY = lastUserY;
                indexX = rm.nextInt(bounds);
            } while ((!checkIfEmpty(btn[indexX][indexY])));
        }
        if (direction==2){ //losuj z pozostałych btn
            do {
                indexX = rm.nextInt(bounds);
                indexY = rm.nextInt(bounds);
            } while ((!checkIfEmpty(btn[indexX][indexY])));
        }

        count++;
        if (cross) {
            btn[indexX][indexY].setText("X");
            cross = false;
        } else {
            btn[indexX][indexY].setText("O");
            cross = true;
        }
        btn[indexX][indexY].setEnabled(false);
        lastX = indexX;
        lastY = indexY;
    }


    void nextMove() {
        boolean moved = false; // czy doszło do ruchu?
        String mySign;
        String userSign;
        if (cross) {
            mySign = "X";
            userSign = "O";
        } else {
            mySign = "O";
            userSign = "X";
        }
        // sprawdz czy user ma szanse wygrac
        for (int i = 0; i < btn.length; i++) {
            for (int j = 0; j < btn.length; j++) {
                if (checkIfEmpty(btn[i][j])) {
                    btn[i][j].setText(userSign);
                    //jesli tak zapobiegnij tej katastrofie :)
                    if (checkWinner(btn, count)) {
                        uNmarkWinner(winnerBtn);
                        btn[i][j].setText(mySign);
                        if (cross)
                            cross = false;
                        else
                            cross = true;
                        btn[i][j].setEnabled(false);
                        lastX = i;
                        lastY = j;
                        count++;
                        moved = true;

                        if (checkWinner(btn, count)) {
                            break; // jeśli po tym ruchu wygrywam - wyjdz z pętli
                        }
                        break;
                    } else {
                        btn[i][j].setText("?"); // przywróć empty btn w przypadku gdy nie ma ryzyka przegranej
                    }
                }

            }
            if (moved == true)
                break;
        }
        // jeślu user nie ma szancy na wygraną
        if (!moved) {
            this.firstMove();
        }
    }

    static void markWinner(JButton[] winnerButton) {
        for (int n = 0; n < winnerButton.length; n++)
            winnerButton[n].setBackground(Color.GREEN);
    }

    static void uNmarkWinner(JButton[] winnerButton) {
        for (int n = 0; n < winnerButton.length; n++)
            winnerButton[n].setBackground(Color.WHITE);
    }


    static boolean checkIfEmpty(JButton btn) {
        if (btn.getText().equals("?"))
            return true;
        else
            return false;
    }

    static boolean checkWinner(JButton[][] btn, int count) {
        int x = 0;
        JButton[] inTextX = new JButton[btn.length];
        JButton[] inTextY = new JButton[btn.length];
        JButton[] inTextDiagonalDown = new JButton[btn.length];
        JButton[] inTextDiagonalUp = new JButton[btn.length];
        winnerBtn = new JButton[btn.length];

        // check if we have a winner
        for (int i = 0; i < btn[0].length; i++) {
            for (int j = 0; j < btn[0].length; j++) {
                x = (-1 * j) + btn.length - 1;
                inTextX[j] = btn[i][j];
                inTextY[j] = btn[j][i];
                if (i == j) {
                    inTextDiagonalDown[i] = btn[i][j];
                }
                if (i == x) {
                    inTextDiagonalUp[i] = btn[i][j];
                }
            }
            if (checkLine(inTextX)) {
                weHaveAWinner = true;
                winnerChar = inTextX[0].getText();
                markWinner(inTextX);
                winnerBtn = inTextX;
                return true;
            }

            if (checkLine(inTextY)) {
                weHaveAWinner = true;
                winnerChar = inTextY[0].getText();
                markWinner(inTextY);
                winnerBtn = inTextY;
                return true;
            }
        }
        if (checkLine(inTextDiagonalDown)) {
            weHaveAWinner = true;
            winnerChar = inTextDiagonalDown[0].getText();
            markWinner(inTextDiagonalDown);
            winnerBtn = inTextDiagonalDown;
            return true;
        }
        if (checkLine(inTextDiagonalUp)) {
            weHaveAWinner = true;
            winnerChar = inTextDiagonalUp[0].getText();
            markWinner(inTextDiagonalUp);
            winnerBtn = inTextDiagonalUp;
            return true;
        }
        return false;
    }
}
