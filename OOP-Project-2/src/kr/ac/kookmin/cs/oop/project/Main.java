package kr.ac.kookmin.cs.oop.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import kr.ac.kookmin.cs.oop.project.model.Song;
import kr.ac.kookmin.cs.oop.project.recommender.Recommender;
import kr.ac.kookmin.cs.oop.project.recommender.impl.RandomRecommender;

public class Main {

    private final String[] studentIds;

    private Recommender musicRecommender;

    public Main(String filePath) {
        studentIds = extractStudentsIds(filePath);
        musicRecommender = new RandomRecommender(filePath);

    }

    /*
     * From the input file path that contains information about the song
     * preference list, it should extract unique students IDs and it should
     * return it as a String array. There are 36 unique student IDs and you
     * should return only the unique IDs.
     */
    private static String[] extractStudentsIds(String filePath) {
        File inputFile = new File(filePath);
        String[] studentIds = new String[37];
        int count = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
            for (String line; (line = br.readLine()) != null;) {
                //System.out.println(line);
                String[] fieldValues = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // You have to extract the kmu-id that is the first element in
                // the fieldValues and store unique ones to studentIds String
                // array
                if (count == 35) {

                } else {
                	studentIds[count] = fieldValues[0]; //아이디값 넣음
                	count++;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return studentIds;
    }

    /*
     * A function to print out basic statistics about song and students
     */
    public void printStatistics() {
        musicRecommender.printSongStatistics();
        musicRecommender.printStudentStatistics();
    }

    /*
     * A function that calls recommend function that is implemented in different
     * classes
     */
    public void recommend() {
        for (String student : studentIds) {
            if (student == null) {

            } else {
                Song[] recommendedSongs = musicRecommender.recommend(student);

                for (int i = 0; i < 10 ; i++) {
                    System.out.println(recommendedSongs[i].toString());
                }
                System.out.println("End of Student 's recommand list " + student);
                System.out.println("--------------------------------------------");
                System.out.println("");
            }

        }

    }

    public static void main(String[] args) {
        Main runner = new Main("resource/oop-2016-song-project.csv");

        runner.printStatistics();
        runner.recommend();
        String[] result_extractStudensIds =runner.extractStudentsIds("resource/oop-2016-song-project.csv");



    }
}
