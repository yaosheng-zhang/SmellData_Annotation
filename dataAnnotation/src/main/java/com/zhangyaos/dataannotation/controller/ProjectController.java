package com.zhangyaos.dataannotation.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangyaos.dataannotation.entity.Project;
import com.zhangyaos.dataannotation.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Project)表控制层
 *
 * @author makejava
 * @since 2023-09-22 16:12:38
 */
//@Api(tags = "数据集项目Api")
@CrossOrigin
@RestController
@RequestMapping("project")
public class ProjectController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectService projectService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param project 查询实体
     * @return 所有数据
     */
//    @ApiOperation(value = "分页获取项目信息")
    @GetMapping
    public R selectAll(Page<Project> page, Project project) {
        return success(this.projectService.page(page, new QueryWrapper<>(project)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
//    @ApiOperation(value = "根据id获取项目信息")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.projectService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param project 实体对象
     * @return 新增结果
     */
    @PostMapping
//    @ApiOperation(value = "新增项目")
    public R insert(@RequestBody Project project) {
        return success(this.projectService.save(project));
    }

    /**
     * 修改数据
     *
     * @param project 实体对象
     * @return 修改结果
     */
    @PutMapping
//    @ApiOperation(value = "修改项目信息")
    public R update(@RequestBody Project project) {
        return success(this.projectService.updateById(project));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.projectService.removeByIds(idList));
    }
}

