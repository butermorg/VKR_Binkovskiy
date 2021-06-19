package UI;

import Math_Logic.Statistical_methods;
import Math_Logic.math_expectation;
import Math_Logic.math_expectation_distr_func;
import Math_Logic.support_func;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;
import validation.Fields;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/**
 * The type App.
 */
public class App extends JFrame {

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
    private JTabbedPane tabbedPane1;
    private final DefaultTableModel model;
    private JTable table1;
    private JTextField textField_ME_Xn;
    private JTextField textField_ME_Xn2;
    private JTextField PEAV1;
    private JTextField LCLAV1;
    private JTextField PEG1;
    private JTextField LCLG1;
    private JPanel JPanel_Statistic;
    private JLabel Point_estimate_av;
    private JLabel Low_confidence_lim_av;
    private JLabel Point_estimate_gamma;
    private JLabel Low_confidence_lim_gamma;
    private JTextField PEAV2;
    private JTextField LCLAV2;
    private JTextField PEG2;
    private JTextField LCLG2;
    private JLabel T_2;
    private JLabel T_2al;
    private JLabel second_lable;
    private JLabel first_lable;


    /**
     * Instantiates a new App.
     *
     * @param title the title
     */
    public App(String title) {

        super(title);
        JPanel_Statistic.setVisible(false);
        tabbedPane1.setVisible(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(MainPanel);
        this.pack();

        model = (DefaultTableModel) table1.getModel();


        button1.addActionListener(e -> {
            double MX, KV;
            int i = 0;

            textArea1.setText(null);
            tabbedPane1.setVisible(false);

            textField_ME_Xn2.setVisible(false);
            second_lable.setVisible(false);
            first_lable.setVisible(false);

            T_2.setVisible(false);
            T_2al.setVisible(false);

            setBounds(getX(), getY(), getWidth(), 200);
            if (textField_N.getText().isEmpty()) {
                i++;
                textField_N.requestFocus();
                textArea1.append("\nВведите n");

            }
            if (textField_KV1.getText().isEmpty()) {
                i++;
                textField_KV1.requestFocus();
                textArea1.append("\nВведите KV1");

            }
            if (textField_M1.getText().isEmpty()) {
                i++;
                textField_M1.requestFocus();
                textArea1.append("\nВведите M1");

            }
            if (i == 0) {
                JPanel_Statistic.setVisible(false);
                tabbedPane1.setVisible(true);
                setBounds(getX(), getY(), 600, 500);


                MX = Double.parseDouble(textField_M1.getText());
                KV = Double.parseDouble(textField_KV1.getText());
                int n = Integer.parseInt(textField_N.getText());
                support_func SF = new support_func();
                math_expectation me = new math_expectation();
                JOptionPane.showMessageDialog(null, "math_exp = " + math_expectation.Math_Exp(10000, MX, KV) +
                        "\nlower_lim = " + math_expectation.lower_lim(10000, MX, KV) +
                        "\nupper_lim = " + math_expectation.upper_lim(10000, MX, KV));
                while (table1.getRowCount() > 0) {
                    model.removeRow(0);
                }
                math_expectation.Math_Exp(n, MX, KV);
                model.setColumnCount(SF.sort(me.getX()).size());
                model.insertRow(model.getRowCount(), SF.sort(me.getX()).toArray());
                math_expectation_distr_func medf = new math_expectation_distr_func();

                XYSeries series1 = new XYSeries("a");
                XYSeries series2 = new XYSeries("b");

                XYLineChartExample Chart = new XYLineChartExample();
                Chart.createSeries(SF.sort(me.getX()), math_expectation.getY(), series1);
                Chart.createSeries(SF.sort(medf.sample_dev(SF.sort(me.getX()))), math_expectation.getY(), series2);

                ChartPanel graph = new ChartPanel(Chart.makechart());
                tabbedPane1.setComponentAt(1, graph);

                textField_ME_Xn.setText(String.valueOf((medf.Xn(SF.sort(me.getX()), math_expectation.getY()))));
                model.insertRow(model.getRowCount(), SF.sort(medf.sample_dev(SF.sort(me.getX()))).toArray());

            }
        });

        textField_M1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseEntered(e);
                textArea1.setText("Оператор математического ожидания для первого случая");
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
                textArea1.setText("Оператор математического ожидания для второго случая");
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
                textArea1.setText("Расчет математического ожидания точечного и абсолютного");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                textArea1.setText("");
            }
        });

        button2.addActionListener(e -> {
            double MX1, KV1, t1, MX2, KV2, t2;
            int i = 0;

            textArea1.setText(null);
            tabbedPane1.setVisible(false);
            textField_ME_Xn2.setVisible(true);
            second_lable.setVisible(true);
            first_lable.setVisible(true);

            setBounds(getX(), getY(), getWidth(), 200);
            if (textField_N.getText().isEmpty()) {
                i++;
                textField_N.requestFocus();
                textArea1.append("\nВведите n");

            }
            if (textField_KV1.getText().isEmpty()) {
                i++;
                textField_KV1.requestFocus();
                textArea1.append("\nВведите KV1");

            }
            if (textField_M1.getText().isEmpty()) {
                i++;
                textField_M1.requestFocus();
                textArea1.append("\nВведите M1");

            }
            if (textField_KV2.getText().isEmpty()) {
                i++;
                textField_KV2.requestFocus();
                textArea1.append("\nВведите KV2");

            }
            if (textField_M2.getText().isEmpty()) {
                i++;
                textField_M2.requestFocus();
                textArea1.append("\nВведите M2");
            }
            if (textField_t1.getText().isEmpty()) {
                i++;
                textField_t1.requestFocus();
                textArea1.append("\nВведите t1");

            }
            if (textField_t2.getText().isEmpty()) {
                i++;
                textField_t2.requestFocus();
                textArea1.append("\nВведите t2");
            }
            if (i == 0) {
                JPanel_Statistic.setVisible(true);
                tabbedPane1.setVisible(true);
                setBounds(getX(), getY(), 1000, 500);
                Point_estimate_av.setText("<html>Точечная оценка <br>среднего остаточного ресурса</html>");
                Low_confidence_lim_av.setText("<html>Нижняя доверительная граница<br>среднего остаточного ресурса</html>");
                Point_estimate_gamma.setText("<html>Точечная оценка<br>гамма-процентного остаточного ресурса</html>");
                Low_confidence_lim_gamma.setText("<html>Нижняя доверительная граница<br>гамма-процентного остаточного ресурса</html>");
                int n = Integer.parseInt(textField_N.getText());
                MX1 = Double.parseDouble(textField_M1.getText());
                KV1 = Double.parseDouble(textField_KV1.getText());
                t1 = Double.parseDouble(textField_t1.getText());
                MX2 = Double.parseDouble(textField_M2.getText());
                KV2 = Double.parseDouble(textField_KV2.getText());
                t2 = Double.parseDouble(textField_t2.getText());

                T_2.setVisible(true);
                T_2al.setVisible(true);

                support_func SF = new support_func();
                math_expectation me = new math_expectation();
                math_expectation_distr_func medf = new math_expectation_distr_func();
                Statistical_methods SM = new Statistical_methods();

                while (table1.getRowCount() > 0) {
                    model.removeRow(0);
                }
                XYSeries series1 = new XYSeries("a");
                XYSeries series2 = new XYSeries("a*");
                XYSeries series3 = new XYSeries("b");
                XYSeries series4 = new XYSeries("b*");
                XYLineChartExample Chart = new XYLineChartExample();


                math_expectation.Math_Exp(n, MX1, KV1);
                Chart.createSeries(SF.sort(me.getX()), math_expectation.getY(), series1);
                Chart.createSeries(SF.sort(medf.sample_dev(SF.sort(me.getX()))), math_expectation.getY(), series2);
                model.setColumnCount(SF.sort(me.getX()).size());
                model.insertRow(model.getRowCount(), SF.sort(me.getX()).toArray());
                model.insertRow(model.getRowCount(), SF.sort(medf.sample_dev(SF.sort(me.getX()))).toArray());
                textField_ME_Xn.setText(String.valueOf((medf.Xn(SF.sort(me.getX()), math_expectation.getY()))));
                try {
                    PEAV1.setText(String.valueOf(SM.Point_estimate_av(SF.sort(me.getX()), t1)));
                    LCLAV1.setText(String.valueOf(SM.Low_confidence_lim_av(SF.sort(me.getX()), t1)));
                    PEG1.setText(String.valueOf(SM.Point_estimate_gamma(SF.sort(me.getX()))));
                    LCLG1.setText(String.valueOf(SM.Low_confidence_lim_gamma(SF.sort(me.getX()))));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "заданное t1, превышает максимальное значение выбоки наработки");
                    textField_t1.setText(null);
                }
                math_expectation.Math_Exp(n, MX2, KV2);
                Chart.createSeries(SF.sort(me.getX()), math_expectation.getY(), series3);
                Chart.createSeries(SF.sort(medf.sample_dev(SF.sort(me.getX()))), math_expectation.getY(), series4);
                model.insertRow(model.getRowCount(), SF.sort(me.getX()).toArray());
                model.insertRow(model.getRowCount(), SF.sort(medf.sample_dev(SF.sort(me.getX()))).toArray());
                textField_ME_Xn2.setText(String.valueOf((medf.Xn(SF.sort(me.getX()), math_expectation.getY()))));
                try {
                    PEAV2.setText(String.valueOf(SM.Point_estimate_av(SF.sort(me.getX()), t2)));
                    LCLAV2.setText(String.valueOf(SM.Low_confidence_lim_av(SF.sort(me.getX()), t2)));
                    PEG2.setText(String.valueOf(SM.Point_estimate_gamma(SF.sort(me.getX()))));
                    LCLG2.setText(String.valueOf(SM.Low_confidence_lim_gamma(SF.sort(me.getX()))));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "заданное t2, превышает максимальное значение выбоки наработки");
                    textField_t2.setText(null);
                }
                ChartPanel graph = new ChartPanel(Chart.makechart());
                tabbedPane1.setComponentAt(1, graph);

            }
        });
        textField_N.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {


                if (new Fields().integer_valid(e)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        textField_M1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (new Fields().double_valid(textField_M1, e)) {
                    getToolkit().beep();
                    e.consume();
                }

            }
        });
        textField_KV1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (new Fields().double_valid(textField_KV1, e)) {
                    getToolkit().beep();
                    e.consume();
                }

            }
        });
        textField_t1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (new Fields().double_valid(textField_t1, e)) {
                    getToolkit().beep();
                    e.consume();
                }

            }
        });
        textField_M2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (new Fields().double_valid(textField_M2, e)) {
                    getToolkit().beep();
                    e.consume();
                }

            }
        });
        textField_t2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (new Fields().double_valid(textField_t2, e)) {
                    getToolkit().beep();
                    e.consume();
                }

            }
        });
        textField_KV2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (new Fields().double_valid(textField_KV2, e)) {
                    getToolkit().beep();
                    e.consume();
                }

            }
        });
    }
}

