package com.rex.text.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.rex.text.TextEditor;

public class AboutUsAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JPanel panel = new JPanel();
		// panel.add(new Image("blue-cross-md.png"));
		// panel.add(new JLabel("blue-cross-md.png"));
		panel.add(new JLabel("<html>" + "<body>" + "<div><b>Author :</b> Rizwan Raza<br></div>"
				+ "<div><b>Contact:</b> +91 9718666289<br></div>"
				+ "<div><b>Study @:</b> University Polytechnic, Jamia Millia Islamia</div>" + "</body>" + "</html>"));
		JOptionPane.showMessageDialog(TextEditor.FRAME, panel);
	}
}