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


import ma.emsi.edu.model.Revue;
import ma.emsi.edu.service.RevueService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("revue")
public class RevueController {

	
	@Autowired
	RevueService revueService;

	@PostMapping
	public void ajouter(@RequestBody Revue revue) {
		revueService.ajouter(revue);
	}

	@GetMapping
	public List<Revue> liste() {
		return revueService.liste();
	}
	
	@GetMapping("/matiere/{id}")
	public List<Revue> liste(@PathVariable Long id) {
		return revueService.getListByMatiere(id);
	}
	


	@GetMapping("/{id}")
	public Revue getById(@PathVariable Long id) {
		return revueService.getRevue(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		revueService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Revue revue ) {
		revueService.modifier(revue,id);
    }
}
