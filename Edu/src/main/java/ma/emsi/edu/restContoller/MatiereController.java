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

import ma.emsi.edu.model.Matiere;
import ma.emsi.edu.service.MatiereService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("matiere")
public class MatiereController {
	@Autowired
	MatiereService matiereService;

	@PostMapping
	public void ajouter(@RequestBody Matiere matiere) {
		matiereService.ajouter(matiere);
	}

	@GetMapping
	public List<Matiere> liste() {
		return matiereService.liste();
	}
	
	@GetMapping("/nform/{id}")
	public List<Matiere> Dispoliste(@PathVariable Long id) {
		return matiereService.getDispoMatiere(id);
	}
	
	@GetMapping("/form/{id}")
	public List<Matiere> getMforF(@PathVariable Long id) {
		return matiereService.getMforF(id);
	}

	@GetMapping("/{id}")
	public Matiere getById(@PathVariable Long id) {
		return matiereService.getMatiere(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		matiereService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Matiere matiere ) {
		matiereService.modifier(matiere,id);
    }
}
