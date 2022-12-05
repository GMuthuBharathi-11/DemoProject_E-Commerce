package com.DemoProjectECommerce.ECommerce.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.HashSet;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;


@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User
{
                                                               //Setting Parameters for the User
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Email
    private String email;

    @NotNull
    private String firstName;
    private String middleName;
    private String lastName;
    @NotNull
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",
//            message = "Use the correct format for password")
    private String        password;
    private Boolean       isDeleted;
    private Boolean       isActive;
    private Boolean       isExpired;
    private Boolean       isLocked;
    private Integer       invalidAttemptCount;
    private LocalDateTime passwordcreatedAt;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)     //Mapped to the Address Table
    @JoinColumn(name = "user_id")
    private Set<Address> addressSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)                             //Mapped to the Role Table
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns =
    @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}

