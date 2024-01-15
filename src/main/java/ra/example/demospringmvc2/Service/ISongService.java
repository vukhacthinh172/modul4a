package ra.example.demospringmvc2.Service;

import ra.example.demospringmvc2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> fingAllSong();
    void  addSong(Song s);
    void  updateSong(Song s);
    void  deleteSong(int id);

}
