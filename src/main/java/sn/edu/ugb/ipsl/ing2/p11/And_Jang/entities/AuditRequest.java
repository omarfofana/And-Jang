package sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "audit_request")
public class AuditRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String url;
    private String method;
    private String ip;
    private String token;
    private Integer responseCode;


}