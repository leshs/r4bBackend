package com.mittelstufenprojekt.api.dao;

import com.mittelstufenprojekt.api.domain.Tarif;

import java.time.LocalDate;
import java.util.List;

public interface ContractDAO {
    void addTarif(Tarif tarif);

    void updateTarif(Tarif tarif, Long id);

    void deleteTarif(Long id);

    void addContract(Long customerID, Long tarifID, LocalDate startDate);

    void cancelContract(Long contractID);

    void renewContract(Long contractID);

    List<Tarif> getAllTarifs();
}
