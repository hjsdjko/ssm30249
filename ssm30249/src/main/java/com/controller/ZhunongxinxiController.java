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

import com.entity.ZhunongxinxiEntity;
import com.entity.view.ZhunongxinxiView;

import com.service.ZhunongxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 助农信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 21:27:50
 */
@RestController
@RequestMapping("/zhunongxinxi")
public class ZhunongxinxiController {
    @Autowired
    private ZhunongxinxiService zhunongxinxiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhunongxinxiEntity zhunongxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			zhunongxinxi.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhunongxinxiEntity> ew = new EntityWrapper<ZhunongxinxiEntity>();


		PageUtils page = zhunongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhunongxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhunongxinxiEntity zhunongxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZhunongxinxiEntity> ew = new EntityWrapper<ZhunongxinxiEntity>();

		PageUtils page = zhunongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhunongxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhunongxinxiEntity zhunongxinxi){
       	EntityWrapper<ZhunongxinxiEntity> ew = new EntityWrapper<ZhunongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhunongxinxi, "zhunongxinxi")); 
        return R.ok().put("data", zhunongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhunongxinxiEntity zhunongxinxi){
        EntityWrapper< ZhunongxinxiEntity> ew = new EntityWrapper< ZhunongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhunongxinxi, "zhunongxinxi")); 
		ZhunongxinxiView zhunongxinxiView =  zhunongxinxiService.selectView(ew);
		return R.ok("查询助农信息成功").put("data", zhunongxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhunongxinxiEntity zhunongxinxi = zhunongxinxiService.selectById(id);
        return R.ok().put("data", zhunongxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhunongxinxiEntity zhunongxinxi = zhunongxinxiService.selectById(id);
        return R.ok().put("data", zhunongxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhunongxinxiEntity zhunongxinxi, HttpServletRequest request){
    	zhunongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhunongxinxi);

        zhunongxinxiService.insert(zhunongxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhunongxinxiEntity zhunongxinxi, HttpServletRequest request){
    	zhunongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhunongxinxi);

        zhunongxinxiService.insert(zhunongxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhunongxinxiEntity zhunongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhunongxinxi);
        zhunongxinxiService.updateById(zhunongxinxi);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhunongxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
