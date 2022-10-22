package ma.emsi.edu.service;

import java.text.Format;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.http.Objres;
import ma.emsi.edu.model.Plannification;
import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.model.Salle;
import ma.emsi.edu.model.SalleReservation;
import ma.emsi.edu.repository.PlannificationRepository;
import ma.emsi.edu.repository.ReservationRepository;
import ma.emsi.edu.repository.SalleReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PlannificationRepository plannificationRepository;
	
	
	@Override
	public Objres ajouter(Reservation reservation)  {
		Date dep = reservation.getDate();
		Date i = reservation.getDate() ;
		Date j = reservation.getDate() ;
		
		 while(j.before(reservation.getDatefin()) || j.equals(reservation.getDatefin())){
			 Format f2 = new SimpleDateFormat("EEEE");
			 String str1 = f2.format(j);
		      System.out.println("Full Day Name = " + str1 );
		      String str21 = f2.format(dep);
		      System.out.println("Full Day Name = " +str21);
			
			if(str1.equals(str21)) {
	        	for(Reservation r : reservationRepository.findBySalleAndDate(reservation.getSalle() , j )) {
					if(  (reservation.getCreneau().getHeureDebut().compareTo(r.getCreneau().getHeureDebut())<=0 && reservation.getCreneau().getHeureFin().compareTo(r.getCreneau().getHeureDebut())>0 )|| 
						 (reservation.getCreneau().getHeureDebut().compareTo(r.getCreneau().getHeureDebut())<=0 && reservation.getCreneau().getHeureFin().compareTo(r.getCreneau().getHeureFin())>=0 ) ||
						 (reservation.getCreneau().getHeureDebut().compareTo(r.getCreneau().getHeureFin())<0 && reservation.getCreneau().getHeureFin().compareTo(r.getCreneau().getHeureFin())>=0 )||
						 (reservation.getCreneau().getHeureDebut().compareTo(r.getCreneau().getHeureDebut())>=0 && reservation.getCreneau().getHeureFin().compareTo(r.getCreneau().getHeureFin())<=0 ) ){
						
						 System.out.println("my reservation cren" + reservation.getCreneau());
						System.out.println("db reservation cren" + r.getCreneau());
						System.out.println(j);
						System.out.println(r.getDate());
						System.out.println(reservation.getSalle());
						System.out.println(r.getSalle());
						System.out.println("error heeeeeere");
							
						Objres o = new Objres();
						 o.res=false;
						 o.c= reservation.getCreneau();
						 o.s = reservation.getSalle();
						 Calendar c3 = Calendar.getInstance();
				        	c3.setTime(j);
					        c3.add(Calendar.DATE, 1);
					        j = c3.getTime();
						 o.d=j ;
						return o ;
						 }
					}
			}
	        	Calendar c2 = Calendar.getInstance();
	        	c2.setTime(j);
		        c2.add(Calendar.DATE, 1);
		        j = c2.getTime();
	        }
		 Plannification plannification;
		if(reservation.getPlannification()==null) {
			plannification =  new Plannification() ;
			if(reservation.getDate().equals(reservation.getDatefin())) {
				plannification.setType("unique");
			}else {
				plannification.setType("serie");
			}
			plannificationRepository.save(plannification);
			reservation.setPlannification(plannification);
		}
		 
		
		
		reservationRepository.save(reservation);
		
		Format f = new SimpleDateFormat("EEEE");
		Calendar c = Calendar.getInstance();
        c.setTime(i);
        c.add(Calendar.DATE, 1);
        i = c.getTime();
		Date fin = null ;
       
        
		while(i.before(reservation.getDatefin()) || i.equals(reservation.getDatefin())){
			
			 // Calendar cal = Calendar.getInstance();
		     // SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy");
		     // System.out.println("Today's date = "+simpleformat.format(cal.getTime()));
			
		      String str = f.format(i);
		      System.out.println("Full Day Name = " + str );
		      String str2 = f.format(dep);
		      System.out.println("Full Day Name = " +str2);
			
			if(str.equals(str2)) {
				
				
				
				Reservation reserv = new Reservation();
				reserv.setDate(i);
				reserv.setCreneau(reservation.getCreneau());
				reserv.setDesription(reservation.getDesription());
				reserv.setUtilisateur(reservation.getUtilisateur());
				reserv.setSalle(reservation.getSalle());
				reserv.setFormateur(reservation.getFormateur());
				reserv.setEtat(reserv.isEtat());
				reserv.setMatiere(reservation.getMatiere());
				reserv.setDatefin(reservation.getDatefin());
				reserv.setPlannification(reservation.getPlannification());
				//salleReservation.setDate(i);
				reservationRepository.save(reserv);
				 fin = i ;
			}
			
			
	        c.setTime(i);
	        c.add(Calendar.DATE, 1);
	        i = c.getTime();
	       System.out.println(i);
	     
	     //  return true ;
		}
		List<Reservation> reservations = reservationRepository.findByPlannification(reservation.getPlannification().getId());
		//Date d = reserv.getDatefin() ;
		for(Reservation r : reservations) {
			r.setDatefin(fin);
			reservationRepository.save(r);
			
		}
		Objres o = new Objres() ;
		o.res = true ;
		return o;
		
				
	}

	@Override
	public void modifier(Reservation reservation, Long id) {
		// TODO Auto-generated method stub
		Reservation reserv = reservationRepository.getById(id);
		if(reserv!=null) {
			
			//reserv.setDate(re.getDate());
			reserv.setCreneau(reservation.getCreneau());
			reserv.setDesription(reservation.getDesription());
			reserv.setUtilisateur(reservation.getUtilisateur());
			reserv.setSalle(reservation.getSalle());
			reserv.setFormateur(reservation.getFormateur());
			reserv.setEtat(reserv.isEtat());
			reserv.setMatiere(reservation.getMatiere());
			//reserv.setDatefin(reservation.getDatefin());
		    reservationRepository.save(reserv);
		}
		System.out.println("update heeeeere");
		/*if(reservation.getDatefin().after(reserv.getDatefin())) {
			System.out.println("eafter truue");
			List<Reservation> reservations = reservationRepository.findByPlannification(reservation.getPlannification().getId());
			Date d = reserv.getDatefin() ;
			for(Reservation r : reservations) {
				r.setDatefin(reservation.getDatefin());
				reservationRepository.save(r);
			}
			Calendar cc = Calendar.getInstance();
			 cc.setTime(d);
		     cc.add(Calendar.DATE, 7);
		     d = cc.getTime();
			reservation.setId(0);
			System.out.println("from updatee extends : "+ reservation);
			reservation.setDate(d);
			ajouter(reservation);
		}
		*/
	}
	public void extend(Reservation reservation) {
		Reservation reserv = reservationRepository.findById(reservation.getId()).get();
		Date dtae = reservation.getDatefin() ;
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String stringDate1= simpleDateFormat.format(reservation.getDatefin());
		
		String stringDate2= simpleDateFormat.format(reserv.getDatefin());
		
		System.out.println("exteeeeeend");
		System.out.println(reservation.getDatefin());
		if (!stringDate1.equals(stringDate2)) {
		if(reservation.getDatefin().after(reserv.getDatefin())) {
			System.out.println("eafter truue");
			
			Date d = reserv.getDatefin() ;
			
			Calendar cc = Calendar.getInstance();
			 cc.setTime(d);
		     cc.add(Calendar.DATE, 7);
		     d = cc.getTime();
			reservation.setId(0);
			System.out.println("from updatee extends : "+ stringDate1);
			System.out.println("from updatee extends : "+ reserv.getDatefin());


			
			reservation.setDate(d);
			if(ajouter(reservation).res==true) {
				List<Reservation> reservations = reservationRepository.findByPlannification(reservation.getPlannification().getId());
				//Date d = reserv.getDatefin() ;
				for(Reservation r : reservations) {
					r.setDatefin(dtae);
					reservationRepository.save(r);
				}
			}
			
		}
	
		}
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
	
		Reservation reserv = reservationRepository.getById(id);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String stringDate1= simpleDateFormat.format(reserv.getDatefin());
		System.out.println("from delete");
		String stringDate2= simpleDateFormat.format(reserv.getDate());
		if(stringDate1.equals(stringDate2)) {
			Calendar cc = Calendar.getInstance();
			 cc.setTime(reserv.getDatefin());
		     cc.add(Calendar.DATE, -7 );
		     Date d = cc.getTime();
		     System.out.println("from delete  : "+ stringDate1);
			System.out.println("from delete extends : "+ stringDate2);
			
			
			
			
		     
		     
		}
		reservationRepository.deleteById(id);
		
		
		Date d;
		
		
		
		List<Reservation> reservations = reservationRepository.findByPlannification(reserv.getPlannification().getId());
		for(Reservation r : reservations) {
			r.setDatefin(r.getDate());
			reservationRepository.save(r);
		}
		
		d = reservations.get(0).getDatefin() ;
		//Date d = reserv.getDatefin() ;
		for(Reservation r : reservations) {
			if(d.before(r.getDatefin())) {
				d = r.getDatefin();
			}
		}
		
		for(Reservation r : reservations) {
			r.setDatefin(d);
			reservationRepository.save(r);
		}
		//System.out.println("delete id " + id);
		
	}

	@Override
	public Reservation getReservation(Long id) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(id).get();
	}

	@Override
	public List<Reservation> liste() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public List<Reservation> listeBySalleAndDate(Salle s, Date d) {
		System.out.println(s);
		System.out.println(d);
		//String pattern = "yyyy-MM-dd";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		//String date = simpleDateFormat.format(d);
		System.out.println(reservationRepository.findBySalleAndDate(s, d));
		return reservationRepository.findBySalleAndDate(s, d);
	}

	@Override
	public void supprimerList(Long id) {
		
		reservationRepository.deleteList(id);
		
	}

}
