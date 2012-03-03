package org.bluemagic.spring;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is used for printing out the values of a simple key-value pair to
 * the console OR a log file. This class is typically used for showing the key
 * and value of a property when the application starts. To do this, add the
 * following piece of xml to one of the spring files that will be run. Make sure
 * to replace the two arguments with the name of the property you are interested
 * in. The first argument is OPTIONAL and is the level used for output to a LOG
 * file. This defaults to System.out if no log LEVEL is specified.
 * 
 * Possible LEVELS: trace, debug, info, warn, error, console
 * 
 * Example prints to console:
 * 
 * <bean class="org.bluemagic.spring.Show">
 *     <constructor-arg type="String" value="property"/>
 *     <constructor-arg type="String" value="${property}"/>
 * </bean>
 * 
 * Example prints to LOG with level DEBUG
 * 
 * <bean class="org.bluemagic.spring.Show">
 *     <constructor-arg type="String" value="debug"/>
 *     <constructor-arg type="String" value="property"/>
 *     <constructor-arg type="String" value="${property}"/>
 * </bean>
 * 
 * If you would like to pass a map of properties to print use the following
 * constructor and pass in a map object
 * 
 * Example prints to console
 * 
 * <bean class="org.bluemagic.spring.Show"> 
 *     <constructor-arg> 
 *         <map> 
 *             <entry key="property1" value="${property1}" /> 
 *             <entry key="property2" value="${property2}" />
 *         </map>
 *     </constructor-arg>
 * </bean>
 * 
 * Example prints to LOG file using trace level
 * 
 * <bean class="org.bluemagic.spring.Show">
 * 	   <constructor-arg type="String" value="trace"/>
 *     <constructor-arg> 
 *         <map> 
 *             <entry key="property1" value="${property1}" /> 
 *             <entry key="property2" value="${property2}" />
 *         </map>
 *     </constructor-arg>
 * </bean>
 * 
 */
public class Show {
    
	protected static Log LOG = LogFactory.getLog(Show.class);
    
    public static String DEFAULT_LEVEL = "console";
    
    public Show() {}
    
    public Show(String key, String value) {
        log(DEFAULT_LEVEL, key, value);
    }
    
    public Show(String level, String key, String value) {
        log(level, key, value);
    }
    
	public Show(Map<String, String> debugMap) {
		logMap(DEFAULT_LEVEL, debugMap);
	}
	
	public Show(String level, Map<String, String> debugMap) {
		logMap(level, debugMap);
	}

	/**
	 * Print out the names and values of the entries in the map.
	 */
	public void logMap(String level, Map<String, String> debugMap) {

		if (debugMap != null) {
			for (String key : debugMap.keySet()) {
				log(level, key, debugMap.get(key));
			}
		}
	}

    /**
     * Print out key-value pair at a particular level
     */
    public void log(String level, String key, String value) {
    	
    	String message = "Key: " + key + ", Value: " + value;
    	
    	if ("error".equals(level.toLowerCase())) {
    		LOG.error(message);
    	} else if ("warn".equals(level.toLowerCase())) {
    		LOG.warn(message);
    	} else if ("info".equals(level.toLowerCase())) {
    		LOG.info(message);
    	} else if ("debug".equals(level.toLowerCase())) {
    		LOG.debug(message);
    	} else if ("trace".equals(level.toLowerCase())) {
    		LOG.trace(message);
    	} else {
    		System.out.println(message);
    	}
    }
}
