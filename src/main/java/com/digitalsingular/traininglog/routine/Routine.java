package com.digitalsingular.traininglog.routine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	public Optional<Workout> getLastWorkout() {
		Optional<Workout> lastWorkout = Optional.empty();
		if (!workouts.isEmpty()) {
			lastWorkout = Optional.of(workouts.get(workouts.size() - 1));
		}
		return lastWorkout;
	}

	public Optional<Workout> findWorkout(List<Activity> activitiesPerformed) {
		Optional<Workout> workoutFound = Optional.empty();
		Collections.reverse(activitiesPerformed);
		List<Workout> workouts = getWorkouts();
		final Iterator<Activity> reverseActivityIt = activitiesPerformed.iterator();
		while (reverseActivityIt.hasNext() && workouts.size() > 1) {
			final Activity activityPerformed = reverseActivityIt.next();
			if (workouts.stream().flatMap(workout -> workout.getActivities().stream())
					.anyMatch(activity -> activity.equals(activityPerformed))) {
				workouts = workouts.stream().filter(workout -> workout.getActivities().contains(activityPerformed))
						.collect(Collectors.toList());
			}
		}
		if (workouts.size() == 1) {
			workoutFound = Optional.of(workouts.get(0));
		}
		return workoutFound;
	}
}
