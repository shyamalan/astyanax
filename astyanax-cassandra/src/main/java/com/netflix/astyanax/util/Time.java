package com.netflix.astyanax.util;

import java.text.MessageFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Time extends ComparablePlusImpl<Time> {

	/***/
	public static final Time	MIN_TIME	= new Time(Long.MIN_VALUE, TimeUnit.NANOSECONDS);
	/***/
	public static final Time	MAX_TIME	= new Time(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	/***/
	public static final Time	NANOSECOND	= new Time(1, TimeUnit.NANOSECONDS);
	/***/
	public static final Time	MICROSECOND	= new Time(1, TimeUnit.MICROSECONDS);
	/***/
	public static final Time	MILLISECOND	= new Time(1, TimeUnit.MILLISECONDS);
	/***/
	public static final Time	SECOND		= new Time(1, TimeUnit.SECONDS);
	/***/
	public static final Time	MINUTE		= new Time(1, TimeUnit.MINUTES);
	/***/
	public static final Time	HOUR		= new Time(1, TimeUnit.HOURS);
	/***/
	public static final Time	DAY			= new Time(1, TimeUnit.DAYS);

	
	public static Time asNanos(final long nanos) {
		return new Time(nanos, TimeUnit.NANOSECONDS);
	}

	
	public static Time currentTime() {
		return new Time(System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	private final long	timeInNanos;

	
	public Time(final Date date) {
		timeInNanos = TimeUnit.NANOSECONDS.convert(date.getTime(), TimeUnit.MILLISECONDS);
	}

	
	public Time(final long amount, final TimeUnit unit) {
		if (unit == TimeUnit.NANOSECONDS)
			timeInNanos = amount;
		else
			timeInNanos = TimeUnit.NANOSECONDS.convert(amount, unit);
	}

	
	public Time(final Time otherTime) {
		timeInNanos = otherTime.inNanos();
	}

	
	public Time abs() {
		if (timeInNanos < 0)
			return new Time(Math.abs(timeInNanos), TimeUnit.NANOSECONDS);
		return this;
	}

	
	public Date asDate() {
		final Date date = new Date();
		date.setTime(TimeUnit.MILLISECONDS.convert(timeInNanos, TimeUnit.NANOSECONDS));
		return date;
	}

	
	@Override
	public int compareTo(final Time otherTime) {
		if (timeInNanos < otherTime.timeInNanos)
			return -1;
		else if (timeInNanos == otherTime.timeInNanos)
			return 0;
		return 1;
	}

	
	public Time div(final long factor) {
		return new Time(timeInNanos / factor, TimeUnit.NANOSECONDS);
	}

	
	@Override
	public boolean equals(final Object obj) {
		if (obj.getClass() != getClass())
			return false;
		return timeInNanos == Time.class.cast(obj).timeInNanos;
	}

	
	@Override
	public int hashCode() {
		return (int) (timeInNanos >>> 32 ^ timeInNanos);
	}

	
	public long inDays() {
		return TimeUnit.DAYS.convert(timeInNanos, TimeUnit.NANOSECONDS);
	}

	
	public long inHours() {
		return TimeUnit.HOURS.convert(timeInNanos, TimeUnit.NANOSECONDS);
	}

	
	public long inMicros() {
		return TimeUnit.MICROSECONDS.convert(timeInNanos, TimeUnit.NANOSECONDS);
	}

	
	public long inMillis() {
		return TimeUnit.MILLISECONDS.convert(timeInNanos, TimeUnit.NANOSECONDS);
	}

	
	public long inMinutes() {
		return TimeUnit.MINUTES.convert(timeInNanos, TimeUnit.NANOSECONDS);
	}

	
	public long inNanos() {
		return timeInNanos;
	}

	
	public long inSeconds() {
		return TimeUnit.SECONDS.convert(timeInNanos, TimeUnit.NANOSECONDS);
	}

	/**
	 * @param time
	 * @return the subtraction of the two times
	 */
	public Time minus(final Time time) {
		return new Time(timeInNanos - time.timeInNanos, TimeUnit.NANOSECONDS);
	}

	
	public Time mod(final long factor) {
		return new Time(timeInNanos % factor, TimeUnit.NANOSECONDS);
	}

	
	public Time plus(final Time time) {
		return new Time(timeInNanos + time.timeInNanos, TimeUnit.NANOSECONDS);
	}

	
	public Time times(final long factor) {
		return new Time(timeInNanos * factor, TimeUnit.NANOSECONDS);
	}

	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		Time val;
		if (timeInNanos < 0) {
			sb.append('-');
			val = new Time(Math.abs(timeInNanos), TimeUnit.NANOSECONDS);
		}
		else
			val = new Time(this);
		final long inDays = val.inDays();
		if (inDays != 0) {
			sb.append(Long.toString(inDays));
			if (inDays == 1)
				sb.append(" day ");
			else
				sb.append(" days ");
			val = val.minus(new Time(inDays, TimeUnit.DAYS));
		}
		final long hours = val.inHours();
		val = val.minus(new Time(hours, TimeUnit.HOURS));
		final long minutes = val.inMinutes();
		val = val.minus(new Time(minutes, TimeUnit.MINUTES));
		final long seconds = val.inSeconds();
		val = val.minus(new Time(seconds, TimeUnit.SECONDS));
		final long millis = val.inMillis();
		val = val.minus(new Time(millis, TimeUnit.MILLISECONDS));
		final long micros = val.inMicros();
		val = val.minus(new Time(micros, TimeUnit.MICROSECONDS));
		final long nanos = val.inNanos();
		final String rest = MessageFormat
			.format(
				"{0,number,00;-00}:{1,number,00;-00}:{2,number,00;-00} {3,number,000;-000}ms {4,number,000;000}µs {5,number,000;-000}ns",
				new Long(hours), new Long(minutes), new Long(seconds), new Long(millis), new Long(micros), new Long(
					nanos));
		sb.append(rest);
		return sb.toString();
	}
}
