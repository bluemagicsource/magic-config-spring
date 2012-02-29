package org.bluemagic.debug;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is used for printing out the values of a simple
 * name value pair.  This class is typically used for debugging
 * bluemagic by logging the name and value of a property.
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

    /***
     *Prints out debug name value pairs 
     */
    public void log() {
        LOG.debug("Name = " + name + ", Value = " + value);
    }

    /***
     * returns the Name Property
     * @return name property
     */
    public String getName() {
        return name;
    }

    /***
     * sets name property
     * @param name sets name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * returns the Value property
     * @return Value Property
     */
    public String getValue() {
        return value;
    }

    /***
     * sets the Value 
     * @param value returns Value property
     */
    public void setValue(String value) {
        this.value = value;
    }
    
}
