package ma.emsi.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ma.emsi.edu.model.SalleReservation;
import ma.emsi.edu.repository.SalleReservationRepository;

@Service
@Transactional
public class SalleReservationServiceImpl implements SalleReservationService {

	@Autowired
	SalleReservationRepository repository ;
	
	@Override
	public void ajouter(SalleReservation reservation) {
		// TODO Auto-generated method stub
		repository.save(reservation);
	}

	@Override
	public void modifier(SalleReservation reservation,Long id) {
		// TODO Auto-generated method stub
		SalleReservation reservation2 = repository.getById(id);
		if(reservation2!=null) {
			reservation2.setCreneau(reservation.getCreneau());
			reservation2.setDate(reservation.getDate());
			reservation2.setSalle(reservation.getSalle());
			reservation2.setUtilisateur(reservation.getUtilisateur());
			reservation2.setDesription(reservation.getDesription());
			repository.save(reservation2);
		}
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public SalleReservation getSalleReservation(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<SalleReservation> liste() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


}
