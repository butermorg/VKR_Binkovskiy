package UI;

import Math_Logic.math_expectation;
import Math_Logic.math_expectation_distr_func;
import com.VKR.support_func;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private DefaultTableModel model;
    private JTable table1;
    private JTextField textField_ME_Xn;


    class TableData extends AbstractTableModel {
        support_func IO = new support_func();

        public int getRowCount() {
            return 1;
        }

        public int getColumnCount() {
            return IO.Xsort().size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }


    }

    public App(String title) {
        super(title);

        tabbedPane1.setVisible(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(MainPanel);
        this.pack();

        model = (DefaultTableModel) table1.getModel();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double MX, KV;
                int i;
                i = 0;
                textArea1.setText(null);
                tabbedPane1.setVisible(false);
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
                    tabbedPane1.setVisible(true);
                    setBounds(getX(), getY(), 600, 500);
                    int n = Integer.parseInt(textField_N.getText());
                    MX = Double.parseDouble(textField_M1.getText());
                    KV = Double.parseDouble(textField_KV1.getText());
                    support_func SF = new support_func();

                    String massage = "";
                    math_expectation me = new math_expectation();
                    JOptionPane.showMessageDialog(null, "math_exp = " + me.Math_Exp(10000, MX, KV) +
                            "\nlower_lim = " + me.lower_lim(10000, MX, KV) +
                            "\nupper_lim = " + me.upper_lim(10000, MX, KV));
                    if (table1.getRowCount() > 1) {
                        model.removeRow(0);
                        model.removeRow(0);
                    }
                    me.Math_Exp(n, MX, KV);
                    model.setColumnCount(SF.Xsort().size());
                    model.insertRow(model.getRowCount(), SF.Xsort().toArray());
                    ChartPanel graph = new ChartPanel(new XYLineChartExample().makechart(SF.Xsort(), me.getY()));
                    tabbedPane1.setComponentAt(1, graph);
                    math_expectation_distr_func medf = new math_expectation_distr_func();
                    textField_ME_Xn.setText(String.valueOf((medf.Xn(SF.Xsort(), me.getY()))));
                    model.insertRow(model.getRowCount(), medf.sample_dev(SF.Xsort()).toArray());

                }
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

    }

}

