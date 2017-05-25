package com.digitalsingular.traininglog.activity;

import java.time.Duration;

import com.digitalsingular.traininglog.activity.Level.Hardness;
import com.digitalsingular.traininglog.exercise.Exercise;

public class ActivityTests {

	public static CardioActivity getCardioActivity() {
		return new CardioActivity("short run", Exercise.RUN, Length.of(Duration.ofMinutes(10L)),
				Level.of(Hardness.LIGHT));
	}

	public static GroupActivity getGroupActivity() {
		return new GroupActivity("yoga", Exercise.YOGA, Length.of(Duration.ofMinutes(55L)));
	}

	public static SerialActivity getStrongliftsSquatsSet() {
		final String squatSets = "Stronglifts Squat Sets";
		final SerialActivity strongLiftsSquatsSet = new SerialActivity(squatSets);
		final TrainingSet squatsSet = new TrainingSet.Builder(Exercise.SQUATS).repetitions(Repetitions.of(5))
				.weight(Weight.of(100)).rest(Rest.of(Duration.ofSeconds(120L))).build();
		for (int i = 0; i < 5; i++) {
			strongLiftsSquatsSet.add(squatsSet);
		}
		return strongLiftsSquatsSet;
	}

	public static Activity getStrongliftsBenchPressSet() {
		final String benchPressSets = "Stronglifts Bench Press Sets";
		final SerialActivity strongLiftsBenchPressSet = new SerialActivity(benchPressSets);
		final TrainingSet benchPressSet = new TrainingSet.Builder(Exercise.BENCH_PRESS).repetitions(Repetitions.of(5))
				.weight(Weight.of(100)).rest(Rest.of(Duration.ofSeconds(120L))).build();
		for (int i = 0; i < 5; i++) {
			strongLiftsBenchPressSet.add(benchPressSet);
		}
		return strongLiftsBenchPressSet;
	}

	public static Activity getStrongliftsBarbellRowSet() {
		final String barbellRowSets = "Stronglifts Barbell Row Sets";
		final SerialActivity strongLiftsBarbellRowSet = new SerialActivity(barbellRowSets);
		final TrainingSet barbellRowSet = new TrainingSet.Builder(Exercise.BARBELL_ROW).repetitions(Repetitions.of(5))
				.weight(Weight.of(100)).rest(Rest.of(Duration.ofSeconds(120L))).build();
		for (int i = 0; i < 5; i++) {
			strongLiftsBarbellRowSet.add(barbellRowSet);
		}
		return strongLiftsBarbellRowSet;
	}

	public static Activity getStrongliftsOverheadPressSet() {
		final String overheadPressSets = "Stronglifts Overhead Press Sets";
		final SerialActivity strongLiftsOverheadPressSet = new SerialActivity(overheadPressSets);
		final TrainingSet overheadPressSet = new TrainingSet.Builder(Exercise.OVERHEAD_PRESS)
				.repetitions(Repetitions.of(5)).weight(Weight.of(100)).rest(Rest.of(Duration.ofSeconds(120L))).build();
		for (int i = 0; i < 5; i++) {
			strongLiftsOverheadPressSet.add(overheadPressSet);
		}
		return strongLiftsOverheadPressSet;
	}

	public static Activity getStrongliftsDeadliftSet() {
		final String deadliftSets = "Stronglifts Deadlift Sets";
		final SerialActivity strongLiftsDeadliftSet = new SerialActivity(deadliftSets);
		final TrainingSet deadliftSet = new TrainingSet.Builder(Exercise.DEADLIFT).repetitions(Repetitions.of(5))
				.weight(Weight.of(100)).rest(Rest.of(Duration.ofSeconds(120L))).build();
		for (int i = 0; i < 5; i++) {
			strongLiftsDeadliftSet.add(deadliftSet);
		}
		return strongLiftsDeadliftSet;
	}
}
