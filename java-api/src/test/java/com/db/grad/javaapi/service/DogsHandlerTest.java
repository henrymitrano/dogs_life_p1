package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();
    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void get_dog_from_name(){
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Willie");
        cut.addDog(dog1);

        Dog result = cut.getDogByName("Willie");
        assertEquals(dog1, result);
    }

    @Test
    public void get_dog_from_id(){
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Willie");
        cut.addDog(dog1);

        dog1.setId(001);
        long expected = 001;
        Dog resultDog = cut.getDogById(dog1.getId());
        assertEquals(expected, resultDog.getId());

    }

    @Test
    public void verify_update_on_dog_details(){
        itsDogRepo.deleteAll();
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Willie");
        cut.addDog(dog1);

        long actual = cut.updateDogDetails(dog1);
        long expected = 001;
        assertEquals(actual, expected);

    }

    @Test
    public void verify_delete_on_repo(){
        itsDogRepo.deleteAll();
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Willie");
        cut.addDog(dog1);

        boolean result = cut.removeDog(dog1.getId());
        boolean expected = true;

        assertEquals(result, expected);
    }

}
