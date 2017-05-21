package com.digitalsingular.traininglog.workout;

import com.digitalsingular.traininglog.exercise.Exercise;

public class GroupActivity extends Activity {

	private final Exercise exercise;

	private Length length;

	public GroupActivity(String name, Exercise exercise, Length length) {
		super(name);
		this.exercise = exercise;
		this.length = length;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setLength(Length length) {
		this.length = length;
	}

	public Length getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final GroupActivity other = (GroupActivity) obj;
		if (exercise != other.exercise) {
			return false;
		}
		return true;
	}

}
