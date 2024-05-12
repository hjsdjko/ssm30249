package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.NongchanpinjianduEntity;
import com.entity.view.NongchanpinjianduView;

import com.service.NongchanpinjianduService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 农产品监督
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 21:27:50
 */
@RestController
@RequestMapping("/nongchanpinjiandu")
public class NongchanpinjianduController {
    @Autowired
    private NongchanpinjianduService nongchanpinjianduService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanpinjianduEntity nongchanpinjiandu, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			nongchanpinjiandu.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NongchanpinjianduEntity> ew = new EntityWrapper<NongchanpinjianduEntity>();


		PageUtils page = nongchanpinjianduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinjiandu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongchanpinjianduEntity nongchanpinjiandu, 
		HttpServletRequest request){
        EntityWrapper<NongchanpinjianduEntity> ew = new EntityWrapper<NongchanpinjianduEntity>();

		PageUtils page = nongchanpinjianduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinjiandu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanpinjianduEntity nongchanpinjiandu){
       	EntityWrapper<NongchanpinjianduEntity> ew = new EntityWrapper<NongchanpinjianduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanpinjiandu, "nongchanpinjiandu")); 
        return R.ok().put("data", nongchanpinjianduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanpinjianduEntity nongchanpinjiandu){
        EntityWrapper< NongchanpinjianduEntity> ew = new EntityWrapper< NongchanpinjianduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanpinjiandu, "nongchanpinjiandu")); 
		NongchanpinjianduView nongchanpinjianduView =  nongchanpinjianduService.selectView(ew);
		return R.ok("查询农产品监督成功").put("data", nongchanpinjianduView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanpinjianduEntity nongchanpinjiandu = nongchanpinjianduService.selectById(id);
        return R.ok().put("data", nongchanpinjiandu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanpinjianduEntity nongchanpinjiandu = nongchanpinjianduService.selectById(id);
        return R.ok().put("data", nongchanpinjiandu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinjianduEntity nongchanpinjiandu, HttpServletRequest request){
    	nongchanpinjiandu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinjiandu);

        nongchanpinjianduService.insert(nongchanpinjiandu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinjianduEntity nongchanpinjiandu, HttpServletRequest request){
    	nongchanpinjiandu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinjiandu);

        nongchanpinjianduService.insert(nongchanpinjiandu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanpinjianduEntity nongchanpinjiandu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpinjiandu);
        nongchanpinjianduService.updateById(nongchanpinjiandu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<NongchanpinjianduEntity> list = new ArrayList<NongchanpinjianduEntity>();
        for(Long id : ids) {
            NongchanpinjianduEntity nongchanpinjiandu = nongchanpinjianduService.selectById(id);
            nongchanpinjiandu.setSfsh(sfsh);
            nongchanpinjiandu.setShhf(shhf);
            list.add(nongchanpinjiandu);
        }
        nongchanpinjianduService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanpinjianduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
