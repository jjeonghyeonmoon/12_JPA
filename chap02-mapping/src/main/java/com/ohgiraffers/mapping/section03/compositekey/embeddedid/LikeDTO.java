package com.ohgiraffers.mapping.section03.compositekey.embeddedid;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LikeDTO {

    private int likedMemberNo;
    private int likedBookNo;
}
