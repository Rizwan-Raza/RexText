package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class SelectAllAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		((TextPanel) TextEditor.JTP.getSelectedComponent()).JTA.selectAll();
		((TextPanel) TextEditor.JTP.getSelectedComponent()).SB
				.setText(((TextPanel) TextEditor.JTP.getSelectedComponent()).JTA.getSelectionEnd()
						- ((TextPanel) TextEditor.JTP.getSelectedComponent()).JTA.getSelectionStart()
						+ " Characters Selected");
	}
}
