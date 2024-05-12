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


import com.dao.ZhunongxinxiDao;
import com.entity.ZhunongxinxiEntity;
import com.service.ZhunongxinxiService;
import com.entity.vo.ZhunongxinxiVO;
import com.entity.view.ZhunongxinxiView;

@Service("zhunongxinxiService")
public class ZhunongxinxiServiceImpl extends ServiceImpl<ZhunongxinxiDao, ZhunongxinxiEntity> implements ZhunongxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhunongxinxiEntity> page = this.selectPage(
                new Query<ZhunongxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhunongxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhunongxinxiEntity> wrapper) {
		  Page<ZhunongxinxiView> page =new Query<ZhunongxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhunongxinxiVO> selectListVO(Wrapper<ZhunongxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhunongxinxiVO selectVO(Wrapper<ZhunongxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhunongxinxiView> selectListView(Wrapper<ZhunongxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhunongxinxiView selectView(Wrapper<ZhunongxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
