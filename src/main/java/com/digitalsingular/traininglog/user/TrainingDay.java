package com.digitalsingular.traininglog.user;

import com.digitalsingular.traininglog.workout.Activity;

import java.time.LocalDate;
import java.util.*;

public class TrainingDay {

	private final LocalDate date;

	private final List<Activity> activities;

	public TrainingDay(LocalDate date, Activity... activities) {
		this.date = date;
		this.activities = Arrays.asList(activities);
	}

	public LocalDate getDate() {
		return date;
	}

	public List<Activity> getActivities() {
		List<Activity> activitiesClone = new ArrayList<>(activities.size());
		for (Activity activity: activities) {
			activitiesClone.add(activity);
		}
		return activitiesClone;
	}

	public void add(Activity activity) {
		if (activity != null) {
			activities.add(activity);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TrainingDay that = (TrainingDay) o;
		return Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}

	@Override
	public String toString() {
		return "TrainingDay{" +
				"date=" + date +
				", activities=" + activities +
				'}';
	}
}
