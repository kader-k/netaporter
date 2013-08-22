package com.whiteleys.zoo.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.whiteleys.zoo.dao.AnimalDao;
import com.whiteleys.zoo.domain.Animal;
import com.whiteleys.zoo.service.AnimalService;


public class AnimalServiceImpl implements AnimalService {

    private AnimalDao animalDao;
    
    @Override
    public List<Animal> getAllAnimals() {
        return animalDao.findAll();
    }

    @Override
    public Animal getAnimal(Long animalId) {
    	return this.animalDao.getAnimal(animalId);
    }

    @Autowired
    public void setAnimalDao(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

}
