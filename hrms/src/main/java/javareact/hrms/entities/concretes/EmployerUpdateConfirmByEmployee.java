package javareact.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employer_update_confirm_by_employees")
public class EmployerUpdateConfirmByEmployee {
	
	@Id
    @Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@NotBlank
	@Column(name="web_adress")
	private String webAdress;
	
	@NotBlank
	@NotNull
	@Email
	@Column(name="email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	@JsonIgnore
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "is_confirm_by_employee", columnDefinition = "boolean default false")
	private boolean isConfirmByEmployee = false;
	
	@Column(name="is_activated", columnDefinition = "boolean default true")
	private boolean isActivated=true;
}
