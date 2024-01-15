package ra.example.demospringmvc2.Dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.example.demospringmvc2.Dao.ISongDao;
import ra.example.demospringmvc2.Until.ConnectDB;
import ra.example.demospringmvc2.model.Song;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SongDaoImpl  implements ISongDao {
    @Override
    public List<Song> findAllSong() {
        List<Song> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("select  * from song");
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Song s = new Song();
                s.setId(rs.getString("id"));
                s.setSongName(rs.getString("songName"));
                s.setAuthor(rs.getString("author"));
                s.setDescription(rs.getString("description"));
                s.setImageUrl(rs.getString("imageUrl"));
                s.setVideoUrl(rs.getString("videoUrl"));
                s.setDuration(rs.getInt("duration"));
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
return list ;
    }

    @Override
    public void addSong(Song s) {
   Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("INSERT INTO Song (id, songName, description, imageUrl, videoUrl, author, duration) VALUES (?, ?, ?, ?, ?,?,?)");
            call.setString(1,s.getId());
            call.setString(2, s.getSongName());
            call.setString(3,s.getDescription());
            call.setString(4,s.getImageUrl());
            call.setString(5,s.getVideoUrl());
            call.setString(6,s.getAuthor());
            call.setInt(7,s.getDuration());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void upDateSong(Song s) {
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("UPDATE Song SET songName=?, description=?, imageUrl=?, videoUrl=?, author=?, duration=?, status=? WHERE id=?");
            call.setString(1,s.getId());
            call.setString(2, s.getSongName());
            call.setString(3,s.getDescription());
            call.setString(4,s.getImageUrl());
            call.setString(5,s.getVideoUrl());
            call.setString(6,s.getAuthor());
            call.setInt(7,s.getDuration());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }


    @Override
    public void deleteSong(int id) {
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("delete  from  song where  id = ?");
            call.setString(1,String.valueOf(id));
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }
}
