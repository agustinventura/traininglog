package com.digitalsingular.traininglog.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

import com.digitalsingular.traininglog.activity.Activity;

public class TrainingLog {

	private final SortedMap<LocalDate, TrainingDay> trainingDays;

	TrainingLog() {
		this.trainingDays = new TreeMap<>();
	}

	public List<TrainingDay> getTrainingDays() {
		final List<TrainingDay> trainingDaysClone = new ArrayList<>(trainingDays.size());
		for (final Map.Entry<LocalDate, TrainingDay> day : trainingDays.entrySet()) {
			trainingDaysClone.add(day.getValue());
		}
		return trainingDaysClone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trainingDays == null) ? 0 : trainingDays.hashCode());
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
		final TrainingLog other = (TrainingLog) obj;
		if (trainingDays == null) {
			if (other.trainingDays != null) {
				return false;
			}
		} else if (!trainingDays.equals(other.trainingDays)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TrainingLog [trainingDays=" + trainingDays + "]";
	}

	Optional<TrainingDay> log(Activity activity) {
		Optional<TrainingDay> loggedDay = Optional.empty();
		if (activity != null) {
			final LocalDate today = LocalDate.now();
			if (trainingDays.containsKey(today)) {
				trainingDays.get(today).add(activity);
				loggedDay = Optional.of(trainingDays.get(today));
			} else {
				final TrainingDay trainingDay = new TrainingDay(today, activity);
				add(trainingDay);
				loggedDay = Optional.of(trainingDay);
			}
		}
		return loggedDay;
	}

	private void add(TrainingDay trainingDay) {
		if (trainingDay != null) {
			this.trainingDays.put(trainingDay.getDate(), trainingDay);
		}
	}
}
