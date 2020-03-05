package br.com.inovelab.visitantes.services.dto;

import br.com.inovelab.visitantes.services.Client;

public class ClientDto {
    private String name;
    private String address;

    public ClientDto(Client client){
        this.name = client.getName();
        this.address = client.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
