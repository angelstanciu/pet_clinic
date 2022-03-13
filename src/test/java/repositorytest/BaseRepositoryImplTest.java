package repositorytest;

import models.Pet;
import org.junit.jupiter.api.Test;
import repository.PetRepository;
import repository.PetRepositoryImpl;

public class BaseRepositoryImplTest {
    private final PetRepository petRepository = new PetRepositoryImpl();
    @Test
    public void saveTest() {
        //given
        Pet pet = new Pet("Ciobananescc", "10-10-2020", true, "Stanciu");

        //when
        petRepository.save(pet);

        //then
        long result = petRepository.findAll().stream().filter(p -> p.getBreed().equalsIgnoreCase(pet.getBreed())).count();
        System.out.println(result);
        if (result == 1) {
            assert true;
        } else {
            assert false;
        }
    }

    @Test
    public void deleteTest(){
        //given
        Pet pet = new Pet("Ciobananesc", "10-10-2020", true, "Stanciu");

        //when
        petRepository.delete(pet);

        //then
        long result = petRepository.findAll().stream().filter(p -> p.getBreed().equalsIgnoreCase(pet.getBreed())).count();
        System.out.println(result);
        if (result == 0) {
            assert true;
        } else {
            assert false;
        }
    }

}
