package com.digitalsingular.traininglog.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.digitalsingular.traininglog.activity.Activity;
import com.digitalsingular.traininglog.activity.CardioActivity;
import com.digitalsingular.traininglog.activity.GroupActivity;
import com.digitalsingular.traininglog.activity.Length;
import com.digitalsingular.traininglog.activity.Level;
import com.digitalsingular.traininglog.activity.Level.Hardness;
import com.digitalsingular.traininglog.exercise.Exercise;
import com.digitalsingular.traininglog.routine.Routine;
import com.digitalsingular.traininglog.routine.RoutineTests;
import com.digitalsingular.traininglog.routine.Workout;

public class UserTest {

	@Test
	public void logActivity() {
		final User user = getAgustin();
		final Activity cardio = getCardioActivity();
		final TrainingDay trainingDay = user.log(cardio).get();
		assertTrue(trainingDay.getActivities().contains(cardio));
		assertTrue(trainingDay.getDate().isEqual(LocalDate.now()));
	}

	private CardioActivity getCardioActivity() {
		return new CardioActivity("short run", Exercise.RUN, Length.of(Duration.ofMinutes(10L)),
				Level.of(Hardness.LIGHT));
	}

	private GroupActivity getGroupActivity() {
		return new GroupActivity("yoga", Exercise.YOGA, Length.of(Duration.ofMinutes(55L)));
	}

	private User getAgustin() {
		return new User("Agustín");
	}

	@Test
	public void logNullActivity() {
		final User user = getAgustin();
		assertFalse(user.log(null).isPresent());
	}

	@Test
	public void logTwoActivities() {
		final User user = getAgustin();
		final Activity cardio = getCardioActivity();
		final Activity group = getGroupActivity();
		user.log(cardio).get();
		final TrainingDay trainingDay = user.log(group).get();
		assertTrue(trainingDay.getActivities().contains(cardio));
		assertTrue(trainingDay.getActivities().contains(group));
		assertTrue(trainingDay.getDate().isEqual(LocalDate.now()));
	}

	@Test
	public void assignRoutineToUser() {
		final User agustin = getAgustin();
		final Routine stronglifts = RoutineTests.getStronglifts();
		final List<Routine> routines = agustin.assign(stronglifts);
		assertTrue(routines.contains(stronglifts));
	}

	@Test
	public void getNextWorkoutWithoutRoutine() {
		final User agustin = getAgustin();
		final Optional<Workout> workout = agustin.getNextWorkout();
		assertFalse(workout.isPresent());
	}

	@Test
	public void getNextWorkoutWithoutTrainingDays() {
		final User agustin = getAgustin();
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		final Optional<Workout> workout = agustin.getNextWorkout();
		assertTrue(workout.equals(stronglifts.getLastWorkout()));
	}

	@Test
	public void getNextWorkoutWithActivityInNoRoutine() {
		final User agustin = getAgustin();
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(getGroupActivity());
		final Optional<Workout> workout = agustin.getNextWorkout();
		assertTrue(workout.equals(Optional.empty()));
	}

	@Test
	public void getNextWorkoutWithActivityInRoutine() {
		final User agustin = getAgustin();
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(RoutineTests.getStrongliftsBarbellRowSet());
		final Optional<Workout> workout = agustin.getNextWorkout();
		assertTrue(workout.isPresent() && workout.get().equals(stronglifts.getWorkouts().get(0)));
	}

	@Test
	public void getNextWorkoutWithActivityInTwoRoutineWorkouts() {
		final User agustin = getAgustin();
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(RoutineTests.getStrongliftsSquatsSet());
		final Optional<Workout> workout = agustin.getNextWorkout();
		assertTrue(workout.equals(Optional.empty()));
	}

	@Test
	public void getNextWorkoutWithTwoActivitiesInRoutineWorkouts() {
		final User agustin = getAgustin();
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(RoutineTests.getStrongliftsSquatsSet());
		agustin.log(RoutineTests.getStrongliftsBarbellRowSet());
		final Optional<Workout> workout = agustin.getNextWorkout();
		assertTrue(workout.isPresent() && workout.get().equals(stronglifts.getWorkouts().get(0)));
	}

	@Test
	public void getNextWorkoutWithTwoActivitiesInRoutineWorkoutsAndAnUnrelatedOne() {
		final User agustin = getAgustin();
		final Routine stronglifts = RoutineTests.getStronglifts();
		agustin.assign(stronglifts);
		agustin.log(RoutineTests.getStrongliftsSquatsSet());
		agustin.log(getGroupActivity());
		agustin.log(RoutineTests.getStrongliftsBarbellRowSet());
		final Optional<Workout> workout = agustin.getNextWorkout();
		assertTrue(workout.isPresent() && workout.get().equals(stronglifts.getWorkouts().get(0)));
	}
}
