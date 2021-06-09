package javareact.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name="employees")
public class Employee extends User{
	
	
	@NotNull
	@NotBlank
	@Size(min=3,max=30,message="About Me must be between 3 and 30 characters")
	@Column(name="first_name")
	private String firstName;
	
	
	@NotNull
	@NotBlank
	@Size(min=3,max=30,message="About Me must be between 3 and 30 characters")
	@Column(name="last_name")
	private String lastName;

}
