package com.imooc.demo.controller;
import com.imooc.demo.domain.Ebook;
import com.imooc.demo.resp.CommonResp;
import com.imooc.demo.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public CommonResp list(){
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> list = ebookService.list();
        resp.setContent(list);
        return resp;
    }
}
