package ua.com.illia;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    private static final Path input = Paths.get("input.txt");
    private static final Path inputTemplate = Paths.get("inputTemplate.txt");
    private static final Path output = Paths.get("output.txt");


    public void inputFileChanger(String select) throws IOException {
        if (select.equals("1")) {
            FileWriter writer = new FileWriter(output.toFile(), false);
            writer.write("");
            fileParser(inputTemplate);
        } else if (select.equals("2")) {
            FileWriter writer = new FileWriter(output.toFile(), false);
            writer.write("");
            fileParser(input);
        }
    }

    public void fileParser(Path path) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            int size = Integer.parseInt(reader.readLine());
            Graph graph = new Graph(size);
            for (int i = 0; i < size; i++) {
                String nameEvaluations = reader.readLine();
                graph.addNode(i, nameEvaluations);
                int countConnects = Integer.parseInt(reader.readLine());
                for (int j = 0; j < countConnects; j++) {
                    String[] connect_cost = reader.readLine().split(" ");
                    graph.addWay(i, Integer.parseInt(connect_cost[0]) - 1, Integer.parseInt(connect_cost[1]));
                }
            }
            int countTasks = Integer.parseInt(reader.readLine());
            for (int i = 0; i < countTasks; i++) {
                String[] destination = reader.readLine().split(" ");
                int cost = Graph.findCheapestWay(graph.cityIndex(destination[0]), graph.getEvaluations())[graph.cityIndex(destination[1])];
                writeResult(destination[0], destination[1], cost);
            }
        } catch (Exception e) {
            System.out.println("Incorrect file input.txt");
        }

    }

    private void writeResult(String from, String to, int cost) throws IOException {
        String output = (from + " " + to + '\n' + cost + '\n');
        FileWriter writer = new FileWriter(FileHandler.output.toFile(), true);
        writer.write(output);
        writer.flush();
        System.out.println(output);
    }

}

