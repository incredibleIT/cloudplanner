package com.yangyang.cloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yangyang.cloud.entities.FinanceRecord;
import com.yangyang.cloud.entities.FinanceRecordDto;
import com.yangyang.cloud.response.ResultData;
import com.yangyang.cloud.service.FinanceRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finace")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class FinanceRecordController {

    @Autowired
    private FinanceRecordService financeRecordService;

    @GetMapping("/list")
    public ResultData<List<FinanceRecord>> list(@RequestHeader("userid") String userId) {

        LambdaQueryWrapper<FinanceRecord> w = new LambdaQueryWrapper<>();

        w.eq(FinanceRecord::getUserId, userId);

        System.out.println("FinanceRecord userid: " + userId);
        System.out.println("FinanceRecord list: " + financeRecordService.list(w));

        return ResultData.success(financeRecordService.list(w));
    }

    @PostMapping("/add")
    public ResultData<String> add(@RequestBody FinanceRecordDto financeRecordDto) {

        System.out.println("financeRecord: " + financeRecordDto.getTransactionDate());
        FinanceRecord financeRecord = new FinanceRecord();
        BeanUtils.copyProperties(financeRecordDto, financeRecord);

        financeRecordService.save(financeRecord);

        return ResultData.success("存储成功");
    }


    @PutMapping("/update")
    public ResultData<String> update(@RequestBody FinanceRecordDto financeRecordDto) {
        System.out.println(financeRecordDto);

        FinanceRecord financeRecord = new FinanceRecord();

        BeanUtils.copyProperties(financeRecordDto, financeRecord);

        financeRecordService.updateById(financeRecord);

        return ResultData.success("更改成功");
    }


    @DeleteMapping("/del/{id}")
    public ResultData<String> del(@PathVariable("id") Integer id) {

        System.out.println(id);

        financeRecordService.removeById(id);

        return ResultData.success("删除成功");
    }
}