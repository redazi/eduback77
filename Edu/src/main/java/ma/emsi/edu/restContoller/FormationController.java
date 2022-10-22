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

import ma.emsi.edu.model.Formation;
import ma.emsi.edu.service.FormationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("formation")
public class FormationController {
	
	@Autowired
	FormationService formationService;

	@PostMapping
	public void ajouter(@RequestBody Formation formation) {
		formationService.ajouter(formation);
	}

	@GetMapping
	public List<Formation> liste() {
		return formationService.liste();
	}

	@GetMapping("/{id}")
	public Formation getById(@PathVariable Long id) {
		return formationService.getFormation(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		formationService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Formation formation ) {
		formationService.modifier(formation,id);
    }

}
