package com.zhangyaos.dataannotation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangyaos.dataannotation.dao.ProjectDao;
import com.zhangyaos.dataannotation.entity.Project;
import com.zhangyaos.dataannotation.service.ProjectService;
import org.springframework.stereotype.Service;

/**
 * (Project)表服务实现类
 *
 * @author makejava
 * @since 2023-09-22 16:12:39
 */
@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, Project> implements ProjectService {

}

