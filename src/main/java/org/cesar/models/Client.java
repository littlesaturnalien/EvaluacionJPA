package org.cesar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
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
    private LocalDateTime registerDate;
}
