package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "admin_user_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class AdminUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "rid")
    private Integer rid;

}