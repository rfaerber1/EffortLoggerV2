package testDate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/*This code was written by
 * Bailey Learned
 */

class dateTest {

	@Test
	public void TD1() {
		assertEquals("Date should be in format: yyyy-mm-dd", dateTesting.testDate("1234567890"));
	}
	public void TD2() {
		assertEquals("Date should be in format: yyyy-mm-dd", dateTesting.testDate("12-04-2021"));
	}
	public void TD3() {
		assertEquals("Date should be in format: yyyy-mm-dd", dateTesting.testDate("2023-5-18"));
	}
	public void TD4() {
		assertEquals("Date is out of range", dateTesting.testDate("2023-15-02"));
	}
	public void TD5() {
		assertEquals("Date is out of range", dateTesting.testDate("2023-02-30"));
	}
	public void TD6() {
		assertEquals("Date is out of range", dateTesting.testDate("2023-06-31"));
	}
	public void TD7() {
		assertEquals("Date is out of range", dateTesting.testDate("2023-22-01"));
	}
	public void TD8() {
		assertEquals("Date is out of range", dateTesting.testDate("2023-08-45"));
	}
	public void TD9() {
		assertEquals("Date is out of range", dateTesting.testDate("2023-06-31"));
	}
	public void TD10() {
		assertEquals("Date is out of range", dateTesting.testDate("2023-01-35"));
	}
	public void TD11() {
		assertEquals("Date is out of range", dateTesting.testDate("2023-11-31"));
	}
	public void TD12() {
		assertEquals("Invalid input", dateTesting.testDate("2a23-06-31"));
	}
	public void TD13() {
		assertEquals("Invalid input", dateTesting.testDate("2023-a6-31"));
	}
	public void TD14() {
		assertEquals("Invalid input", dateTesting.testDate("2023-06-a1"));
	}
	
	