package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class StatusToggleAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (((TextPanel) TextEditor.JTP.getSelectedComponent()).SB.isVisible()) {
			for (int i = 0; i < TextEditor.JTP.getTabCount(); i++) {
				((TextPanel) TextEditor.JTP.getComponentAt(i)).SB.setVisible(false);
			}
		} else {
			for (int i = 0; i < TextEditor.JTP.getTabCount(); i++) {
				((TextPanel) TextEditor.JTP.getComponentAt(i)).SB.setVisible(true);
			}
		}
	}
}