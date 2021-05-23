package com.limbo.practice.core.base;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * BaseController 基础Controller
 *
 * @author : limbo
 * @date : 2020/6/4
 */
public class BaseController<T extends BaseBO, D> {

    protected BaseService<T, D> service;

    public void setService(BaseService<T, D> service) {
        this.service = service;
    }

    @GetMapping("/list")
    @ApiOperation("获取集合")
    @ResponseBody
    public PageTableBean queryList(T vo) {
        return service.queryList(vo);
    }

    @PostMapping("/insert")
    @ApiOperation("新增")
    @ResponseBody
    public Long postData(T data){
        return service.insertDb(data);
    }

    @PutMapping("/save")
    @ApiOperation("保存")
    @ResponseBody
    public ResultBean putData(T data){
        ResultBean resultBean = service.save(data);
        return resultBean;
    }

    @PatchMapping("/saveActive")
    @ApiOperation("局部更新")
    @ResponseBody
    public ResultBean patchData(T data){
        ResultBean resultBean = service.saveActive(data);
        return resultBean;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    @ResponseBody
    public ResultBean delete(@ApiParam("删除id") @PathVariable("id") Long id){
        return service.delete(id);
    }
}
