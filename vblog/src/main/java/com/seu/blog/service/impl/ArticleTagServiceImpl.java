package com.seu.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.seu.blog.dao.ArticleTagDao;
import com.seu.blog.entity.ArticleEntity;
import com.seu.blog.entity.ArticleTagEntity;
import com.seu.blog.entity.TagEntity;
import com.seu.blog.service.ArticleTagService;
import com.seu.blog.vo.TagPageVo;
import com.seu.common.utils.PageUtils;
import com.seu.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 文章标签表
 *
 * @author liangfeihu
 * @email liangfhhd@163.com
 * @date 2018-07-04 15:00:55
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTagEntity> implements ArticleTagService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ArticleTagEntity> page = this.selectPage(
                new Query<ArticleTagEntity>(params).getPage(),
                new EntityWrapper<ArticleTagEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询最热标签
     *
     * @param limit
     * @return
     */
    @Override
    public List<Integer> queryHotTagIds(Integer limit){
        List<Integer> hotTagIds = this.baseMapper.queryHotTagIds(limit);
        return hotTagIds;
    }

    /**
     * 根据标签查询文章
     *
     * @param tagPageVo
     * @return
     */
    @Override
    public List<ArticleEntity> queryArticlesByTag(TagPageVo tagPageVo) {
        return this.baseMapper.queryArticlesByTag(tagPageVo);
    }

    /**
     * 获取文章所有标签
     *
     * @param articleId
     * @return
     */
    @Override
    public List<TagEntity> queryArticleTags(Long articleId) {
        return this.baseMapper.queryArticleTags(articleId);
    }
}
