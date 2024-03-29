package ec.jorgetorres.shrimpfarmweb.rest;

import ec.jorgetorres.shrimpfarmweb.domain.Pond;
import ec.jorgetorres.shrimpfarmweb.service.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PondController {

  private PondService pondService;

  @Autowired
  public PondController(PondService pondService) {
    super();
    this.pondService = pondService;
  }

  @GetMapping("/pond/{id}")
  ResponseEntity<?> getPond(@PathVariable Long id) {
    Optional<Pond> pond = pondService.findById(id);
    return pond.map(response -> ResponseEntity.ok().body(response))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/pond")
  public ResponseEntity<Pond> createPond(@Valid @RequestBody Pond pond) throws URISyntaxException {
    Pond result = pondService.save(pond);
    return ResponseEntity.created(new URI("/api/pond/" + result.getId()))
        .body(result);
  }

  @PutMapping("/pond")
  ResponseEntity<Pond> updatePond(@Valid @RequestBody Pond pond) {
    Pond result = pondService.save(pond);
    return ResponseEntity.ok().body(result);
  }

  @DeleteMapping("/pond/")
  public ResponseEntity<?> deletePond(@Valid @RequestBody Pond pond) {
    pondService.deletePond(pond);
    return ResponseEntity.ok().build();
  }
}
