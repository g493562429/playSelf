package com.gn.demo.controller;

import com.alibaba.fastjson.JSON;
import com.gn.demo.config.CommonConfig;
import com.gn.demo.service.DemoService;
import com.gn.demo.utils.RedisDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author: gn
 * @Date: 2020-6-8 16:44
 * @Description:
 */
@Controller
@RequestMapping("/common")
@Slf4j
public class DemoController {
    @Resource
    private DemoService demoService;

    @Resource
    private CommonConfig commonConfig;

    @Autowired
    @Qualifier("gnRedisDistributedLock")
    private RedisDistributedLock redisDistributedLock;

    @GetMapping("/ss")
    @ResponseBody
    public String demo(){
        log.info("配置获取测试：{}", commonConfig.getCeShi());
        return demoService.demoFeign();
    }
    @PostMapping("/toJson")
    @ResponseBody
    public Json toJson(@RequestBody Map<String,Object> jsonpObject){
        log.info("入参:{}",jsonpObject.toString());
        return (Json)jsonpObject;
    }
    @GetMapping("/tryLock")
    @ResponseBody
    public boolean tryLock(@RequestParam String lockName, @RequestParam long expiredTime){
        log.info("获取锁 start...");
        boolean result = redisDistributedLock.tryLock(lockName, expiredTime);
        log.info("获取锁 result:{}", result);
        return result;
    }

    @GetMapping("/unLock")
    @ResponseBody
    public boolean unLock(@RequestParam String lockName){
        log.info("释放锁 start...");
        boolean result = redisDistributedLock.unlock(lockName);
        log.info("释放锁 result:{}", result);
        return result;
    }

    @PostMapping("uploadurl")
    public HttpServletResponse uploadurl(HttpServletRequest request,
                            HttpServletResponse response, String id){
        if(!(request instanceof MultipartHttpServletRequest)){
            response.addHeader("msg", "FALSE");
            return response;
        }
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile soundRecordFile = multipartHttpServletRequest.getFile("soundRecordFile");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(date);
        log.info("id:{}", id);
        log.info("id:{}", request.getHeader("id"));
        response.addHeader("msg", "TRUE");
        return response;
    }

    public static void main(String[] args) {
        HttpClient client = new DefaultHttpClient();
        // 上传地址
        HttpPost httpPost = new HttpPost("http://10.113.118.166:7001/eim_sm_mgr/restful/record/downZipByHttp");
        // 文件位置
        FileBody fileBody = new FileBody(new File("d:\\test.txt"));
        StringBody stringBody;
        try {
            MultipartEntity entity = new MultipartEntity();
            entity.addPart("file", fileBody);
            httpPost.setEntity(entity);
            httpPost.setHeader("id", "234");
            HttpResponse response = client.execute(httpPost);
            System.out.println("response:" + JSON.toJSONString(response.getHeaders("msg")));
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                // 上传成功
                HttpEntity entity1 = response.getEntity();
                System.out.println("entity1:" + entity1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
