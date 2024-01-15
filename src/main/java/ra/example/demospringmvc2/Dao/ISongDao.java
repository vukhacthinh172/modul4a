package ra.example.demospringmvc2.Dao;

import ra.example.demospringmvc2.model.Song;

import java.util.List;

public interface ISongDao {
    List<Song> findAllSong();
    void addSong(Song s) ;
    void upDateSong(Song s);
    void deleteSong(int id);

}
