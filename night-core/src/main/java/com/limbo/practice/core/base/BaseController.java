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

    @PostMapping("/post")
    @ApiOperation("创建资源")
    public void postData(){

    }

    @PutMapping("/put")
    @ApiOperation("更新资源")
    public void putData(){

    }

    @PatchMapping("/patch")
    @ApiOperation("局部更新数据")
    @ResponseBody
    public ResultBean patchData(T bean){
        return new ResultBean();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    @ResponseBody
    public ResultBean delete(@ApiParam("删除id") @PathVariable("id") Long id){
        return service.delete(id);
    }
}
