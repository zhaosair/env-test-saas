package com.jfeat.am.module.test.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.common.annotation.BusinessLog;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.module.test.services.domain.dao.QueryTestSaasEntityDao;
import com.jfeat.am.module.test.services.domain.model.TestSaasEntityRecord;
import com.jfeat.am.module.test.services.domain.service.TestSaasEntityService;
import com.jfeat.am.module.test.services.gen.persistence.model.TestSaasEntity;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-02-13
 */
@RestController

@Api(value = "/api/crud/testsaas/entities")
@RequestMapping("/api/crud/testsaas/entities")
public class TestSaasEntityEndpoint {

    @Resource
    TestSaasEntityService testSaasEntityService;

    @Resource
    QueryTestSaasEntityDao queryTestSaasEntityDao;

    @BusinessLog(name = "测试", value = "新建 TestSaasEntity")
    @ApiOperation(value = "新建 TestSaasEntity", response = TestSaasEntity.class)
    @Permission(TestSaasPermission.PERM_ADD)
    @PostMapping
    public Tip createTestSaasEntity(@RequestBody TestSaasEntity entity) {

        Integer affected = 0;
        try {
            affected = testSaasEntityService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "测试", value = "查看 TestSaasEntity")
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 TestSaasEntity", response = TestSaasEntity.class)
    @Permission(TestSaasPermission.PERM_VIEW)
    public Tip getTestSaasEntity(@PathVariable Long id) {
        return SuccessTip.create(testSaasEntityService.retrieveMaster(id));
    }

    @BusinessLog(name = "测试", value = "修改 TestSaasEntity")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 TestSaasEntity", response = TestSaasEntity.class)
    @Permission(TestSaasPermission.PERM_EDIT)
    public Tip updateTestSaasEntity(@PathVariable Long id, @RequestBody TestSaasEntity entity) {
        entity.setId(id);
        return SuccessTip.create(testSaasEntityService.updateMaster(entity));
    }

    @BusinessLog(name = "测试", value = "删除 TestSaasEntity")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 TestSaasEntity")
    @Permission(TestSaasPermission.PERM_DELETE)
    public Tip deleteTestSaasEntity(@PathVariable Long id) {
        return SuccessTip.create(testSaasEntityService.deleteMaster(id));
    }

    @BusinessLog(name = "测试", value = "TestSaasEntity 列表信息")
    @ApiOperation(value = "TestSaasEntity 列表信息", response = TestSaasEntityRecord.class)
    @GetMapping
    @Permission(TestSaasPermission.PERM_VIEW)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "orgId", dataType = "Long"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "createdTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryTestSaasEntities(Page<TestSaasEntityRecord> page,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "search", required = false) String search,
                                     @RequestParam(name = "id", required = false) Long id,
                                     @RequestParam(name = "name", required = false) String name,
                                     @RequestParam(name = "orgId", required = false) Long orgId,
                                     @RequestParam(name = "status", required = false) String status,
                                     @RequestParam(name = "createdTime", required = false) Date createdTime,
                                     @RequestParam(name = "orderBy", required = false) String orderBy,
                                     @RequestParam(name = "sort", required = false) String sort) {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        TestSaasEntityRecord record = new TestSaasEntityRecord();
        record.setId(id);
        record.setName(name);
        record.setOrgId(orgId);
        record.setStatus(status);
        record.setCreateTime(createdTime);
        page.setRecords(queryTestSaasEntityDao.findTestSaasEntityPage(page, record, search, orderBy));

        return SuccessTip.create(page);
    }
}
