package br.com.inovelab.visitantes.services.dto;

import br.com.inovelab.visitantes.services.Visit;

import java.time.LocalDateTime;

public class DetailVisitDto {
    private Long id;
    private String nameRepresentative;
    private String nameClient;
    private String address;
    private LocalDateTime date;
    private Double cost;

    public DetailVisitDto(Visit visit){
        this.id = visit.getId();
        this.nameRepresentative = visit.getRepresentative().getName();
        this.nameClient = visit.getClient().getName();
        this.address = visit.getClient().getAddress();
        this.date = visit.getVisit();
        this.cost = visit.getCost();
    }

    public Long getId() {
        return id;
    }

    public String getNameRepresentative() {
        return nameRepresentative;
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getCost() {
        return cost;
    }
}
