package com.digitalsingular.traininglog.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.digitalsingular.traininglog.routine.Routine;

public class User {

	private final String username;

	private final List<Routine> routines;

	private final TrainingLog trainingLog;

	public User(String username) {
		super();
		this.username = username;
		this.routines = new ArrayList<>();
		this.trainingLog = new TrainingLog();
	}

	public User(String username, List<Routine> routines) {
		super();
		this.username = username;
		this.routines = routines;
		this.trainingLog = new TrainingLog();
	}

	public String getUsername() {
		return username;
	}

	public List<Routine> getRoutines() {
		final List<Routine> clone = new ArrayList<>(routines.size());
		for (Routine routine: routines) {
		 clone.add(routine);
		}
		return clone;
	}

	public void add(Routine routine) {
		if (routine != null) {
			this.routines.add(routine);
		}
	}

	public void remove(Routine routine) {
		this.routines.remove(routine);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(username, user.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", routines=" + routines +
				", trainingLog=" + trainingLog +
				'}';
	}
}
