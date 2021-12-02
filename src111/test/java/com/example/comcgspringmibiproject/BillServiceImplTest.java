package com.example.comcgspringmibiproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.BillDao;
import com.capgemini.exceptions.NoSuchConsumerNumberException;
import com.capgemini.service.BillServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BillServiceImplTest {
	
	@MockBean
	private BillDao billDao;
	
	@Autowired
	private BillServiceImpl billServiceImpl;

	@Test
	void viewBillByConsumerNumber() throws NoSuchConsumerNumberException {
		System.out.println("test case running..");
		Mockito.doReturn(null).when(billDao).readBillByConsumerNumber(ArgumentMatchers.anyLong());
//		Bill billopt = billDao.readBillByConsumerNumber(consumerNumber);
		
		assertEquals("This bill is available in the database ", billServiceImpl.viewBillByConsumerNumber(10L));
	}
}
