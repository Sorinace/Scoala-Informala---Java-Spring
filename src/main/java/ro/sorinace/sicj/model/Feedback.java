package ro.sorinace.sicj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;
import org.apache.commons.text.StringEscapeUtils;

/**
 * @author Sorin
 * The feedback data
 */
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

    /**
     * An empty item, not a null one
     */
    public Feedback() {
        this.name = "";
        this.email = "";
        this.title = "";
        this.message = "";
        this.visible = false;
    }

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

    /**
     * Check the condition for the form data + change the harmfulness script
     * @return the errors for the checked feedback
     */
    public ArrayList<String> check() {
        ArrayList<String> errors = new ArrayList<>();
        if (this.name.replaceAll("\\s+","") == "" ||
                this.name.replaceAll("\\s+","").length() < 2 ||
                this.name.replaceAll("\\s+","").length() > 125)
            errors.add("The name must have at least 2 characters, and max. 125!");
        else
            this.name = StringEscapeUtils.escapeHtml4(this.name);

        if (this.email.replaceAll("\\s+","") == "" || !isValid(this.email))
            errors.add( "The e-mail is not valid, pleas check!");
        else
            this.email = StringEscapeUtils.escapeHtml4(this.email);

        if (this.title.replaceAll("\\s+","") == "" ||
                this.title.replaceAll("\\s+","").length() < 5||
                this.name.replaceAll("\\s+","").length() > 225)
            errors.add("The title must have at least 5 characters, and max. 225!");
        else
            this.title = StringEscapeUtils.escapeHtml4(this.title);


        if (this.message.replaceAll("\\s+","") == "" ||
                this.message.replaceAll("\\s+","").length() < 5||
                this.name.replaceAll("\\s+","").length() > 2100)
            errors.add("The message must have at least 5 characters, and max 2100!");
        else
            this.message = StringEscapeUtils.escapeHtml4(this.message);


        return errors;
    }

    /**
     * Check if the e-mail have the right format
     * @param email is the e-mail checked
     * @return an boolean, true if the e-mail seam to be valid and false otherwise
     */
    private boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-z A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
