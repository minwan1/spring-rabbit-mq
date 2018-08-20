package com.wan.example.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "customer")
public class User {


    @Id
    @GeneratedValue
    public long id;

    @Column(name = "email")
    public String email;


}
