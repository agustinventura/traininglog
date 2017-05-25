package com.digitalsingular.traininglog.routine;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.Test;

import com.digitalsingular.traininglog.activity.Activity;
import com.digitalsingular.traininglog.activity.CardioActivity;
import com.digitalsingular.traininglog.activity.Length;
import com.digitalsingular.traininglog.activity.Level;
import com.digitalsingular.traininglog.activity.Level.Hardness;
import com.digitalsingular.traininglog.activity.Repetitions;
import com.digitalsingular.traininglog.activity.Rest;
import com.digitalsingular.traininglog.activity.SerialActivity;
import com.digitalsingular.traininglog.activity.TrainingSet;
import com.digitalsingular.traininglog.activity.Weight;
import com.digitalsingular.traininglog.exercise.Exercise;

public class RoutineTests {

	@Test
	public void buildRoutine() {
		final Routine routine = getStronglifts();
		final Activity warmUp = getShortRun();
		final Activity squats = getStrongliftsSquatsSet();
		final Activity benchPress = getStrongliftsBenchPressSet();
		final Activity barbellRow = getStrongliftsBarbellRowSet();
		final Activity overheadPress = getStrongliftsOverheadPressSet();
		final Activity deadlift = getStrongliftsDeadliftSet();
		assertTrue(routine.getWorkouts().size() == 2);
		for (int i = 0; i < routine.getWorkouts().size(); i++) {
			final List<Activity> activities = routine.getWorkouts().get(i).getActivities();
			assertTrue(activities.size() == 4);
			if (i == 0) {
				assertTrue(activities.contains(warmUp) && activities.contains(squats) && activities.contains(benchPress)
						&& activities.contains(barbellRow));
			} else {
				assertTrue(activities.contains(warmUp) && activities.contains(squats)
						&& activities.contains(overheadPress) && activities.contains(deadlift));
			}
		}
	}

	public static Routine getStronglifts() {
		final Activity warmUp = getShortRun();
		final Activity squats = getStrongliftsSquatsSet();
		final Activity benchPress = getStrongliftsBenchPressSet();
		final Activity barbellRow = getStrongliftsBarbellRowSet();
		final Activity overheadPress = getStrongliftsOverheadPressSet();
		final Activity deadlift = getStrongliftsDeadliftSet();
		final String workoutAName = "Stronglifts Workout A";
		final String workoutBName = "Stronglifts Workout B";
		final String routineName = "Stronglifts";
		final Routine routine = new Routine(routineName)
				.withWorkout(workoutAName, warmUp, squats, benchPress, barbellRow)
				.withWorkout(workoutBName, warmUp, squats, overheadPress, deadlift);
		return routine;
	}

	private static CardioActivity getShortRun() {
		final String shortRun = "Short run";
		return new CardioActivity(shortRun, Exercise.RUN, Length.of(Duration.ofMinutes(5L)), Level.of(Hardness.LIGHT));
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

	private static Activity getStrongliftsBenchPressSet() {
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

	private static Activity getStrongliftsOverheadPressSet() {
		final String overheadPressSets = "Stronglifts Overhead Press Sets";
		final SerialActivity strongLiftsOverheadPressSet = new SerialActivity(overheadPressSets);
		final TrainingSet overheadPressSet = new TrainingSet.Builder(Exercise.OVERHEAD_PRESS)
				.repetitions(Repetitions.of(5)).weight(Weight.of(100)).rest(Rest.of(Duration.ofSeconds(120L))).build();
		for (int i = 0; i < 5; i++) {
			strongLiftsOverheadPressSet.add(overheadPressSet);
		}
		return strongLiftsOverheadPressSet;
	}

	private static Activity getStrongliftsDeadliftSet() {
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
