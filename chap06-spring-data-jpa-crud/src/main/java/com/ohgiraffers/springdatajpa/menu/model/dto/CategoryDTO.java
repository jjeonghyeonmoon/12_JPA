package com.ohgiraffers.springdatajpa.menu.model.dto;

import ch.qos.logback.core.model.INamedModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CategoryDTO {

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
}
