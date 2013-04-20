package com.netflix.astyanax.util;
/*
 * @author Shyam Singh
 */


public interface ComparablePlus<T> extends Comparable<T> {

	
	public boolean isEqualTo(final T obj);

	
	public boolean isGreaterThan(final T obj);

	
	public boolean isGreaterThanOrEqualTo(final T obj);

	
	public boolean isLessThan(final T obj);

	
	public boolean isLessThanOrEqual(final T obj);

	
	public boolean isNotEqual(final T obj);

}
