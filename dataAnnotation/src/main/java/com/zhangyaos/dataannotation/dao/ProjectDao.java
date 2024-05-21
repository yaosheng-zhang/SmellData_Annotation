package com.zhangyaos.dataannotation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangyaos.dataannotation.entity.Project;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Project)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-22 16:12:38
 */
@Mapper
public interface ProjectDao extends BaseMapper<Project> {

}

