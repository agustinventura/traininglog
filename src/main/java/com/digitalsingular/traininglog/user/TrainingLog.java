package com.digitalsingular.traininglog.user;

import java.util.ArrayList;
import java.util.List;

public class TrainingLog {

	private final List<TrainingDay> trainingDays;

	public TrainingLog() {
		this.trainingDays = new ArrayList<>();
	}

	public void add(TrainingDay trainingDay) {
		if (trainingDay != null) {
			this.trainingDays.add(trainingDay);
		}
	}

	public List<TrainingDay> getTrainingDays() {
		return trainingDays;
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
}
