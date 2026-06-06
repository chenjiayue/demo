package com.imooc.demo.controller;
import com.imooc.demo.domain.Ebook;
import com.imooc.demo.req.EbookReq;
import com.imooc.demo.req.EbookQueryReq;
import com.imooc.demo.resp.CommonResp;
import com.imooc.demo.resp.EbookQueryResp;
import com.imooc.demo.resp.EbookResp;
import com.imooc.demo.resp.PageResp;
import com.imooc.demo.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    //@Value("${ebook.hello}")
    //private String ebookHello;
    @Autowired
    private EbookService ebookService;
    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    //public String hello(){
    //    return "hello world!!!" + ebookHello;
    //}
    //@RequestMapping(value = "/hello/post",method = RequestMethod.POST)
    //public String helloPost(String name){
    //    return "hello world!!!" + name;
    //}

    @GetMapping("/list")
    public CommonResp list(@Valid EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}
