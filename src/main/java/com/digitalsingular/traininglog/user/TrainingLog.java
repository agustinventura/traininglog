package com.digitalsingular.traininglog.user;

import java.util.ArrayList;
import java.util.List;

public class TrainingLog {

    private final List<TrainingDay> trainingDays;

    public TrainingLog() {
        this.trainingDays = new ArrayList<>();
    }

    public void add(TrainingDay trainingDay) {
        if (trainingDay != null) {
            this.trainingDays.add(trainingDay);
        }
    }

    public List<TrainingDay> getTrainingDays() {
        return trainingDays;
    }
}
