package kr.ac.kookmin.cs.oop.project.model;

/*
 * A class to store the information about each song entry
 * It should contain all the fields that are registered in the song list file
 * You have to declare fields and way to parse comma separated string to the Song class 
 */
public class Song {
	String songUploadedBy;
	String songComposer;
	String songName;
	String songType;
	String songMadewhen;
	String songAlbumName;
	String songProducer;
	String songCountry;
	String songLanguage;
	String songLength;
	String songEntryRaw;
	
	
    public Song(String entry) {
    	String[] fieldValues = entry.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    	
    	this.songUploadedBy = fieldValues[0];
    	this.songComposer = fieldValues[1];
    	this.songName = fieldValues[2];
    	this.songType = fieldValues[3];
    	this.songMadewhen = fieldValues[4];
    	this.songAlbumName = fieldValues[5];
    	this.songProducer = fieldValues[6];
    	this.songCountry = fieldValues[7];
    	this.songLanguage = fieldValues[8];
    	this.songLength = fieldValues[10];
		this.songEntryRaw = entry;
    	System.out.println(entry + " from SongClass (not splited)");
//    	System.out.println( fieldValues[0] + " from SongClass "); // Test print when created Song object from Recommonder Class
    }



	/*
     * You have to write your custom toString function to print Song information
     */
    @Override
    public String toString() {

        return this.songEntryRaw;
    }

	public String getUploadStudent() {
		return this.songUploadedBy;
	}

}
