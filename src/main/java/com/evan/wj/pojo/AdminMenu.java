package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "path", length = 64)
    private String path;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "name_zh", length = 64)
    private String nameZh;

    @Column(name = "icon_cls", length = 64)
    private String iconCls;

    @Column(name = "component", length = 64)
    private String component;

    @Column(name = "parent_id")
    private Integer parentId;

    @Transient
    List<AdminMenu> children;
}