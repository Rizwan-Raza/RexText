package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class SaveAsAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (TextEditor.JTP.getTabCount() == 0) {
			return;
		}
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Save As");
		switch (jfc.showSaveDialog(TextEditor.FRAME)) {
		case JFileChooser.APPROVE_OPTION:
			String filename = jfc.getSelectedFile().getName();
			String path = jfc.getSelectedFile().getPath();
			try {
				File f = new File(path);
				PrintWriter pw = new PrintWriter(f);
				TextPanel current = (TextPanel) TextEditor.JTP.getSelectedComponent();
				pw.print(current.JTA.getText());
				current.PATH = path;
				pw.close();
				TextEditor.JTP.setTitleAt(TextEditor.JTP.getSelectedIndex(), filename);
				TextEditor.FRAME.setTitle(current.PATH + " - Rex Text");
			} catch (IOException ioe) {
				System.out.println("Caught Exception in Creating or writing into file.");
			}
			break;
		case JFileChooser.CANCEL_OPTION:
			break;
		}
	}
}
