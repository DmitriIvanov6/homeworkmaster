package Lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(1);
    }

}
