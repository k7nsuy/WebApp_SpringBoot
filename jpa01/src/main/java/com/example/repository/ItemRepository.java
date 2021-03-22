package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Item1;
import com.example.entity.ItemProjection;

public interface ItemRepository extends JpaRepository<Item1, Long> {
	//https://docs.spring.io/spring-data/jpa/docs/1.10.1.RELEASE/reference/html/#jpa.sample-app.finders.strategies
	
	//SELECT * FROM ITEM1TBL OREDER BY NO ASC
	List<Item1> findAllByOrderByNoAsc();
	
	//SELECT * FROM ITEM1TBL WHERE name=?
	List<Item1> findByName(String name);
	
	//SELECT * FROM ITEM1TBL WHERE name=? and price=?
	List<Item1> findByNameAndPrice(String name, long price);
	
	@Query(value = "SELECT * FROM ITEM1TBL WHERE PRICE > :price", nativeQuery = true)
	public List<Item1> selectQueryWherePrice(@Param("price") long price);
	
	@Query(value="SELECT * FROM ITEM1TBL ORDER BY ITMNO DESC", nativeQuery=true)
	public List<Item1> selectQueryOrderByNoDesc();
	
	@Query(value="SELECT ITMNO , ITMNAME FROM ITEM1TBL ORDER BY ITMNO DESC", nativeQuery=true)
	public List<ItemProjection> selectQueryOrderByNoDesc1();
	
}
