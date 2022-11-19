package ma.emsi.edu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Client;
import ma.emsi.edu.repository.ClientRepository;
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	 private ClientRepository clientRepository;
	 
	 public ClientServiceImpl(ClientRepository clientRepository) {
	        this.clientRepository = clientRepository;
	    }
	@Override
	public void ajouter(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	@Override
	public void modifier(Client client,Long id) {
		// TODO Auto-generated method stub
		Client client1 = clientRepository.getById(id);
        if (client1 != null){
        	client1.setAge(client.getAge());
        	client1.setCin(client.getCin());
        	client1.setEmail(client.getEmail());
        	client1.setNom(client.getNom());
        	client1.setActive(client.isActive());
        	client1.setPassword(client.getPassword());
        	client1.setPrenom(client.getPrenom());
        	client1.setRoles(client.getRoles());
        	client1.setUserName(client.getUserName());
        	client1.setPicByte(client.getPicByte());
        	
        	
        	
        	clientRepository.save(client1);
        }
		
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}

	@Override
	public Client getClient(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> liste() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}
	@Override
	public byte[] decompressBytes(byte[] data) {
		// TODO Auto-generated method stub
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	@Override
	public byte[] compressBytes(byte[] data) {
		// TODO Auto-generated method stub
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

}
