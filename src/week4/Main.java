import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //Problem 1 test
//        LibraryBook book1 = new LibraryBook();
//        LibraryBook book2 = new LibraryBook();
//
//        System.out.println(book1.bookTitle);
//        System.out.println(book1.author);
//        System.out.println(book1.pages);
//
//        book1.setBookTitle("Book1");
//        book1.setAuthor("Author1");
//        book1.setPages(501);
//
//        System.out.println(book1.getBookTitle());
//        System.out.println(book1.getAuthor());
//        System.out.println(book1.getPages());
//        System.out.println(book1.isThick());
//
//        book2.setBookTitle("Book2");
//        book2.setAuthor("Author2");
//        book2.setPages(-3);
//
//        System.out.println(book2.getBookTitle());
//        System.out.println(book2.getAuthor());
//        System.out.println(book2.getPages());
//        System.out.println(book2.isThick());

        //Problem 2 test
//        Scanner input = new Scanner(System.in);
//        Sensor newsensor = new Sensor();
//        double[] sensors = new double[5];
//        for (int i=0; i<5; i++){
//            sensors[i]= input.nextDouble();
//            newsensor = new Sensor();
//            newsensor.reading = sensors[i];
//        }
//        System.out.println(Arrays.toString(sensors));
//        System.out.println(newsensor.average(sensors));

        //Problem 3 test
//        StepCounter UserA = new StepCounter();
//        StepCounter UserB = new StepCounter();
//        UserA.walk(56);
//        UserB.walk(35);
//        System.out.println(UserA.getIndividualSteps());
//        System.out.println(UserB.getIndividualSteps());
//        System.out.println(StepCounter.totalStepsAllUsers);

        //Problem 4 test
        Mathtool mathtool = new Mathtool();
        StopWatch watch = new StopWatch();
        watch.startTime();
        for (int i=0; i<1000000; i++){
            mathtool.factorialRecursive(20);
        }
        watch.stopTime();
        System.out.println(watch.getTotalTime());

        watch.startTime();
        for (int i=0; i<1000000; i++){
            mathtool.factorialIterative(20);
        }
        watch.stopTime();
        System.out.println(watch.getTotalTime());


    }
}
