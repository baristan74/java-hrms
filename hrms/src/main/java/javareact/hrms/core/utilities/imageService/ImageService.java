package javareact.hrms.core.utilities.imageService;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import javareact.hrms.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
