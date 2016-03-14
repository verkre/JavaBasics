/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.userinterface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Vera Kreuter
 */
public class PopUpMenuCopyPaste extends MouseAdapter {
    JTextField thisTextField;
    
    public PopUpMenuCopyPaste(JTextField thisTextField) {
        this.thisTextField = thisTextField;
    }

    // the following code to add a popup menu (copy) was taken from
    // http://tiebing.blogspot.de/2013/10/add-context-menu-copypaste-to-java.html
    @Override
    public void mouseReleased(final MouseEvent e) {
        if (e.isPopupTrigger()) {
            final JPopupMenu menu = new JPopupMenu();
            JMenuItem cpItem, pasteItem;
            cpItem = new JMenuItem(new DefaultEditorKit.CopyAction());
            pasteItem = new JMenuItem(new DefaultEditorKit.PasteAction());
            cpItem.setText("Copy");
            pasteItem.setText("Paste");
            cpItem.setEnabled(thisTextField.getSelectionStart() != thisTextField.getSelectionEnd());
            pasteItem.setEnabled(thisTextField.getSelectionStart() != thisTextField.getSelectionEnd());
            menu.add(cpItem);
            menu.add(pasteItem);
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        mouseReleased(e);
    }
}
