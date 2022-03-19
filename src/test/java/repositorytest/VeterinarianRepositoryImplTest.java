package repositorytest;

import models.Veterinarian;
import repository.BaseRepository;

public class VeterinarianRepositoryImplTest extends BaseRepositoryImplTest<Veterinarian,Integer> implements BaseRepository<Veterinarian, Integer> {
    public VeterinarianRepositoryImplTest() {
        super(Veterinarian.class);
    }
}
