package org.bluemagic.debug;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is used to print out the names and values of
 * a group of properties to the debug logs.  To have this 
 * class print out the values when the application starts, 
 * include the following piece of xml in one of the spring 
 * files that will be used.  Make sure to substitute the 
 * property names for the names your are interested in.
 * 
 * <bean class="org.bluemagic.debug.DebugMap">
 *     <constructor-arg>
 *         <map>
 *             <entry key="property1" value="${property1}" />
 *             <entry key="property2" value="${property2}" />
 *         </map>
 *     </constructor-arg>
 * </bean>
 */
public class DebugMap {

    private static final Log LOG = LogFactory.getLog(DebugMap.class);
    
    private Map<String, String> debugMap;

    public DebugMap() {}
    
    public DebugMap(Map<String, String> debugMap) {
        this.debugMap = debugMap;
        
        log();
    }
    
    /**
     * Print out the names and values of the entries in the map.
     */
    public void log() {
        if (debugMap != null) {
            for (String key : debugMap.keySet()) {
                LOG.debug("Name: " + key + ", Value: " + debugMap.get(key));
            }
        }
    }
    
    /**
     * @return the debugMap
     */
    public Map<String, String> getDebugMap() {
        return debugMap;
    }

    /**
     * @param debugMap the debugMap to set
     */
    public void setDebugMap(Map<String, String> debugMap) {
        this.debugMap = debugMap;
    }
}
