package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Matiere;
import ma.emsi.edu.model.Paiment;
import ma.emsi.edu.model.PaimentFormateur;
import ma.emsi.edu.repository.MatiereRepository;
import ma.emsi.edu.repository.PaiementFormateurRepository;
@Service
@Transactional
public class PaiementFormateurServiceImpl implements PaiementFormateurService {
private PaiementFormateurRepository paiementFormateurRepository;
public PaiementFormateurServiceImpl(PaiementFormateurRepository paiementFormateurRepository) {
	this.paiementFormateurRepository=paiementFormateurRepository;
}
@Override
public void ajouter(PaimentFormateur paimentFormateur) {
	// TODO Auto-generated method stub
	
paiementFormateurRepository.save(paimentFormateur);
	
}
@Override
public void modifier(PaimentFormateur paimentFormateur,Long id) {
	// TODO Auto-generated method stub
	PaimentFormateur paimentFormateur2 = paiementFormateurRepository.getById(id);
	if(paimentFormateur2!=null) {
		paimentFormateur2.setFormateur(paimentFormateur.getFormateur());
		paimentFormateur2.setDateSalaire(paimentFormateur.getDateSalaire());
		
		
		
		paiementFormateurRepository.save(paimentFormateur2);
	}
	
}
@Override
public void supprimer(Long id) {
	// TODO Auto-generated method stub
	paiementFormateurRepository.deleteById(id);
	
}
@Override
public PaimentFormateur getPaimentFormateur(Long id) {
	// TODO Auto-generated method stub
	return paiementFormateurRepository.findById(id).get();
}
@Override
public List<PaimentFormateur> liste() {
	// TODO Auto-generated method stub
	return paiementFormateurRepository.findAll();
}
	

}
