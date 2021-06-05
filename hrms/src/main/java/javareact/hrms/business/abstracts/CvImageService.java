package javareact.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvImage;

public interface CvImageService {
	Result add(CvImage cvImage,MultipartFile imageFile);
	DataResult<List<CvImage>> getAll();
	DataResult<List<CvImage>> getAllByCandidateId(int candidateId);
}
