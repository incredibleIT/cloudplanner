package com.yangyang.cloud.entities;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class TaskDto {
    private Integer id;
    private String title;         // 任务标题
    private String description;   // 任务描述
    private Integer priority;     // 任务优先级
    private String category;      // 任务分类（工作、生活等）
    private LocalDateTime dueDate;    // 截止日期
    private LocalDateTime reminderTime;   // 提醒时间
    private String status;        // 任务状态（待办、进行中、已完成）
}
