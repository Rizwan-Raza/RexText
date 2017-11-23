package com.rex.text.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeelAction implements ActionListener {
	String classname;
	Component frame;

	public LookAndFeelAction(String cln, Component jf) {
		frame = jf;
		classname = cln;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			UIManager.setLookAndFeel(classname);
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception excp) {
			System.out.println(excp);
		}
	}
}
