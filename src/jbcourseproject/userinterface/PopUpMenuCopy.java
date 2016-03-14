/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.userinterface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Vera Kreuter
 */
public class PopUpMenuCopy extends MouseAdapter {
    JTextArea thisTextArea;
    
    public PopUpMenuCopy(JTextArea thisTextArea) {
        this.thisTextArea = thisTextArea;
    }

    // the following code to add a popup menu (copy) was taken from
    // http://tiebing.blogspot.de/2013/10/add-context-menu-copypaste-to-java.html
    @Override
    public void mouseReleased(final MouseEvent e) {
        if (e.isPopupTrigger()) {
            final JPopupMenu menu = new JPopupMenu();
            JMenuItem item;
            item = new JMenuItem(new DefaultEditorKit.CopyAction());
            item.setText("Copy");
            item.setEnabled(thisTextArea.getSelectionStart() != thisTextArea.getSelectionEnd());
            menu.add(item);
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        mouseReleased(e);
    }
}
