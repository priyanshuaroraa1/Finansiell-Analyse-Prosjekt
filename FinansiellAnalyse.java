import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FinansiellAnalyse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Antall måneder du vil analysere: ");
        int months = scanner.nextInt();
        
        ArrayList<Double> incomes = new ArrayList<>();
        ArrayList<Double> expenses = new ArrayList<>();
        ArrayList<Double> netIncomes = new ArrayList<>();
        
        // Samle inn data
        for (int i = 0; i < months; i++) {
            System.out.print("Inntekter for måned " + (i + 1) + ": ");
            incomes.add(scanner.nextDouble());
            System.out.print("Utgifter for måned " + (i + 1) + ": ");
            expenses.add(scanner.nextDouble());
            netIncomes.add(incomes.get(i) - expenses.get(i));
        }
        
        // Beregn gjennomsnitt
        double avgIncome = calculateAverage(incomes);
        double avgExpenses = calculateAverage(expenses);
        double avgNetIncome = calculateAverage(netIncomes);
        
        // Beregn standardavvik
        double stdDevIncome = calculateStandardDeviation(incomes, avgIncome);
        double stdDevExpenses = calculateStandardDeviation(expenses, avgExpenses);
        double stdDevNetIncome = calculateStandardDeviation(netIncomes, avgNetIncome);
        
        // Finn måned med høyest og lavest nettoinntekt
        int maxNetIncomeMonth = netIncomes.indexOf(Collections.max(netIncomes)) + 1;
        int minNetIncomeMonth = netIncomes.indexOf(Collections.min(netIncomes)) + 1;
        
        // Vis resultater
        System.out.println("\nØkonomisk analyse:");
        System.out.printf("Gjennomsnittlig månedlig inntekt: %.2f\n", avgIncome);
        System.out.printf("Gjennomsnittlig månedlig utgift: %.2f\n", avgExpenses);
        System.out.printf("Gjennomsnittlig månedlig nettoinntekt: %.2f\n", avgNetIncome);
        System.out.printf("Standardavvik for inntekter: %.2f\n", stdDevIncome);
        System.out.printf("Standardavvik for utgifter: %.2f\n", stdDevExpenses);
        System.out.printf("Standardavvik for nettoinntekter: %.2f\n", stdDevNetIncome);
        System.out.printf("Høyeste nettoinntekt i måned %d\n", maxNetIncomeMonth);
        System.out.printf("Laveste nettoinntekt i måned %d\n", minNetIncomeMonth);
        
        // Vis nettoinntekt per måned
        for (int i = 0; i < months; i++) {
            System.out.printf("Nettoinntekt for måned %d: %.2f\n", i + 1, netIncomes.get(i));
        }
        
        scanner.close();
    }
    
    private static double calculateAverage(ArrayList<Double> data) {
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.size();
    }
    
    private static double calculateStandardDeviation(ArrayList<Double> data, double mean) {
        double sumSquaredDifferences = 0;
        for (double value : data) {
            sumSquaredDifferences += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sumSquaredDifferences / data.size());
    }
}
