package com.digitalsingular.traininglog.routine;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.digitalsingular.traininglog.activity.Activity;
import com.digitalsingular.traininglog.activity.ActivityTests;

public class RoutineTests {

	@Test
	public void buildRoutine() {
		final Routine routine = getStronglifts();
		final Activity warmUp = ActivityTests.getCardioActivity();
		final Activity squats = ActivityTests.getStrongliftsSquatsSet();
		final Activity benchPress = ActivityTests.getStrongliftsBenchPressSet();
		final Activity barbellRow = ActivityTests.getStrongliftsBarbellRowSet();
		final Activity overheadPress = ActivityTests.getStrongliftsOverheadPressSet();
		final Activity deadlift = ActivityTests.getStrongliftsDeadliftSet();
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
		final Activity warmUp = ActivityTests.getCardioActivity();
		final Activity squats = ActivityTests.getStrongliftsSquatsSet();
		final Activity benchPress = ActivityTests.getStrongliftsBenchPressSet();
		final Activity barbellRow = ActivityTests.getStrongliftsBarbellRowSet();
		final Activity overheadPress = ActivityTests.getStrongliftsOverheadPressSet();
		final Activity deadlift = ActivityTests.getStrongliftsDeadliftSet();
		final String workoutAName = "Stronglifts Workout A";
		final String workoutBName = "Stronglifts Workout B";
		final String routineName = "Stronglifts";
		final Routine routine = new Routine(routineName)
				.withWorkout(workoutAName, warmUp, squats, benchPress, barbellRow)
				.withWorkout(workoutBName, warmUp, squats, overheadPress, deadlift);
		return routine;
	}
}
