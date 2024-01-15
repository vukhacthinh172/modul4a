package ra.example.demospringmvc2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Song {
    private  String id,songName , description,imageUrl, videoUrl , author;
    private  int duration ;
    private  boolean status ;

}
