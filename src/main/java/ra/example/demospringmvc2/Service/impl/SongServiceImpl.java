package ra.example.demospringmvc2.Service.impl;

import org.springframework.stereotype.Service;
import ra.example.demospringmvc2.Dao.ISongDao;
import ra.example.demospringmvc2.Service.ISongService;
import ra.example.demospringmvc2.model.Song;

import java.util.List;
@Service
public class SongServiceImpl implements ISongService {
    private ISongDao songDao ;
    @Override
    public List<Song> fingAllSong() {
        return songDao.findAllSong();
    }

    @Override
    public void addSong(Song s) {
        songDao.addSong(s);

    }

    @Override
    public void updateSong(Song s) {
        songDao.upDateSong(s);

    }

    @Override
    public void deleteSong(int id) {
       songDao.deleteSong(id);
    }
}
