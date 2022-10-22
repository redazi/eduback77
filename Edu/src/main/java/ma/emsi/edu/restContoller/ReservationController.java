package ma.emsi.edu.restContoller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.edu.http.Objres;
import ma.emsi.edu.model.Plannification;
import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.model.Salle;
import ma.emsi.edu.repository.ReservationRepository;
import ma.emsi.edu.service.ReservationService;
import ma.emsi.edu.service.SalleService;

class Obj {
	public Salle s ; 
	public Date d ;
}


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("reservation")
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	ReservationRepository reservationRepository; 

	@Autowired
	SalleService salleService ;

	@PostMapping
	public ResponseEntity ajouter(@RequestBody  Reservation reservation) {
		Objres o = reservationService.ajouter(reservation);
		if ( o.res == false ) {
			return new ResponseEntity<>( o , HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		return new ResponseEntity<>( null , HttpStatus.OK);
	}

	@GetMapping
	public List<Reservation> liste() {
		return reservationService.liste();
	}
	
	@PostMapping("/bySalleAndDate")
	public List<Reservation> listeBySalleAndDate(@RequestBody Obj obj) {
		Salle salle = salleService.getSalle(obj.s.getId());
		return reservationService.listeBySalleAndDate(salle, obj.d);
	}

	@GetMapping("/{id}")
	public Reservation getById(@PathVariable Long id) {
		return reservationService.getReservation(id);
	}
	
	@GetMapping("/list/{id}")
	public List<Reservation> getByPlannif(@PathVariable Long id) {
		return reservationRepository.findByPlannification(id);
	}
	

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		reservationService.supprimer(id);

	}
	
	@GetMapping("/deleteList/{id}")
	public void supprimerList(@PathVariable Long id) {
		reservationService.supprimerList(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Reservation reservation ) {
		reservationService.modifier(reservation,id);
    }
	
	@PostMapping("/extend")
    public void extend(@RequestBody Reservation reservation ) {
		reservationService.extend(reservation);
    }
		
}

