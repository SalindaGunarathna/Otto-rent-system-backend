package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name",nullable = false,unique = true)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "profile_pic")
    private  String profilePic;
    @Column(name = "phone_no")
    private String phoneNO;
    @Column(name = "address")
    private String address;


}
