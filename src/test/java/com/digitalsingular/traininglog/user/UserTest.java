package com.digitalsingular.traininglog.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.digitalsingular.traininglog.activity.Activity;
import com.digitalsingular.traininglog.activity.CardioActivity;
import com.digitalsingular.traininglog.activity.Length;
import com.digitalsingular.traininglog.activity.Level;
import com.digitalsingular.traininglog.activity.Level.Hardness;
import com.digitalsingular.traininglog.exercise.Exercise;
import com.digitalsingular.traininglog.routine.Routine;
import com.digitalsingular.traininglog.routine.RoutineTests;

public class UserTest {

	@Test
	public void logActivity() {
		final User user = getAgustin();
		final Activity cardio = new CardioActivity("short run", Exercise.RUN, Length.of(Duration.ofMinutes(10L)),
				Level.of(Hardness.LIGHT));
		final TrainingDay trainingDay = user.log(cardio).get();
		assertTrue(trainingDay.getActivities().contains(cardio));
		assertTrue(trainingDay.getDate().isEqual(LocalDate.now()));
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
	public void assignRoutineToUser() {
		final User agustin = getAgustin();
		final Routine stronglifts = RoutineTests.getStronglifts();
		final List<Routine> routines = agustin.assign(stronglifts);
		assertTrue(routines.contains(stronglifts));
	}
}
