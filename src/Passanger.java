import java.util.Date;

//@Entity
public class Passanger {
    //    @Id
    private long id;
    private String name;
    private Date birthdate;

    public long getId() {
            return id;
        }

    public void setId(long id) {
            this.id = id;
        }

    public String getName() {
            return name;
        }

    public void setName(String name) {
            this.name = name;
        }

    public Date getBirthdate() {
            return birthdate;
        }

    public void setBirthdate(Date birthdate) {
            this.birthdate = birthdate;
        }

    @Override
    public String toString() {
        return "Passanger{" +
               "birthdate=" + birthdate +
               ", name='" + name + '\'' +
               ", id=" + id +
               '}';
    }
}
