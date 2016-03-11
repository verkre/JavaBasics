/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import jbcourseproject.actions.*;

/**
 *
 * @author Vera Kreuter
 */
public class ViewGUI extends View {
    
    private JFrame frame;
    private List<Action> actions;
    private int inputInt;
    private Long inputLong;
    private List<Long> inputLongs;
    private String solutionString;
    Action firstAction;
    Action secondAction;
    Action thirdAction;
    Action fifthAction;
    List<JPanel> mainMenuPanels;
    List<JTextArea> mainMenuResultTextAreas;
    List<JPanel> calculationPanels;
    List<JTextField> inputNumberFields;
    List<JButton> startCalcButtons;
    
    private JTextArea textPrimeCheckerResult;
    private JTextField textInputNumber;
    
    public ViewGUI(List<Action> actions) {
        this.inputLongs = new ArrayList<>();
        // frame is instantiated in the constructor - is that correct?
        frame = new JFrame("Primes and Euler Problems");
        this.actions = actions;
        // REFACT the first action is manually exchanged here (from Exit to Welcome). It works but it is kind of ugly
        this.actions.set(0, new ActionWelcome());
        this.mainMenuPanels = new ArrayList<>();
        this.mainMenuResultTextAreas = new ArrayList();
        this.calculationPanels = new ArrayList();
        this.inputNumberFields = new ArrayList();
        this.startCalcButtons = new ArrayList();
    }
    
    public void go() {
        // show all available look-and-feels in the sys.out
//        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                System.out.println(info.getName());
//        }
        
        // copied from generated code from GUIBuilder
        // set the look and feel; if the look and feel selected is not available, resort to the standard
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        constructFrame();
    }
    
    private void constructFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        fillFrame(frame);
        frame.setVisible(true);
        
    }
    
    private void fillFrame(JFrame frame) {
        // configure and fill frame here:
        JTabbedPane tabsMainMenu = new JTabbedPane();
        frame.add(tabsMainMenu);
        
        // construct a panel for each action
        // collect them in a List to be referenced later (to add components, possibly change the Layout etc).
        for (int i = 0; i < actions.size(); i++) {
            JPanel nextPanel = new JPanel();
            nextPanel.setLayout(new BoxLayout(nextPanel, BoxLayout.Y_AXIS));
            nextPanel.setName(actions.get(i).getTitle());
            mainMenuPanels.add(nextPanel);
        }
        
        // add the panels to the tabbedPane
        for (JPanel panel : mainMenuPanels) {
            tabsMainMenu.add(panel);
        }
        
        // add info text from the respective action to each panel
        // the info text areas do not have to be referenced anywhere else, so they are
        // not collected in a List.
        // the last panel (Euler problems) gets a different layout
        for (int i = 0; i < mainMenuPanels.size()-1; i++) {
            mainMenuPanels.get(i).add(makeTextArea(actions.get(i).getInfoText()));
        }
        
        // construct a "result"/ user interaction text area for each action, collect them in a List
        // to be referenced later (to change their text)
        for (int i = 0; i < actions.size()-1; i++) {
            JTextArea nextTextArea = makeTextArea(actions.get(i).getDescription());
            mainMenuResultTextAreas.add(nextTextArea);
        }
        
        // add the text areas to the panels, on a scroll pane
        for (int i = 0; i < mainMenuPanels.size()-1; i++) {
            JScrollPane newScrollPane = new JScrollPane(mainMenuResultTextAreas.get(i));
            newScrollPane.setPreferredSize(new Dimension(800, 150));
            mainMenuPanels.get(i).add(newScrollPane);
        }
        
        
        for (int i = 0; i < mainMenuPanels.size()-1; i++) {
            Action thisAction = actions.get(i);
            if (thisAction.needsInputNumber() == false) {
                calculationPanels.add(null); // or maybe add an anonymous empty JPanel?
            }
            else {
                JPanel nextCalcPanel = new JPanel();
                nextCalcPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
                calculationPanels.add(nextCalcPanel);
            }
        }
        
        for (int i = 0; i < mainMenuPanels.size()-1; i++) {
            if (calculationPanels.get(i) != null) {
                fillCalculationPanel(calculationPanels.get(i));
                mainMenuPanels.get(i).add(calculationPanels.get(i));
            } else {
                inputNumberFields.add(null);
                startCalcButtons.add(null);
            }
        }
        
        addEventHandlingToButtons(startCalcButtons);
        
        // **** and now for the last tab *********
        fillEulerProblemsTab(mainMenuPanels.get(mainMenuPanels.size()-1));
    }
    
    private void fillEulerProblemsTab(JPanel epPanel) {
        epPanel.setLayout(new BoxLayout(epPanel, BoxLayout.X_AXIS));
        EpListModel epListModel = new EpListModel();
        JList epList = new JList(epListModel);
        
        
        
        epList.addMouseListener(new MouseAdapter() {
            public void mouseClicked() {
                // TODO add method here to display content for the selected EP to the right of the list.
            }
        });
        
        epPanel.add(new JScrollPane(epList));
        epPanel.add(new JPanel());
    }
    
    private void addEventHandlingToButtons(List<JButton> startCalcButtons) {
        for (int i = 0; i < mainMenuPanels.size()-1; i++) {
            JButton thisButton = startCalcButtons.get(i);
            Action thisAction = actions.get(i);
            JTextField thisTextField = inputNumberFields.get(i);
            final JTextArea thisResultArea = mainMenuResultTextAreas.get(i);
            if (thisButton != null) {
                thisButton.addActionListener((ActionEvent e) -> {
                    inputLong = getInputLongInt(1L, thisTextField);
                    if (inputLong == null) {
                        thisResultArea.setText("Invalid input. Please enter a number between " + 1 + " and " + MAX_LONG + ".");
                        return;
                    }
                    thisAction.setInputNumber(inputLong);
                    thisResultArea.setText(thisAction.getSolutionString());
                });
            }
        }
        
    }
    
    private void fillCalculationPanel(JPanel calcPanel) {
        JTextField nextTextField = makeNumberInputTextField();
        inputNumberFields.add(nextTextField);
        calcPanel.add(nextTextField);
        JButton nextButton = new JButton("Show result");
        startCalcButtons.add(nextButton);
        calcPanel.add(nextButton);
    }
    
    private void fillActionPanel(JPanel thisPanel, Action thisAction) {
        JTextArea textInfo = makeTextArea(thisAction.getInfoText());
        thisPanel.add(textInfo);
    }
    
    private JTextArea makeTextArea(String textForArea) {
        JTextArea newTextArea = new JTextArea(textForArea);
        newTextArea.setEditable(false);
        newTextArea.setOpaque(false);
        newTextArea.setLineWrap(true);
        
        return newTextArea;
    }
    
    private JTextField makeNumberInputTextField() {
        JTextField newTextField = new JTextField();
        newTextField.setText("enter a number");
        newTextField.setPreferredSize(new Dimension(120, 30));
        newTextField.setHorizontalAlignment(JTextField.TRAILING);
        newTextField.setBorder(new EmptyBorder(4, 4, 4, 4));
        return newTextField;
        
//        textInputNumber.addActionListener((ActionEvent e) -> {
//            inputLong = getInputLongInt(1L, textInputNumber);
//        });

//        textInputNumber.addFocusListener(new FocusAdapter() {
//            public void focusLost() {
//                inputLong = getInputLongInt(1L, textInputNumber);
//            }
//        });

    }

    // TODO implement getInput methods by getting input from text fields in the JFrame object
    public Long getInputLongInt(long lowerBound, JTextField textInputField) {
        String inputString = textInputField.getText();
        try {
            Long parsedLong = Long.parseLong(inputString);
            return parsedLong;
        } catch (NumberFormatException nfe) {
            textInputField.setText("");
            return null;
        }
    }

    public int getInputInteger(int lowerBound, int upperBound) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getInputInteger(int lowerBound) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
