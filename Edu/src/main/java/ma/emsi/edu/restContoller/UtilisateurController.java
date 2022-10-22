package ma.emsi.edu.restContoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.edu.model.Utilisateur;
import ma.emsi.edu.repository.UtilisateurRepository;
import ma.emsi.edu.service.UtilisateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("utilisateur")
public class UtilisateurController {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@Autowired
	UtilisateurRepository utilisateurRepository ; 

	@PostMapping
	public void ajouter(@RequestBody Utilisateur utilisateur) {
		utilisateurService.ajouter(utilisateur);
	}

	@GetMapping
	public List<Utilisateur> liste() {
		return utilisateurService.liste();
	}

	@GetMapping("/{id}")
	public Utilisateur getById(@PathVariable Long id) {
		return utilisateurService.getUtilisateur(id);
	}
	
	@GetMapping("/find/{username}")
	public Utilisateur getBure(@PathVariable String username) {
		return utilisateurRepository.findByUserName(username);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		utilisateurService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Utilisateur utilisateur ) {
		utilisateurService.modifier(utilisateur,id);
    }

}
