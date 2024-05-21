package com.zhangyaos.dataannotation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

/**
 * (Datasets)表实体类
 *
 * @author makejava
 * @since 2023-09-22 16:12:38
 */
@Data
public class Datasets extends Model<Datasets> {

    @TableId(type = IdType.AUTO)
    @JsonProperty("data_id")
    private int dataId;

    @JsonProperty("violated_code")
    private String violatedCode;

    @JsonProperty("generated_patch")
    private String generatedPatch;

    @JsonProperty("real_patch")
    private String realPatch;

    private String rule;
    //项目链接
    private String link;
    //项目版本号
    private String version;

    @JsonProperty("project")
    private String project;


    private String file;
    @JsonProperty("start_line")
    private String startLine;

    @JsonProperty("end_line")
    private String endLine;

    private String line;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.dataId;
    }
}

