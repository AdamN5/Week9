package ie.atu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

        BankAccount account;

        @BeforeEach
        void setup()
        {
            account = new BankAccount();
        }

        void constructorInitialisation()
        {
            account = new BankAccount("ACC12345", "Paul", 100);
            assertEquals("ACC12345", account.getAccNo());
            assertEquals("Paul", account.getName());
            assertEquals(100, account.getBalance());
        }
        @Test
        void constructorNegativeInitialisation()
        {
            Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "Paul",-100));
            assertEquals("Balance must be greater than 0.", ex.getMessage());
        }
        @Test
        void depositPositive()
        {
            assertEquals(10,BankAccount.deposit(10));
        }
        @Test
        void depositNegative()
        {
            Exception ex = assertThrows(IllegalArgumentException.class, () -> BankAccount.deposit(0));
            assertEquals("Deposit must be greater than 0.", ex.getMessage());
        }
        void withdrawPositive()
        {
            assertEquals(0,BankAccount.withdraw(10));
        }
        void withdrawNegative()
        {
            Exception ex = assertThrows(IllegalArgumentException.class, () -> BankAccount.deposit(0));
            assertEquals("Withdraw must be greater than 0.", ex.getMessage());
        }



}

