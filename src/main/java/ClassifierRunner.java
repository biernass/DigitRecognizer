import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ClassifierRunner {

    public static void main(String[] args) throws IOException {

        List<Record> trainingRecords = getRecordsFromFile("trainingsample.csv");
        List<Record> validationRecords = getRecordsFromFile("validationsample.csv");

        for (Record record : validationRecords) {
            Integer recognizedNumber = predict(record.Pixels, trainingRecords);
            System.out.println(recognizedNumber + " " + (recognizedNumber == record.Number));
        }

        System.out.println("hi");
    }

    private static List<Record> getRecordsFromFile(String fileName) throws IOException{
        List<String> lines = new ArrayList<>();

        Path pathOfTrainingsample = Paths.get(fileName);
        lines.addAll(Files.readAllLines(pathOfTrainingsample));

        List<Record> RecordsList = lines
                .stream()
                .map(x -> x.split(","))
                .collect(Collectors.toList())
                .subList(1, lines.size())
                .stream()
                .map(x -> Arrays.stream(x)
                        .map(y -> Integer.parseInt(y))
                        .collect(Collectors.toList()))      //parsing String to int
                .map(x -> {
                    Record record = new Record();
                    record.Number = x.get(0);
                    record.Pixels = x.subList(1, x.size()).toArray(new Integer[0]);
                    return record;
                })
                .collect(Collectors.toList());

        return RecordsList;
    }

    public static double distance(Integer[] pointA, Integer[] pointB) {

        double result = 0;
        for (int index = 0; index < pointA.length; index++) {
            Integer difference = pointA[index] - pointB[index];
            result = result + Math.pow(difference, 2);
        }
        return Math.sqrt(result);
    }

    public static Integer predict(Integer[] pixels, List<Record> sampleRecords) {
        Pair match = sampleRecords
                .stream()
                .map(x -> new Pair(x.Number, distance(pixels, x.Pixels)))
                .sorted(Comparator.comparingDouble(x -> (double) x.getValue()))
                .findFirst()
                .get();

        Integer theBestNumber = (Integer) match.getKey();
        return theBestNumber;
    }


}