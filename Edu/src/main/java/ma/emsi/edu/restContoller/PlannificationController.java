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

import ma.emsi.edu.model.Panier;
import ma.emsi.edu.model.Plannification;
import ma.emsi.edu.service.PlannificationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("plannifiaction")
public class PlannificationController {

	@Autowired
	PlannificationService plannificationService ;
	
	@PostMapping
	public void ajouter(@RequestBody Plannification plannification) {
		plannificationService.ajouter(plannification);
	}

	@GetMapping
	public List<Plannification> liste() {
		return plannificationService.liste();
	}

	@GetMapping("/{id}")
	public Plannification getById(@PathVariable Long id) {
		return plannificationService.getPlannification(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		plannificationService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Plannification plannification ) {
		plannificationService.modifier(plannification,id);
    }
}
