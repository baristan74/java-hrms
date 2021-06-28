package javareact.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv_educations")
public class CvEducation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
    @NotNull
    @NotBlank
    private String schoolName;
	
	@Column(name = "department_name")
    @NotNull
    @NotBlank
    private String departmentName;
	
	@Column(name = "start_date")
	@Past
	@NotNull
    private LocalDate startDate;
	
	
	@Column(name = "finish_date")
    private LocalDate finishDate;
	
	@ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
