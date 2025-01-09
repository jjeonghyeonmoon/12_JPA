package com.ohgiraffers.associationmapping.section01.manytoone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToOneTests {

    @Autowired
    private ManyToOneService service;

    /* title. 연관관계 매핑*/

    /* comment.
    *   Entity 클래스 간의 관계 == 연관성을 매핑하는 것을 의미한다.
    *   이를 통해서 객체를 이용한 DB 테이블 간 관계를 매핑할 수 있다.
    *   */

    /* comment.
    *   다중성에 의한 분류
    *   : 연관 관계가 있는 객체 관계에서 실제로 연관을 가지는
    *   객체의 수에 따라 분류된다.
    *   - 1:1 (OneToOne)
    *   - 1:N (OneOToMany)
    *   - N:1 (ManyToOne)
    *   - N:M (ManyToMany)
    * */

    /* comment.
    *   ManyToOne 은 다수의 엔티티(메뉴) 가 하나의 엔티티(카테고리)
    *   를 참조하는 상황에서 사용이 된다.
    *   예를 들자면 하나의 카테고리가 여러 개의 메뉴를 가질 수 있는
    *   상황에서 메뉴가 카테고리를 참조하는 것이다.
    *   따라서 이 때 Menu 가 Many, Category 가 One 이 된다.
    * */

    /* comment.
    *   이렇게 연관관계를 형성 된 엔티티를 조회하는 방법
    *   1. 객체 그래프탐색(객체 연관 관계를 사용한 조회)
    *   2. 객체 지향 쿼티(JPQL) 사용이 있다.
    * */

    @DisplayName("N:1 관계의 객체 그래프 탐색을 이용한 조회")
    @Test
    void manyToOneFind(){
        // 테스트용 값
        int menuCode = 10;

        Menu foundMenu = service.findMenu(menuCode);


    }

}
