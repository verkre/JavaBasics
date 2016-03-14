/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.userinterface;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import jbcourseproject.actions.Action;
import jbcourseproject.actions.eulerproblems.Ep2;
import jbcourseproject.actions.eulerproblems.Ep3;
import jbcourseproject.actions.eulerproblems.Ep4;
import jbcourseproject.actions.eulerproblems.Ep7;
import jbcourseproject.actions.eulerproblems.Ep75;

/**
 *
 * @author Vera Kreuter
 */
public class EpListModel extends AbstractListModel<Object> {
    

    private List<Action> epActions;

    public EpListModel(List<Action> epActions) {
        this.epActions = epActions;
    }
    

    @Override
    public int getSize() {
        return epActions.size();
    }

    @Override
    public Object getElementAt(int index) {
        return epActions.get(index);
    }
    
    public List<String> getTitles() {
        List<String> epTitles = new ArrayList<>();
        for (Action epObject : epActions) {
            epTitles.add(epObject.getTitle());
        }
        return epTitles;
    }
    
}
