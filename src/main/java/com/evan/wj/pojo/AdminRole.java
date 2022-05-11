package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "admin_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "name_zh", length = 100)
    private String nameZh;

    @Column(name = "enabled")
    private Boolean enabled;
}