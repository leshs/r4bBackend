package com.mittelstufenprojekt.api.service;

import com.mittelstufenprojekt.api.domain.Tarif;

import java.util.List;

public interface ContractService {
    void addTarif(Tarif tarif);
    List<Tarif> getAllTarifs();
}
