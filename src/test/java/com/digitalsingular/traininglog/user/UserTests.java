package com.digitalsingular.traininglog.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.digitalsingular.traininglog.activity.Activity;
import com.digitalsingular.traininglog.activity.ActivityTests;
import com.digitalsingular.traininglog.routine.Routine;
import com.digitalsingular.traininglog.routine.RoutineTests;

public class UserTests {

	@Test
	public void logActivity() {
		final User user = getAgustin();
		final Activity cardio = ActivityTests.getCardioActivity();
		final TrainingDay trainingDay = user.log(cardio).get();
		assertTrue(trainingDay.getActivities().contains(cardio));
		assertTrue(trainingDay.getDate().isEqual(LocalDate.now()));
	}

	public static User getAgustin() {
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
		final Activity cardio = ActivityTests.getCardioActivity();
		final Activity group = ActivityTests.getGroupActivity();
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
}
