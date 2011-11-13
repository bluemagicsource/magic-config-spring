package org.springframework.beans.factory.config;

import java.util.Properties;

public class PropertiesObjectPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private Properties propertiesObject; 
	
	@Override
	protected String resolvePlaceholder(String placeholder, Properties props) {
		return getPropertiesObject().get(placeholder).toString();
	}

	public void setPropertiesObject(Properties propertiesObject) {
		this.propertiesObject = propertiesObject;
	}

	public Properties getPropertiesObject() {
		return propertiesObject;
	}
}
