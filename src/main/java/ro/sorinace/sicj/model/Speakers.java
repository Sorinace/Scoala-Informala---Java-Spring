package ro.sorinace.sicj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Speakers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String name;
    private String shortname;
    private String summary;
    private String description;
    //private Artwork[] artworks = null;

    public Speakers() {}

    public Speakers(String title, String name, String shortname, String summary, String description) {
        this.title = title;
        this.name = name;
        this.shortname = shortname;
        this.summary = summary;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Artwork[] getArtworks() {
//        return artworks;
//    }
//
//    public void setArtworks(Artwork[] artworks) {
//        this.artworks = artworks;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speaker = (Speakers) o;
        return Objects.equals(id, speaker.id) &&
                Objects.equals(name, speaker.name) &&
                Objects.equals(shortname, speaker.shortname) &&
                Objects.equals(title, speaker.title) &&
                Objects.equals(summary, speaker.summary) &&
                Objects.equals(description, speaker.description);
      //          Objects.equals(artworks, speaker.artworks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortname, title, summary);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Speakers{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", shortname='").append(shortname).append('\'');
        sb.append(", summary='").append(summary).append('\'');
        sb.append(", description='").append(description).append('\'');
   //     sb.append(", artworks='").append(artworks.toString()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
