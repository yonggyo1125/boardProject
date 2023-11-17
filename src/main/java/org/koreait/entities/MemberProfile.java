package org.koreait.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class MemberProfile {
    @Id @GeneratedValue
    private Long seq;

    @Column(length=100)
    private String image;
}
