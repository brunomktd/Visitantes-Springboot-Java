package br.com.inovelab.visitantes.services;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Visit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Representative representative;
    @ManyToOne
    private Client client;
    private LocalDateTime visit;
    private double cost;

    public Visit(){

    }

    public Visit(Representative dataRepresentative, Client dataClient, LocalDateTime date, double costVisit) {
        setRepresentative(dataRepresentative);
        setClient(dataClient);
        setVisit(date);
        setCost(costVisit);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Representative getRepresentative() {
        return representative;
    }

    public void setRepresentative(Representative representative) {
        this.representative = representative;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
