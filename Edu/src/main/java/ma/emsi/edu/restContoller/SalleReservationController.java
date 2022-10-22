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

import ma.emsi.edu.model.SalleReservation;
import ma.emsi.edu.service.SalleReservationService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("sallereservation")
public class SalleReservationController {

	
	@Autowired
	SalleReservationService salleReservationService;

	@PostMapping
	public void ajouter(@RequestBody SalleReservation salleReservation) {
		salleReservationService.ajouter(salleReservation);
	}

	@GetMapping
	public List<SalleReservation> liste() {
		return salleReservationService.liste();
	}

	@GetMapping("/{id}")
	public SalleReservation getById(@PathVariable Long id) {
		return salleReservationService.getSalleReservation(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		salleReservationService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody SalleReservation salleReservation ) {
		salleReservationService.modifier(salleReservation,id);
    }
}
