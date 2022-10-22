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

import ma.emsi.edu.model.Panier;
import ma.emsi.edu.service.PanierService;

@RestController
@RequestMapping("panier")
public class PanierController {

	@Autowired
	PanierService panierService;

	@PostMapping
	public void ajouter(@RequestBody Panier panier) {
		panierService.ajouter(panier);
	}

	@GetMapping
	public List<Panier> liste() {
		return panierService.liste();
	}

	@GetMapping("/{id}")
	public Panier getById(@PathVariable Long id) {
		return panierService.getPanier(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		panierService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Panier panier ) {
		panierService.modifier(panier,id);
    }
}
