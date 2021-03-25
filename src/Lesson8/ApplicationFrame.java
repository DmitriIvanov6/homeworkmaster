package Lesson8;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {
    public ApplicationFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 500);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = menuBar.add(new JMenu("File"));
        JMenuItem exit = menu.add(new JMenuItem("Exit"));
        exit.addActionListener(new ExitBtnListener());
        setJMenuBar(menuBar);

        setLayout(new BorderLayout());
        JPanel top = createTop();
        add(top, BorderLayout.NORTH);
        Component component = top.getComponent(0);
        add(createBottom((JTextField) component), BorderLayout.CENTER);


        setVisible(true);


    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        JTextField textField = new JTextField();
        textField.setEditable(false);
        top.setLayout(new BorderLayout());
        top.add(textField, BorderLayout.CENTER);

        return top;
    }

    private JPanel createBottom(JTextField in) {
        JPanel bottom = new JPanel();
        BtnListener btnListener = new BtnListener(in);
        CalcBtnListener calcBtnListener = new CalcBtnListener(in);
        ClearBtnListener clearBtnListener = new ClearBtnListener(in);
        ScriptCalcBtnListener scriptCalcBtnListener = new ScriptCalcBtnListener(in);
        bottom.setLayout(new GridLayout(7, 3));
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(btnListener);
            bottom.add(btn);
        }
        JButton dot = new JButton(".");
        bottom.add(dot);
        dot.addActionListener(btnListener);

        JButton plus = new JButton("+");
        bottom.add(plus);
        plus.addActionListener(btnListener);

        JButton minus = new JButton("-");
        bottom.add(minus);
        minus.addActionListener(btnListener);

        JButton multiplication = new JButton("*");
        bottom.add(multiplication);
        multiplication.addActionListener(btnListener);

        JButton division = new JButton("/");
        bottom.add(division);
        division.addActionListener(btnListener);

        JButton squareRoot = new JButton("√");
        bottom.add(squareRoot);
        squareRoot.addActionListener(btnListener);

        JButton clear = new JButton("C");
        bottom.add(clear);
        clear.addActionListener(clearBtnListener);

        JButton calc = new JButton("=");
        bottom.add(calc);
        calc.addActionListener(calcBtnListener);

        JButton scriptCalc = new JButton("script=");
        bottom.add(scriptCalc);
        scriptCalc.addActionListener(scriptCalcBtnListener);

        return bottom;
    }
}
