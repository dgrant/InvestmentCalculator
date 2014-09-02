package ca.davidgrant.util;

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
 * Date: May 12, 2003
 * Time: 12:32:00 AM
 */

public class StringUtils {

	/**
	 * Public empty constructor
	 */
	public static String stripLetters(String s) {
		StringBuffer sBuf = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.'
					|| s.charAt(i) == '-') {
				sBuf.append(s.charAt(i));
			}
		}
		return sBuf.toString();
	}
}
