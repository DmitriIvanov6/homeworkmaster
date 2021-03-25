package Lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnListener implements ActionListener {
    private final JTextField in;

    public BtnListener(JTextField in) {
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        StringBuilder stringBuilder = new StringBuilder(in.getText());
        stringBuilder.append(btn.getText());
        in.setText(stringBuilder.toString());

    }
}
