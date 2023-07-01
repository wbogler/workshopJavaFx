package model.service;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartamentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll(){

		return dao.findAll();
	}
	
	public void saveOrUpdate(Department dept) {
		if(dept.getId()==null) {
			dao.insert(dept);
		}else {
			dao.update(dept);
		}
	}

}
