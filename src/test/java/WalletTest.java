import org.example.Wallet;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalletTest {

    Wallet myWallet;

    @BeforeAll
    void initClass() {
        System.out.println("Initializing class");
        myWallet = new Wallet("Aku");
    }

    @AfterAll
    void clearClass() {
        // pembersihan sekali setelah seluruh pengujian dijalankan
        System.out.println("Cleaning class");
        myWallet = null;
    }

    @BeforeEach
    public void initMethod() {
        System.out.println("Initializing method");
        myWallet.addMoney(100000);
        myWallet.addMoney(50000);
        myWallet.addCoin(1000);
        myWallet.addCard("KTP");
        myWallet.addCard("SIM");
    }
    @AfterEach
    void cleanMethod() {
        System.out.println("Cleaning method");
        // menghapus semua objek setiap kali setelah metode pengujian dijalankan
        myWallet.getMoneys().clear();
        myWallet.getCoins().clear();
        myWallet.getCards().clear();
        myWallet.resetMoney();
    }

    @Test
    public void testSetOwner() {
//        Wallet myWallet = new Wallet("NewOwner");
        myWallet.setOwner("Kamu");

        Assertions.assertEquals("Kamu", myWallet.getOwner());
    }

    @Test
    public void testAddCard() {
//        Wallet myWallet = new Wallet("Aku");
        myWallet.addCard("KTP");

        Assertions.assertTrue(myWallet.getCards().contains("KTP"));
        Assertions.assertEquals(3, myWallet.getCards().size());
    }

    @Test
    public void testTakeCard() {
//        Wallet myWallet = new Wallet("Aku");
//        myWallet.addCard("BNI");
        myWallet.takeCard("KTP");

        Assertions.assertFalse(myWallet.getCards().contains("KTP"));
//        Assertions.assertTrue(myWallet.getCards().isEmpty());
    }

    @Test
    public void testAddMoney() {
//        Wallet myWallet = new Wallet("Aku");
        myWallet.addMoney(10000);

        Assertions.assertTrue(myWallet.getMoneys().containsKey(10000));
        Assertions.assertEquals(1, myWallet.getMoneys().get(10000));
    }

    @Test
    public void testTakeMoneysNotEnoughMoney() {
//        Wallet myWallet = new Wallet("Aku");

//        myWallet.addMoney(10000);
//
        myWallet.takeMoneys(50000);

        Assertions.assertTrue(myWallet.getMoneys().containsKey(100000));
        Assertions.assertEquals(0, myWallet.getMoneys().get(50000));
    }

    @Test
    public void testGetMoneyAvailableWithMoneysOnly() {
//        Wallet myWallet = new Wallet("Aku");
//        myWallet.addMoney(1000);
//        myWallet.addMoney(5000);

        Assertions.assertEquals(150000, myWallet.calculateMoneys());
        Assertions.assertEquals(151000, myWallet.getMoneyAvailable());
    }

}

