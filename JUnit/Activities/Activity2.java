package Activities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Activity2 {

	@Test
	public void notEnoughFunds() {
		// object for bankaccount class
		BankAccount account = new BankAccount(9);

		// assertion for exception
		assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10));
	}

	@Test
	public void enoughFunds() {

		BankAccount account = new BankAccount(100);

		// assertion for no exception
		assertDoesNotThrow(() -> account.withdraw(100));

	}

}
