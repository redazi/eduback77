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

import ma.emsi.edu.model.FormMatiere;
import ma.emsi.edu.service.FormMatiereService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("formmatiere")
public class FormMatiereController {
	
	@Autowired
	FormMatiereService formMatiereService;

	@PostMapping
	public void ajouter(@RequestBody FormMatiere formMatiere) {
		formMatiereService.ajouter(formMatiere);
	}

	@GetMapping
	public List<FormMatiere> liste() {
		return formMatiereService.liste();
	}

	@GetMapping("/{id}")
	public FormMatiere getById(@PathVariable Long id) {
		return formMatiereService.getFormMatiere(id);
	}
	
	@GetMapping("/find/{idf}/{idm}")
	public FormMatiere getByFM(@PathVariable Long idf , @PathVariable Long idm) {
		return formMatiereService.getfm(idf, idm);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		formMatiereService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody FormMatiere formMatiere ) {
		formMatiereService.modifier(formMatiere,id);
    }

}
