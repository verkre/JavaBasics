/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.userinterface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import jbcourseproject.Controller;
import jbcourseproject.actions.*;

/**
 *
 * @author Vera Kreuter
 */
public class ViewGUI extends View {
    
    private JFrame frame;
    private List<Action> actions;
    private List<Action> epActions;
    private Long inputLong;
    private List<Long> inputLongs;
    Action firstAction;
    Action secondAction;
    Action thirdAction;
    Action fifthAction;
    List<JPanel> mainMenuPanels;
    List<JTextArea> mainMenuResultTextAreas;
    List<JPanel> calculationPanels;
    List<JTextField> inputNumberFields;
    List<JButton> startCalcButtons;
    JPanel epContentsPanel;
    JTextArea epInfo;
    JTextArea epSolution;
    
    
    public ViewGUI(Controller controller) {
        this.actions = controller.getActions();
        this.epActions = controller.getEulerProblemActions();
        this.inputLongs = new ArrayList<>();
        // frame is instantiated in the constructor - is that correct?
        frame = new JFrame("Primes and Euler Problems");
        // REFACT the first actions are manually exchanged here (from Exit to Welcome). It works but it is kind of ugly
        this.actions.set(0, new ActionWelcome());
        this.epActions.set(0, new ActionWelcomeEp());
        this.mainMenuPanels = new ArrayList<>();
        this.mainMenuResultTextAreas = new ArrayList();
        this.calculationPanels = new ArrayList();
        this.inputNumberFields = new ArrayList();
        this.startCalcButtons = new ArrayList();
    }
    
    public static void main(String[] args) {
        new ViewGUI(new Controller()).go();
    }
    
    public void go() {
        setNiceLookAndFeel();
        
        constructFrame();
    }

    private void setNiceLookAndFeel() {
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
            java.util.logging.Logger.getLogger(frame.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            tabsMainMenu.add(nextPanel);
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
        // no result area on the first (welcome) tab, so add null to the list first, then
        // add textAreas for the other tabs.
        mainMenuResultTextAreas.add(null); 
        for (int i = 1; i < actions.size()-1; i++) {
            JTextArea nextTextArea = makeTextArea("nothing to show yet");
            mainMenuResultTextAreas.add(nextTextArea);
        }
        
        // add the text areas to the panels, on a scroll pane
        for (int i = 0; i < mainMenuPanels.size() - 1; i++) {
            if (mainMenuResultTextAreas.get(i) != null) {
                JScrollPane newScrollPane = new JScrollPane(mainMenuResultTextAreas.get(i));
                newScrollPane.setPreferredSize(new Dimension(800, 150));
                mainMenuPanels.get(i).add(newScrollPane);
            }
            
            // add a panel for the input field and button to those panels that need user input
            // (ask the respective action if it needs input)
            Action thisAction = actions.get(i);
            if (!thisAction.needsInputNumber()) {
                calculationPanels.add(null);
            } else {
                JPanel nextCalcPanel = new JPanel();
                nextCalcPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
                calculationPanels.add(nextCalcPanel);
                fillCalculationPanel(nextCalcPanel);
            }

            if (calculationPanels.get(i) != null) {
                mainMenuPanels.get(i).add(calculationPanels.get(i));
            } else {
                inputNumberFields.add(null);
                startCalcButtons.add(null);
            }
        }
        
        addEventHandlingToButtons(startCalcButtons);
        addEventHandlingToInputFields(inputNumberFields);
        
        // the last tab is special
        fillEulerProblemsTab(mainMenuPanels.get(mainMenuPanels.size()-1));
    }
    
    private void fillEulerProblemsTab(JPanel epPanel) {
//        epPanel.setLayout(new BoxLayout(epPanel, BoxLayout.X_AXIS));
//        epPanel.setLayout(new GridLayout(1, 2));
        EpListModel epListModel = new EpListModel(epActions);
        JList epList = new JList(epListModel);
        
        epList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                epListMouseClicked(evt, epList);
            }
        });
        
        epContentsPanel = new JPanel();
        epContentsPanel.setLayout(new BoxLayout(epContentsPanel, BoxLayout.PAGE_AXIS));
        JSplitPane epSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        // to make the split pane non-resizable:
        epSplitPane.setEnabled(false);
        epInfo = makeTextArea(epActions.get(0).getInfoText());
        epInfo.setPreferredSize(new Dimension(600, 200)); // frame size is 800x400
        epSolution = makeTextArea(epActions.get(0).getSolutionString());
        
        epSplitPane.add(new JScrollPane(epList));
        epSplitPane.add(epContentsPanel);
        epContentsPanel.add(new JScrollPane(epInfo));
        epContentsPanel.add(new JScrollPane(epSolution));
        epPanel.add(epSplitPane);
        
        // TODO the text areas resize automatically when the mouse goes over one of the
        // non-active tabs.
    }
    
    private void epListMouseClicked(MouseEvent evt, JList epList) {
        String infoString = "***"
                + ((Action) epList.getSelectedValue()).getDescription()
                + "***"
                + "\n\n" 
                + ((Action) epList.getSelectedValue()).getInfoText();
        epInfo.setText(infoString);
        epSolution.setText(((Action) epList.getSelectedValue()).getSolutionString());

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
    
    private void addEventHandlingToInputFields(List<JTextField> inputTextFields) {
        for (int i = 0; i < mainMenuPanels.size()-1; i++) {
            JTextField thisTextField = inputTextFields.get(i);
            Action thisAction = actions.get(i);
            final JTextArea thisResultArea = mainMenuResultTextAreas.get(i);
            if (thisTextField != null) {
                thisTextField.addActionListener((ActionEvent e) -> {
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
    
    private JTextArea makeTextArea(String textForArea) {
        JTextArea newTextArea = new JTextArea(textForArea);
        newTextArea.setEditable(false);
        newTextArea.setOpaque(false);
        newTextArea.setLineWrap(true);
        newTextArea.setWrapStyleWord(true);
        newTextArea.add(new PopupMenu());
        newTextArea.addMouseListener(new PopUpMenuCopy(newTextArea));
        
        return newTextArea;
    }
    
    private JTextField makeNumberInputTextField() {
        JTextField newTextField = new JTextField();
        newTextField.setText("enter a number");
        newTextField.setPreferredSize(new Dimension(120, 30));
        newTextField.setHorizontalAlignment(JTextField.TRAILING);
        newTextField.setBorder(new EmptyBorder(4, 4, 4, 4));
        newTextField.addMouseListener(new PopUpMenuCopyPaste(newTextField));
        
        return newTextField;
    }

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

}