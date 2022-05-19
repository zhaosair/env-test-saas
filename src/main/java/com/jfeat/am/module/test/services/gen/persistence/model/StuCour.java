package com.jfeat.am.module.test.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2022-05-18
 */
@TableName("t_stu_cour")
@ApiModel(value="StuCour对象", description="")
public class StuCour extends Model<StuCour> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer stuId;

    private Integer courId;

    
    public Integer getId() {
        return id;
    }

      public StuCour setId(Integer id) {
          this.id = id;
          return this;
      }
    
    public Integer getStuId() {
        return stuId;
    }

      public StuCour setStuId(Integer stuId) {
          this.stuId = stuId;
          return this;
      }
    
    public Integer getCourId() {
        return courId;
    }

      public StuCour setCourId(Integer courId) {
          this.courId = courId;
          return this;
      }

      public static final String ID = "id";

      public static final String STU_ID = "stu_id";

      public static final String COUR_ID = "cour_id";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "StuCour{" +
              "id=" + id +
                  ", stuId=" + stuId +
                  ", courId=" + courId +
              "}";
    }
}
