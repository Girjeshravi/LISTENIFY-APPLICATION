package songApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album a1 =new Album("old hindi songs","kishore kumar");
        a1.addNewSongtoAlbum("nile nile ambar",6.0);
        a1.addNewSongtoAlbum("meri bhigi bhigi se",5.0);
        a1.addNewSongtoAlbum("dil kya kare",5.5);
        a1.addNewSongtoAlbum("ek ajnabi haseena",3.5);

        Album a2=new Album("latest bollywood songs","jubin nautiyal");
        a2.addNewSongtoAlbum("itni si hasi",4.5);
        a2.addNewSongtoAlbum("tere vaste",3.5);
        a2.addNewSongtoAlbum("raatan lambia",4.6);
        a2.addNewSongtoAlbum("barish ban ja",3.2);
        a2.addNewSongtoAlbum("pasoori",3.4);

        ArrayList<Song>playlist=new ArrayList<>();
        a1.addSongToPayList(2,playlist);
        a1.addSongToPayList(4,playlist);

        a2.addSongToPlayList("pasoori",playlist);
        a2.addSongToPlayList("itti se hassi",playlist);

        play(playlist);
    }

    public static void play(ArrayList<Song>playlist) {
        printMenu();
        Scanner sc=new Scanner(System.in);
        int choice =sc.nextInt();
        System.out.println("printing the first song");
        int currentIndex=0;
        System.out.println(playlist.get(currentIndex).toString());
        boolean isOver=false;
        while(!isOver){
            switch (choice){
                case 1:
                    if(currentIndex==(playlist.size()-1)){
                        System.out.println("youare at the last song");
                    }
                    else{
                        currentIndex++;
                        System.out.println(playlist.get(currentIndex).toString());
                    }
                    break;
                case 2:
                    if(currentIndex==0){
                        System.out.println("you are the first song");
                    }
                    else{
                        currentIndex--;
                        System.out.println(playlist.get(currentIndex).toString());
                    }
                    break;
                case 3:
                    System.out.println(playlist.get(currentIndex).toString());
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    printAllSongs(playlist);
                case 6:
                    deleteSong(currentIndex,playlist);
                    break;
                case 7:
                    isOver=true;
                    break;
            }
            choice =sc.nextInt();
        }
    }
    public static void printAllSongs(ArrayList<Song>playlist){
        for(Song song :playlist){
            System.out.println(song.toString());
        }
    }
    public static void deleteSong(int index,ArrayList<Song>playlist){
        System.out.println("Removed Song :"+playlist.get(index).toString());
        playlist.remove(playlist.get(index));
    }
    public static void printMenu(){
        System.out.println("enter your choice");
        System.out.println("1. go to next song");
        System.out.println("2. go to previous song");
        System.out.println("3. repeat this song");
        System.out.println("4. print the menu");
        System.out.println("5. print playlist");
        System.out.println("6. delet the current song");
        System.out.println("7. close the playlist");
    }
}