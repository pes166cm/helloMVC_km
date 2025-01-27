package com.mybatis.model.servlce;

import org.apache.ibatis.session.SqlSession;
import static com.mybatis.common.SqlSessionTemplate.getSession;
import com.mybatis.model.dao.StudentDao;

public class InsertStudentService {
	
	private StudentDao dao = new StudentDao();
	
	public int insertStudent() {
		SqlSession session = getSession();
		int result = dao.insertStudent(session);
		
		//트렌젝션처리
		if(result>0) session.commit();
		else session.rollback();
		
		session.close();
		
		return result;
	}

	public int insertStudentByName(String name) {
		SqlSession session = getSession();
		int result = dao.insertStudentByName(session,name);
		
		if(result>0) session.commit();
		else session.rollback();
		
		session.close();
		
		return result;
	}
	
	
	
}
