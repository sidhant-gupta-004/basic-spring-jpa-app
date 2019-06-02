package code.service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;


@Entity
@Table(name="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String content;

    // Not sure why this is necessary, but error page shows "code.service.Blog does not default constructor", so adding
    public Blog() { }

    public Blog (String title, String content) {

        this.setTitle(title);
        this.setContent(content);
    }

    public Blog (int id, String title, String content) {

        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
    }

    public int getId() {

        return this.id;
    }

    public void setId (int id) {

        this.id = id;
    }

    public String getTitle() {

        return this.title;
    }

    public void setTitle (String title) {

        this.title = title;
    }

    public String getContent() {

        return this.content;
    }

    public void setContent (String content) {

        this.content = content;
    }

    @Override
    public String toString() {

        return "Blog{" + "id=" + id + ", title=" + title + "\\" + ", content=" + content + "\\" + "}";
    }
}
