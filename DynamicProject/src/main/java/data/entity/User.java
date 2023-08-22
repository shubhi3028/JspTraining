package data.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "Email")
    private String email;
    @Column(name = "PasswordHash")
    private String passwordHash;
    @Column(name = "Role")
    private String role;
    @Column(name = "Status")
    private String status;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Column(name = "IsApproved")
    private Boolean isApproved;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Column(name = "CreatedAt")
    private Date createdAt;
    @Column(name = "ModifiedAt")
    private Date modifiedAt;


    public User(String id, String firstName, String lastName, String email, String phoneNumber, String passwordHash) {
    }
}
