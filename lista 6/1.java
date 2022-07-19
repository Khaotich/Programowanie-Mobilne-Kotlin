import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<Future<BigInteger>> tasksList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbe: ");
        long n = Long.parseLong(scan.nextLine());
        double taskNum = (double) n / NUM_THREADS;
        System.out.println(taskNum);

        for (int i = 0; i < NUM_THREADS; i++) {
            long fromInInnerRange = (long) ((taskNum * i) + 1);
            long toInInnerRange = (long) (taskNum * (i + 1));
            System.out.printf("From z %d to %d", fromInInnerRange, toInInnerRange);
            System.out.println();

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
        System.out.printf("Silnia z %d to %d", n, sumaSilni);
        executorService.shutdown();
    }
}