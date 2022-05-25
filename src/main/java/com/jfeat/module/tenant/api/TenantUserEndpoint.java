
package com.jfeat.module.tenant.api;


import com.jfeat.crud.plus.META;
import com.jfeat.am.core.jwt.JWTKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.module.tenant.services.domain.dao.QueryTenantUserDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import com.jfeat.module.tenant.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import java.math.BigDecimal;

import com.jfeat.module.tenant.services.domain.service.*;
import com.jfeat.module.tenant.services.domain.model.TenantUserRecord;
import com.jfeat.module.tenant.services.gen.persistence.model.TenantUser;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code generator
 * @since 2022-05-24
 */
@RestController
@Api("TenantUser")
@RequestMapping("/api/crud/tenant/tenantUser/tenantUsers")
public class TenantUserEndpoint {

    @Resource
    TenantUserService tenantUserService;

    @Resource
    QueryTenantUserDao queryTenantUserDao;


    @BusinessLog(name = "TenantUser", value = "create TenantUser")
    @Permission(TenantUserPermission.TENANTUSER_NEW)
    @PostMapping
    @ApiOperation(value = "新建 TenantUser", response = TenantUser.class)
    public Tip createTenantUser(@RequestBody TenantUser entity) {
        Integer affected = 0;
        try {
            affected = tenantUserService.createMaster(entity);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @Permission(TenantUserPermission.TENANTUSER_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 TenantUser", response = TenantUser.class)
    public Tip getTenantUser(@PathVariable Long id) {
        return SuccessTip.create(tenantUserService.queryMasterModel(queryTenantUserDao, id));
    }

    @BusinessLog(name = "TenantUser", value = "update TenantUser")
    @Permission(TenantUserPermission.TENANTUSER_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 TenantUser", response = TenantUser.class)
    public Tip updateTenantUser(@PathVariable Long id, @RequestBody TenantUser entity) {
        entity.setId(id);
        return SuccessTip.create(tenantUserService.updateMaster(entity));
    }

    @BusinessLog(name = "TenantUser", value = "delete TenantUser")
    @Permission(TenantUserPermission.TENANTUSER_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 TenantUser")
    public Tip deleteTenantUser(@PathVariable Long id) {
        return SuccessTip.create(tenantUserService.deleteMaster(id));
    }

    @Permission(TenantUserPermission.TENANTUSER_VIEW)
    @ApiOperation(value = "TenantUser 列表信息", response = TenantUserRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "checkIn", dataType = "Date"),
            @ApiImplicitParam(name = "occupancyDays", dataType = "Integer"),
            @ApiImplicitParam(name = "roomNumber", dataType = "String"),
            @ApiImplicitParam(name = "orgId", dataType = "Long"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryTenantUserPage(Page<TenantUserRecord> page,
                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   // for tag feature query
                                   @RequestParam(name = "tag", required = false) String tag,
                                   // end tag
                                   @RequestParam(name = "search", required = false) String search,

                                   @RequestParam(name = "name", required = false) String name,

                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                   @RequestParam(name = "checkIn", required = false) Date checkIn,

                                   @RequestParam(name = "occupancyDays", required = false) Integer occupancyDays,

                                   @RequestParam(name = "roomNumber", required = false) String roomNumber,

                                   @RequestParam(name = "orgId", required = false) Long orgId,
                                   @RequestParam(name = "orderBy", required = false) String orderBy,
                                   @RequestParam(name = "sort", required = false) String sort) {

        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String sortPattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(sortPattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        TenantUserRecord record = new TenantUserRecord();
        record.setName(name);
        record.setCheckIn(checkIn);
        record.setOccupancyDays(occupancyDays);
        record.setRoomNumber(roomNumber);
        record.setOrgId(JWTKit.getOrgId());
        System.out.println(JWTKit.getOrgId());
//        if (META.enabledSaas()) {
//            record.setOrgId(JWTKit.getOrgId());
//        }

        List<TenantUserRecord> tenantUserPage = queryTenantUserDao.findTenantUserPage(page, record, tag, search, orderBy, null, null);

        page.setRecords(tenantUserPage);

        return SuccessTip.create(page);
    }
}

