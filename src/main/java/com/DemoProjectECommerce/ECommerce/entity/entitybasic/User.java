package com.DemoProjectECommerce.ECommerce.entity.entitybasic;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    //Setting Parameters for the User
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long          Id;
    @Email
    private String        email;
    //    @NotNull(message = " first Name can't be null")
    private String        firstName;
    private String        middleName;
    private String        lastName;
    @NotNull
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",
//            message = "Use the Correct Format for Password")
    private String        password;
    private Boolean       isDeleted;
    private Boolean       isActive;
    private Boolean       isExpired;
    private Boolean       isLocked;
    private Integer       invalidAttemptCount;
    private LocalDateTime passwordcreatedAt;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Address> addressSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
