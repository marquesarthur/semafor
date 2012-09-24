/*******************************************************************************
 * Copyright (c) 2011 Dipanjan Das 
 * Language Technologies Institute, 
 * Carnegie Mellon University, 
 * All Rights Reserved.
 * 
 * Prediction.java is part of SEMAFOR 2.0.
 * 
 * SEMAFOR 2.0 is free software: you can redistribute it and/or modify  it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 * 
 * SEMAFOR 2.0 is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. 
 * 
 * You should have received a copy of the GNU General Public License along
 * with SEMAFOR 2.0.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package edu.cmu.cs.lti.ark.util;

/**
 * Wrapper for a predicted value or object and an associated score.
 * 
 * @author Nathan Schneider (nschneid)
 * @since 2009-11-17
 *
 * @param <T> Type of the predicted object
 */
public class Prediction<T> {
	T _item;
	double _score;
	
	public Prediction(T item, double score) {
		_item = item;
		_score = score;
	}
	public T getItem() { return _item; }
	public double getScore() { return _score; }
}
