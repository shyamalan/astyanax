package com.netflix.astyanax.util;


public abstract class ComparablePlusImpl<T> implements ComparablePlus<T> {

	
	@Override
	public boolean isEqualTo(final T obj) {
		return compareTo(obj) == 0;
	}

	
	@Override
	public boolean isGreaterThan(final T obj) {
		return compareTo(obj) > 0;
	}

	/**
	 * @see com.apigee.data.Utilities.ComparableExt#isGreaterThanOrEqualTo(java.lang.Object)
	 */
	@Override
	public boolean isGreaterThanOrEqualTo(final T obj) {
		return compareTo(obj) >= 0;
	}

	
	@Override
	public boolean isLessThan(final T obj) {
		return compareTo(obj) < 0;
	}

	
	@Override
	public boolean isLessThanOrEqual(final T obj) {
		return compareTo(obj) <= 0;
	}

	
	@Override
	public boolean isNotEqual(final T obj) {
		return compareTo(obj) != 0;
	}
}
