package MultiThreading;

import java.math.BigInteger;

public class ComplexCalculation {

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result = BigInteger.ONE;

        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (thread1.getResult() != null && thread2.getResult() != null) {
            result = thread1.getResult().add(thread2.getResult());
        }

        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        return result;
    }

    private static class PowerCalculatingThread extends Thread {

        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            for (int i = 0; i < power.intValue(); i++) {
                result = result.multiply(base);
            }


        }

        public BigInteger getResult() {
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation cm = new ComplexCalculation();
        BigInteger result = cm
                .calculateResult(BigInteger.valueOf(100L), BigInteger.valueOf(20L), BigInteger.valueOf(35L),
                        BigInteger.valueOf(45L));

        System.out.println("Result --> " + result.toString());
    }

}
