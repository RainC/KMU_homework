package kr.ac.kookmin.cs.oop.project.recommender;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import kr.ac.kookmin.cs.oop.project.model.Song;

public abstract class Recommender {

    protected final Song[] songs;

    public abstract Song[] recommend(String studentId);

    public Recommender(String filePath) {
        this.songs = buildSongObjects(filePath);
    }

    /*
     * Read the input file and fill the Song[] array
     */
    private Song[] buildSongObjects(String filePath) {
        Song[] songs = new Song[376];
        File inputFile = new File(filePath);
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
            String line;
            for (int i = 0; (line = br.readLine()) != null; ++i) {
                String[] fieldValues = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                // You have to create Song object using fieldValues and store
                // the Song object to songs array
                songs[i] = new Song(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return songs;
    }

    /*
     * A function to print statistics about Song Title, Singer, Genre, ... You
     * have to implement it
     */
    public void printSongStatistics() {
        System.out.println("printSongStatistics()");
        for (Song item : songs) {
            String rawSongString =item.toString();
            String[] fieldValues = rawSongString.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            String InfoSongName = fieldValues[1];
            String InfoSongArtist = fieldValues[2];
            String InfoSongLength= fieldValues[10];
            String InfoSongUploadStudent = fieldValues[0];
            System.out.println("SongName : " + InfoSongName + ", Artist : " + InfoSongArtist + ", Length : " + InfoSongLength );

        }


    }

    /*
     * A function to print basic statistics for each student You have to
     * implement it
    */
    public void printStudentStatistics() {
        System.out.println("printStudentStatistics()");
        for (Song item : songs) {
            String studentInfo =item.getUploadStudent();
            System.out.println("studentId_Slack : " + studentInfo);

        }
    }
}
