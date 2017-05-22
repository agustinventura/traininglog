package com.digitalsingular.traininglog.workout;

import java.time.Duration;

public class Rest {

	private final Duration duration;

	private Rest(Duration duration) {
		super();
		this.duration = duration;
	}

	public static Rest of(Duration duration) {
		if (duration.isNegative() || duration.isZero()) {
			throw new IllegalArgumentException("You can't un-rest!");
		}
		return new Rest(duration);
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
		final Rest other = (Rest) obj;
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
		return "Rest [duration=" + duration + "]";
	}

}
