package tables;

import javax.persistence.*;
import java.util.Collection;
// Entity
@Entity
@NamedQueries({
        @NamedQuery(name = "Spec.findAll", query = "select sp from Spec sp"),
        @NamedQuery(name = "Spec.findById", query = "select sp from Spec sp where sp.id=:sid")
})
public class Spec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private int code;
    @Basic
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "spec")
    private Collection<Student> students;

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return code + " : " + title;
    }
}
