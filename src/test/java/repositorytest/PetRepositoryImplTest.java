package repositorytest;

import models.Pet;
import repository.BaseRepository;
import repository.BaseRepositoryImpl;

public class PetRepositoryImplTest extends BaseRepositoryImplTest<Pet, Integer> implements BaseRepository<Pet, Integer> {
    public PetRepositoryImplTest() {
        super(Pet.class);
    }
}
