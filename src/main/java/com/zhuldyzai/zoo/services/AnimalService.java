package com.zhuldyzai.zoo.services;

import com.zhuldyzai.zoo.entity.Animal;
import com.zhuldyzai.zoo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }
    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
    }
    public Animal updateAnimal(long id, Animal newAnimal) {
        return animalRepository.findById(id).map(animal -> {
            animal.setName(newAnimal.getName());
            animal.setAge(newAnimal.getAge());
            animal.setType(newAnimal.getType());
            return animalRepository.save(animal);
        }).orElseThrow(() -> new RuntimeException("Animal not found"));
    }
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

}
