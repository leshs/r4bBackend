package com.mittelstufenprojekt.api.controller;
import com.mittelstufenprojekt.api.DTO.TarifDTO;
import com.mittelstufenprojekt.api.domain.Tarif;
import com.mittelstufenprojekt.api.service.ContractService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contract")
public class ContractController {
    @Autowired
    ContractService contractService;


    @Operation(summary = "add Tarif",
            description = "add a new tarif template",
            tags = "tarif-controller")
    @PostMapping("/tarif/add")
    public void addTarif(@RequestBody TarifDTO tarifDTO) {
        contractService.addTarif(tarifDTO.parseDTO());
    }


    @Operation(summary = "get all tarifs",
            description = "get all tarif templates",
            tags = "tarif-controller")
    @GetMapping("/tarifs")
    public List<TarifDTO> getAllTarifs() {
        List<Tarif> allTarifs = contractService.getAllTarifs();
        List<TarifDTO> tarifDTOS = new ArrayList<>();
        for (Tarif tarif : allTarifs) {
            tarifDTOS.add(new TarifDTO(tarif));
        }
        return tarifDTOS;
    }
}
