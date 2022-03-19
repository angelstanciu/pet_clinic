package repositorytest;

import models.Consult;
import repository.BaseRepository;
import repository.BaseRepositoryImpl;

public class ConsultRepositoryImplTest extends BaseRepositoryImplTest<Consult,Integer> implements BaseRepository<Consult, Integer> {
    public ConsultRepositoryImplTest() {
        super(Consult.class);
    }
}
