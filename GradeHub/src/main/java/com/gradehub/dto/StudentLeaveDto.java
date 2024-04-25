package com.gradehub.dto;


import com.gradehub.enums.StudentLeaveStatus;
import lombok.Data;

import java.util.Date;

@Data
public class StudentLeaveDto {
    private Long id;
    private String subject;
    private String body;
    private Date date;

    private StudentLeaveStatus studentLeaveStatus;

    private Long userid;
}
