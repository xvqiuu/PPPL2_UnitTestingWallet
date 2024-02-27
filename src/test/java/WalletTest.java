import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class WalletTest {

    @Test
    public void testSetOwner() {
        Wallet myWallet = new Wallet("NewOwner");
        myWallet.setOwner("Aku");

        Assertions.assertEquals("Aku", myWallet.getOwner());
    }

    @Test
    public void testAddCard() {
        Wallet myWallet = new Wallet("Aku");
        myWallet.addCard("BNI");

        Assertions.assertTrue(myWallet.getCards().contains("BNI"));
        Assertions.assertEquals(1, myWallet.getCards().size());
    }

    @Test
    public void testTakeCard() {
        Wallet myWallet = new Wallet("Aku");
        myWallet.addCard("BNI");
        myWallet.takeCard("BNI");

        Assertions.assertFalse(myWallet.getCards().contains("BRI"));
        Assertions.assertTrue(myWallet.getCards().isEmpty());
    }

    @Test
    public void testAddMoney() {
        Wallet myWallet = new Wallet("Aku");
        myWallet.addMoney(10000);

        Assertions.assertTrue(myWallet.getMoneys().containsKey(10000));
        Assertions.assertEquals(1, myWallet.getMoneys().get(10000));
    }

    @Test
    public void testTakeMoneysNotEnoughMoney() {
        Wallet myWallet = new Wallet("Aku");

        myWallet.addMoney(10000);

        myWallet.takeMoneys(20000);

        Assertions.assertTrue(myWallet.getMoneys().containsKey(10000));
        Assertions.assertEquals(1, myWallet.getMoneys().get(10000));
    }

    @Test
    public void testGetMoneyAvailableWithMoneysOnly() {
        Wallet myWallet = new Wallet("Aku");
        myWallet.addMoney(1000);
        myWallet.addMoney(5000);

        Assertions.assertEquals(6000, myWallet.calculateMoneys());
        Assertions.assertEquals(6000, myWallet.getMoneyAvailable());
    }
}

