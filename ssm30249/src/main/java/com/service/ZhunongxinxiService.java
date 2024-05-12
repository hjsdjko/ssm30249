package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhunongxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhunongxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhunongxinxiView;


/**
 * 助农信息
 *
 * @author 
 * @email 
 * @date 2023-05-08 21:27:50
 */
public interface ZhunongxinxiService extends IService<ZhunongxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhunongxinxiVO> selectListVO(Wrapper<ZhunongxinxiEntity> wrapper);
   	
   	ZhunongxinxiVO selectVO(@Param("ew") Wrapper<ZhunongxinxiEntity> wrapper);
   	
   	List<ZhunongxinxiView> selectListView(Wrapper<ZhunongxinxiEntity> wrapper);
   	
   	ZhunongxinxiView selectView(@Param("ew") Wrapper<ZhunongxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhunongxinxiEntity> wrapper);
   	

}

