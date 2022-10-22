package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Client;

public interface ClientService {
	void ajouter(Client client);

	void modifier(Client client,Long id);
	
	void supprimer(Long id);

	Client getClient(Long id);
	byte[] decompressBytes(byte[] data);

	byte[] compressBytes(byte[] data);
	List<Client> liste();
}
