
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kafei")
public class KafeiController {
    private static final Logger logger = LoggerFactory.getLogger(KafeiController.class);

    @Autowired
    private KafeiService kafeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShangjiaService shangjiaService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        params.put("kafeiDeleteStart",1);params.put("kafeiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = kafeiService.queryPage(params);

        //字典表数据转换
        List<KafeiView> list =(List<KafeiView>)page.getList();
        for(KafeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KafeiEntity kafei = kafeiService.selectById(id);
        if(kafei !=null){
            //entity转view
            KafeiView view = new KafeiView();
            BeanUtils.copyProperties( kafei , view );//把实体数据重构到view中

                //级联表
                ShangjiaEntity shangjia = shangjiaService.selectById(kafei.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KafeiEntity kafei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kafei:{}",this.getClass().getName(),kafei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("商家".equals(role))
            kafei.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KafeiEntity> queryWrapper = new EntityWrapper<KafeiEntity>()
            .eq("shangjia_id", kafei.getShangjiaId())
            .eq("kafei_name", kafei.getKafeiName())
            .eq("kafei_types", kafei.getKafeiTypes())
            .eq("kafei_kucun_number", kafei.getKafeiKucunNumber())
            .eq("kafei_clicknum", kafei.getKafeiClicknum())
            .eq("shangxia_types", kafei.getShangxiaTypes())
            .eq("kafei_delete", kafei.getKafeiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KafeiEntity kafeiEntity = kafeiService.selectOne(queryWrapper);
        if(kafeiEntity==null){
            kafei.setKafeiClicknum(1);
            kafei.setShangxiaTypes(1);
            kafei.setKafeiDelete(1);
            kafei.setCreateTime(new Date());
            kafeiService.insert(kafei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KafeiEntity kafei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kafei:{}",this.getClass().getName(),kafei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("商家".equals(role))
//            kafei.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KafeiEntity> queryWrapper = new EntityWrapper<KafeiEntity>()
            .notIn("id",kafei.getId())
            .andNew()
            .eq("shangjia_id", kafei.getShangjiaId())
            .eq("kafei_name", kafei.getKafeiName())
            .eq("kafei_types", kafei.getKafeiTypes())
            .eq("kafei_kucun_number", kafei.getKafeiKucunNumber())
            .eq("kafei_clicknum", kafei.getKafeiClicknum())
            .eq("shangxia_types", kafei.getShangxiaTypes())
            .eq("kafei_delete", kafei.getKafeiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KafeiEntity kafeiEntity = kafeiService.selectOne(queryWrapper);
        if("".equals(kafei.getKafeiPhoto()) || "null".equals(kafei.getKafeiPhoto())){
                kafei.setKafeiPhoto(null);
        }
        if(kafeiEntity==null){
            kafeiService.updateById(kafei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<KafeiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            KafeiEntity kafeiEntity = new KafeiEntity();
            kafeiEntity.setId(id);
            kafeiEntity.setKafeiDelete(2);
            list.add(kafeiEntity);
        }
        if(list != null && list.size() >0){
            kafeiService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<KafeiEntity> kafeiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            KafeiEntity kafeiEntity = new KafeiEntity();
//                            kafeiEntity.setShangjiaId(Integer.valueOf(data.get(0)));   //商家 要改的
//                            kafeiEntity.setKafeiName(data.get(0));                    //商品名称 要改的
//                            kafeiEntity.setKafeiPhoto("");//照片
//                            kafeiEntity.setKafeiTypes(Integer.valueOf(data.get(0)));   //商品类型 要改的
//                            kafeiEntity.setKafeiKucunNumber(Integer.valueOf(data.get(0)));   //商品库存 要改的
//                            kafeiEntity.setKafeiOldMoney(data.get(0));                    //商品原价 要改的
//                            kafeiEntity.setKafeiNewMoney(data.get(0));                    //现价 要改的
//                            kafeiEntity.setKafeiClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            kafeiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            kafeiEntity.setKafeiDelete(1);//逻辑删除字段
//                            kafeiEntity.setKafeiContent("");//照片
//                            kafeiEntity.setCreateTime(date);//时间
                            kafeiList.add(kafeiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        kafeiService.insertBatch(kafeiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = kafeiService.queryPage(params);

        //字典表数据转换
        List<KafeiView> list =(List<KafeiView>)page.getList();
        for(KafeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KafeiEntity kafei = kafeiService.selectById(id);
            if(kafei !=null){

                //点击数量加1
                kafei.setKafeiClicknum(kafei.getKafeiClicknum()+1);
                kafeiService.updateById(kafei);

                //entity转view
                KafeiView view = new KafeiView();
                BeanUtils.copyProperties( kafei , view );//把实体数据重构到view中

                //级联表
                    ShangjiaEntity shangjia = shangjiaService.selectById(kafei.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody KafeiEntity kafei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,kafei:{}",this.getClass().getName(),kafei.toString());
        Wrapper<KafeiEntity> queryWrapper = new EntityWrapper<KafeiEntity>()
            .eq("shangjia_id", kafei.getShangjiaId())
            .eq("kafei_name", kafei.getKafeiName())
            .eq("kafei_types", kafei.getKafeiTypes())
            .eq("kafei_kucun_number", kafei.getKafeiKucunNumber())
            .eq("kafei_clicknum", kafei.getKafeiClicknum())
            .eq("shangxia_types", kafei.getShangxiaTypes())
            .eq("kafei_delete", kafei.getKafeiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KafeiEntity kafeiEntity = kafeiService.selectOne(queryWrapper);
        if(kafeiEntity==null){
            kafei.setKafeiDelete(1);
            kafei.setCreateTime(new Date());
        kafeiService.insert(kafei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
