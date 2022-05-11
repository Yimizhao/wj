package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "admin_role_permission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class AdminRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rid")
    private Integer rid;

    @Column(name = "pid")
    private Integer pid;

}