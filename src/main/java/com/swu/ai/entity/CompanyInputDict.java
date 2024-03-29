package com.swu.ai.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "company_input_dict")
public class CompanyInputDict {
    @Id
    private String name;

    private String value;

    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}