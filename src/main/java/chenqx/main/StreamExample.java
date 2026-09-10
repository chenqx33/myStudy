package chenqx.main;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Tracker> elements = Lists.newArrayList(
                new Tracker("A", 1.0),
                new Tracker("B", 0.1),
                new Tracker("C", 0.0),
                new Tracker("A", 1.0),
                new Tracker("B", 0.3),
                new Tracker("D", 1.0));
        Set<String> exclusions = new HashSet<>(Arrays.asList("A", "B"));
        Set<String> exclusions2 = new HashSet<>(Arrays.asList("C", "D"));
        List<Set<String>> rules = Arrays.asList(exclusions, exclusions2);

        Map<String, Optional<Tracker>> collect = elements.stream()
                .collect(Collectors.groupingBy(o -> o.getName(), Collectors.maxBy(Comparator.comparingDouble(Tracker::getScore))));

        for (Set<String> rule : rules) {
            String trackerName = rule.stream().map(o -> collect.get(o).orElse(null)).filter(Objects::nonNull).max(Comparator.comparingDouble(Tracker::getScore)).map(o -> o.getName()).get();
            elements.removeIf(o -> rule.contains(o.getName())&&!o.getName().equals(trackerName));

        }


        System.out.println(elements); // 应该输出 [A, C, A, D]
    }

    @Data
    public static class Tracker {
        private String name;
        private double score;

        public Tracker(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }
}