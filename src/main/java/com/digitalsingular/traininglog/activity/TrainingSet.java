package com.digitalsingular.traininglog.activity;

import java.util.Optional;

import com.digitalsingular.traininglog.exercise.Exercise;

public class TrainingSet {

	private final Exercise exercise;

	private final Optional<Repetitions> repetitions;

	private final Optional<Length> length;

	private final Optional<Rest> rest;

	private final Optional<Weight> weight;

	public TrainingSet(Exercise exercise, Optional<Repetitions> repetitions, Optional<Length> length, Optional<Rest> rest,
			Optional<Weight> weight) {
		super();
		this.exercise = exercise;
		this.repetitions = repetitions;
		this.length = length;
		this.rest = rest;
		this.weight = weight;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public Optional<Repetitions> getRepetitions() {
		return repetitions;
	}

	public Optional<Length> getLength() {
		return length;
	}

	public Optional<Rest> getRest() {
		return rest;
	}

	public Optional<Weight> getWeight() {
		return weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((repetitions == null) ? 0 : repetitions.hashCode());
		result = prime * result + ((rest == null) ? 0 : rest.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		final TrainingSet other = (TrainingSet) obj;
		if (exercise == null) {
			if (other.exercise != null) {
				return false;
			}
		} else if (!exercise.equals(other.exercise)) {
			return false;
		}
		if (length == null) {
			if (other.length != null) {
				return false;
			}
		} else if (!length.equals(other.length)) {
			return false;
		}
		if (repetitions == null) {
			if (other.repetitions != null) {
				return false;
			}
		} else if (!repetitions.equals(other.repetitions)) {
			return false;
		}
		if (rest == null) {
			if (other.rest != null) {
				return false;
			}
		} else if (!rest.equals(other.rest)) {
			return false;
		}
		if (weight == null) {
			if (other.weight != null) {
				return false;
			}
		} else if (!weight.equals(other.weight)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Set [exercise=" + exercise + ", repetitions=" + repetitions + ", length=" + length + ", rest=" + rest
				+ ", weight=" + weight + "]";
	}

	public static class Builder {
		private final Exercise exercise;

		private Repetitions repetitions;

		private Length length;

		private Rest rest;

		private Weight weight;

		public Builder(Exercise exercise) {
			super();
			this.exercise = exercise;
		}

		public Builder repetitions(Repetitions repetitions) {
			this.repetitions = repetitions;
			return this;
		}

		public Builder length(Length length) {
			this.length = length;
			return this;
		}

		public Builder rest(Rest rest) {
			this.rest = rest;
			return this;
		}

		public Builder weight(Weight weight) {
			this.weight = weight;
			return this;
		}

		public TrainingSet build() {
			TrainingSet set = null;
			if (repetitions != null && length != null) {
				throw new IllegalArgumentException("You can't have a Set with repetitions and length!");
			} else if (repetitions == null && length == null) {
				throw new IllegalArgumentException("A Set must have either repetitions or length!");
			} else {
				set = new TrainingSet(exercise, Optional.ofNullable(repetitions), Optional.ofNullable(length),
						Optional.ofNullable(rest), Optional.ofNullable(weight));
			}
			return set;
		}

	}
}
