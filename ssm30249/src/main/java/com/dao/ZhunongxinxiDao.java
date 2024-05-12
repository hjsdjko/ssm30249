package com.dao;

import com.entity.ZhunongxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhunongxinxiVO;
import com.entity.view.ZhunongxinxiView;


/**
 * 助农信息
 * 
 * @author 
 * @email 
 * @date 2023-05-08 21:27:50
 */
public interface ZhunongxinxiDao extends BaseMapper<ZhunongxinxiEntity> {
	
	List<ZhunongxinxiVO> selectListVO(@Param("ew") Wrapper<ZhunongxinxiEntity> wrapper);
	
	ZhunongxinxiVO selectVO(@Param("ew") Wrapper<ZhunongxinxiEntity> wrapper);
	
	List<ZhunongxinxiView> selectListView(@Param("ew") Wrapper<ZhunongxinxiEntity> wrapper);

	List<ZhunongxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhunongxinxiEntity> wrapper);
	
	ZhunongxinxiView selectView(@Param("ew") Wrapper<ZhunongxinxiEntity> wrapper);
	

}
