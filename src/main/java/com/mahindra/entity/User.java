package com.mahindra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mUser")
@ToString
public class User {


    @Id
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private String leadId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    @NotNull
    private String firstName;


//    @Pattern(regexp = "^[a-zA-Z]+$")
    private String middleName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    @NotNull
    private String lastName;

    @Pattern(regexp = "([5-9]|\\d{10})")
    private String mobileNumber;

    //@Pattern(regexp = "(Male|Female|Others)")
    private Gender gender;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date DOB;

    @Email
    @NotNull
    private String email;
}
