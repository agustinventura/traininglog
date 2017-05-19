package com.digitalsingular.traininglog.workout;

public class Repetitions {

	private final int number;

	public Repetitions(int number) {
		super();
		this.number = number;
	}

	public static Repetitions of(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("You can't do negative repetitions!");
		}
		return new Repetitions(number);
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		final Repetitions other = (Repetitions) obj;
		if (number != other.number) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Repetitions [number=" + number + "]";
	}

}
