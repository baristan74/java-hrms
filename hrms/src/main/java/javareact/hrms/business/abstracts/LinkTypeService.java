package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.LinkType;

public interface LinkTypeService {
	Result add(LinkType linkType);
	DataResult<List<LinkType>> getAll();
}
