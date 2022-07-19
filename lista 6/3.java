import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final int NUM_THREADS = 10;
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    static class Dzielniki implements Callable<ArrayList<Integer>> {
        int from, to, licznaDzielnikow, dzielniki = 0, liczba = 0;

        public Dzielniki(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public ArrayList<Integer> call() {
            for (int i = from; i <= to; i++) {
                licznaDzielnikow = 0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0)
                        licznaDzielnikow++;
                }
                if (dzielniki < licznaDzielnikow) {
                    dzielniki = licznaDzielnikow;
                    liczba = i;
                }
            }
            ArrayList<Integer> lista = new ArrayList<>();
            lista.add(dzielniki);
            lista.add(liczba);
            return lista;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<Future<ArrayList<Integer>>> tasksList = new ArrayList<>();
        int liczba = 100000;
        double taskNum = (double) liczba / NUM_THREADS;

        for (int i = 0; i < NUM_THREADS; i++) {
            int fromInInnerRange = (int) ((taskNum * i) + 1);
            int toInInnerRange = (int) (taskNum * (i + 1));

            Callable<ArrayList<Integer>> task = new Dzielniki(fromInInnerRange, toInInnerRange);
            Future<ArrayList<Integer>> wynik= executorService.submit(task);
            tasksList.add(wynik);
        }

        for (Future<ArrayList<Integer>> res : tasksList) {
            try {
                result.add(res.get());
            } catch (CancellationException | ExecutionException | InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        int dzielniki = 0, num = 0;
        for (ArrayList<Integer> calculatedResult : result) {
            if (dzielniki < calculatedResult.get(0)) {
                dzielniki = calculatedResult.get(0);
                num = calculatedResult.get(1);
            }
        }
        executorService.shutdown();
        System.out.println("Liczba = " + num);
        System.out.println("Liczba dzielników = " + dzielniki);
    }
}