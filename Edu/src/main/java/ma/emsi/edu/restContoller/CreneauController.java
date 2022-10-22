package ma.emsi.edu.restContoller;

import java.util.Date;
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

import ma.emsi.edu.model.Creneau;
import ma.emsi.edu.model.Salle;
import ma.emsi.edu.service.CreneauService;
import ma.emsi.edu.service.SalleService;
class Obj2 {
	public Salle s ; 
	public Date d ;
}
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("creneau")
public class CreneauController {
	@Autowired
	CreneauService creneauService;
	@Autowired
	SalleService salleService;

	@PostMapping
	public void ajouter(@RequestBody Creneau creneau) {
		creneauService.ajouter(creneau);
	}
	
	@PostMapping("/dispo")
	public List<Creneau> dsipo(@RequestBody Obj2 obj) {
		Salle salle = salleService.getSalle(obj.s.getId());
		return creneauService.findDispo(salle , obj.d);
	}
	@GetMapping
	public List<Creneau> liste() {
		return creneauService.liste();
	}

	@GetMapping("/{id}")
	public Creneau getById(@PathVariable Long id) {
		return creneauService.getCreneau(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		creneauService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Creneau creneau ) {
		creneauService.modifier(creneau,id);
    }
}
