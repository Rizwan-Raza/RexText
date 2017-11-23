package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class NewAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		TextPanel txtpnl = new TextPanel();
		TextEditor.JTP.addTab("Untitled ", TextEditor.II, txtpnl);
		TextEditor.JTP.setSelectedIndex(TextEditor.JTP.getTabCount() - 1);
		TextEditor.FRAME.setTitle(txtpnl.PATH + " - Rex Text");
	}

}
