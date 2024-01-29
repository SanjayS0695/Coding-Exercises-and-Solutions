import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EpamCodingTwo {

    public static void main(String[] args) {
        //Consider the following class representing a student's grade in different subjects:
        //
        //class StudentGrade {
        //    private String studentName;
        //    private Map<String, Integer> subjectGrades;
        //
        //    // Constructor, getters, setters...
        //
        //}
        //
        //Now, assume you have a list of `StudentGrade` objects, each containing a student's name and their grades in various subjects.
        //
        //Your task is to find the average grade for each subject across all
        // students and identify the subject with the highest average grade.

        StudentGrade s1 = new StudentGrade();
        s1.setStudentName("S1");
        Map<String, Integer> val = new HashMap<>();
        val.put("Math", 90);
        val.put("Physics", 85);
        val.put("History", 78);
        s1.setSubjectGrades(val);

        Map<String, Integer> val2 = new HashMap<>();
        val2.put("Math", 92);
        val2.put("Physics", 88);
        val2.put("History", 75);
        StudentGrade s2 = new StudentGrade();
        s2.setStudentName("S2");
        s2.setSubjectGrades(val2);

        Map<String, Integer> val3 = new HashMap<>();
        val3.put("Math", 85);
        val3.put("Physics", 95);
        val3.put("History", 80);
        StudentGrade s3 = new StudentGrade();
        s3.setStudentName("S3");
        s3.setSubjectGrades(val3);

        List<StudentGrade> studentGrades = Arrays.asList(s1, s2, s3);
        //Your task is to find the average grade for each subject across all
        // students and identify the subject with the highest average grade.

//        val3.put("Math", 85);
//        val3.put("Physics", 95);
//        val3.put("History", 80);
//        val3.put("Math", 85);
//        val3.put("Physics", 95);
//        val3.put("History", 80);
//        val3.put("Math", 85);
//        val3.put("Physics", 95);
//        val3.put("History", 80);

        Map<String, Double> averageOfSubjects = new HashMap<>();
        Map<String, Double> avgMap = studentGrades.stream().flatMap(studentGrade -> studentGrade.getSubjectGrades().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
        System.out.println(avgMap);
        System.out.println(avgMap.entrySet().stream().max(Map.Entry.comparingByValue()));

    }




    static class StudentGrade {
        private String studentName;
        private Map<String, Integer> subjectGrades;

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public Map<String, Integer> getSubjectGrades() {
            return subjectGrades;
        }

        public void setSubjectGrades(Map<String, Integer> subjectGrades) {
            this.subjectGrades = subjectGrades;
        }
    }
}
