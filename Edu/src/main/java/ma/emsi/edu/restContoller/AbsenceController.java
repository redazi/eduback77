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


import ma.emsi.edu.model.Absence;
import ma.emsi.edu.service.AbsenceService;

@RestController
@RequestMapping("/absence")
public class AbsenceController {

	@Autowired
	AbsenceService absenceService;

	@PostMapping
	public void ajouter(@RequestBody Absence absence) {
		absenceService.ajouter(absence);
	}

	@GetMapping
	public List<Absence> liste() {
		return absenceService.liste();
	}

	@GetMapping("/{id}")
	public Absence getById(@PathVariable Long id) {
		return absenceService.getAbsence(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		absenceService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Absence absence ) {
		absenceService.modifier(absence,id);
    }

}
