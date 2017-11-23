package com.rex.text;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.rex.text.views.MenuBarCreator;
import com.rex.text.views.TextPanel;

public class TextEditor {
	public static JFrame FRAME;
	public static JTabbedPane JTP;
	// static JLabel SB;
	public static Font DEFAULT_FONT = new Font("Consolas", Font.PLAIN, 20);
	public static final ImageIcon II = new ImageIcon("resources/red-cross-xs.png");

	TextEditor() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Exception e) {
			System.out.println("Sorry !! Look and Feel not Applied");
		}
		FRAME = new JFrame("Rex Text Editor");
		JTP = new JTabbedPane(JTabbedPane.TOP);
		// SB = new JLabel("Line 1, Column 1");
		JComponent jcmp = new TextPanel();
		JTP.addTab("Untitled ", II, jcmp);
		JTP.setSelectedIndex(0);
		FRAME.setBackground(new Color(67, 96, 156));
		FRAME.setJMenuBar(MenuBarCreator.MainMenuBarCreator());
		FRAME.add(JTP, BorderLayout.CENTER);
		// FRAME.add(SB, BorderLayout.SOUTH);
		FRAME.setSize(800, 600);
		FRAME.setVisible(true);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TextEditor();
	}
}
