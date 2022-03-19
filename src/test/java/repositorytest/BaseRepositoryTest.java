package repositorytest;

import models.Consult;
import models.Pet;
import models.Veterinarian;
import org.junit.jupiter.api.Test;
import repository.BaseRepositoryImpl;

import java.util.List;

public class BaseRepositoryTest {
    private final PetRepositoryImplTest petRepository = new PetRepositoryImplTest();
    private final ConsultRepositoryImplTest consultRepository = new ConsultRepositoryImplTest();
    private final VeterinarianRepositoryImplTest veterinarianRepository = new VeterinarianRepositoryImplTest();

    @Test
    public void saveTest() {
        //given
        Pet pet = new Pet("C", "1", true, "S");

        //when
        petRepository.save(pet);

        //then
        if(petRepository.findAll().size() == 1 && petRepository.findAll().contains(pet)) {
            assert true;
        } else {
            assert false;
        }
    }

    @Test
    public void deleteTest() {
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

    @Test
    public void updateTest() {
        //given
        Veterinarian veterinarian = new Veterinarian("Ion", "Gheorghita", "Campului 21", "chirurg");
        veterinarianRepository.save(veterinarian);
        int id = veterinarian.getId();

        //when
        veterinarian.setFirstName("I");
        veterinarian.setAddress("4");
        veterinarianRepository.update(veterinarian);

        //then
        Veterinarian veterinarianById = veterinarianRepository.findById(id).get();
        if (veterinarianById.getAddress().equalsIgnoreCase("4")
                && veterinarianById.getFirstName().equalsIgnoreCase("I")) {
            assert true;
        } else {
            assert false;
        }
    }

    @Test
    public void findAllTest() {
        //given
        Consult consult1 = new Consult("10-10-2020", "sterlizare");
        Consult consult2 = new Consult("10-10-2022", "deparazitare");
        consultRepository.save(consult1);
        consultRepository.save(consult2);

        //when
        long result = consultRepository.findAll().size();
        List<Consult> consults = consultRepository.findAll();

        //then
        if (result == 2 && consults.contains(consult1) && consults.contains(consult2)) {
            assert true;
        } else {
            assert false;
        }
    }
}
