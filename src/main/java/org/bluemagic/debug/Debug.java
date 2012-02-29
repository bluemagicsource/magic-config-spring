package org.bluemagic.debug;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is used for printing out the values of a simple
 * name-value pair to the debug log.  This class is typically 
 * used for debugging bluemagic by logging the name and value 
 * of a property when the application starts.  To do this, add
 * the following piece of xml to one of the spring files that
 * will be run.  Make sure to replace the two arguments with
 * the name of the property you are interested in.
 * 
 * <bean class="org.bluemagic.debug.Debug">
 *     <constructor-arg type="String" value="property"/>
 *     <constructor-arg type="String" value="${property}"/>    
 * </bean>
 */
public class Debug {
    private static final Log LOG = LogFactory.getLog(Debug.class);
    
    private String name;
    private String value;
    
    public Debug() {}
    
    public Debug(String name, String value) {
        this.name = name;
        this.value = value;
        
        log();
    }

    /**
     * Print out debug name-value pairs 
     */
    public void log() {
        LOG.debug("Name: " + name + ", Value: " + value);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
}
