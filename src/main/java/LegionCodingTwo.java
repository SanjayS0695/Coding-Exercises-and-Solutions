import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LegionCodingTwo {

    public static void main(String[] args) {
        ScoreCalculations scoreCalculations = new ScoreCalculations(new TestScoreGeneratorImpl());
        System.out.println(scoreCalculations.queryCountOfScore(10));
        System.out.println(scoreCalculations.getNthMostByCount(1));
    }

    public interface TestScoreGenerator {
        // Each call to getNext returns the next test score
        // When scores are exhausted returns null
        // Number of test scores is unknown (but will fit in memory and no integer overflows)
        // TestScoreGenerator cannot go backwards or be reset
        // DO NOT IMPLEMENT
        Integer getNext();
    }

    public static class TestScoreGeneratorImpl implements TestScoreGenerator {

        Stack<Integer> data = new Stack<>();

        TestScoreGeneratorImpl() {
            data.push(10);
            data.push(20);
            data.push(30);
            data.push(10);
            data.push(25);
            data.push(10);
            data.push(20);
        }

        @Override
        public Integer getNext() {
            if (data.empty()) {
                return null;
            } else {
                return data.pop();
            }
        }
    }

    // Different score calculations on FULL set of scores for given TestScoreGenerator
// Can use any standard Java collection class
// No other outside libraries (ie. apache collections, etc) can be used
    public static class ScoreCalculations {

        List<Integer> scores;
        Map<Integer, Long> countMap;
        Map<Integer, Set<Integer>> rankMap;

        public ScoreCalculations(TestScoreGenerator testScoreGenerator) {
            // TODO
            var firstScore = testScoreGenerator.getNext();
            if (null != firstScore) {
                scores = new ArrayList<>();
                scores.add(firstScore);
                while (true) {
                    var next = testScoreGenerator.getNext();
                    if (null != next) {
                        scores.add(next);
                    } else {
                        break;
                    }
                }

                countMap = scores.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                rankMap = new HashMap<>();
//                var result = countMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).sorted()
//                        .collect(Collections.frequency())
//                var list = new ArrayList<>(countMap.entrySet());
//                list.sort(Map.Entry.comparingByValue());

//                rankMap = new HashMap<Integer, Set<Integer>>();
//                for (Map.Entry<Integer,Long> entry: list) {
//                    if (null == rankMap.get(entry.getValue())) {
//                        rankMap.put(Math.toIntExact(entry.getValue()), new HashSet<>(entry.getKey()));
//                    } else {
//                        var val = rankMap.get(entry.getValue());
//                        val.add(entry.getKey());
//                        rankMap.put(Math.toIntExact(entry.getValue()), val);
//                    }
//                }
                Collections.sort(scores);
                int i = 0;
                int rank = 1;
                rankMap = new HashMap<Integer, Set<Integer>>();
                while (i < scores.size()) {
                    var score = scores.get(i);
                    if (null == rankMap.get(rank)) {
                        rankMap.put(rank, new HashSet<>(score));
                    } else {
                        var scoresWithSameRank = rankMap.get(rank);
                        scoresWithSameRank.add(score);
                        rankMap.put(rank, scoresWithSameRank);
                    }
                    i++;
                    if (scores.get(i) != score) {
                        rank++;
                    }
                }

            } else {
                System.out.println("Score in TestScoreGenerator is empty!");
            }
        }

        //{10, 10, 10, 20, 20, 25, 30 , null}
        // scores: { 10, 20, 30, 10, 25, 10, 20 null}
        // queryCountOfScore(10) returns 3
        public int queryCountOfScore(Integer score) {
            // TODO
            if (countMap.isEmpty()) {
                System.out.println("Cannot query the count as the list of score is empty");
                return 0;
            } else {
                var count = countMap.get(score);
                return count != null ? count.intValue() : 0;
            }
        }

        // Gets the nth most or least frequently occurring score
        // Returns a set of scores as it is possible for multiple scores to have the same rank
        // scores: { 10, `20, 30, 10, 25, 10, 20 null}
        // ranking by score: Rank #1: {10}; Rank #2: {20}; Rank #3: {25, 30}
        // getNthMostByCount(1) returns set of {10}
        // getNthMostByCount(3) returns set of {25, 30}
        // getNthMostByCount(4) returns empty set { }
        public Set<Integer> getNthMostByCount(int scoreCountRank) {
            // TODO
            return rankMap.get(scoreCountRank);
        }

    }
}