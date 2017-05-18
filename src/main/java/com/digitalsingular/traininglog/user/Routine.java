package com.digitalsingular.traininglog.user;

import java.util.List;

import com.digitalsingular.traininglog.workout.Workout;

import lombok.Data;

@Data
public class Routine {

	private long id;

	private List<Workout> workouts;
}
