package com.example;

import org.junit.Assert;
import org.junit.Test;

public class MyDataStructureTest {
	
	@Test
	public void test() {
		MyDataStructure mds = new MyDataStructure(3);

		try {
			mds.put("key1", "value1", 0);
			Thread.sleep(5); // sleep 5ms
			mds.put("key2", "value2", 2000); // time to live: 2000ms
			Thread.sleep(5); // sleep 5ms
			mds.put("key3", "value3", 0);

			Assert.assertTrue(mds.size() == 3);
			Assert.assertTrue(((String)mds.get("key1")).equals("value1"));
			Assert.assertTrue(((String)mds.get("key2")).equals("value2"));
			Assert.assertTrue(((String)mds.get("key3")).equals("value3"));

			Thread.sleep(5); // sleep 5ms
			mds.put("key4", "value4", 0);

			Assert.assertTrue(mds.size() == 3);
			Assert.assertTrue(mds.get("key1") == null);
			Assert.assertTrue(((String)mds.get("key4")).equals("value4"));

			Thread.sleep(2500); // sleep 2500ms
			Assert.assertTrue("actual size="+mds.size(), mds.size() == 2);
			Assert.assertTrue(mds.get("key2") == null);
			Assert.assertTrue(((String)mds.get("key3")).equals("value3"));
			Assert.assertTrue(((String)mds.get("key4")).equals("value4"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
