package com.whiteleys.zoo.dao.hibernate;

import com.whiteleys.zoo.dao.AnimalDao;
import com.whiteleys.zoo.domain.Animal;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class HibernateAnimalDao extends HibernateDaoSupport implements AnimalDao {

	@Override
    public List<Animal> findAll() {
        return getHibernateTemplate().loadAll(Animal.class);
    }
	
	@Override
	public Animal getAnimal(Long animalId) {
		List<Animal> animals = getHibernateTemplate().find("FROM Animal WHERE id = ?", new Object[]{animalId});
		
		return animals.size() > 0 ? animals.get(0) : null;
	}
}