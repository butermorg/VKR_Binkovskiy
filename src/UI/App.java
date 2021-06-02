package UI;

import Math_Logic.math_expectation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{
    private JPanel MainPanel;
    private JButton button2;
    private JTextField textField_M1;
    private JTextField textField_KV1;
    private JTextField textField_N;
    private JTextField textField_t1;
    private JTextField textField_M2;
    private JTextField textField_KV2;
    private JTextField textField_t2;
    private JButton button1;
    private JTextArea textArea1;

    public App(String title){
        super(title);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(MainPanel);
        this.pack();
        this.setResizable(false);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double MX,KV;
                if (textField_N.getText()==""){textField_N.setEnabled(true);

                }
                int n = Integer.parseInt(textField_N.getText());
                MX = Double.parseDouble(textField_M1.getText());
                KV = Double.parseDouble(textField_KV1.getText());

                String massage ="";
                math_expectation me = new math_expectation();
                JOptionPane.showMessageDialog(null,"math_exp = "+me.Math_Exp(n,MX,KV)+
                        "\nlower_lim = "+me.lower_lim(n,MX,KV)+
                        "\nupper_lim = "+me.upper_lim(n,MX,KV));
            }
        });

        textField_M1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseEntered(e);
                textArea1.setText("Математическое ожидание\n для первого случая");
            }
        });
        textField_KV1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                textArea1.setText("Коэфициент вариации\n для первого случая");
            }
        });
        textField_N.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                textArea1.setText("Размер выборки");
            }
        });
        textField_KV2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                textArea1.setText("Коэфициент вариации\n для второго случая");
            }
        });
        textField_M2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                textArea1.setText("Математическое ожидание\n для второго случая");
            }
        });
        textField_t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                textArea1.setText("Время для первого случая");
            }
        });
        textField_t2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                textArea1.setText("Время для второго случая");


            }

        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                textArea1.setText("Расчет математического\n ожидания точечного\n и абслютного");
            }
            @Override
            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                textArea1.setText("");
            }
        });

        textField_M1.addMouseListener(new MouseAdapter() {
        });
    }

}

