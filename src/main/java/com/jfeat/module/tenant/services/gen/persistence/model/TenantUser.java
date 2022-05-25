package com.jfeat.module.tenant.services.gen.persistence.model;

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
 * @since 2022-05-24
 */
@TableName("t_tenant_user")
@ApiModel(value="TenantUser对象", description="")
public class TenantUser extends Model<TenantUser> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "用户名")
      private String name;

      @ApiModelProperty(value = "入住时间时间")
      private Date checkIn;

      @ApiModelProperty(value = "入住天数")
      private Integer occupancyDays;

      @ApiModelProperty(value = "入住房间")
      private String roomNumber;

      @ApiModelProperty(value = "数据隔离级别")
      private Long orgId;

    
    public Long getId() {
        return id;
    }

      public TenantUser setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public TenantUser setName(String name) {
          this.name = name;
          return this;
      }
    
    public Date getCheckIn() {
        return checkIn;
    }

      public TenantUser setCheckIn(Date checkIn) {
          this.checkIn = checkIn;
          return this;
      }
    
    public Integer getOccupancyDays() {
        return occupancyDays;
    }

      public TenantUser setOccupancyDays(Integer occupancyDays) {
          this.occupancyDays = occupancyDays;
          return this;
      }
    
    public String getRoomNumber() {
        return roomNumber;
    }

      public TenantUser setRoomNumber(String roomNumber) {
          this.roomNumber = roomNumber;
          return this;
      }
    
    public Long getOrgId() {
        return orgId;
    }

      public TenantUser setOrgId(Long orgId) {
          this.orgId = orgId;
          return this;
      }

      public static final String ID = "id";

      public static final String NAME = "name";

      public static final String CHECK_IN = "check_in";

      public static final String OCCUPANCY_DAYS = "occupancy_days";

      public static final String ROOM_NUMBER = "room_number";

      public static final String ORG_ID = "org_id";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "TenantUser{" +
              "id=" + id +
                  ", name=" + name +
                  ", checkIn=" + checkIn +
                  ", occupancyDays=" + occupancyDays +
                  ", roomNumber=" + roomNumber +
                  ", orgId=" + orgId +
              "}";
    }
}
