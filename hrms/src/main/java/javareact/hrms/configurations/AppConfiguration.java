package javareact.hrms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javareact.hrms.core.utilities.imageService.CloudinaryImageManager;
import javareact.hrms.core.utilities.imageService.ImageService;

@Configuration
public class AppConfiguration {

	@Bean
	public Cloudinary cloudinary() {

		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dlyhxsow4", 
				"api_key", "652668777819144", 
				"api_secret","RxBAeQudTMqp9S0u4-S6xRWmv0Q"));
	}

	@Bean
	public ImageService imageService() {
		return new CloudinaryImageManager(cloudinary());
	}
}
