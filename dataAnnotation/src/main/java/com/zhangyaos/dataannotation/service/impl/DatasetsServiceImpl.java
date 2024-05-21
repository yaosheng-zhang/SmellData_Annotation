package com.zhangyaos.dataannotation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangyaos.dataannotation.dao.DatasetsDao;
import com.zhangyaos.dataannotation.entity.Datasets;
import com.zhangyaos.dataannotation.service.DatasetsService;
import org.springframework.stereotype.Service;

/**
 * (Datasets)表服务实现类
 *
 * @author makejava
 * @since 2023-09-22 16:12:38
 */
@Service("datasetsService")
public class DatasetsServiceImpl extends ServiceImpl<DatasetsDao, Datasets> implements DatasetsService {

}

