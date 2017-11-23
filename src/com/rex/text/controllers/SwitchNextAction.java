package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class SwitchNextAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		int focussedTab = TextEditor.JTP.getSelectedIndex();
		if (focussedTab < TextEditor.JTP.getTabCount() - 1) {
			TextEditor.JTP.setSelectedIndex(focussedTab + 1);
		} else {
			TextEditor.JTP.setSelectedIndex(0);
		}
		TextEditor.FRAME.setTitle(((TextPanel) TextEditor.JTP.getSelectedComponent()).PATH + " - Rex Text");
	}
}