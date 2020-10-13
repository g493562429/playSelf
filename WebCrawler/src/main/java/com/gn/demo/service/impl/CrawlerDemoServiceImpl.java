package com.gn.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.gn.demo.dto.WebCrawlerDto;
import com.gn.demo.service.CrawlerDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: gn
 * @Date: 2020-8-1
 * @Description:
 */
@Service
@Slf4j
public class CrawlerDemoServiceImpl implements CrawlerDemoService {
    /**
     * 爬取网页内容功能
     *
     * @param urlStr url字符串
     * @return WebCrawlerDto
     */
    @Override
    public WebCrawlerDto getContext(String urlStr) {
        BufferedReader br = null;
        PrintWriter pw = null;
        InputStream inputStream = null;
        String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
        Pattern p = Pattern.compile(regex);
        try {
            URL url = new URL(urlStr);
            URLConnection urlconnection = url.openConnection();
            inputStream = urlconnection.getInputStream();
            pw = new PrintWriter(new FileWriter("d:\\spider_url.txt"), true);
            br = new BufferedReader(new InputStreamReader(
                    inputStream));
            String buf;
            while ((buf = br.readLine()) != null) {
                Matcher bufM = p.matcher(buf);
                while (bufM.find()) {
                    pw.println(bufM.group());
                }
            }
            System.out.println("获取成功！");
        } catch (MalformedURLException e) {
            log.error("创建url对象失败:{}", e.getMessage());
        } catch (IOException e) {
            log.error("创建输出文件失败:{}", e.getMessage());
        } catch (Exception e) {
            log.error("爬取网页内容失败:{}", e.getMessage());
        } finally {
            try {
                br.close();
                pw.close();
            } catch (IOException e) {
                log.error("爬取网页内容close.br/pw失败:{}", e.getMessage());
            }
        }
        return WebCrawlerDto.builder().context(JSON.toJSONString(inputStream)).build();
    }
}
