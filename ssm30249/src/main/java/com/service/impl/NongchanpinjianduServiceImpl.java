package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.NongchanpinjianduDao;
import com.entity.NongchanpinjianduEntity;
import com.service.NongchanpinjianduService;
import com.entity.vo.NongchanpinjianduVO;
import com.entity.view.NongchanpinjianduView;

@Service("nongchanpinjianduService")
public class NongchanpinjianduServiceImpl extends ServiceImpl<NongchanpinjianduDao, NongchanpinjianduEntity> implements NongchanpinjianduService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongchanpinjianduEntity> page = this.selectPage(
                new Query<NongchanpinjianduEntity>(params).getPage(),
                new EntityWrapper<NongchanpinjianduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongchanpinjianduEntity> wrapper) {
		  Page<NongchanpinjianduView> page =new Query<NongchanpinjianduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NongchanpinjianduVO> selectListVO(Wrapper<NongchanpinjianduEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongchanpinjianduVO selectVO(Wrapper<NongchanpinjianduEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongchanpinjianduView> selectListView(Wrapper<NongchanpinjianduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongchanpinjianduView selectView(Wrapper<NongchanpinjianduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
