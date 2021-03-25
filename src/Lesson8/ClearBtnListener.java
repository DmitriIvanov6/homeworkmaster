package Lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearBtnListener implements ActionListener {
    private final JTextField in;

    public ClearBtnListener(JTextField in) {
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        in.setText(null);
    }
}
