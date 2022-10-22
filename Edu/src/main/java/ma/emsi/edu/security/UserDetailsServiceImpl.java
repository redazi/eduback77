package ma.emsi.edu.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Role;
import ma.emsi.edu.model.Utilisateur;
import ma.emsi.edu.repository.UtilisateurRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("test1");
		Utilisateur utilisateur = utilisateurRepository.findByUserName(username);
		System.out.println("test2");
		if (utilisateur == null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("Nom d'utilisateur ou mot de passe erroné");
		}
		System.out.println(utilisateur);
		for (Role r : utilisateur.getRoles())
			System.out.println("Role:" + r.getNom());
		

		return UserDetailsImpl.build(utilisateur);
	}

}
