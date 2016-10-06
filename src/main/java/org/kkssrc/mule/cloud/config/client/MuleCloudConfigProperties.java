package org.kkssrc.mule.cloud.config.client;

import java.util.Properties;

import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

public class MuleCloudConfigProperties extends Properties{

	private ConfigClientProperties configClientProperties;
	private ApplicationContextProvider appCtxProvider;
	
	public MuleCloudConfigProperties(ConfigClientProperties configClientProperties, ApplicationContextProvider appCtxProvider){
		this.configClientProperties = configClientProperties;
		this.appCtxProvider = appCtxProvider;
		init();
	}
	
	protected void init(){
		ConfigServicePropertySourceLocator locator = new ConfigServicePropertySourceLocator(configClientProperties);
		CompositePropertySource propertySource  = (CompositePropertySource) locator.locate(appCtxProvider.getApplicationContext().getEnvironment());
		for(PropertySource<?> mapSource : propertySource.getPropertySources()){
			super.putAll(((MapPropertySource) mapSource).getSource());
		}
	}
}
