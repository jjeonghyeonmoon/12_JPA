package com.ohgiraffers.associationmapping.section01.manytoone;

import lombok.*;

import javax.naming.ldap.PagedResultsControl;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDTO {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private CategoryDTO category;
    private String orderableStatus;
}
