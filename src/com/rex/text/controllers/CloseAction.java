package com.rex.text.controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class CloseAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (TextEditor.JTP.getTabCount() == 0) {
			return;
		}
		TextEditor.JTP.remove(TextEditor.JTP.getSelectedIndex());
		if (TextEditor.JTP.getSelectedIndex() >= 0) {
			TextEditor.FRAME.setTitle(((TextPanel)TextEditor.JTP.getSelectedComponent()).PATH + " - Rex Text");
		} else {
			TextEditor.FRAME.setTitle("Rex Text Editor");
		}
	}
}
