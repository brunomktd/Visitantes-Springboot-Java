package br.com.inovelab.visitantes.services.dto;

import br.com.inovelab.visitantes.services.Visit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VisitDto {
    private Long id;
    private Long idRepresentative;
    private String nameRepresentative;
    private String clientName;
    private String address;
    private LocalDateTime dateVisit;
    private double cost;

    public VisitDto(Visit visit){
        this.id = visit.getId();
        this.idRepresentative = visit.getRepresentative().getId();
        this.nameRepresentative = visit.getRepresentative().getName();
        this.clientName = visit.getClient().getName();
        this.address = visit.getClient().getAddress();
        this.dateVisit = visit.getVisit();
        this.cost = visit.getCost();
    }

    public static List<VisitDto> execute(List<Visit> visits) {
        return visits.stream().map(VisitDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public Long getIdRepresentative() {
        return idRepresentative;
    }

    public String getNameRepresentative() {
        return nameRepresentative;
    }

    public String getClientName() {
        return clientName;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getDateVisit() {
        return dateVisit;
    }

    public double getCost() {
        return cost;
    }
}
