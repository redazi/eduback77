package ma.emsi.edu.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id ;
	
	@CreatedDate
	@Column(name = "creationDate" , nullable = false)
	@JsonIgnore
	private Instant creationDate ;
	
	@LastModifiedDate
	@Column(name = "lastModifiedDate")
	@JsonIgnore
	private Instant lastModifiedDate ;

}
