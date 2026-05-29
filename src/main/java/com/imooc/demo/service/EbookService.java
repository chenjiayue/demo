package com.imooc.demo.service;
import com.imooc.demo.domain.Ebook;
import com.imooc.demo.domain.EbookExample;
import com.imooc.demo.mapper.EbookMapper;
import com.imooc.demo.req.EbookReq;
import com.imooc.demo.resp.EbookResp;
import com.imooc.demo.utils.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebooksList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebooksList) {
            //EbookResp ebookResp = new EbookResp();
            //BeanUtils.copyProperties(ebook, ebookResp);

            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            respList.add(ebookResp);
        }

        List<EbookResp> list = CopyUtil.copyList(ebooksList, EbookResp.class);
        return list;
    }
}
