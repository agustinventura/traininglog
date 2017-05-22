package com.digitalsingular.traininglog;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.Test;

import com.digitalsingular.traininglog.exercise.Exercise;
import com.digitalsingular.traininglog.user.TrainingDay;
import com.digitalsingular.traininglog.user.User;
import com.digitalsingular.traininglog.workout.Activity;
import com.digitalsingular.traininglog.workout.CardioActivity;
import com.digitalsingular.traininglog.workout.Length;
import com.digitalsingular.traininglog.workout.Level;
import com.digitalsingular.traininglog.workout.Level.Hardness;

public class UserTest {

	@Test
	public void logActivity() {
		User user = new User("Agustín");
		Activity cardio = new CardioActivity("short run", Exercise.RUN, Length.of(Duration.ofMinutes(10L)), Level.of(Hardness.LIGHT));
		TrainingDay trainingDay = user.log(cardio).get();
		assertTrue(trainingDay.getActivities().contains(cardio));
		assertTrue(trainingDay.getDate().isEqual(LocalDate.now()));
	}
	
	@Test
	public void logNullActivity() {
		User user = new User("Agustín");
		assertFalse(user.log(null).isPresent());
	}
}
