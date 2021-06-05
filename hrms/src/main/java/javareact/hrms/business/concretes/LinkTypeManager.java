package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.LinkTypeService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.LinkTypeDao;
import javareact.hrms.entities.concretes.LinkType;

@Service
public class LinkTypeManager implements LinkTypeService{

	private LinkTypeDao linkTypeDao;
	
	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao) {
		super();
		this.linkTypeDao = linkTypeDao;
	}

	@Override
	public Result add(LinkType linkType) {
		this.linkTypeDao.save(linkType);
		return new SuccessResult("Link Type Added.");
	}

	@Override
	public DataResult<List<LinkType>> getAll() {
		
		return new SuccessDataResult<List<LinkType>>(this.linkTypeDao.findAll());
	}

}
