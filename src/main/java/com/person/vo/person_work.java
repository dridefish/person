package com.person.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class person_work {
    private String WorkID;
    private String PersonId;
    private String StartDate;
    private String EndDate;
    private String Post;
    private String Desc;

}
