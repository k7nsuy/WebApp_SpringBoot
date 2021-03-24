package com.example.repository;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User1;

@Repository
public interface UserRepository extends JpaRepository<User1, Long> {

	User1 findByUserid(String userid);
	
	@Transactional  //import javax.transaction.Transactional;
	int deleteByUserid(String userid);
	
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query(value="DELETE FROM MEMBERTBL3 WHERE MEMID = :id", nativeQuery=true)
//	int sqlDeleteById(@Param("id") String id);
		
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query(value="UPDATE USERTBL1 SET USERNAME = :#{#obj.username} WHRER USERID = :#{#obj.userid}", nativeQuery=true)
//	int sqlUpdateByUserid(@Param("userid") User1 userid);
//	
}
