package com.digitalsingular.traininglog.workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SerialActivity extends Activity {

	private final List<TrainingSet> trainingSets;

	public SerialActivity(String name) {
		super(name);
		this.trainingSets = new ArrayList<>();
	}

	public List<TrainingSet> getTrainingSets() {
		List<TrainingSet> setsClone = new ArrayList<>(trainingSets.size());
		for (TrainingSet set: trainingSets) {
			setsClone.add(set);
		}
		return setsClone;
	}

	public List<TrainingSet> add(TrainingSet trainingSet) {
		if (trainingSet != null) {
			trainingSets.add(trainingSet);
		}
		return getTrainingSets();
	}

	@Override
	public String toString() {
		return "SerialActivity{" +
				"trainingSets=" + trainingSets +
				'}';
	}
}
