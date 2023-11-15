package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.koreait.commons.constants.MemberType;

import java.time.LocalDateTime;

@Data
@Entity
@Table(indexes = {
        @Index(name="idx_member_userNm", columnList = "userNm"),
        @Index(name="idx_member_mobile", columnList = "mobile")
})
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNo;

    private String email;

    private String password;

    private String userNm;

    private String mobile;

    private MemberType mtype = MemberType.USER;

    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
