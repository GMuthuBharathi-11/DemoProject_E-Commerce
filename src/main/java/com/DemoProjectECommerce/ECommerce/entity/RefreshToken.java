package com.DemoProjectECommerce.ECommerce.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.time.Instant;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long          id;
        private String        token;
        private Instant       createdAt;
        private LocalDateTime expiresAt;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", referencedColumnName = "Id")
        private User user;
}
