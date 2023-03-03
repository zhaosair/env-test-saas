
package com.jfeat.module.saas.api;


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
import com.jfeat.module.saas.services.domain.dao.QueryTestSaasEntityDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.module.saas.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import com.jfeat.module.saas.services.domain.service.*;
import com.jfeat.module.saas.services.domain.model.TestSaasEntityRecord;
import com.jfeat.module.saas.services.gen.persistence.model.TestSaasEntity;

    import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  api
 * </p>
 *
 * @author Code generator
 * @since 2022-06-07
 */
    @RestController
    @Api("TestSaasEntity")
    @RequestMapping("/api/crud/t_test_saas_entity/testSaasEntity/testSaasEntityies")
    public class TestSaasEntityEndpoint {

    @Resource
    TestSaasEntityService testSaasEntityService;

    @Resource
    QueryTestSaasEntityDao queryTestSaasEntityDao;



    @BusinessLog(name = "TestSaasEntity", value = "create TestSaasEntity")
    @Permission(TestSaasEntityPermission.TESTSAASENTITY_NEW)
    @PostMapping
    @ApiOperation(value = "新建 TestSaasEntity",response = TestSaasEntity.class)
    public Tip createTestSaasEntity(@RequestBody TestSaasEntity entity){
        Integer affected=0;
        try{
                affected= testSaasEntityService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @Permission(TestSaasEntityPermission.TESTSAASENTITY_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 TestSaasEntity",response = TestSaasEntity.class)
    public Tip getTestSaasEntity(@PathVariable Long id){
                        return SuccessTip.create(testSaasEntityService.queryMasterModel(queryTestSaasEntityDao, id));
            }

    @BusinessLog(name = "TestSaasEntity", value = "update TestSaasEntity")
    @Permission(TestSaasEntityPermission.TESTSAASENTITY_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 TestSaasEntity",response = TestSaasEntity.class)
    public Tip updateTestSaasEntity(@PathVariable Long id,@RequestBody TestSaasEntity entity){
        entity.setId(id);
                return SuccessTip.create(testSaasEntityService.updateMaster(entity));
            }

    @BusinessLog(name = "TestSaasEntity", value = "delete TestSaasEntity")
    @Permission(TestSaasEntityPermission.TESTSAASENTITY_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 TestSaasEntity")
    public Tip deleteTestSaasEntity(@PathVariable Long id){
            return SuccessTip.create(testSaasEntityService.deleteMaster(id));
        }

    @Permission(TestSaasEntityPermission.TESTSAASENTITY_VIEW)
    @ApiOperation(value = "TestSaasEntity 列表信息",response = TestSaasEntityRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                    @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "orgId", dataType = "Long"),
                                                                                    @ApiImplicitParam(name = "status", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "createTime", dataType = "Date") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryTestSaasEntityPage(Page<TestSaasEntityRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                            @RequestParam(name = "name", required = false) String name,
                    
                                                                                                                        @RequestParam(name = "orgId", required = false) Long orgId,
                    
                                                                                                                            @RequestParam(name = "status", required = false) String status,
                    
                                                                                                                    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
                                                @RequestParam(name = "createTime", required = false) Date createTime,
        @RequestParam(name = "orderBy", required = false) String orderBy,
        @RequestParam(name = "sort", required = false)  String sort) {
                    
            if(orderBy!=null&&orderBy.length()>0){
        if(sort!=null&&sort.length()>0){
        String sortPattern = "(ASC|DESC|asc|desc)";
        if(!sort.matches(sortPattern)){
        throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
        }
        }else{
        sort = "ASC";
        }
        orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

    TestSaasEntityRecord record = new TestSaasEntityRecord();
                                                                                                                                                                                        record.setName(name);
                                                                                                            if (META.enabledSaas()) {
                record.setOrgId(JWTKit.getOrgId());
            }
                                                                                                    record.setStatus(status);
                                                                                                                        record.setCreateTime(createTime);
                        
                                

    List<TestSaasEntityRecord> testSaasEntityPage = queryTestSaasEntityDao.findTestSaasEntityPage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(testSaasEntityPage);

        return SuccessTip.create(page);
    }
}

