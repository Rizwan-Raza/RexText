package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class OpenAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		switch (jfc.showOpenDialog(TextEditor.FRAME)) {
		case JFileChooser.APPROVE_OPTION:
			String filename = jfc.getSelectedFile().getName();
			TextPanel out = new TextPanel();
			String path = jfc.getSelectedFile().getPath();
			FileInputStream in = null;
			try {
				in = new FileInputStream(path);
				int c;
				while ((c = in.read()) != -1) {
					out.JTA.setText(out.JTA.getText() + Character.toString((char) c));
				}
			} catch (IOException exception) {
				System.out.println("File is not found or not readable");
			} finally {
				try {
					if (in != null) {
						in.close();
					}
				} catch (IOException exception) {
					System.out.println("File can't be closed");
				}
				out.PATH = path;
				TextEditor.JTP.addTab(filename, TextEditor.II, out);
				TextEditor.JTP.setSelectedIndex(TextEditor.JTP.getTabCount() - 1);
				TextEditor.FRAME.setTitle(out.PATH + " - Rex Text");
			}
			break;
		case JFileChooser.CANCEL_OPTION:
			break;
		}
	}
}
