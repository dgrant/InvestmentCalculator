package ca.davidgrant.ui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ca.davidgrant.util.StringUtils;

/*
 * Copyright (C) 2002 David Grant
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * Created by IntelliJ IDEA.
 * Author: david
 * Date: Dec 5, 2002
 * Time: 1:00:55 AM
 */

public class DoubleTextField extends JTextField implements FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private double actualValue;

	/**
	 * Other constructor
	 */
	public DoubleTextField(double d, int columns) {
		super(columns);
		this.setNumber(d);
		this.addFocusListener(this);
	}

	/**
	 * Other constructor
	 */
	public DoubleTextField(double d) {
		this(d, 10);
	}

	public double getNumber() {
		return actualValue;
	}

	public void setNumber(double d) {
		if (Double.isNaN(d) || d == 0d) {
			actualValue = 0d;
			super.setText("0.00");
		} else {
			actualValue = d;
			DecimalFormat df = new DecimalFormat("0.00");
			StringBuffer sBuf = new StringBuffer(df.format(d));
			super.setText(sBuf.toString());
		}
	}

	public void focusLost(FocusEvent e) {
		try {
			this.setNumber(Double.parseDouble(StringUtils.stripLetters(this
					.getText())));
		} catch (NumberFormatException e1) {
			this.setNumber(1d);
		}
	}

	public void focusGained(FocusEvent fe) {
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame("Percent Text Field Test Frame");
		DoubleTextField testDoubleTextField = new DoubleTextField(5.678, 20);
		JPanel testPanel = new JPanel();
		JButton testButton = new JButton("click me");

		testPanel.add(testDoubleTextField);
		testPanel.add(testButton);

		testPanel.setVisible(true);

		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.getContentPane().add(testPanel);
		testFrame.setVisible(true);
		testFrame.pack();
	}

}
