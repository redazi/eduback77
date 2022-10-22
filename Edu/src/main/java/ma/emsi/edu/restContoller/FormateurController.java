package ma.emsi.edu.restContoller;

import java.util.ArrayList;
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

import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Formateur;
import ma.emsi.edu.service.FormateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/formateur")
public class FormateurController {
	@Autowired
	FormateurService formateurService;
	@PostMapping
	public void ajouter(@RequestBody Formateur formateur) {
		System.out.println("ana dkhaallt");
		if(formateur.getPicByte()==null)
		System.out.println("heeereeeeee22");
	
			System.out.println("Original Image Byte Size - " + formateur.getPicByte());
			
			formateur.setPicByte(formateurService.compressBytes(formateur.getPicByte()));
			formateurService.ajouter(formateur);
	
	}

	@GetMapping
	public List<Formateur> liste() {
		List<Formateur> formateurs = new ArrayList(); 
		System.out.println("reeeeeeeeeeeeeeeeeeeedaaaaaaaaaaa");
		Formateur formateur1;
		for(Formateur formateur : formateurService.liste()){
			System.out.println("reeeeeeeeeeeeeeeeeeeedaaaaaaaaaaa555");

			/*final Optional<Client> retrievedImage = imageRepository.findByName(img.getName());
			img1 = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
					decompressBytes(retrievedImage.get().getPicByte()));
			imgs.add(img1);*/
			
			
			try {
				System.out.println("amm heeereee : "+formateur.getPicByte().length);
				formateur1 = new Formateur(formateur.getId(),formateur.getUserName(),formateur.getPassword(),formateur.getNom(),formateur.getPrenom(),formateur.getAge(),formateur.getEmail(),formateur.getCin(),formateurService.decompressBytes(formateur.getPicByte()),formateur.getSalaire(),formateur.getDernierPaiement());
				formateurs.add(formateur1);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("null values exist !!!");
			}
			
		}
		
		return formateurs;
	}

	@GetMapping("/{id}")
	public Formateur getById(@PathVariable Long id) {
		return formateurService.getFormateur(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		formateurService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Formateur formateur ) {
		formateurService.modifier(formateur,id);
    }

}
