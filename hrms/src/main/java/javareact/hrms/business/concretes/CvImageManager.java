package javareact.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javareact.hrms.business.abstracts.CvImageService;
import javareact.hrms.core.utilities.imageService.ImageService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CvImageDao;
import javareact.hrms.entities.concretes.CvImage;
@Service
public class CvImageManager implements CvImageService{
	
	private CvImageDao cvImageDao;
	private ImageService imageService;
	
	@Autowired
	public CvImageManager(ImageService imageService,CvImageDao cvImageDao) {
		super();
		this.cvImageDao = cvImageDao;
		this.imageService=imageService;
	}

	@Override
	public Result add(CvImage cvImage,MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imageService.uploadImageFile(imageFile).getData();
		cvImage.setUrl(uploadImage.get("url"));
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Image added");
	}

	@Override
	public DataResult<List<CvImage>> getAll() {
		
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll());
	}

	

	@Override
	public DataResult<CvImage> getByCandidateId(int candidateId) {
		
		return new SuccessDataResult<CvImage>(this.cvImageDao.findByCandidate_Id(candidateId));
	}

	

}
