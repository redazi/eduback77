package ma.emsi.edu.restContoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.edu.model.Salle;
import ma.emsi.edu.service.SalleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("salle")
public class SalleController {
	
	@Autowired
	SalleService salleService;

	@PostMapping
	public void ajouter(@RequestBody Salle salle) {
		salleService.ajouter(salle);
	}

	@GetMapping
	public List<Salle> liste() {
		return salleService.liste();
	}

	@GetMapping("/{id}")
	public Salle getById(@PathVariable Long id) {
		return salleService.getSalle(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		salleService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Salle salle ) {
		salleService.modifier(salle,id);
    }

}
