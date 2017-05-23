package com.digitalsingular.traininglog.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.digitalsingular.traininglog.activity.Activity;

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
		final List<Activity> activitiesClone = new ArrayList<>(activities.size());
		for (final Activity activity : activities) {
			activitiesClone.add(activity);
		}
		return activitiesClone;
	}

	void add(Activity activity) {
		if (activity != null) {
			activities.add(activity);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		final TrainingDay other = (TrainingDay) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TrainingDay [date=" + date + ", activities=" + activities + "]";
	}
}
