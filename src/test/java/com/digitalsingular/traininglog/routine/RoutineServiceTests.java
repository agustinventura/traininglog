package com.digitalsingular.traininglog.routine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.digitalsingular.traininglog.activity.ActivityTests;
import com.digitalsingular.traininglog.user.User;
import com.digitalsingular.traininglog.user.UserTests;

public class RoutineServiceTests {

	private RoutineService routineService = null;
	private User agustin = null;

	@Before
	public void setUp() {
		this.routineService = new RoutineService();
		agustin = UserTests.getAgustin();
	}

	@Test
	public void getNextWorkoutWithoutRoutine() {
		final Optional<Workout> workout = routineService.getNextWorkout(agustin);
		assertFalse(workout.isPresent());
	}

	@Test
	public void getNextWorkoutWithoutTrainingDays() {
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		final Optional<Workout> workout = routineService.getNextWorkout(agustin);
		assertTrue(workout.equals(stronglifts.getFirstWorkout()));
	}

	@Test
	public void getNextWorkoutWithActivityInNoRoutine() {
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(ActivityTests.getGroupActivity());
		final Optional<Workout> workout = routineService.getNextWorkout(agustin);
		assertTrue(workout.equals(Optional.empty()));
	}

	@Test
	public void getNextWorkoutWithActivityInRoutine() {
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(ActivityTests.getStrongliftsBarbellRowSet());
		final Optional<Workout> workout = routineService.getNextWorkout(agustin);
		assertTrue(workout.isPresent() && workout.get().equals(stronglifts.getWorkouts().get(1)));
	}

	@Test
	public void getNextWorkoutWithActivityInTwoRoutineWorkouts() {
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(ActivityTests.getStrongliftsSquatsSet());
		final Optional<Workout> workout = routineService.getNextWorkout(agustin);
		assertTrue(workout.equals(Optional.empty()));
	}

	@Test
	public void getNextWorkoutWithTwoActivitiesInRoutineWorkouts() {
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(ActivityTests.getStrongliftsSquatsSet());
		agustin.log(ActivityTests.getStrongliftsBarbellRowSet());
		final Optional<Workout> workout = routineService.getNextWorkout(agustin);
		assertTrue(workout.isPresent() && workout.get().equals(stronglifts.getWorkouts().get(1)));
	}

	@Test
	public void getNextWorkoutWithTwoActivitiesInRoutineWorkoutsAndAnUnrelatedOne() {
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(ActivityTests.getStrongliftsSquatsSet());
		agustin.log(ActivityTests.getGroupActivity());
		agustin.log(ActivityTests.getStrongliftsBarbellRowSet());
		final Optional<Workout> workout = routineService.getNextWorkout(agustin);
		assertTrue(workout.isPresent() && workout.get().equals(stronglifts.getWorkouts().get(1)));
	}
}
