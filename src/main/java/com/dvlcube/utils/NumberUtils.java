package com.dvlcube.utils;

import com.dvlcube.utils.ex.Range;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @since 04/07/2013
 * @author Ulisses Lima
 */
public class NumberUtils {
	/**
	 * http://stackoverflow.com/questions/345187/math-mapping-numbers
	 * <p>
	 * Linear Transform
	 * <p>
	 * Y = (X-A)/(B-A) * (D-C) + C
	 * 
	 * @param originalRange
	 * @param newRange
	 * @return (X-A)/(B-A) * (D-C) + C
	 * @since 04/07/2013
	 * @author Ulisses Lima
	 */
	public static double map(double n, Range<Double> originalRange, Range<Double> newRange) {
		double newNumber = (n - originalRange.getStart()) / (originalRange.getEnd() - originalRange.getStart())
				* (newRange.getEnd() - newRange.getStart()) + newRange.getStart();
		return round2(newNumber);
	}

	public static Double round2(Double val) {
		return new BigDecimal(val.toString()).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}