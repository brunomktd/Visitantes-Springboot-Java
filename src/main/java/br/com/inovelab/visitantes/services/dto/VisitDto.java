package br.com.inovelab.visitantes.services.dto;

import br.com.inovelab.visitantes.services.Visit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VisitDto {
    private Long id;
    private RepresentativeDto representative;
    private ClientDto client;
    private LocalDateTime dateVisit;
    private double cost;

    public VisitDto(Visit visit){
        this.id = visit.getId();
        this.representative = new RepresentativeDto(visit.getRepresentative());
        this.client = new ClientDto(visit.getClient());
        this.dateVisit = visit.getVisit();
        this.cost = visit.getCost();
    }

    public static List<VisitDto> execute(List<Visit> visits) {
        return visits.stream().map(VisitDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public RepresentativeDto getRepresentative() {
        return representative;
    }

    public ClientDto getClient() {
        return client;
    }

    public LocalDateTime getDateVisit() {
        return dateVisit;
    }

    public double getCost() {
        return cost;
    }
}
