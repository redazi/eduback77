package ma.emsi.edu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Formateur;
import ma.emsi.edu.repository.FormateurRepository;

@Service
@Transactional
public class FormateurServiceImpl implements FormateurService {
 private FormateurRepository formateurRepository;
 public FormateurServiceImpl(FormateurRepository formateurRepository) {
	 this.formateurRepository=formateurRepository;
 }
	@Override
	public void ajouter(Formateur formateur) {
		// TODO Auto-generated method stub
		formateurRepository.save(formateur);
	}
	
	@Override
	public void modifier(Formateur formateur,Long id) {
		// TODO Auto-generated method stub
		Formateur formateur1 =formateurRepository.getById(id);
        if (formateur1 != null){
        	formateur1.setAge(formateur.getAge());
        	formateur1.setCin(formateur.getCin());
        	formateur1.setEmail(formateur.getEmail());
        	formateur1.setNom(formateur.getNom());
        	formateur1.setDernierPaiement(formateur.getDernierPaiement());
        	formateur1.setSalaire(formateur.getSalaire());
        	formateur1.setPassword(formateur.getPassword());
        	formateur1.setPrenom(formateur.getPassword());
        	formateur1.setRoles(formateur.getRoles());
        	formateur1.setUserName(formateur.getUserName());
        	
        	
        	
        	formateurRepository.save(formateur1);
        }
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		formateurRepository.deleteById(id);
	}

	@Override
	public Formateur getFormateur(Long id) {
		// TODO Auto-generated method stub
		return formateurRepository.findById(id).get();
	}

	@Override
	public List<Formateur> liste() {
		// TODO Auto-generated method stub
		return formateurRepository.findAll();
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
