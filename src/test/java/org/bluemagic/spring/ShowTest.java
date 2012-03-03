package org.bluemagic.spring;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.easymock.EasyMock;
import org.junit.Test;

public class ShowTest {

	@Test
	public void showWithDebug() {
	
		Log mockLog = EasyMock.createStrictMock(Log.class);
		mockLog.debug("Key: key, Value: value");
		EasyMock.replay(mockLog);
		
		Show.LOG = mockLog;
		
		new Show("debug", "key", "value");
		EasyMock.verify(mockLog);
	}
	
	@Test
	public void showWithError() {
	
		Log mockLog = EasyMock.createStrictMock(Log.class);
		mockLog.error("Key: key, Value: value");
		EasyMock.replay(mockLog);
		
		Show.LOG = mockLog;
		
		new Show("error", "key", "value");
		EasyMock.verify(mockLog);
	}
	
	@Test
	public void showMapWithInfo() {
	
		Log mockLog = EasyMock.createStrictMock(Log.class);
		mockLog.info("Key: key, Value: value");
		EasyMock.replay(mockLog);
		
		Show.LOG = mockLog;
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("key", "value");
		
		new Show("info", map);
		EasyMock.verify(mockLog);
	}
	
	@Test
	public void showMapWithMultipleInfo() {
	
		Log mockLog = EasyMock.createNiceMock(Log.class);
		mockLog.info("Key: key1, Value: value1");
		mockLog.info("Key: key2, Value: value2");
		EasyMock.replay(mockLog);
		
		Show.LOG = mockLog;
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		
		new Show("info", map);
		EasyMock.verify(mockLog);
	}
	
	@Test
	public void showWithNoLevel() {
	
		Log mockLog = EasyMock.createStrictMock(Log.class);
		EasyMock.replay(mockLog);
		
		Show.LOG = mockLog;
		
		new Show("key", "value");
		EasyMock.verify(mockLog);
	}
}