package com.example.easybookkeepingsystem.infrastructure.persistence.member;

import com.example.easybookkeepingsystem.infrastructure.persistence.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    Long id;

    @Version
    @Column(name = "VERSION", nullable = false)
    Long version;

    @NotBlank
    @Column(name = "USERID", nullable = false, unique = true)
    String userId;

    @NotBlank
    @Column(name = "PASSWORD", nullable = false)
    String password;

    @NotNull
    @Column(name = "ROLE", nullable = false)
    String role;

}
