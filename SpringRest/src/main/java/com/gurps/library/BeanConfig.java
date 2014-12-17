package com.gurps.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import com.gurps.library.util.StringToAuthorListConverter;

@Configuration
@EnableAutoConfiguration
public class BeanConfig {

	@Autowired
    private ResourceLoader resourceLoader;
	
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON) //just being explicit for understanding
	public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() throws IOException{
		DozerBeanMapperFactoryBean mapperFactory = new DozerBeanMapperFactoryBean();
		mapperFactory.setMappingFiles(ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:*mapping.xml"));
		
		/*List<CustomConverter> customConverters = new ArrayList<>();
		customConverters.add(new StringToAuthorListConverter());
		mapperFactory.setCustomConverters(customConverters);
		*/
		return mapperFactory;
	}
	
}
