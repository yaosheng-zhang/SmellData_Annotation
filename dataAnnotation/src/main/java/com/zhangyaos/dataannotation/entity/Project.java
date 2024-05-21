package com.zhangyaos.dataannotation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * (Project)表实体类
 *
 * @author makejava
 * @since 2023-09-22 16:12:38
 */
@Data
public class Project extends Model<Project> {
    //主键
    @TableId(type= IdType.AUTO)
    private String projectId;
    //项目名称
    private String project;


    //已标记数量
    private Integer markedNum;
    //总数量
    private Integer totalNum;



    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.projectId;
    }
}

