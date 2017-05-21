package com.digitalsingular.traininglog.routine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Routine {

	private final String name;

	private final List<Workout> workouts;

	public Routine(String name) {
		this.name = name;
		workouts = new ArrayList<>();
	}

	public Routine(String name, Workout... workouts) {
		this.name = name;
		this.workouts = Arrays.asList(workouts);
	}

	public String getName() {
		return name;
	}

	public List<Workout> getWorkouts() {
		List<Workout> workoutsClone = new ArrayList<>(workouts.size());
		for (Workout workout: workouts) {
			workoutsClone.add(workout);
		}
		return workoutsClone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Routine routine = (Routine) o;
		return Objects.equals(name, routine.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "Routine{" +
				"name='" + name + '\'' +
				", workouts=" + workouts +
				'}';
	}
}
