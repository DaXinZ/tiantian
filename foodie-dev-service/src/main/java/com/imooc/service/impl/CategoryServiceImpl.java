package com.imooc.service.impl;

import com.imooc.mapper.CarouseMapper;
import com.imooc.mapper.CategoryMapper;

import com.imooc.mapper.CategoryMapperCustom;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;

import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2022/3/15 2:26 下午
 * CarouselServiceImpl
 * Describe：
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS)


    @Override
    public List<Category> queryAllRootLevelCat() {

        Example example = new Example(Carousel.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", 1);
        List<Category> result = categoryMapper.selectByExample(example);

        return result;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCarId) {


        return categoryMapperCustom.getSubCatList(rootCarId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCarId) {
        Map<String, Object> Map = new HashMap<>();
        Map.put("rootCatId",rootCarId);


        return categoryMapperCustom.getSixNewItemsLazy(Map);
    }


}
