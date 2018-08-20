package com.capgemini.listeners;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PreUpdate;

import com.capgemini.domain.AbstractEntity;

public class UpdateEntityListener {

	@PreUpdate
	protected void onUpdate(AbstractEntity abstractEntity) {
		Date updateDate= new Date();
		abstractEntity.setUpdated(new Timestamp(updateDate.getTime()));
	}
}