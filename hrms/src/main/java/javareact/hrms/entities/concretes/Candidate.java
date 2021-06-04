package javareact.hrms.entities.concretes;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
@Entity
@Table(name="candidates")
public class Candidate extends User{
	
	@NotNull
    @NotBlank
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
    @NotBlank
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
    @NotBlank
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotNull
    @NotBlank
	@Column(name="birthdate")
	private String birthDate;
	

	
}
