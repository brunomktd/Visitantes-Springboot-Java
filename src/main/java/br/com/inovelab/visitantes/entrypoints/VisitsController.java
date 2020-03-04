package br.com.inovelab.visitantes.entrypoints;

import br.com.inovelab.visitantes.repository.ClientRepository;
import br.com.inovelab.visitantes.repository.RepresentativeRepository;
import br.com.inovelab.visitantes.repository.VisitRepository;
import br.com.inovelab.visitantes.services.Client;
import br.com.inovelab.visitantes.services.Representative;
import br.com.inovelab.visitantes.services.Visit;
import br.com.inovelab.visitantes.services.dto.VisitDto;
import br.com.inovelab.visitantes.services.form.VisitForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("/visits")
public class VisitsController {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private RepresentativeRepository representativeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<VisitDto> visit(String representative){
        System.out.println(representative);
        if(representative == null){
            List<Visit> visits = visitRepository.findAll();
            return VisitDto.execute(visits);
        } else {
            List<Visit> visits = visitRepository.findByRepresentativeName(representative);
            return VisitDto.execute(visits);
        }
//        Visit visit = new Visit(
//                new Representative(1,"Bruno"),
//                new Client("Carol", "Estr das nações"),
//                "29/02/2020",
//                103.20
//        );
//        return VisitDto.execute(Arrays.asList(visit, visit, visit));
    };

    @PostMapping
    public ResponseEntity<VisitDto> store(@RequestBody @Valid VisitForm newVisit, UriComponentsBuilder uriBuilder){

        Visit visit = newVisit.execute(representativeRepository, clientRepository);
        visitRepository.save(visit);

        URI uri = uriBuilder.path("visits/{id}").buildAndExpand(visit.getId()).toUri();
        return ResponseEntity.created(uri).body(new VisitDto(visit));
    }

}