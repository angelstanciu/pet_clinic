package repository;

import models.Veterinarian;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian, Integer> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }
}
