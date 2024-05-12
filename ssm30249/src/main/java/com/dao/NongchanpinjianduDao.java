package com.dao;

import com.entity.NongchanpinjianduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongchanpinjianduVO;
import com.entity.view.NongchanpinjianduView;


/**
 * 农产品监督
 * 
 * @author 
 * @email 
 * @date 2023-05-08 21:27:50
 */
public interface NongchanpinjianduDao extends BaseMapper<NongchanpinjianduEntity> {
	
	List<NongchanpinjianduVO> selectListVO(@Param("ew") Wrapper<NongchanpinjianduEntity> wrapper);
	
	NongchanpinjianduVO selectVO(@Param("ew") Wrapper<NongchanpinjianduEntity> wrapper);
	
	List<NongchanpinjianduView> selectListView(@Param("ew") Wrapper<NongchanpinjianduEntity> wrapper);

	List<NongchanpinjianduView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanpinjianduEntity> wrapper);
	
	NongchanpinjianduView selectView(@Param("ew") Wrapper<NongchanpinjianduEntity> wrapper);
	

}
