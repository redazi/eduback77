package ma.emsi.edu.restContoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ma.emsi.edu.model.Client;
import ma.emsi.edu.service.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")
public class ClientContoller {
	@Autowired
	ClientService clientService;
	@PostMapping
	public void ajouter(@RequestBody Client client)  throws IOException {
		System.out.println("ana dkhaallt");
		if(client.getPicByte()==null)
		System.out.println("heeereeeeee22");
		System.out.println("Original Image Byte Size - " + client.getPicByte());
		
		client.setPicByte(clientService.compressBytes(client.getPicByte()));
		clientService.ajouter(client);
	}

	@GetMapping
	public List<Client> liste() {
		List<Client> clients = new ArrayList(); 
		System.out.println("reeeeeeeeeeeeeeeeeeeedaaaaaaaaaaa");
		Client client1;
		for(Client client : clientService.liste()){
			System.out.println(client.getPicByte());

			/*final Optional<Client> retrievedImage = imageRepository.findByName(img.getName());
			img1 = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
					decompressBytes(retrievedImage.get().getPicByte()));
			imgs.add(img1);*/
			try {
				System.out.println("amm heeereee : "+client.getPicByte().length);
				client1 = new Client(client.getId(),client.getUserName(),client.getPassword(),client.getNom(),client.getPrenom(),client.getAge(),client.getEmail(),client.getCin(),clientService.decompressBytes(client.getPicByte()),client.isActive());
			clients.add(client1);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("null values exist !!!");
			}
			
		}
		
		return clients;
	
	}
	@GetMapping("/count")
	public int countClient() {
		return clientService.liste().size();
	}
	@GetMapping("/{id}")
	public Client getById(@PathVariable Long id) {
		return clientService.getClient(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		clientService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Client client ) {
		clientService.modifier(client,id);
    }

	
}
