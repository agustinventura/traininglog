package com.digitalsingular.traininglog.traininglog;

import java.time.LocalDate;
import java.util.Set;

import com.digitalsingular.traininglog.activity.Activity;

import lombok.Data;

@Data
public class TrainingDay {

	private LocalDate date;

	private Set<Activity> activities;
}
