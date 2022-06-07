package com.jfeat.module.saas.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
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
@TableName("t_test_saas_entity")
@ApiModel(value="TestSaasEntity对象", description="")
public class TestSaasEntity extends Model<TestSaasEntity> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "测试名称")
      private String name;

      @ApiModelProperty(value = "所属组织")
      private Long orgId;

      @ApiModelProperty(value = "状态")
      private String status;

      @ApiModelProperty(value = "创建时间")
      private Date createTime;

    
    public Long getId() {
        return id;
    }

      public TestSaasEntity setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public TestSaasEntity setName(String name) {
          this.name = name;
          return this;
      }
    
    public Long getOrgId() {
        return orgId;
    }

      public TestSaasEntity setOrgId(Long orgId) {
          this.orgId = orgId;
          return this;
      }
    
    public String getStatus() {
        return status;
    }

      public TestSaasEntity setStatus(String status) {
          this.status = status;
          return this;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public TestSaasEntity setCreateTime(Date createTime) {
          this.createTime = createTime;
          return this;
      }

      public static final String ID = "id";

      public static final String NAME = "name";

      public static final String ORG_ID = "org_id";

      public static final String STATUS = "status";

      public static final String CREATE_TIME = "create_time";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "TestSaasEntity{" +
              "id=" + id +
                  ", name=" + name +
                  ", orgId=" + orgId +
                  ", status=" + status +
                  ", createTime=" + createTime +
              "}";
    }
}
