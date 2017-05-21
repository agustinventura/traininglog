package com.digitalsingular.traininglog.workout;

public class Level {

	private final int hardness;

	private Level(int hardness) {
		super();
		this.hardness = hardness;
	}

	public static Level of(int hardness) {
		if (hardness < 0) {
			throw new IllegalArgumentException("You can't workout with negative hardness!");
		}
		return new Level(hardness);
	}

	public int getHardness() {
		return hardness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hardness;
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
		final Level other = (Level) obj;
		if (hardness != other.hardness) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Level [hardness=" + hardness + "]";
	}

}
