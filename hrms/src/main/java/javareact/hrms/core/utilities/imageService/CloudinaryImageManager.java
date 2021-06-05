package javareact.hrms.core.utilities.imageService;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.ErrorDataResult;
import javareact.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryImageManager implements ImageService{
	private Cloudinary cloudinary;

	@Autowired 
	public CloudinaryImageManager(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		
		try {
			//Burada type güvenliği vardır
			@SuppressWarnings("unchecked")
			Map<String,String> uploadResult =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			
			return new SuccessDataResult<Map>(uploadResult);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return new ErrorDataResult<Map>("Cannot added.");
    }
	

	

}
