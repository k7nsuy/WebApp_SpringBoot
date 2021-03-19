package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MyBatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		//xml mapper가 있는 위치 설정
		// scr/main/resources의 mapper폴더의 *Mapper.xml로 된 파일
		Resource[] arrResource = new PathMatchingResourcePatternResolver()
				.getResources("classpath:mapper/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(arrResource);
		return sqlSessionFactoryBean.getObject();
			
		
	}
	
}
