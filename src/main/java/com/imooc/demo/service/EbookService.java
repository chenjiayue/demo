package com.imooc.demo.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.demo.domain.Ebook;
import com.imooc.demo.domain.EbookExample;
import com.imooc.demo.mapper.EbookMapper;
import com.imooc.demo.req.EbookQueryReq;
import com.imooc.demo.req.EbookSaveReq;
import com.imooc.demo.resp.EbookQueryResp;
import com.imooc.demo.resp.PageResp;
import com.imooc.demo.utils.CopyUtil;
import com.imooc.demo.utils.SnowFlake;
import org.slf4j.Logger;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

import java.util.List;

@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<EbookQueryResp> list(EbookQueryReq req) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria(); //相当于where查询条件
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(),req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        PageResp<EbookQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req,Ebook.class);
        if (ObjectUtils.isEmpty(ebook.getId())) {
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        } else {
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }
    public void delete(Long id){
        ebookMapper.deleteByPrimaryKey(id);
    }
}

