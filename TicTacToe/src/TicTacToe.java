import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_painel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_vez;
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(183, 40, 215));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(197, 179, 19));
        textfield.setForeground(new Color(3, 198, 29));
        textfield.setFont(new Font("Ink Free", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli" ,Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_painel.setLayout(new BorderLayout());
        title_painel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150, 150, 150));


        title_painel.add(textfield);
        frame.add(title_painel, BorderLayout.NORTH);
        frame.add(button_panel);

        primeiraVez();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i =0;i<9;i++) {
            if(e.getSource()==buttons[i]) {
                if(player1_vez) {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[0].setText("X");
                        player1_vez=false;
                        textfield.setText("Vez do O");
                        verifica();
                    }
                }
                else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(0, 60, 255));
                        buttons[0].setText("O");
                        player1_vez=true;
                        textfield.setText("Vez do X");
                        verifica();
                    }
                }
            }
        }
    }

    public void primeiraVez() {

        try {
            Thread.sleep((2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if(random.nextInt(2) == 0) {
            player1_vez = true;
            textfield.setText("Vez do X");
        } else {
            player1_vez = false;
            textfield.setText("Vez do O");
        }
    }
    public void verifica() {

    }

    public void xGanhou(int a, int b, int c) {

    }
    public void oGanhou(int a, int b, int c) {

    }
}
