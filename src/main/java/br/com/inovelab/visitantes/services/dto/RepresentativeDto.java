package br.com.inovelab.visitantes.services.dto;

import br.com.inovelab.visitantes.services.Representative;

public class RepresentativeDto {
    private Long id;
    private String name;

    public RepresentativeDto(Representative representative){
        this.id = representative.getId();
        this.name= representative.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
