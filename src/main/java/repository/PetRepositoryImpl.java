package repository;

import models.Pet;

public class PetRepositoryImpl extends BaseRepositoryImpl<Pet, Integer> implements PetRepository {
    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
