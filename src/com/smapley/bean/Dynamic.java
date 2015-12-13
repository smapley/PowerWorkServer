package com.smapley.bean;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Dynamic entity. @author MyEclipse Persistence Tools
 */
public class Dynamic extends AbstractDynamic implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Dynamic() {
	}

	/** full constructor */
	public Dynamic(Project project, User user, Task task, File file,
			Timestamp creDate, Integer type, String picUrl, Set praises,
			Set discusses) {
		super(project, user, task, file, creDate, type, picUrl, praises,
				discusses);
	}

}
