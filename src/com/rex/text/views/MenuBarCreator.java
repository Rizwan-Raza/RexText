package com.rex.text.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import com.rex.text.TextEditor;
import com.rex.text.controllers.AboutUsAction;
import com.rex.text.controllers.CloseAction;
import com.rex.text.controllers.CloseAllAction;
import com.rex.text.controllers.ColorAction;
import com.rex.text.controllers.CopyAction;
import com.rex.text.controllers.CutAction;
import com.rex.text.controllers.DeleteAction;
import com.rex.text.controllers.FontSizeAction;
import com.rex.text.controllers.LookAndFeelAction;
import com.rex.text.controllers.NewAction;
import com.rex.text.controllers.OpenAction;
import com.rex.text.controllers.PasteAction;
import com.rex.text.controllers.RedoAction;
import com.rex.text.controllers.SaveAction;
import com.rex.text.controllers.SaveAsAction;
import com.rex.text.controllers.SelectAllAction;
import com.rex.text.controllers.StatusToggleAction;
import com.rex.text.controllers.SwitchNextAction;
import com.rex.text.controllers.SwitchPreviousAction;
import com.rex.text.controllers.UndoAction;
import com.rex.text.controllers.VersionAction;

public class MenuBarCreator {
	public static JMenuBar MainMenuBarCreator() {

		JMenuBar jmb = new JMenuBar();
		jmb.add(fileMenuCreator());
		jmb.add(editMenuCreator());
		jmb.add(formatMenuCreator());
		jmb.add(viewMenuCreator());
		jmb.add(helpMenuCreator());
		return jmb;
	}

	public static JMenu fileMenuCreator() {

		JMenu file = menuCreator("File", KeyEvent.VK_F);

		file.add(menuItemCreator("New", KeyEvent.VK_N, new NewAction(), KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		file.add(menuItemCreator("Open", KeyEvent.VK_O, new OpenAction(), KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		file.add(menuItemCreator("Save", KeyEvent.VK_S, new SaveAction(), KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		file.add(menuItemCreator("Save As", KeyEvent.VK_A, new SaveAsAction(), KeyEvent.VK_S,
				ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));

		file.addSeparator();

		file.add(menuItemCreator("Close File", KeyEvent.VK_C, new CloseAction(), KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		file.add(menuItemCreator("Close All Files", KeyEvent.VK_L, new CloseAllAction(), KeyEvent.VK_W,
				ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));

		file.addSeparator();

		file.add(menuItemCreator("Exit", KeyEvent.VK_X, new OpenAction(), KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

		return file;
	}

	public static JMenu editMenuCreator() {

		JMenu edit = menuCreator("Edit", KeyEvent.VK_E);

		edit.add(menuItemCreator("Undo", KeyEvent.VK_U, new UndoAction(), KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		edit.add(menuItemCreator("Redo", KeyEvent.VK_R, new RedoAction(), KeyEvent.VK_Y, ActionEvent.CTRL_MASK));

		edit.addSeparator();

		edit.add(menuItemCreator("Cut", KeyEvent.VK_T, new CutAction(), KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		edit.add(menuItemCreator("Copy", KeyEvent.VK_C, new CopyAction(), KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		edit.add(menuItemCreator("Paste", KeyEvent.VK_V, new PasteAction(), KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		edit.add(menuItemCreator("Delete", KeyEvent.VK_L, new DeleteAction(), KeyEvent.VK_DELETE, 0));

		edit.addSeparator();

		edit.add(menuItemCreator("Select All", KeyEvent.VK_U, new SelectAllAction(), KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));

		return edit;
	}

	public static JMenu formatMenuCreator() {
		JMenu format = new JMenu("Format");
		format.setMnemonic(KeyEvent.VK_O);

		JMenu font = menuCreator("Font", KeyEvent.VK_F);
		JMenu fntsze = menuCreator("Size", KeyEvent.VK_S);
		fntsze.add(menuItemCreator("Increase + ", KeyEvent.VK_I, new FontSizeAction(+2), KeyEvent.VK_EQUALS,
				ActionEvent.CTRL_MASK));
		fntsze.add(menuItemCreator("Decrease + ", KeyEvent.VK_D, new FontSizeAction(-2), KeyEvent.VK_MINUS,
				ActionEvent.CTRL_MASK));
		fntsze.add(
				menuItemCreator("Reset ", KeyEvent.VK_R, new FontSizeAction(0), KeyEvent.VK_0, ActionEvent.CTRL_MASK));
		font.add(fntsze);
		font.add(menuItemCreator("Color", KeyEvent.VK_S, new ColorAction(), KeyEvent.VK_C,
				ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		format.add(font);
		format.add(menuItemCreator("Pad Color", KeyEvent.VK_C, new ColorAction(), KeyEvent.VK_C,
				ActionEvent.CTRL_MASK | ActionEvent.ALT_MASK));
		return format;
	}

	public static JMenu viewMenuCreator() {

		JMenu view = menuCreator("View", KeyEvent.VK_V);
		JMenuItem status = checkBoxMenuItemCreator("Status Bar", KeyEvent.VK_S, new StatusToggleAction(), KeyEvent.VK_S,
				ActionEvent.CTRL_MASK | ActionEvent.ALT_MASK);
		status.setSelected(true);
		view.add(status);
		JMenu laf = menuCreator("Look and Feel", KeyEvent.VK_L);
		final UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		JRadioButtonMenuItem rbm[] = new JRadioButtonMenuItem[infos.length];
		ButtonGroup bg = new ButtonGroup();
		for (int i = 0; i < infos.length; i++) {
			rbm[i] = new JRadioButtonMenuItem(infos[i].getName());
			rbm[i].setMnemonic(infos[i].getName().charAt(0));
			rbm[i].setAccelerator(KeyStroke.getKeyStroke(i + 49, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
			laf.add(rbm[i]);
			bg.add(rbm[i]);
			rbm[i].addActionListener(new LookAndFeelAction(infos[i].getClassName(), TextEditor.FRAME));
		}

		rbm[1].setSelected(true);
		view.add(laf);

		view.addSeparator();

		view.add(menuItemCreator("Next File in Stack", KeyEvent.VK_N, new SwitchNextAction(), KeyEvent.VK_BACK_QUOTE,
				ActionEvent.CTRL_MASK));
		view.add(menuItemCreator("Previous File in Stack", KeyEvent.VK_P, new SwitchPreviousAction(),
				KeyEvent.VK_BACK_QUOTE, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));

		return view;
	}

	public static JMenu helpMenuCreator() {

		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);

		JMenuItem h_about = new JMenuItem("About Us");
		h_about.addActionListener(new AboutUsAction());
		h_about.setMnemonic(KeyEvent.VK_A);
		h_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		help.add(h_about);

		help.addSeparator();

		JMenuItem h_version = new JMenuItem("Version");
		h_version.addActionListener(new VersionAction());
		h_version.setMnemonic(KeyEvent.VK_V);
		h_version.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		help.add(h_version);

		return help;
	}

	public static JMenu menuCreator(String name, int mnemonic) {
		JMenu temp = new JMenu(name);
		temp.setMnemonic(mnemonic);
		return temp;
	}

	public static JCheckBoxMenuItem checkBoxMenuItemCreator(String name, int mnemonic, ActionListener al) {
		JCheckBoxMenuItem temp = new JCheckBoxMenuItem(name);
		temp.setMnemonic(mnemonic);
		temp.addActionListener(al);
		return temp;
	}

	public static JCheckBoxMenuItem checkBoxMenuItemCreator(String name, int mnemonic, ActionListener al, int shrtctKey,
			int mask) {
		JCheckBoxMenuItem temp = new JCheckBoxMenuItem(name);
		temp.setMnemonic(mnemonic);
		temp.addActionListener(al);
		temp.setAccelerator(KeyStroke.getKeyStroke(shrtctKey, mask));
		return temp;
	}

	public static JMenuItem menuItemCreator(String name, int mnemonic, ActionListener al) {
		JMenuItem temp = new JMenuItem(name, mnemonic);
		temp.addActionListener(al);
		return temp;
	}

	public static JMenuItem menuItemCreator(String name, int mnemonic, ActionListener al, int shrtctKey, int mask) {
		JMenuItem temp = new JMenuItem(name, mnemonic);
		temp.addActionListener(al);
		temp.setAccelerator(KeyStroke.getKeyStroke(shrtctKey, mask));
		return temp;
	}

}