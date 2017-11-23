package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rex.text.TextEditor;

public class CloseAllAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		TextEditor.JTP.removeAll();
		TextEditor.FRAME.setTitle("Rex Text Editor");
	}
}