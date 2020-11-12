package services;

import tables.Spec;

import javax.persistence.EntityManager;
import java.util.List;

public class SpecService {
    private EntityManager em;

    public SpecService(EntityManager em) {
        this.em = em;
    }

    public List<Spec> findAll() {
        return em.createNamedQuery("Spec.findAll", Spec.class).getResultList();
    }
}
