package br.com.inovelab.visitantes.repository;

import br.com.inovelab.visitantes.services.Representative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentativeRepository extends JpaRepository<Representative, Long> {
    Representative findByName(String name);
}
