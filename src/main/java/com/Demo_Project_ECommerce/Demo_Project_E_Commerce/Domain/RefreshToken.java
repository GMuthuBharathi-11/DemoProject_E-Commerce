package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken
{
      @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String token;
        private Instant createdAt;
        private LocalDateTime expiresAt;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id",referencedColumnName = "Id")
        private User user;
}
