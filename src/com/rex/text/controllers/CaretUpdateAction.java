package com.rex.text.controllers;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.rex.text.TextEditor;
import com.rex.text.views.TextPanel;

public class CaretUpdateAction implements CaretListener {
	public void caretUpdate(CaretEvent e) {
		TextPanel crnt_txt_pnl = (TextPanel) TextEditor.JTP.getSelectedComponent();
		int pos, line, column, sstart, send, ssl, sel;
		pos = line = column = sstart = send = ssl = sel = 0;
		try {
			pos = crnt_txt_pnl.JTA.getCaretPosition();
			line = crnt_txt_pnl.JTA.getLineOfOffset(pos);
			column = pos - crnt_txt_pnl.JTA.getLineStartOffset(line);
			sstart = crnt_txt_pnl.JTA.getSelectionStart(); // Selection Start Character Position
			send = crnt_txt_pnl.JTA.getSelectionEnd(); // Selection End Character Position
			ssl = crnt_txt_pnl.JTA.getLineOfOffset(sstart); // Selection Start Line Position
			sel = crnt_txt_pnl.JTA.getLineOfOffset(send); // Selection End Line Position
		} catch (javax.swing.text.BadLocationException excp) {
			System.out.println(excp);
		}
		crnt_txt_pnl.SB.setText("Line " + ++line + ", Column " + ++column);
		if (sstart != send) {
			if (ssl != sel) {
				crnt_txt_pnl.SB.setText((sel - ssl + 1) + " lines, ");
			} else {
				crnt_txt_pnl.SB.setText("");
			}
			crnt_txt_pnl.SB.setText(crnt_txt_pnl.SB.getText() + (send - sstart) + " Characters Selected");
		}
	}
}
