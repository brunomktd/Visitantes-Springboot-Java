package br.com.inovelab.visitantes.services.form;

import br.com.inovelab.visitantes.repository.VisitRepository;
import br.com.inovelab.visitantes.services.Visit;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class UpdateVisitForm {
    @Positive
    private Long idRepresentative;
    private String nameRepresentative;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String address;
    @NotNull @PastOrPresent
    private LocalDateTime visit;
    @NotNull @Digits(integer = 10,fraction = 2)
    private Double cost;

    public Long getIdRepresentative() {
        return idRepresentative;
    }

    public void setIdRepresentative(Long idRepresentative) {
        this.idRepresentative = idRepresentative;
    }

    public String getNameRepresentative() {
        return nameRepresentative;
    }

    public void setNameRepresentative(String nameRepresentative) {
        this.nameRepresentative = nameRepresentative;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getVisit() {
        return visit;
    }

    public void setVisit(LocalDateTime visit) {
        this.visit = visit;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Visit atualizar(Long id, VisitRepository visitRepository) {
        Visit visit = visitRepository.getOne(id);
        visit.getRepresentative().setId(this.idRepresentative);
        visit.getRepresentative().setName(this.nameRepresentative);
        visit.getClient().setName(this.name);
        visit.getClient().setAddress(this.address);
        visit.setVisit(this.visit);
        visit.setCost(this.cost);

        return visit;
    }
}
