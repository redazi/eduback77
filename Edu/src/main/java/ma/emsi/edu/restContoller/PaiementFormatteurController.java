package ma.emsi.edu.restContoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.edu.model.PaimentFormateur;
import ma.emsi.edu.service.PaiementFormateurService;

@RestController
@RequestMapping("paiementFormation")
public class PaiementFormatteurController {
	@Autowired
	PaiementFormateurService paiementFormateurService;

	@PostMapping
	public void ajouter(@RequestBody PaimentFormateur PaimentFormateur) {
		paiementFormateurService.ajouter(PaimentFormateur);
	}

	@GetMapping
	public List<PaimentFormateur> liste() {
		return paiementFormateurService.liste();
	}

	@GetMapping("/{id}")
	public PaimentFormateur getById(@PathVariable Long id) {
		return paiementFormateurService.getPaimentFormateur(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		paiementFormateurService.supprimer(id);
	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody PaimentFormateur PaimentFormateur ) {
		paiementFormateurService.modifier(PaimentFormateur,id);
    }
	
}
