package com.yangyang.cloud.entities;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("task")
public class Task {

    @TableId(type = IdType.AUTO)
    private Integer id;  // 主键

    private Integer userId;          // 用户ID（外键）
    private String title;         // 任务标题
    private String description;   // 任务描述
    private Integer priority;     // 任务优先级
    private String category;      // 任务分类（工作、生活等）
    private LocalDateTime dueDate;    // 截止日期
    private LocalDateTime reminderTime;   // 提醒时间
    private String status;        // 任务状态（待办、进行中、已完成）

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;  // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;  // 更新时间

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;  // 逻辑删除字段
}
