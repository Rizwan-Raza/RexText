package com.rex.text.views;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.rex.text.TextEditor;
import com.rex.text.controllers.CaretUpdateAction;

public class TextPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public String PATH;
	public JScrollPane jsp;
	// public JEditorPane JEP;
	public JTextArea JTA;
	public JLabel SB;
	private JPanel upper, lower;
	public boolean SAVED = false;

	public TextPanel() {
		PATH = "Untitled";
		// JEP = new JEditorPane();
		upper = new JPanel();
		lower = new JPanel();
		JTA = new JTextArea();
		SB = new JLabel("Line 1, Column 1");
		JTA.setFont(TextEditor.DEFAULT_FONT);
		JTA.addCaretListener(new CaretUpdateAction());
		JTA.setMargin(new Insets(0, 0, 0, 100));
		jsp = new JScrollPane(JTA);
		// setBackground(Color.LIGHT_GRAY);
		upper.setLayout(new BoxLayout(upper, BoxLayout.Y_AXIS));
		lower.setLayout(new BoxLayout(lower, BoxLayout.Y_AXIS));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		upper.add(jsp, BorderLayout.CENTER);
		upper.setAlignmentX(0.05f);
		lower.add(SB, BorderLayout.SOUTH);
		add(upper);
		add(lower);
	}
}
