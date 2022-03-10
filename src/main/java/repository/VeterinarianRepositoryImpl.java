package repository;

import models.Veterinarian;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.VeterinarianRepository;
import utils.SessionManager;

import java.util.List;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian,Integer> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }
}
