

import org.example.task1.ATM;
import org.example.task1.Section_200;
import org.example.task1.Section_500;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATMTest {

    @Test
    public void testValidAmountProcessing() {
        ATM atm = new ATM();
        Assertions.assertDoesNotThrow(() -> atm.getMeMoney(700));
    }

    @Test
    public void testInvalidAmountProcessing() {
        ATM atm = new ATM();
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> atm.getMeMoney(750)
        );
        Assertions.assertEquals("Invalid amount", exception.getMessage());
    }

    @Test
    public void testSectionChaining() {
        Section_500 section500 = new Section_500();
        Section_200 section200 = new Section_200();
        section500.setNext(section200);

        Assertions.assertDoesNotThrow(() -> section500.process(700));
    }

    @Test
    public void testSectionProcessingInvalidAmount() {
        Section_500 section500 = new Section_500();
        Section_200 section200 = new Section_200();
        section500.setNext(section200);

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> section500.process(750)
        );
        Assertions.assertEquals("Invalid amount", exception.getMessage());
    }
}
