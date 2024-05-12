package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongchanpinjianduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongchanpinjianduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanpinjianduView;


/**
 * 农产品监督
 *
 * @author 
 * @email 
 * @date 2023-05-08 21:27:50
 */
public interface NongchanpinjianduService extends IService<NongchanpinjianduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanpinjianduVO> selectListVO(Wrapper<NongchanpinjianduEntity> wrapper);
   	
   	NongchanpinjianduVO selectVO(@Param("ew") Wrapper<NongchanpinjianduEntity> wrapper);
   	
   	List<NongchanpinjianduView> selectListView(Wrapper<NongchanpinjianduEntity> wrapper);
   	
   	NongchanpinjianduView selectView(@Param("ew") Wrapper<NongchanpinjianduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanpinjianduEntity> wrapper);
   	

}

