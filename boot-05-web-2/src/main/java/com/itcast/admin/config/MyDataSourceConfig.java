package com.itcast.admin.config;

import java.util.Arrays;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Deprecated
//@Configuration
public class MyDataSourceConfig {
	
	@ConfigurationProperties("spring.datasource")
	@Bean
	public DataSource  dataSource()throws Exception {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setFilters("stat,wall");
		return dataSource;
	}
	/**
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<StatViewServlet> statViewServlet() {
		StatViewServlet statViewServlet = new StatViewServlet();
		ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");		
		return servletRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean<WebStatFilter> webStatFilter(){
		WebStatFilter webStatFilter = new WebStatFilter();
		FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/"));
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
