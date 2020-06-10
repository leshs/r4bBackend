package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Tarif;

public class TarifDTO {

    @JsonProperty
    private Long id;
    @JsonProperty
    private int duration;
    @JsonProperty
    private String name;
    @JsonProperty
    private int cancellationPeriod;
    @JsonProperty
    private int lessonPerWeek;
    @JsonProperty
    private int lessonLength;
    @JsonProperty
    private Float price;
    @JsonProperty
    private SubjectDTO subjectDTO;

    public TarifDTO() {
    }

    public TarifDTO(Tarif tarif) {
        this.cancellationPeriod = tarif.getCancellationPeriod();
        this.duration = tarif.getDuration();
        this.id=tarif.getId();
        this.lessonLength = tarif.getLessonLength();
        this.lessonPerWeek = tarif.getLessonPerWeek();
        this.price = tarif.getPrice();
        this.subjectDTO = new SubjectDTO(tarif.getSubject());
    }

    public Tarif parseDTO() {
        Tarif tarif = new Tarif();
        tarif.setCancellationPeriod(cancellationPeriod);
        tarif.setDuration(duration);
        tarif.setId(id);
        tarif.setLessonLength(lessonLength);
        tarif.setLessonPerWeek(lessonPerWeek);
        tarif.setName(name);
        tarif.setPrice(price);
        tarif.setSubject(subjectDTO.parseDTO());
        return tarif;
    }
}
