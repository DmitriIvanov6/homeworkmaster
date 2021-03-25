package Lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcBtnListener implements ActionListener {
    private final JTextField in;

    public CalcBtnListener(JTextField in) {
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculation();
    }

    public void calculation() {
        String expression = in.getText();
        String[] expArray = expression.split("(?<=\\d)(?=[+\\-*/√])|(?<=[+\\-*/√])(?=\\d)");
        boolean docount = true;
        for (int i = 0; i < expArray.length; i++) {
            if (expArray[i].equals("√-") || expArray[i].equals("+√-") || expArray[i].equals("-√-") || expArray[i].equals("*√-") || expArray[i].equals("/√-")) {
                in.setText("Ошибка ввода, корень из отрицательного числа!");
                docount = false;
            }
        }
        if (docount) {
            double result;
            if (expArray[0].equals("-")) {
                result = -Double.parseDouble(expArray[1]);
            } else if (expArray[0].equals("√")) {
                result = Math.sqrt(Double.parseDouble(expArray[1]));
            } else {
                result = Double.parseDouble(expArray[0]);
            }


            for (int i = 1; i < expArray.length; i++) {

                switch (expArray[i]) {

                    case ("+"):
                        result += Double.parseDouble(expArray[(i + 1)]);
                        in.setText(String.valueOf(result));
                        break;
                    case ("*"):
                        result *= Double.parseDouble(expArray[(i + 1)]);
                        in.setText(String.valueOf(result));
                        break;
                    case ("-"):
                    case ("+-"):
                        result -= Double.parseDouble(expArray[(i + 1)]);
                        in.setText(String.valueOf(result));
                        break;
                    case ("/"):
                        result /= Double.parseDouble(expArray[(i + 1)]);
                        in.setText(String.valueOf(result));
                        break;
                    case ("--"):
                        result += -Double.parseDouble(expArray[(i + 1)]);
                        in.setText(String.valueOf(result));
                        break;
                    case ("*-"):
                        result *= -Double.parseDouble(expArray[(i + 1)]);
                        in.setText(String.valueOf(result));
                        break;
                    case ("/-"):
                        result /= -Double.parseDouble(expArray[(i + 1)]);
                        in.setText(String.valueOf(result));
                        break;
                    case ("+√"):
                        result += Math.sqrt(Double.parseDouble(expArray[(i + 1)]));
                        in.setText(String.valueOf(result));
                        break;
                    case ("-√"):
                        result -= Math.sqrt(Double.parseDouble(expArray[(i + 1)]));
                        in.setText(String.valueOf(result));
                        break;
                    case ("*√"):
                        result *= Math.sqrt(Double.parseDouble(expArray[(i + 1)]));
                        in.setText(String.valueOf(result));
                        break;
                    case ("/√"):
                        result /= Math.sqrt(Double.parseDouble(expArray[(i + 1)]));
                        in.setText(String.valueOf(result));
                        break;

                    default:
                        in.setText(String.valueOf(result));

                }
            }
        }
    }
}
