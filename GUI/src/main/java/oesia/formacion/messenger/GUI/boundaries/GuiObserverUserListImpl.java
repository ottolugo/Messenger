package oesia.formacion.messenger.GUI.boundaries;

import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;

public class GuiObserverUserListImpl implements GUIObserver<List<String>> {

    public void update(List<String> obj) {
	// TODO Auto-generated method stub
    	System.out.println("Recibida lista usuarios: " + obj);
    }

}
