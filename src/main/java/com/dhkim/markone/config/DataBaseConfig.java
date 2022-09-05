package com.dhkim.markone.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.dhkim.markone.mapper"})
public class DataBaseConfig {

	/**
	 * Session Factory 설정
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		// 리졸버에 등록된 패키지 하위의 dao 클래스를 스캔합니다.
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		// 오른쪽에 있는 리소스 경로에 들어감(src/main/resources)
		sessionFactory.setMapperLocations(resolver.getResources(
				// 실제 쿼리가 들어갈 xml 패키지 경로
				"classpath:mapper/*.xml"));

		
		// 한참을 개고생
		sessionFactory.setVfs(SpringBootVFS.class);
		// Value Object를 선언해 놓은 package 경로
		sessionFactory.setTypeAliasesPackage("com.dhkim.markone.vo");
		return sessionFactory.getObject();
	}

	/**
	 * Mybatis template 설정
	 */
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		// underscore를 camelCase로 매칭 : 예) user_id -> userId
		sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);
		// Insert시 생성되는 pk를 bean으로 반환
		sqlSessionTemplate.getConfiguration().setUseGeneratedKeys(true);
		return sqlSessionTemplate;
	}

//    /** 
//    * 트랜잭션 매니저 설정
//    */
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

}
