import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;
import example.model.SimpleBankAccountWithAtm;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private BankAccount bankAccountATM;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
        bankAccountATM = new SimpleBankAccountWithAtm(accountHolder, 0, 1);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }


    @Test
    void testInitialBalanceATM() {
        assertEquals(0, bankAccountATM.getBalance());
    }

    @Test
    void testDepositATM() {
        bankAccountATM.deposit(accountHolder.getId(), 100);
        assertEquals(99, bankAccountATM.getBalance());
    }

    @Test
    void testWrongDepositATM() {
        bankAccountATM.deposit(accountHolder.getId(), 100);
        bankAccountATM.deposit(2, 50);
        assertEquals(99, bankAccountATM.getBalance());
    }

    @Test
    void testWithdrawATM() {
        bankAccountATM.deposit(accountHolder.getId(), 100);
        bankAccountATM.withdraw(accountHolder.getId(), 70);
        assertEquals(28, bankAccountATM.getBalance());
    }

    @Test
    void testWrongWithdrawATM() {
        bankAccountATM.deposit(accountHolder.getId(), 100);
        bankAccountATM.withdraw(2, 70);
        assertEquals(99, bankAccountATM.getBalance());
    }
}
