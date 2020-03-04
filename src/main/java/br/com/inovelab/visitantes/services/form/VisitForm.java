package br.com.inovelab.visitantes.services.form;


import br.com.inovelab.visitantes.repository.ClientRepository;
import br.com.inovelab.visitantes.repository.RepresentativeRepository;
import br.com.inovelab.visitantes.services.Client;
import br.com.inovelab.visitantes.services.Representative;
import br.com.inovelab.visitantes.services.Visit;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class VisitForm {
    @Positive
    private Long idRepresentative;
    private String nameRepresentative;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String address;
    @NotNull @PastOrPresent
    private LocalDateTime visit;
    @NotNull @Digits(integer = 10,fraction = 2)
    private Double cost;

    public Visit execute(RepresentativeRepository representativeRepository, ClientRepository clientRepository) {

        Representative representative = representativeRepository.findByName(getNameRepresentative());
        Client client = clientRepository.findByName(getName());

        return new Visit(representative, client, visit, cost);
    }

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
