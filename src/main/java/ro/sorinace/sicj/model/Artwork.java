package ro.sorinace.sicj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long speaker_id;
    private String picture;

    public Artwork() {}

    public Artwork(Long speaker_id, String picture) {
        this.speaker_id = speaker_id;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public Long getSpeakerId() {
        return speaker_id;
    }

    public void setSpeakerId(Long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setEmail(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artwork art = (Artwork) o;
        return Objects.equals(id, art.id) &&
                Objects.equals(speaker_id, art.speaker_id) &&
                Objects.equals(picture, art.picture) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speaker_id, picture);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artworks{");
        sb.append("id=").append(id);
        sb.append(", speaker_id='").append(speaker_id).append('\'');
        sb.append(", picture='").append(picture).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
