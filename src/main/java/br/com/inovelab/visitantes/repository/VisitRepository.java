package br.com.inovelab.visitantes.repository;

import br.com.inovelab.visitantes.services.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findByRepresentativeName (String representative);
}
