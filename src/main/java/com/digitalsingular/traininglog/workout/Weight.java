package com.digitalsingular.traininglog.workout;

public class Weight {

	private final int kilos;

	private Weight(int kilos) {
		super();
		this.kilos = kilos;
	}

	public static Weight of(int kilos) {
		if (kilos < 0) {
			throw new IllegalArgumentException("You can't lift negative kilos!");
		}
		return new Weight(kilos);
	}

	public int getKilos() {
		return kilos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kilos;
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
		final Weight other = (Weight) obj;
		if (kilos != other.kilos) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Weight [kilos=" + kilos + "]";
	}

}
