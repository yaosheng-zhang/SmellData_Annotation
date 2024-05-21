package com.zhangyaos.dataannotation.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangyaos.dataannotation.entity.Datasets;
import com.zhangyaos.dataannotation.entity.Project;
import com.zhangyaos.dataannotation.service.DatasetsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Datasets)表控制层
 *
 * @author makejava
 * @since 2023-09-22 16:12:38
 */
//@Api(tags = "数据集Api")
@CrossOrigin
@RestController
@RequestMapping("datasets")
public class DatasetsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DatasetsService datasetsService;





    /**
     * 分页查询所有数据
     *
     * @param page     分页对象

     * @return 所有数据
     */
    @GetMapping
//    @ApiOperation(value = "分页获取数据信息")
    public R selectAll(Page<Datasets> page,@RequestParam(required = false)  Boolean isMasked) {
        QueryWrapper<Datasets> queryWrapper = new QueryWrapper<>();
        //masked
        if (isMasked!=null){
            if (isMasked)
            {
                queryWrapper.isNotNull("real_patch").and(wrapper -> wrapper.ne("real_patch", ""));
            }else {
                queryWrapper.isNull("real_patch").or().eq("real_patch", "");
            }
        }


        return success(this.datasetsService.page(page,queryWrapper));

    }
    @GetMapping("/all")
    public R getAll() {
        return success(this.datasetsService.list());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
//    @ApiOperation(value = "id查询数据信息")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.datasetsService.getById(id));
    }

    /**
     *  通过keyword进行模糊查询
     *
     */
    @GetMapping("/search")
    public R queryByCondition(@RequestParam("keyword") String keyword) {
        QueryWrapper<Datasets> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("rule", keyword)
                .or()
                .like("project", keyword);

        return success(this.datasetsService.list(queryWrapper));
    }



    /**
     * 新增数据
     *
     * @param datasets 实体对象
     * @return 新增结果
     */
    @PostMapping
//    @ApiOperation(value = "新增数据")
    public R insert(@RequestBody Datasets datasets) {
        return success(this.datasetsService.save(datasets));
    }

    /**
     * 修改数据
     *
     * @param datasets 实体对象
     * @return 修改结果
     */
    @PutMapping
//    @ApiOperation(value = "修改数据")
    public R update(@RequestBody Datasets datasets) {
        return success(this.datasetsService.updateById(datasets));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
//    @ApiOperation(value = "删除数据")
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.datasetsService.removeByIds(idList));
    }

    /**
     * 上传标注数据
     *
     * @param file     上传文件
     * @return 所有数据
     */
    @PostMapping("/upload")
//    @ApiOperation(value = "上传文件")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // 读取上传的 JSON 文件
            byte[] bytes = file.getBytes();
            String jsonData = new String(bytes);

            // 将 JSON 数据解析为对象数组
            ObjectMapper objectMapper = new ObjectMapper();
            Datasets[] codeInfoArray = objectMapper.readValue(jsonData, Datasets[].class);

            this.datasetsService.saveBatch(Arrays.stream(codeInfoArray).collect(Collectors.toList()));

            return ResponseEntity.ok("Data imported successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing data.");
        }
    }
}

