package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.rex.text.TextEditor;

public class VersionAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(TextEditor.FRAME,
				"<html>" + "<body>" + "<div><b>Version :</b> 0.01<br></div>" + "<div><b>Release:</b> Awaiting<br></div>"
						+ "<div><b>Contributors:</b> No one!</div>" + "</body>" + "</html>",
				"Rex Text | Version", JOptionPane.INFORMATION_MESSAGE);
	}
}