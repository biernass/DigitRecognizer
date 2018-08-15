import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassifierRunner {

    public static void main(String[] args) {


        List<String> lines = new ArrayList<>();


        try {
            Path pathOfTrainingsample = Paths.get("trainingsample.csv");
            lines.addAll(Files.readAllLines(pathOfTrainingsample));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String[]> trainingsampleListAsStringsArraysWithoutLabels = lines
                .stream()
                .map(x -> x.split(","))
                .collect(Collectors.toList());
        trainingsampleListAsStringsArraysWithoutLabels.remove(0);

        List<Record> RecordsList = trainingsampleListAsStringsArraysWithoutLabels.stream()
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


        System.out.println("hi");
    }


}