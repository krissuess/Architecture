package forNumberTests;

import numberTests.Primes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
    @Test
    public void testPrimes() {
        String e = "35";
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testnonPrime() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }
}
