package com.whiteleys.zoo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ANIMAL")
public class UserAnimal implements Serializable {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Id
	@Column(name="USER_ID")
	private Long userId;

	
	public UserAnimal() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
