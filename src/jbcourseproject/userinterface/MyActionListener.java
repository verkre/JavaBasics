/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import jbcourseproject.actions.Action;
import static jbcourseproject.userinterface.View.MAX_LONG;

/**
 *
 * @author Vera Kreuter
 */
public class MyActionListener implements ActionListener {
    
    int index;
    List<JPanel> mainMenuPanels;
    List<JButton> startCalcButtons;
    List<Action> actions;
    List<JTextField> inputNumberFields;
    List<JTextArea> mainMenuResultTextAreas;
    ViewGUI view;
    
    public MyActionListener(int index, List<JPanel> mainMenuPanels, List<JButton> startCalcButtons, List<Action> actions, 
            List<JTextField> inputNumberFields, List<JTextArea> mainMenuResultTextAreas, ViewGUI view) {
        this.index = index;
        this.actions = actions;
        this.inputNumberFields = inputNumberFields;
        this.mainMenuPanels = mainMenuPanels;
        this.mainMenuResultTextAreas = mainMenuResultTextAreas;
        this.startCalcButtons = startCalcButtons;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Long inputLong = view.getInputLongInt(1L, this.inputNumberFields.get(index));
        if (inputLong == null) {
            this.inputNumberFields.get(index).setText("That was not a long integer. Please enter a number between " + 1 + " and " + MAX_LONG + ".");
            return;
        }
        this.actions.get(index).setInputNumber(inputLong);
        this.mainMenuResultTextAreas.get(index).setText(this.actions.get(index).getSolutionString());
    }


}
