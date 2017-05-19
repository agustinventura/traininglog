package com.digitalsingular.traininglog.workout;

import java.time.Duration;

public class Length {

	private final Duration duration;

	private Length(Duration duration) {
		super();
		this.duration = duration;
	}

	public Length of(Duration duration) {
		if (duration.isNegative()) {
			throw new IllegalArgumentException("You can't un-workout!");
		}
		return new Length(duration);
	}

	public Duration getDuration() {
		return duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Length other = (Length) obj;
		if (duration == null) {
			if (other.duration != null) {
				return false;
			}
		} else if (!duration.equals(other.duration)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Length [duration=" + duration + "]";
	}
}
