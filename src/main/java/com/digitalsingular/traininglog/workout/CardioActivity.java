package com.digitalsingular.traininglog.workout;

import com.digitalsingular.traininglog.exercise.Exercise;

import java.util.Objects;

public class CardioActivity extends Activity {

	private final Exercise exercise;

	private Length length;

	private Level level;

	public CardioActivity(String name, Exercise exercise, Length length, Level level) {
		super(name);
		this.exercise = exercise;
		this.length = length;
		this.level = level;
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "CardioActivity{" +
				"exercise=" + exercise +
				", length=" + length +
				", level=" + level +
				'}';
	}
}
