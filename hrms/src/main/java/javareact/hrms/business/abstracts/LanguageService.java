package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.Language;

public interface LanguageService {
	Result add(Language language);
	DataResult<List<Language>> getAll();
}
