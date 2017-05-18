package com.digitalsingular.traininglog.user;

import java.util.List;

import lombok.Data;

@Data
public class User {

	private Long id;

	private String username;

	private List<Routine> routines;
}
