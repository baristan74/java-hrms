package javareact.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "candidates")
public class Candidate extends User {

	@NotNull
	@NotBlank
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@NotBlank
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@NotBlank
	@Column(name = "identity_number")
	private String identityNumber;

	@NotNull
	@NotBlank
	@Column(name = "birthdate")
	private String birthDate;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CvEducation> educations;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CvJobExperience> experiences;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CvLanguage> languages;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CvLink> links;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CvSkill> skills;

	@JsonIgnore
	@OneToOne(mappedBy = "candidate", optional = false, fetch = FetchType.LAZY)
	@JsonManagedReference
	private CvImage images;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CvCoverLetter> coverLetters;

}
