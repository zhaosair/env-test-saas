package com.jfeat.am.module.test.services.domain.service.impl;
import com.jfeat.am.module.test.services.domain.service.ClassroomOverModelService;
import com.jfeat.am.module.test.services.gen.crud.service.impl.CRUDClassroomOverModelServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("classroomService")
public class ClassroomOverModelServiceImpl extends CRUDClassroomOverModelServiceImpl implements ClassroomOverModelService {

    @Override
    protected String entityName() {
        return "Classroom";
    }


                            }
