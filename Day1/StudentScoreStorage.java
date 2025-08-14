import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StudentScoreStorage {

    public static void main(String[] args) {

        // 1. Store marks in a HashMap<String, Integer>
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 88);
        studentScores.put("Bob", 92);
        studentScores.put("Charlie", 76);
        studentScores.put("Diana", 95);
        studentScores.put("Ethan", 89);

        System.out.println("--- All Student Scores ---");
        studentScores.forEach((name, score) -> System.out.println(name + ": " + score));
        System.out.println("--------------------------\n");

        // 2. Find the highest scorer using streams
        Optional<Map.Entry<String, Integer>> highestScorerEntry = studentScores.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
                
        // An alternative way to write the comparator:
        // .max(Comparator.comparing(Map.Entry::getValue));

        // 3. Display the result
        System.out.println("--- Finding Highest Scorer ---");
        if (highestScorerEntry.isPresent()) {
            Map.Entry<String, Integer> highestScorer = highestScorerEntry.get();
            System.out.println("Highest Scorer: " + highestScorer.getKey());
            System.out.println("Score: " + highestScorer.getValue());
        } else {
            System.out.println("The score map is empty. No highest scorer found.");
        }
    }
}