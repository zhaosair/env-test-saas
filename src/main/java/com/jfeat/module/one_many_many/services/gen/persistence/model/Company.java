package com.jfeat.module.one_many_many.services.gen.persistence.model;

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
 * @since 2022-06-07
 */
@TableName("t_company")
@ApiModel(value="Company对象", description="")
public class Company extends Model<Company> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "公司名称")
      private String name;

    
    public Long getId() {
        return id;
    }

      public Company setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public Company setName(String name) {
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
        return "Company{" +
              "id=" + id +
                  ", name=" + name +
              "}";
    }
}
