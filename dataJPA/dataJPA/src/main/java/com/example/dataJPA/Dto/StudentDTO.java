package com.example.dataJPA.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    //DTO is a class that contains only the data you want to receive or send, while
    // Entity represents the full database table.
    //think like in college it require all details like fathers occupation
    // name but in admission form it only require name for this DTO used

    private Integer id;
    private String name;
    private String tech;
    private String gender;
    private String email;


}
