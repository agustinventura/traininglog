package com.digitalsingular.traininglog.workout;

public class Level {

	public enum Hardness {
		LIGHT, MEDIUM, HARD;
	}
	private final Hardness hardness;

	private Level(Hardness hardness) {
		super();
		this.hardness = hardness;
	}

	public static Level of(Hardness hardness) {
		return new Level(hardness);
	}

	public Hardness getHardness() {
		return hardness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hardness == null) ? 0 : hardness.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		if (hardness != other.hardness)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Level [hardness=" + hardness + "]";
	}

}
