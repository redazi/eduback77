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

import ma.emsi.edu.model.Paiment;
import ma.emsi.edu.service.PaiementService;

@RestController
@RequestMapping("paiementService")
public class PaiementServiceController {
	
	@Autowired
	PaiementService paiementService;

	@PostMapping
	public void ajouter(@RequestBody Paiment Paiment) {
		paiementService.ajouter(Paiment);
	}

	@GetMapping
	public List<Paiment> liste() {
		return paiementService.liste();
	}

	@GetMapping("/{id}")
	public Paiment getById(@PathVariable Long id) {
		return paiementService.getPaiment(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		paiementService.supprimer(id);
	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Paiment paiment ) {
		paiementService.modifier(paiment,id);
    }
	

}
