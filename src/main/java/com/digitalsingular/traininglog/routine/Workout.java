package com.digitalsingular.traininglog.routine;

import com.digitalsingular.traininglog.workout.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Workout {

    private final List<Activity> activities;

    public Workout(Activity... activities) {
        this.activities = Arrays.asList(activities);
    }

    public List<Activity> getActivities() {
        List<Activity> activitiesClone = new ArrayList<>(activities.size());
        for (Activity activity: activities) {
            activitiesClone.add(activity);
        }
        return activitiesClone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return Objects.equals(activities, workout.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activities);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "activities=" + activities +
                '}';
    }
}
