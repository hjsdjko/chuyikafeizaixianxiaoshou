package com.dao;

import com.entity.KafeiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KafeiLiuyanView;

/**
 * 商品留言 Dao 接口
 *
 * @author 
 */
public interface KafeiLiuyanDao extends BaseMapper<KafeiLiuyanEntity> {

   List<KafeiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
