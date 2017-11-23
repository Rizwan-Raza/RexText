package com.rex.text.controllers;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class FontSizeAction implements ActionListener {
	int size = 0;

	public FontSizeAction(int size) {
		this.size = size;
	}

	public void actionPerformed(ActionEvent e) {
		TextEditor.DEFAULT_FONT = new Font(TextEditor.DEFAULT_FONT.getName(), TextEditor.DEFAULT_FONT.getStyle(),
				(size != 0 ? TextEditor.DEFAULT_FONT.getSize() : 24) + size);
		for (int i = 0; i < TextEditor.JTP.getTabCount(); i++) {
			((TextPanel) TextEditor.JTP.getComponentAt(i)).JTA.setFont(TextEditor.DEFAULT_FONT);
		}
	}
}