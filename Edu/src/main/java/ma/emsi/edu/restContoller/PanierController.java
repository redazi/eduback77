package ma.emsi.edu.restContoller;

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

import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Panier;
import ma.emsi.edu.repository.ClientRepository;
import ma.emsi.edu.repository.UtilisateurRepository;
import ma.emsi.edu.service.PanierService;
import ma.emsi.edu.service.UtilisateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("panier")
public class PanierController {

	@Autowired
	PanierService panierService;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	ClientRepository clientRepository;

	@PostMapping
	public void ajouter(@RequestBody Panier panier) {
		panierService.ajouter(panier);
	}

	@GetMapping
	public List<Panier> liste() {
		return panierService.liste();
	}
	@GetMapping("/getplanification")
	public List<Panier> getPlanificationByClient() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
String username = userDetails.getUsername();
System.out.println("ffefefeff :"+username);
		System.out.println("loooool");
		return panierService.getPlanificationByClient(utilisateurRepository.findByUserName(username).getId());
	}
	@GetMapping("/getuser")
	public Client client() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
String username = userDetails.getUsername();
System.out.println("heeoooooooo");
System.out.println("ffefefeff :"+username);
Client c =  clientRepository.findByUserName(username);
System.out.println("l9iiinaaaah " +c.getId());
		return c;
	}
	@GetMapping("/{id}")
	public Panier getById(@PathVariable Long id) {
		return panierService.getPanier(id);
	}
	@GetMapping("checkIfDejaExist/{id}")
	public List<Panier> checkIfDejaExist(@PathVariable Long id) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
String username = userDetails.getUsername();
System.out.println("heloooo 158");
for (Panier p : panierService.checkIfDejaExist(utilisateurRepository.findByUserName(username).getId(),id)) {
	System.out.println(p.getClient().getUserName());
}
		return panierService.checkIfDejaExist(utilisateurRepository.findByUserName(username).getId(),id);
	}
	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		panierService.supprimer(id);

	}
	@GetMapping("/getplanifbyres/{id}")
	public Long GetPlanificationByRes(@PathVariable Long id) {
		return panierService.GetPlanificationByRes(id);

	}
	;
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Panier panier ) {
		panierService.modifier(panier,id);
    }
}
