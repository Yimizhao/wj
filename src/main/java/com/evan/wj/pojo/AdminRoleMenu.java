package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "admin_role_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class AdminRoleMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rid")
    private Integer rid;

    @Column(name = "mid")
    private Integer mid;

}