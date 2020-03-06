package br.com.inovelab.visitantes.entrypoints;

import br.com.inovelab.visitantes.repository.ClientRepository;
import br.com.inovelab.visitantes.repository.RepresentativeRepository;
import br.com.inovelab.visitantes.repository.VisitRepository;
import br.com.inovelab.visitantes.services.Visit;
import br.com.inovelab.visitantes.services.dto.DetailVisitDto;
import br.com.inovelab.visitantes.services.dto.VisitDto;
import br.com.inovelab.visitantes.services.form.UpdateVisitForm;
import br.com.inovelab.visitantes.services.form.VisitForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


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

    };

    @PostMapping
    public ResponseEntity<VisitDto> store(@RequestBody @Valid VisitForm newVisit, UriComponentsBuilder uriBuilder){

        Visit visit = newVisit.execute(representativeRepository, clientRepository);
        visitRepository.save(visit);

        URI uri = uriBuilder.path("visits/{id}").buildAndExpand(visit.getId()).toUri();
        return ResponseEntity.created(uri).body(new VisitDto(visit));
    };

    @GetMapping("/{id}")
    public DetailVisitDto show(@PathVariable Long id ){
        Visit visit = visitRepository.getOne(id);
        return new DetailVisitDto(visit);
    };

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VisitDto> update(@PathVariable Long id, @RequestBody @Valid UpdateVisitForm updateVisit){
        Visit visit = updateVisit.atualizar(id, visitRepository);

        return ResponseEntity.ok(new VisitDto(visit));
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        visitRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
