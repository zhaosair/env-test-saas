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
@TableName("t_employee")
@ApiModel(value="Employee对象", description="")
public class Employee extends Model<Employee> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "员工名称")
      private String name;

      @ApiModelProperty(value = "公司id")
      private Integer companyId;

    
    public Long getId() {
        return id;
    }

      public Employee setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public Employee setName(String name) {
          this.name = name;
          return this;
      }
    
    public Integer getCompanyId() {
        return companyId;
    }

      public Employee setCompanyId(Integer companyId) {
          this.companyId = companyId;
          return this;
      }

      public static final String ID = "id";

      public static final String NAME = "name";

      public static final String COMPANY_ID = "company_id";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "Employee{" +
              "id=" + id +
                  ", name=" + name +
                  ", companyId=" + companyId +
              "}";
    }
}
