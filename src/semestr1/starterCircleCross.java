package semestr1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class starterCircleCross extends JFrame implements ActionListener {


    int level;
    static final int MIN = 3;
    static final int MAX = 10;
    static final int INIT = 3;

    JPanel panel;
    JSlider levelSlider;
    JButton playBtn;
    JButton closeBtn;
    JButton aboutBtn;
    JLabel labelLbl;

    starterCircleCross() {
        super("Gra w kółko i krzyżyk");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        labelLbl = new JLabel("Wybierz poziom i klinij PLAY");
        JSlider levelSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        levelSlider.addChangeListener(this::stateChanged);
        levelSlider.setMajorTickSpacing(1);
        levelSlider.setMinorTickSpacing(1);
        levelSlider.setPaintTicks(true);
        levelSlider.setPaintLabels(true);
        level = levelSlider.getValue();

        playBtn = new JButton("Play");
        playBtn.addActionListener(this);
        closeBtn = new JButton("Close");
        closeBtn.addActionListener(this);
        aboutBtn = new JButton("Info");
        aboutBtn.addActionListener(this);

        panel.add(labelLbl);
        panel.add(levelSlider);
        panel.add(playBtn);
        panel.add(aboutBtn);
        panel.add(closeBtn);
        add(panel);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        starterCircleCross app = new starterCircleCross();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == playBtn) {
            CircleCross playWindow = new CircleCross(level);
        }
        if (source == closeBtn) {
            this.dispose();
        }
        if (source == aboutBtn) {
            JOptionPane.showMessageDialog(this, "Gra w kółko i krzyżyk z możliwością wyboru poziomu gry. Autor: Wojciech Brożonowicz.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            int inLevel = (int) source.getValue();
            level = inLevel;
        }
    }
}
