package com.mittelstufenprojekt.api.service;

import com.mittelstufenprojekt.api.dao.ContractDAO;
import com.mittelstufenprojekt.api.domain.Tarif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractDAO contractDAO;

    @Override
    public void addTarif(Tarif tarif) {
        contractDAO.addTarif(tarif);
    }

    @Override
    public List<Tarif> getAllTarifs() {
        return contractDAO.getAllTarifs();
    }
}
