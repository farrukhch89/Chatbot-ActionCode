package cmdChatbot;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTimePartExtratTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	static final private String CALC_TIME = "find = 0.0131 fetch = 0.0056 total=0.0186";

	@Test
	public void testGetValueStrFromCalcTimePart () {
		String findValue = AbstractOwmResponse.getValueStrFromCalcTimePart (CalcTimePartExtratTest.CALC_TIME, "find");
		assertNotNull (findValue);
		assertEquals ("0.0131", findValue);

		String fetchValue = AbstractOwmResponse.getValueStrFromCalcTimePart (CalcTimePartExtratTest.CALC_TIME, "fetch");
		assertNotNull (fetchValue);
		assertEquals ("0.0056", fetchValue);

		String totalValue = AbstractOwmResponse.getValueStrFromCalcTimePart (CalcTimePartExtratTest.CALC_TIME, "total");
		assertNotNull (totalValue);
		assertEquals ("0.0186", totalValue);
	}

	@Test
	public void testGetValueFromCalcTimeStr () {
		double findValue = AbstractOwmResponse.getValueFromCalcTimeStr (CalcTimePartExtratTest.CALC_TIME, "find");
		assertNotNull (findValue);
		assertEquals (0.0131d, findValue, 0.00001d);

		double fetchValue = AbstractOwmResponse.getValueFromCalcTimeStr (CalcTimePartExtratTest.CALC_TIME, "fetch");
		assertNotNull (fetchValue);
		assertEquals (0.0056d, fetchValue, 0.00001d);

		double totalValue = AbstractOwmResponse.getValueFromCalcTimeStr (CalcTimePartExtratTest.CALC_TIME, "total");
		assertNotNull (totalValue);
		assertEquals (0.0186d, totalValue, 0.00001d);
	}

}

