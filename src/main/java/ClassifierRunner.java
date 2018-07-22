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

        List<String> trainingsampleList = new ArrayList<>();


        try {
            Path pathTrainingsample = Paths.get("trainingsample.csv");
            trainingsampleList.addAll(Files.readAllLines(pathTrainingsample));
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        List<String[]> trainingsampleListAsArrays = trainingsampleList
                .stream()
                .map(x->x.split(","))
                .collect(Collectors.toList());

        List<List<Integer>> trainingsampleListAsIntegers = trainingsampleListAsArrays
                .stream()
                .map(x->{
                    return Arrays.stream(x)
                            .map(y->Integer.parseInt(String.valueOf(y)))
                            .collect(Collectors.toList());
                })
                .collect(Collectors.toList());

        System.out.println("hi");
    }


}