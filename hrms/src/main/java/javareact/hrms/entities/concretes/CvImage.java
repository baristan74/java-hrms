package javareact.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv_images")
public class CvImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "url")
	@NotNull
	@NotBlank
	private String url;

	@Column(name = "uploaded_at",columnDefinition = "DATE DEFAULT CURRENT_DATE")
	@JsonIgnore
	private LocalDate uploadedAt=LocalDate.now();

	@OneToOne(optional=false,fetch=FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
