package org.kkssrc.mule.cloud.config.client;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware{

	@Autowired
	private ApplicationContext appContext;
	
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.appContext = arg0;
	}

	public ApplicationContext getApplicationContext(){
		return this.appContext;
	}

	
}
