package javareact.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_adverts")
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private Double minSalary;
	
	@Column(name="max_salary")
	private Double maxSalary;
	
	
	@Min(value=1)
	@Column(name="open_position_count")
	private int openPositionCount;
	
	
	@Column(name="application_deadline")
	@Future
	private LocalDate applicationDeadline;
	
	
	@Column(name="published_date",columnDefinition = "DATE DEFAULT CURRENT_DATE")
	@JsonIgnore
	private LocalDate publishedDate=LocalDate.now();
	
	@Column(name="is_activated",columnDefinition = "boolean default true")
	private Boolean isActivated=true;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "working_type_id")
	private WorkingType workingType;
	
	@ManyToOne()
	@JoinColumn(name = "employment_type_id")
	private EmploymentType employmentType;
	
	@Column(name="is_confirmed_by_employee",columnDefinition="boolean default false")
	private Boolean isConfirmedByEmployee=false;
	
	@OneToMany(mappedBy ="jobAdvert",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CandidateJobAdvertFavorite> candidateJobAdvertFavorites;
	
	
}
