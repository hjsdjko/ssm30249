package com.entity.view;

import com.entity.ZhunongxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 助农信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 21:27:50
 */
@TableName("zhunongxinxi")
public class ZhunongxinxiView  extends ZhunongxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhunongxinxiView(){
	}
 
 	public ZhunongxinxiView(ZhunongxinxiEntity zhunongxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zhunongxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
