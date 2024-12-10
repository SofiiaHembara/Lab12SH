

import org.example.task2.Signature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class SignatureTest {

    @Test
    public void testSignatureExecution() {
        AtomicBoolean executed = new AtomicBoolean(false);

        Signature<String> signature = new Signature<>(arg -> {
            executed.set(true);
            System.out.println("Task executed with argument: " + arg);
        });

        signature.apply("Test Argument");
        Assertions.assertTrue(executed.get());
    }

    @Test
    public void testSignatureIdGeneration() {
        Signature<String> signature = new Signature<>(arg -> System.out.println("Task executed with argument: " + arg));
        signature.apply("Test Argument");

        Assertions.assertNotNull(signature.getId());
    }

    @Test
    public void testHeaders() {
        Signature<String> signature = new Signature<>(arg -> System.out.println("Task executed with argument: " + arg));
        signature.setHeader("Content-Type", "application/json");

        Assertions.assertEquals("application/json", signature.getHeader("Content-Type"));
    }
}

