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

	public Length getLength() {
		return length;
	}

	public void setLength(Length length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "GroupActivity [exercise=" + exercise + ", length=" + length + ", getName()=" + getName() + "]";
	}
}
