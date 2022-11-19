package ma.emsi.edu.restContoller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.edu.model.AbsenceInfo;
import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.service.AbsenceInfoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/absenceInfo")
public class AsenceInfoController {
	@Autowired
	AbsenceInfoService absenceInfoService;
	@PostMapping
	public void ajouter(@RequestBody AbsenceInfo absenceInfo) {
		absenceInfoService.ajouter(absenceInfo);
	}

	@PutMapping("/status/{id}")
    public void updateabsence(@PathVariable(value = "id", required = false) final Long id, @RequestBody Client client) {
		System.out.println("dkhaalt l update d absence"+id+" --id client: "+client.getId());
		
		System.out.println("status is : "+absenceInfoService.getStatusBuidclient(client.getId(), id));
		try {
			if(absenceInfoService.getStatusBuidclient(client.getId(), id)) {
				absenceInfoService.updateabsence(false,"Absent",client.getId(),id);
			}else {
				absenceInfoService.updateabsence(true,"Present",client.getId(),id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
    }
	@GetMapping
	public List<AbsenceInfo> liste() {
		return absenceInfoService.liste();
	}

	@GetMapping("/listeEtudiant/{id}")
	public List<Client> listeEtudiant(@PathVariable long id) {
		List<Client> clients = new ArrayList(); 
		Client client1;
		for(Client client : absenceInfoService.listeEtudiant( id)){
			System.out.println(client.getPicByte());

			/*final Optional<Client> retrievedImage = imageRepository.findByName(img.getName());
			img1 = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
					decompressBytes(retrievedImage.get().getPicByte()));
			imgs.add(img1);*/
			try {
				System.out.println("amm heeereee : "+client.getPicByte().length);
				client1 = new Client(client.getId(),client.getUserName(),client.getPassword(),client.getNom(),client.getPrenom(),client.getAge(),client.getEmail(),client.getCin(),absenceInfoService.decompressBytes(client.getPicByte()),client.isActive());
			clients.add(client1);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("null values exist !!!");
			}
			
		}
		
		return clients;
	}
	
	@GetMapping("/listeReservation")
	public List<Reservation> listeReservation() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
String username = userDetails.getUsername();
System.out.println("ffefefeff :"+username);
		String nom = "Sebbar";
		return absenceInfoService.listereservation(username);
	}
	@GetMapping("/absenceinfobyreservation/{id}")
	public List<AbsenceInfo> absenceinfobyreservation(@PathVariable long id) {
		List<AbsenceInfo> absenceInfo = new ArrayList(); 
		AbsenceInfo absenceInfo1;
	
		for(AbsenceInfo absenceInfo2 : absenceInfoService.absenceinfobyreservation(id)){
			//System.out.println(client.getPicByte());

			/*final Optional<Client> retrievedImage = imageRepository.findByName(img.getName());
			img1 = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
					decompressBytes(retrievedImage.get().getPicByte()));
			imgs.add(img1);*/
			try {
				//System.out.println("amm heeereee : "+client.getPicByte().length);
				absenceInfo2.getClient().setPicByte(absenceInfoService.decompressBytes(absenceInfo2.getClient().getPicByte()));
				absenceInfo1 = new AbsenceInfo(absenceInfo2.getId(),absenceInfo2.getClient(),absenceInfo2.getReservation(),absenceInfo2.getStatus(),absenceInfo2.isAbsence());
				absenceInfo.add(absenceInfo1);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("null values exist !!!");
			}
			
		}
		
		return absenceInfo;
	}
	@GetMapping("/listeReservationvalide")
	public List<Reservation> listeReservationvalide() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
String username = userDetails.getUsername();
System.out.println("ffefefeff :"+username);
		String nom = "Sebbar";
		System.out.println("hooooooo");
		return absenceInfoService.reservationwithabsencevalide(username);
	}
	@GetMapping("/{id}")
	public AbsenceInfo getById(@PathVariable Long id) {
		
		return absenceInfoService.getAbsenceInfo(id);
	}
	@GetMapping("checkunmarkedabsence/{id}")
	public List<AbsenceInfo> checkunmarkedabsence(@PathVariable Long id) {
		return absenceInfoService.checkUnMarkedAbsence(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		absenceInfoService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody AbsenceInfo absenceInfo ) {
		absenceInfoService.modifier(absenceInfo,id);
    }
	@GetMapping("/updatevalidation/{id}")
    public void updatevalidation(@PathVariable(value = "id", required = false) final Long id ) {
		absenceInfoService.updateabsencevalider(id);
    }
}
