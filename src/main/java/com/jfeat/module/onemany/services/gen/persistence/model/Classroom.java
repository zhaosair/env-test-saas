package com.jfeat.module.onemany.services.gen.persistence.model;

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
 * @since 2022-05-22
 */
@TableName("t_classroom")
@ApiModel(value="Classroom对象", description="")
public class Classroom extends Model<Classroom> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String name;

    
    public Long getId() {
        return id;
    }

      public Classroom setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public Classroom setName(String name) {
          this.name = name;
          return this;
      }

      public static final String ID = "id";

      public static final String NAME = "name";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "Classroom{" +
              "id=" + id +
                  ", name=" + name +
              "}";
    }
}
