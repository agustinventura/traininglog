package com.digitalsingular.traininglog.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.digitalsingular.traininglog.activity.Activity;
import com.digitalsingular.traininglog.routine.Routine;

public class User {

	private final String username;

	private final List<Routine> routines;

	private final TrainingLog trainingLog;

	public User(String username) {
		super();
		this.username = username;
		this.routines = new ArrayList<>();
		this.trainingLog = new TrainingLog();
	}

	public String getUsername() {
		return username;
	}

	public List<Routine> getRoutines() {
		final List<Routine> clone = new ArrayList<>(routines.size());
		for (final Routine routine : routines) {
			clone.add(routine);
		}
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		final User other = (User) obj;
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", routines=" + routines + ", trainingLog=" + trainingLog + "]";
	}

	public Optional<TrainingDay> log(Activity activity) {
		Optional<TrainingDay> loggedDay = Optional.empty();
		if (activity != null) {
			loggedDay = trainingLog.log(activity);
		}
		return loggedDay;
	}

	public List<Routine> assign(Routine routine) {
		if (routine != null) {
			this.routines.add(routine);
		}
		return getRoutines();
	}

	public Optional<Routine> getCurrentRoutine() {
		return routines.isEmpty() ? Optional.empty() : Optional.of(routines.get(routines.size() - 1));
	}

	public List<Activity> getPerformedActivities() {
		final List<TrainingDay> trainingDays = trainingLog.getTrainingDays();
		final List<Activity> activities = trainingDays.stream()
				.flatMap(trainingDay -> trainingDay.getActivities().stream()).collect(Collectors.toList());
		return activities;
	}
}
