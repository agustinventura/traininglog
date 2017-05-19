package com.digitalsingular.traininglog.user;

import java.util.List;

import com.digitalsingular.traininglog.workout.Routine;
import com.google.common.collect.Lists;

public class User {

	private final Long id;

	private final String username;

	private final List<Routine> routines;

	public User(Long id, String username, List<Routine> routines) {
		super();
		this.id = id;
		this.username = username;
		this.routines = routines;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public List<Routine> getRoutines() {
		final List<Routine> clone = Lists.newArrayListWithCapacity(routines.size());
		// for (Routine routine: routines) {
		// clone.add(routine.clone());
		// }
		return clone;
	}

}
