package test.java;

import org.junit.Test;

import com.anil.java.dao.CustDao;

import junit.framework.Assert;

public class DummyTest {
@Test
public void  test() {
		Assert.assertEquals(CustDao.insertData("ANil", "Pune"),true);
	}

}
