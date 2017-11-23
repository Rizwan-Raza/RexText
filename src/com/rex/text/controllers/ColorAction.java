package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.rex.text.TextEditor;

public class ColorAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JPanel panel = new JPanel();
		JColorChooser jcc = new JColorChooser();
		panel.add(jcc);
		JOptionPane.showMessageDialog(TextEditor.FRAME, panel);
	}
}