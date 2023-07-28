package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;


import java.util.ArrayList;
import java.util.List;

public class DogHandler {

    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogByName(String dogsName )
    {
        Dog dogToFind = new Dog();
        dogToFind.setName(dogsName);
        List<Dog> dogs = itsDogsRepo.findByName(dogToFind);
        Dog result = null;

        if( dogs.size() == 1)
            result = dogs.get(0);

        return result;
    }


    public Dog getDogById(long id) {
        return itsDogsRepo.findById(id);
    }

    public long updateDogDetails(Dog dog) {
        dog.setName("Gerald");
        return dog.getId();
    }

    public boolean removeDog(long id) {
        itsDogsRepo.delete(itsDogsRepo.findById(id));
        if (itsDogsRepo.existsById(id)){
            return false;
        } else {
            return true;
        }

    }
}
