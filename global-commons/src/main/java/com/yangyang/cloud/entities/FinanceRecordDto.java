package com.yangyang.cloud.entities;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class FinanceRecordDto {

    private Long id;  // 主键
    private Long userId;
    private String type;              // 记录类型（收入、支出）
    private Double amount;            // 金额
    private String category;          // 财务分类（如餐饮、交通等）
    private String note;              // 备注
    private LocalDateTime transactionDate;  // 交易日期
}
