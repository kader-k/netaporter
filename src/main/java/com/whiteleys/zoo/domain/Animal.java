package com.whiteleys.zoo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

@Entity
public class Animal implements Serializable {

    private Long id;
    private String name;
    private String iconFilename;

    // Default Constructor
    public Animal(){

    }

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", unique = false, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "icon_filename", unique = false, nullable = false)
    public String getFilename() {
        return iconFilename;
    }

    public void setFilename(String iconFilename) {
        this.iconFilename = iconFilename;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) {
			return false; 
		}
		
		Animal other = (Animal) obj;
		if (id == null && other.id != null) {
				return false;
		} 
		
		return id.equals(other.id);
	}
}
