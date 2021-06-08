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
public class CloudinaryImageManager implements ImageService {

	private Cloudinary cloudinary;

	public CloudinaryImageManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dlyhxsow4",
				"api_key", "652668777819144",
				"api_secret","RxBAeQudTMqp9S0u4-S6xRWmv0Q"
				));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {

		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}

}
