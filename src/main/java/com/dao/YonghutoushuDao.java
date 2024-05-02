package com.dao;

import com.entity.YonghutoushuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghutoushuView;

/**
 * 用户投诉 Dao 接口
 *
 * @author 
 */
public interface YonghutoushuDao extends BaseMapper<YonghutoushuEntity> {

   List<YonghutoushuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
