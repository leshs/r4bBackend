package com.mittelstufenprojekt.api.dao;

import com.mittelstufenprojekt.api.domain.Tarif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ContractDAOImpl implements ContractDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public void addTarif(Tarif tarif) {
        entityManager.persist(tarif);
    }

    @Override
    public void updateTarif(Tarif tarif, Long id) {
        //TODO
    }

    @Override
    public void deleteTarif(Long id) {
        //TODO
    }

    @Override
    public void addContract(Long customerID, Long tarifID, LocalDate startDate) {
        //TODO
    }

    @Override
    public void cancelContract(Long contractID) {
        //TODO
    }

    //Renew the subscription of a contract
    @Override
    public void renewContract(Long contractID) {
        //TODO

    }

    @Override
    public List<Tarif> getAllTarifs() {
        TypedQuery<Tarif> selectCustomerQuery = entityManager.createQuery("select a FROM Tarif a", Tarif.class);
        return selectCustomerQuery.getResultList();
    }
}
