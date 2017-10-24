package oesia.formacion.messenger.GUI.boundaries;

import java.util.ArrayList;
import java.util.List;

import oesia.formacion.messenger.GUI.App;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;

public class GUIObserverUserListImpl implements GUIObserver<List<String>> {
	public static List<String> listaUser = new ArrayList<String>();

	public void update(List<String> obj) {
		// TODO Auto-generated method stub

		App.getApp().setUserList(obj);

	}

}
