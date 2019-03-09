package com.swu.ai.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "figure_dict")
public class FigureDict {
    @Id
    private Long id;

    private String figureName;

    private Integer figureLevel;

    private Integer subFigureNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName == null ? null : figureName.trim();
    }

    public Integer getFigureLevel() {
        return figureLevel;
    }

    public void setFigureLevel(Integer figureLevel) {
        this.figureLevel = figureLevel;
    }

    public Integer getSubFigureNum() {
        return subFigureNum;
    }

    public void setSubFigureNum(Integer subFigureNum) {
        this.subFigureNum = subFigureNum;
    }
}