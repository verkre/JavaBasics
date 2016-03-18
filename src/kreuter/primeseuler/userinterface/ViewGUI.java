/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.userinterface;

import kreuter.primeseuler.actions.ActionGUIWelcome;
import kreuter.primeseuler.actions.Action;
import kreuter.primeseuler.actions.ActionGUIWelcomeEp;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
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
import kreuter.primeseuler.MainController;
import kreuter.primeseuler.interfaces.Controller;
import kreuter.primeseuler.utils.Logger;

/**
 * This class starts the program in the GUI, constructs the main frame and fills
 * it. It gets the main controller as an argument (the controller has the list of menu
 * actions that are used in the GUI).
 * @author Vera Kreuter
 */
public class ViewGUI extends View {
    
    private final JFrame frame;
    private final List<Action> actions;
    private final List<Action> epActions;
    private Long inputLong;
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
    MainController controller;
    
    
    public ViewGUI(MainController controller) {
        this.controller = controller;
        this.actions = controller.getMenuItems();
        this.epActions = controller.getEulerProblemActions();
        frame = new JFrame("Primes and Euler Problems");
        // REFACT the first actions are manually exchanged here (from Exit, which is used in the TUI, to Welcome). 
        // There might be a better way but I can't think of one.
        this.actions.set(0, new ActionGUIWelcome());
        this.epActions.set(0, new ActionGUIWelcomeEp(controller.getEsc()));
        this.mainMenuPanels = new ArrayList<>();
        this.mainMenuResultTextAreas = new ArrayList<>();
        this.calculationPanels = new ArrayList<>();
        this.inputNumberFields = new ArrayList<>();
        this.startCalcButtons = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        new ViewGUI(new MainController()).go();
    }
    
    private void go() {
        setNiceLookAndFeel();
        constructFrame();
    }

    private void setNiceLookAndFeel() {
        // show all available look-and-feels in the sys.out
//        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                System.out.println(info.getName());
//        }

// copied generated code from GUIBuilder
// set the look and feel; if the look and feel selected is not available, resort to the standard
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.writeToLogFile("GUI: Look and Feel not found, using default Look and Feel");
        }
    }
    
    private void constructFrame() {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                try {
                    if (controller.getEsc() != null) {
                        controller.getEsc().getConnection().close();
                    }
                } catch (SQLException ex) {
                    // TODO do something with this exception?
                }
                System.exit(0);
            }
        });
        frame.setSize(800, 500);
        fillFrame(frame);
        frame.setVisible(true);
    }
    
    private void fillFrame(JFrame frame) {
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
        EpListModel epListModel = new EpListModel(epActions);
        JList<Action> epList = new JList<>(epListModel);
        
        epList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                epListMouseClicked(evt, epList);
            }
        });
        
        epContentsPanel = new JPanel();
        epContentsPanel.setLayout(new BoxLayout(epContentsPanel, BoxLayout.PAGE_AXIS));
        JSplitPane epSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        // make the split pane non-resizable:
        epSplitPane.setEnabled(false);
        epInfo = makeTextArea(epActions.get(0).getInfoText());
        epSolution = makeTextArea(epActions.get(0).getSolutionString());
        
        epSplitPane.add(new JScrollPane(epList));
        epSplitPane.add(epContentsPanel);
        JScrollPane epInfoScrollPane = new JScrollPane(epInfo);
        epInfoScrollPane.setPreferredSize(new Dimension(600, 200));
        epContentsPanel.add(epInfoScrollPane);
        epContentsPanel.add(new JScrollPane(epSolution));
        epPanel.add(epSplitPane);
        
    }
    
    private void epListMouseClicked(MouseEvent evt, JList epList) {
        String infoString = "***"
                + ((Action) epList.getSelectedValue()).getDescription()
                + "***"
                + "\n\n" 
                + ((Action) epList.getSelectedValue()).getInfoText();
        epInfo.setText(infoString);
        epSolution.setText(((Action) epList.getSelectedValue()).getSolutionString());
        
        // TODO to try using Threads:
        // if it is problem 75, start a new thread that computes the solution
        // ideally something like:
        // - new Object delayedEp75Solver whose run method:
        // -- displays "Please wait..." in the TextArea
        // -- call the solve method (or getSolution?) of ep75
        // -- display solution and maybe notifies user via popup window?

    }
    
    private void addEventHandlingToButtons(List<JButton> startCalcButtons) {
        for (int i = 0; i < mainMenuPanels.size()-1; i++) {
            JButton thisButton = startCalcButtons.get(i);
            Action thisAction = actions.get(i);
            JTextField thisTextField = inputNumberFields.get(i);
            final JTextArea thisResultArea = mainMenuResultTextAreas.get(i);
            if (thisButton != null) {
                thisButton.addActionListener(new NumberInputActionListener(thisAction, thisResultArea, thisTextField));
            }
        }
    }
    
    private void addEventHandlingToInputFields(List<JTextField> inputTextFields) {
        for (int i = 0; i < mainMenuPanels.size()-1; i++) {
            JTextField thisTextField = inputTextFields.get(i);
            Action thisAction = actions.get(i);
            final JTextArea thisResultArea = mainMenuResultTextAreas.get(i);
            if (thisTextField != null) {
                thisTextField.addActionListener(new NumberInputActionListener(thisAction, thisResultArea, thisTextField));
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

    private Long getInputLongInt(JTextField textInputField) {
        String inputString = textInputField.getText();
        try {
            Long parsedLong = Long.parseLong(inputString);
            return parsedLong;
        } catch (NumberFormatException nfe) {
            textInputField.setText("");
            textInputField.requestFocus();
            return null;
        }
    }

    class NumberInputActionListener implements ActionListener {

        private final Action thisAction;
        private final JTextArea thisResultArea;
        private final JTextField thisTextField;

        public NumberInputActionListener(Action thisAction, JTextArea thisResultArea, JTextField thisTextField) {
            this.thisAction = thisAction;
            this.thisResultArea = thisResultArea;
            this.thisTextField = thisTextField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            inputLong = getInputLongInt(thisTextField);
            if (inputLong == null || thisAction.isValidInput(inputLong) == false) {
                thisResultArea.setText("Invalid input: " + thisTextField.getText() + ". Please enter a number between " + thisAction.getLowerInputBound() + " and " + MAX_LONG + ".");
                return;
            }
            thisAction.setInputNumber(inputLong);
            thisResultArea.setText(thisAction.getSolutionString());
        }
    }
}
