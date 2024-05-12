package com.entity.view;

import com.entity.NongchanpinjianduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 农产品监督
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 21:27:50
 */
@TableName("nongchanpinjiandu")
public class NongchanpinjianduView  extends NongchanpinjianduEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongchanpinjianduView(){
	}
 
 	public NongchanpinjianduView(NongchanpinjianduEntity nongchanpinjianduEntity){
 	try {
			BeanUtils.copyProperties(this, nongchanpinjianduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
