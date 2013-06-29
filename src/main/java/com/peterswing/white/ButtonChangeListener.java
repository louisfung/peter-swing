package com.peterswing.white;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ButtonChangeListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println("peter stateChanged");
	}

}
