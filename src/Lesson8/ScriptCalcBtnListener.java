package Lesson8;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScriptCalcBtnListener implements ActionListener {
    private final JTextField in;

    public ScriptCalcBtnListener(JTextField in) {
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            scriptCalculation();
        } catch (Exception ex) {
            in.setText("Ошибка скрипта!");
            System.out.println(ex.getMessage());
        }
    }

    public void scriptCalculation() throws ScriptException {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        String one = in.getText();
        Object expResult1 = scriptEngine.eval(one);
        in.setText(expResult1.toString());

    }
}
