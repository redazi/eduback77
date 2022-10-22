package ma.emsi.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Creneau;
import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.model.Salle;
import ma.emsi.edu.repository.AbsenceRepository;
import ma.emsi.edu.repository.CreneauRepository;

@Service
@Transactional
public class CreneauServiceImpl implements CreneauService {
	
	@Autowired
	ReservationService reservationService ;
	private CreneauRepository creneauRepository;
	public CreneauServiceImpl(CreneauRepository creneauRepository) {
        this.creneauRepository = creneauRepository;
    }
	@Override
	public void ajouter(Creneau creneau) {
		// TODO Auto-generated method stub
		creneauRepository.save(creneau);
	}

	@Override
	public void modifier(Creneau creneau,Long id) {
		// TODO Auto-generated method stub
		Creneau creneau2 = creneauRepository.getById(id);
		if(creneau2!=null) {
			creneau2.setHeureDebut(creneau.getHeureDebut());
			creneau2.setHeureFin(creneau.getHeureFin());
			creneauRepository.save(creneau2);
		}
		
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		creneauRepository.deleteById(id);
		
	}

	@Override
	public Creneau getCreneau(Long id) {
		// TODO Auto-generated method stub
		return creneauRepository.findById(id).get();
	}

	@Override
	public List<Creneau> liste() {
		// TODO Auto-generated method stub
		return creneauRepository.findAll();
	}
	
	@Override
	public List<Creneau> findDispo(Salle salle , Date d) {
	//	OccupationService os = new OccupationService();
		 List<Creneau>  dispos = new ArrayList<Creneau>();

		
		
		 for(Creneau c : creneauRepository.findAll()) {
			 int check=0;
			// System.out.println(c);
			 for(Reservation o : reservationService.listeBySalleAndDate(salle,d)) {
				 System.out.println("from creneau service " + o);
				  check = 0 ;
				  System.out.println("from creneau service " + c.getHeureDebut());
				  System.out.println("from creneau service " + o.getCreneau().getHeureDebut());
				// System.out.println(o);
				 if(     (c.getHeureDebut().compareTo(o.getCreneau().getHeureDebut())<=0 && c.getHeureFin().compareTo(o.getCreneau().getHeureDebut())>0 )|| 
						 (c.getHeureDebut().compareTo(o.getCreneau().getHeureDebut())<=0 && c.getHeureFin().compareTo(o.getCreneau().getHeureFin())>=0 ) ||
						 (c.getHeureDebut().compareTo(o.getCreneau().getHeureFin())<0 && c.getHeureFin().compareTo(o.getCreneau().getHeureFin())>=0 )||
						 (c.getHeureDebut().compareTo(o.getCreneau().getHeureDebut())>=0 && c.getHeureFin().compareTo(o.getCreneau().getHeureFin())<=0 )) {
					 System.out.println("skip");
					 check = 1;
					 break ;
				 }
				 
			 } 
			 
			 if(check==0) {
				 dispos.add(c);
			 }
		 }
	        
	        return dispos;
	}
	

}
