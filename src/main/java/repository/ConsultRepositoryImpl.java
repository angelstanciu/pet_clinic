package repository;

import models.Consult;

public class ConsultRepositoryImpl extends BaseRepositoryImpl<Consult,Integer> implements ConsultRepository{
    public ConsultRepositoryImpl() {
        super(Consult.class);
    }
}
