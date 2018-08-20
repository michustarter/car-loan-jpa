package com.capgemini.listeners;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PrePersist;

import com.capgemini.domain.AbstractEntity;

public class CreateEntityListener {

	@PrePersist
	protected void onCreate(AbstractEntity abstractEntity) {
		Date creationDate= new Date();
		abstractEntity.setCreated(new Timestamp(creationDate.getTime()));
	}
}