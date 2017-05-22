package com.digitalsingular.traininglog.routine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.digitalsingular.traininglog.workout.Activity;

public class Workout {

	private final List<Activity> activities;

	public Workout(Activity... activities) {
		this.activities = Arrays.asList(activities);
	}

	public List<Activity> getActivities() {
		final List<Activity> activitiesClone = new ArrayList<>(activities.size());
		for (final Activity activity : activities) {
			activitiesClone.add(activity);
		}
		return activitiesClone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activities == null) ? 0 : activities.hashCode());
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
		final Workout other = (Workout) obj;
		if (activities == null) {
			if (other.activities != null) {
				return false;
			}
		} else if (!activities.equals(other.activities)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Workout [activities=" + activities + "]";
	}

}
