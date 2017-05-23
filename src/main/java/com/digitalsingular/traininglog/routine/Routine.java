package com.digitalsingular.traininglog.routine;

import java.util.ArrayList;
import java.util.List;

import com.digitalsingular.traininglog.activity.Activity;

public class Routine {

	private final String name;

	private final List<Workout> workouts;

	public Routine(String name) {
		this.name = name;
		workouts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Workout> getWorkouts() {
		final List<Workout> workoutsClone = new ArrayList<>(workouts.size());
		for (final Workout workout : workouts) {
			workoutsClone.add(workout);
		}
		return workoutsClone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		final Routine other = (Routine) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Routine [name=" + name + ", workouts=" + workouts + "]";
	}

	public Routine withWorkout(String workoutName, Activity... activities) {
		if (workoutName != null && activities.length != 0) {
			this.workouts.add(new Workout(workoutName, activities));
		}
		return this;
	}
}
