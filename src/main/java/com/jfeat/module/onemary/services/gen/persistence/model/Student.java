package com.jfeat.module.onemary.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2022-05-23
 */
@TableName("t_student")
@ApiModel(value="Student对象", description="")
public class Student extends Model<Student> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String name;

    private Integer classroomId;

    private String address;

    @TableField(exist = false)
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

      public Student setId(Integer id) {
          this.id = id;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public Student setName(String name) {
          this.name = name;
          return this;
      }
    
    public Integer getClassroomId() {
        return classroomId;
    }

      public Student setClassroomId(Integer classroomId) {
          this.classroomId = classroomId;
          return this;
      }
    
    public String getAddress() {
        return address;
    }

      public Student setAddress(String address) {
          this.address = address;
          return this;
      }

      public static final String ID = "id";

      public static final String NAME = "name";

      public static final String CLASSROOM_ID = "classroom_id";

      public static final String ADDRESS = "address";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "Student{" +
              "id=" + id +
                  ", name=" + name +
                  ", classroomId=" + classroomId +
                  ", address=" + address +
              "}";
    }
}
