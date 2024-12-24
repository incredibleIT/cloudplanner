package com.yangyang.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangyang.cloud.entities.FinanceRecord;
import com.yangyang.cloud.mapper.FinanceRecordMapper;
import com.yangyang.cloud.service.FinanceRecordService;
import org.springframework.stereotype.Service;


@Service
public class FinanceRecordServiceImpl extends ServiceImpl<FinanceRecordMapper, FinanceRecord> implements FinanceRecordService {
}