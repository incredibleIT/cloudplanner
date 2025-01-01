package com.yangyang.cloud.entities;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
public class Category {

    @TableId(type = IdType.AUTO)
    private Long id;  // 主键

    private Long userId;              // 用户ID（外键）
    private String type;              // 分类类型（任务、财务）
    private String name;              // 分类名称（如工作、娱乐、餐饮等）

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;  // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;  // 更新时间

    @TableLogic
    private Integer deleted;  // 逻辑删除字段
}
