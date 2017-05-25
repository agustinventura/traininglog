package com.digitalsingular.traininglog.routine;

import java.util.List;
import java.util.Optional;

import com.digitalsingular.traininglog.activity.Activity;
import com.digitalsingular.traininglog.user.User;

public class RoutineService {

	public Optional<Workout> getNextWorkout(User user) {
		Optional<Workout> nextWorkout = Optional.empty();
		final List<Activity> activitiesPerformed = user.getPerformedActivities();
		final Optional<Routine> currentRoutine = user.getCurrentRoutine();
		if (currentRoutine.isPresent()) {
			nextWorkout = currentRoutine.get().getNextWorkout(activitiesPerformed);
		}
		return nextWorkout;
	}
}
