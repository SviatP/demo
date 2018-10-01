package com.sviat.demo.dto;

import java.util.Arrays;

public enum SessionPeriod {
	MORNING(9, 12),
	DAY(12, 18),
	EVENING(18, 24),
	NIGHT(0, 9),;

	SessionPeriod(int start, int end) {
		this.start = start;
		this.end = end;

	}

	public static SessionPeriod fromHours(int hour) {
		return Arrays.stream(values()).filter(value -> value.getStart() <= hour && hour < value.getEnd())
				.findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("wrong time requested for hours %d", hour)));
	}

	private int start;
	private int end;

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
}
