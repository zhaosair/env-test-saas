package com.jfeat.module.onemary_teacher.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.onemary_teacher.services.gen.persistence.model.Classroom;
import com.jfeat.module.onemary_teacher.services.gen.persistence.dao.ClassroomMapper;
import com.jfeat.module.onemary_teacher.services.gen.persistence.dao.StudentMapper;
import com.jfeat.module.onemary_teacher.services.gen.persistence.model.Student;
    
    import com.jfeat.module.onemary_teacher.services.gen.persistence.dao.TeacherMapper;
import com.jfeat.module.onemary_teacher.services.gen.persistence.model.Teacher;
    
    import com.jfeat.module.onemary_teacher.services.gen.crud.service.CRUDClassroomOverModelService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOverModelImpl;
import com.jfeat.module.onemary_teacher.services.gen.crud.model.ClassroomModel;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDClassroomOverModelService
 * @author Code generator
 * @since 2022-06-07
 */

@Service
public class CRUDClassroomOverModelServiceImpl  extends CRUDServiceOverModelImpl<Classroom,ClassroomModel> implements CRUDClassroomOverModelService {









    @Resource
    protected ClassroomMapper classroomMapper;

    
    @Override
    protected BaseMapper<Classroom> getMasterMapper() {
        return classroomMapper;
    }

    @Override
    protected Class<Classroom> masterClassName() {
        return Classroom.class;
    }

    @Override
    protected Class<ClassroomModel> modelClassName() {
        return ClassroomModel.class;
    }



    
    @Resource
    private StudentMapper studentMapper;

                        private final static String studentFieldName = "classroom_id";
    
    
                private final static String studentKeyName = "students";
    
                        
    

    
    
    @Resource
    private TeacherMapper teacherMapper;

                        private final static String teacherFieldName = "classroom_id";
    
    
                private final static String teacherKeyName = "teachers";
    
                        
    

    
    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                                             studentKeyName
                                                                 ,teacherKeyName
                            };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {

        
                                                
            if (field.compareTo(studentKeyName) == 0) {
                FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(studentFieldName);
            _field.setItemClassName(Student.class);
            _field.setItemMapper(studentMapper);
            
            return _field;
        }


            
                                                
            else if (field.compareTo(teacherKeyName) == 0) {
                FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(teacherFieldName);
            _field.setItemClassName(Teacher.class);
            _field.setItemMapper(teacherMapper);
            
            return _field;
        }


            
        throw new BusinessException(BusinessCode.BadRequest);
    }


    @Override
    protected String[] childFieldNames() {
        return new String[]{
                                };
    }

    @Override
    protected FIELD onChildFieldItem(String field) {
                
        throw new BusinessException(BusinessCode.BadRequest);
    }




}


