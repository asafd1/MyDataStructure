package com.example;

import org.junit.Assert;
import org.junit.Test;

public class MyDataStructureTest {
	
	/**
	 * The task is to implement MyDataStructure with the following charectaristics:
	 * 1. max items is given in the constructor (int capacity). when adding new keys - make sure capacity is not breached by removing oldest inserted items if necessary
	 * 2. every item should be removed after the time-to-live has elapsed (unless time-to-live is 0 and then the item does not expire)
	 * 3. get, put, remove, size should all have a complexity of o(1) in average
	 * 4. you may use internally any java data structures, and any number of threads
	 * 5. exercise success criteria is that "mvn install" succeeds   
	 */
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
