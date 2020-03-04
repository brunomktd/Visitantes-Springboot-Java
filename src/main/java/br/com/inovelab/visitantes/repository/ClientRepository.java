package br.com.inovelab.visitantes.repository;

import br.com.inovelab.visitantes.services.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByName(String name);
}
