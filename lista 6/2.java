import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static BigInteger sumaSilni = BigInteger.ONE;
    private static final int NUM_THREADS = 10;

    static class Silnia implements Callable<BigInteger> {
        long from, to;
        BigInteger localSum = BigInteger.ONE;

        public Silnia(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public BigInteger call() {
            for (long i = from; i <= to; i++)
                localSum = localSum.multiply(BigInteger.valueOf(i));
            return localSum;
        }
    }

    static BigDecimal silnia(long liczba) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<Future<BigInteger>> tasksList = new ArrayList<>();

        double taskNum = (double) liczba / NUM_THREADS;

        if (liczba < NUM_THREADS && liczba > 0) {
            BigDecimal localSum = BigDecimal.ONE;
            for (long i = 1; i <= liczba; i++)
                localSum = localSum.multiply(BigDecimal.valueOf(i));
            return localSum;
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            long fromInInnerRange = (long) ((taskNum * i) + 1);
            long toInInnerRange = (long) (taskNum * (i + 1));

            Callable<BigInteger> task = new Silnia(fromInInnerRange, toInInnerRange);
            Future<BigInteger> przyszlaSuma = executorService.submit(task);
            tasksList.add(przyszlaSuma);
        }

        for (Future<BigInteger> sil : tasksList) {
            try {
                sumaSilni = sumaSilni.multiply(sil.get());
            } catch (CancellationException | ExecutionException | InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        executorService.shutdown();
        return new BigDecimal(sumaSilni);
    }

    public static void main(String[] args) {
        BigDecimal wynik = BigDecimal.ZERO;
        for (int i = 0; i <= 17; i++) {
            wynik = wynik.add(BigDecimal.ONE.divide(silnia(i), 20, RoundingMode.DOWN));
        }
        System.out.println(wynik);
    }
}