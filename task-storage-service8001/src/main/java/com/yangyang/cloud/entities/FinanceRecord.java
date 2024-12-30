package com.yangyang.cloud.entities;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("finance_record")
public class FinanceRecord {

    @TableId(type = IdType.AUTO)
    private Long id;  // 主键

    private Long userId;              // 用户ID（外键）
    private String type;              // 记录类型（收入、支出）
    private Double amount;            // 金额
    private String category;          // 财务分类（如餐饮、交通等）
    private String note;              // 备注
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime transactionDate;  // 交易日期



    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;  // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;  // 更新时间

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;  // 逻辑删除字段
}
