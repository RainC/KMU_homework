package kr.ac.kookmin.cs.oop.project.recommender.impl;

import kr.ac.kookmin.cs.oop.project.model.Song;
import kr.ac.kookmin.cs.oop.project.recommender.Recommender;

import java.util.Random;

/*
 * A song recommender that simply relies on random algorithm.
 * Recommend whatever you want to
 */
public class RandomRecommender extends Recommender {

    public RandomRecommender(String filePath) {
        super(filePath);
    }

    /*
     * Write your own recommender module. You can remove the for loop and write
     * your custom logic
     */
    @Override
    public Song[] recommend(String studentId) {

        Song[] RandomSongs = new Song[10];
        int count = 0;

        for (Song songs : this.songs) {
            Random rand = new Random();
            int RandomIndexer = rand.nextInt(50) + 1;
            if (this.songs[RandomIndexer].getUploadStudent() == studentId) {

            } else {
                if (count == 10 ) {
                    return RandomSongs;
                } else {
                    RandomSongs[count] = this.songs[RandomIndexer];
                    count++;
                }
            }
        }

        return null;
    }

}
