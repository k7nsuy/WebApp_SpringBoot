package com.example.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Team1;

@Component
public class TeamService {

	@Autowired
	EntityManagerFactory emf;

	// 반복문이 실행되는 동안 컴퓨터가 불통이 되는 현상을 피하는 것을 방지하기 위해 commit을 반복문이 다 끝나면 commmit
	// 이 되도록 하는 공간. => 데이터가 중간까지만 저장되는 불상사를 막을 수 있다.
	public void insertBatch(long[] id,String[] name) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			//반복문 (3회)
			for(int i=0; i<id.length; i++) {
				Team1 vo = new Team1();
				vo.setId(id[i]);
				vo.setName(name[i]);
				em.persist(vo);
				//teamRepository.save(vo);
			}

			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void insertBatch1(long[] id,String[] name) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			String sql = "INSERT INTO TEAMTBL3(TEAMID,TEAMNAME,TEAMDATE) "
					+ " VALUES(:id, :name, CURRENT_DATE)";
			//반복문 (3회)
			for(int i=0; i<id.length; i++) {
				em.createNativeQuery(sql)
				.setParameter("id", id[i])
				.setParameter("name", name[i]).executeUpdate();
				
				//teamRepository.save(vo);
			}

			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void updateBatch1(long[] id,String[] name) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			// :name (jpa) => #{name} (MyBatis)
			String sql = "UPDATE TEAMTBL3 SET TEAMNAME=:name WHERE TEAM=:id";
			//반복문 (3회)
			for(int i=0; i<id.length; i++) {
				em.createQuery(sql)
				.setParameter("id", id[i])
				.setParameter("name", name[i]).executeUpdate();
				
				//teamRepository.save(vo);
			}

			em.getTransaction().commit();
		}
		catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
}
