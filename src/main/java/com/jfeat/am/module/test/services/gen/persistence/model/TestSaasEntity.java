package com.jfeat.am.module.test.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2019-02-13
 */
@TableName("t_test_saas_entity")
public class TestSaasEntity extends Model<TestSaasEntity> {

    @TableField(exist = false)
    private com.alibaba.fastjson.JSONObject extra;

    public com.alibaba.fastjson.JSONObject getExtra() {
        return extra;
    }
    public void setExtra(com.alibaba.fastjson.JSONObject extra) {
        this.extra = extra;
    }


    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 测试名称
     */
	private String name;
    /**
     */
	@TableField("org_id")
	private Long orgId;
    /**
     */
	private String status;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@TableField("create_time")
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

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
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
