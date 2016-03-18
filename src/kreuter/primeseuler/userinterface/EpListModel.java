/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.userinterface;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import kreuter.primeseuler.actions.Action;

/**
 *
 * @author Vera Kreuter
 */
public class EpListModel extends AbstractListModel<Action> {
    

    private final List<Action> epActions;

    public EpListModel(List<Action> epActions) {
        this.epActions = epActions;
    }
    

    @Override
    public int getSize() {
        return epActions.size();
    }

    @Override
    public Action getElementAt(int index) {
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
