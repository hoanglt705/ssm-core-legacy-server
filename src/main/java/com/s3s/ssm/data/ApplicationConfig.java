/*
 * Copyright 2012-2013 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.s3s.ssm.data;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.s3s.ssm.repo")
@EntityScan({"com.sunrise.xdoc.entity", "com.s3s.ssm.security.entity"})
@SpringBootApplication
public class ApplicationConfig {
	
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/ssm-db?useSSL=false")
				.driverClassName("com.mysql.jdbc.Driver").username("root").password("rootpass").build();
	}
  public static void main(String[] args) {
	  SpringApplication.run(ApplicationConfig.class, args);
  }

}
