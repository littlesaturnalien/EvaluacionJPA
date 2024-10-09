package org.cesar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Entity @Table(name = "clients")
public class Client {

    @Id @NotNull(message = "Id cannot be null.")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull(message = "Name cannot be null.")
    @Column(name = "fullName", nullable = false)
    private String fullName;
    // Length by default is 255, so it's ok for a full name

    @Email
    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "Email cannot be null.")
    private String email;

    @NotNull(message = "Phone cannot be null.")
    @Column(name = "phonenumber", nullable = false, unique = true)
    private String phone;

    @NotNull(message = "Date cannot be null.")
    @Column(nullable = false)
    private String registerDate;

    public Client(String fullName, String email, String phone, String registerDate) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.registerDate = registerDate;
    }
}
