package ro.sorinace.sicj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String title;
    private String message;
    private Boolean visible;

    public Feedback() {}

    public Feedback(String name, String email, String title, String message, Boolean visible) {
        this.name = name;
        this.email = email;
        this.title = title;
        this.message = message;
        this.visible = visible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getVisible() {
        return visible;
    }

    public String getVisibleSt() {

        if(visible){
            return "True";
        }
        return "False";
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id) &&
                Objects.equals(name, feedback.name) &&
                Objects.equals(email, feedback.email) &&
                Objects.equals(title, feedback.title) &&
                Objects.equals(message, feedback.message) &&
                Objects.equals(visible, feedback.visible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, title,message);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Latest feedback{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", visible='").append(visible).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
