package javareact.hrms.entities.dtos;

import java.util.List;

import javareact.hrms.entities.concretes.Candidate;
import javareact.hrms.entities.concretes.CvCoverLetter;
import javareact.hrms.entities.concretes.CvEducation;
import javareact.hrms.entities.concretes.CvImage;
import javareact.hrms.entities.concretes.CvJobExperience;
import javareact.hrms.entities.concretes.CvLanguage;
import javareact.hrms.entities.concretes.CvLink;
import javareact.hrms.entities.concretes.CvSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvDto {
	public Candidate candidate;
	public List<CvCoverLetter> coverletters;
	public List<CvEducation> educations;
	public CvImage image;
	public List<CvJobExperience> jobExperiences;
	public List<CvLanguage> languages;
	public List<CvLink> links;
	public List<CvSkill> skills;
	
}
