package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class units {
	public Account account;
	public void setUp() {
		account = new Account();
	}
	
	@Test
	public void testTypicalResults() {
		Account accounts[] = new Account[3];

		accounts[0] = new Account();
		accounts[0].principal = 35;
		accounts[0].rate = (float) .04;
		accounts[0].daysActive = 365;
		accounts[0].accountType = Account.PREMIUM;

		accounts[1] = new Account();
		accounts[1].principal = 100;
		accounts[1].rate = (float) .035;
		accounts[1].daysActive = 100;
		accounts[1].accountType = Account.BUDGET;

		accounts[2] = new Account();
		accounts[2].principal = 50;
		accounts[2].rate = (float) .04;
		accounts[2].daysActive = 600;
		accounts[2].accountType = Account.PREMIUM_PLUS;

		float result = account.calculateFee(accounts);
		assertEquals(result, (float) 0.060289, (float) 0.00001);
	}
	
	@Test
    public void testNonPremiumAccounts() {
	Account accounts[] = new Account[2];

	accounts[0] = new Account();
	accounts[0].principal = 12;
	accounts[0].rate = (float) .025;
	accounts[0].daysActive = 100;
	accounts[0].accountType = Account.BUDGET;

	accounts[1] = new Account();
	accounts[1].principal = 50;
	accounts[1].rate = (float) .0265;
	accounts[1].daysActive = 150;
	accounts[1].accountType = Account.STANDARD;

	float result = account.calculateFee(accounts);
	assertEquals(result, 0, 0.0001);
}
	@Test
	public void testZeroRate() {
	Account accounts[] = new Account[1];

	accounts[0] = new Account();
	accounts[0].principal = 1000;
	accounts[0].rate = (float) 0;
	accounts[0].daysActive = 100;
	accounts[0].accountType = Account.PREMIUM;

	float result = account.calculateFee(accounts);
	assertEquals(result, 0, 0.00001);
}
	@Test
	public void testNegativePrincipal() {
	Account accounts[] = new Account[1];

	accounts[0] = new Account();
	accounts[0].principal = -10000;
	accounts[0].rate = (float) 0.263;
	accounts[0].daysActive = 100;
	accounts[0].accountType = Account.PREMIUM;

	float result = account.calculateFee(accounts);
	assertEquals(result, -9.33265, 0.0001);
}
	@Test
	public void testDuplicateReference() {
	Account accounts[] = new Account[3];

	accounts[0] = new Account();
	accounts[0].principal = 35;
	accounts[0].rate = (float) .04;
	accounts[0].daysActive = 365;
	accounts[0].accountType = Account.PREMIUM;

	accounts[1] = accounts[0];

	accounts[2] = new Account();
	accounts[2].principal = 50;
	accounts[2].rate = (float) .04;
	accounts[2].daysActive = 600;
	accounts[2].accountType = Account.PREMIUM_PLUS;

	float result = account.calculateFee(accounts);
	assertEquals(result, 0.0781316, 0.000001);
}
	@Test
	public void testNullInput() {
	Account accounts[] = null;
	try {
		float result = account.calculateFee(accounts);
		fail();
	} catch (NullPointerException e) {
		assertTrue(true);
	}
}

}
