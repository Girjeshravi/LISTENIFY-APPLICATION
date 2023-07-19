package songApplication;
import java.util.*;

public class Album {
    private String albumName;
    private String artistName;
    private List<Song>songList;

    public Album(String alnumName,String artistName){
        this.albumName=albumName;
        this.artistName=artistName;
        this.songList=new ArrayList<>();
    }
    public boolean findSongBytitle(String title){
        for(Song song:songList){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    public String addNewSongtoAlbum(String title,double duration){
        if(findSongBytitle(title)){
            return "Song is already present";
        }
        Song song=new Song(title,duration);
        this.songList.add(song);
        return "song has been added successfully";
    }
    public String addSongToPayList(int songNo,ArrayList<Song>playList){
        int index=songNo-1;
        if(index>=0 && index<songList.size()){
            Song song =songList.get(index);
            playList.add(song);
            return "Song added to playlist successfully";
        }
        else{
            return "song no entered is out of range";
        }
    }
    public String addSongToPlayList(String title,ArrayList<Song>playlist){
        for(Song song:songList){
            if(song.getTitle().equals(title)){
                playlist.add(song);
                return "song added to playlist";
            }
        }
        return "No song found with given title";
    }
}
