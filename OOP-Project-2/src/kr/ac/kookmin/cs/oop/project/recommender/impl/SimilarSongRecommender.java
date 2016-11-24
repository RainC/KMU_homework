package kr.ac.kookmin.cs.oop.project.recommender.impl;

import kr.ac.kookmin.cs.oop.project.model.Song;
import kr.ac.kookmin.cs.oop.project.recommender.Recommender;

/*
 * A song recommender based on the similarity of songs
 */
public class SimilarSongRecommender extends Recommender {

    public SimilarSongRecommender(String filePath) {
        super(filePath);
    }

    @Override
    public Song[] recommend(String studentId) {
        for (Song song : this.songs) {

        }
        return null;
    }

}
