package com.xiang.demo.java.test;

import com.jd.security.tdeclient.TDEClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Auther: xianghairui
 * Date: 2018/7/5 18:40
 * Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-test.xml"})
public class TdeClientTest {

    private static Logger logger = LoggerFactory.getLogger(TdeClientTest.class);

    @Qualifier("tdeClient")
    @Autowired
    private TDEClient tdeClient;

    @Test
    public void test() {
        // 从tms获得的token 此token 为 测试tms 上的XXXX_9cOe8f6g业务的token
        // ，使用时请替换为自己申请的token
        String token = "eyJkYXRhIjp7ImFjdCI6ImNyZWF0ZSIsImVmZmVjdGl2ZSI6MTUwODA4MzIwMDAwMCwiZXhwaXJlZCI6MTUxNjAzMjAwMDAwMCwiaWQiOiJaREUyWmpneU5tVXRPRE01WmkwME5XSTRMV0kzTkRrdE1USm1ZVE5tWmpGbE1HUTUiLCJrZXkiOiJ1eGhWWW9hdmh2N1FtcXFqMkY4OG00bGNreHR0Z0I5ZDVMVTZ6dmdMRk1VPSIsInNlcnZpY2UiOiJYWFhYXzljT2U4ZjZnIiwic3R5cGUiOjB9LCJzaWciOiJYdE1xWjJlR1FleUsxVVNpT3JQS0xaTEJCVEVFWWdKbzIydXg5a1ROTERwMXVKVU9uSlhKSFVGTnAzT0JRL0U4SmpWV21XbThsdFNtOENXYVF3VmVJUGs4UzdhTXl3SzYrVmJqK1FTUXFaejFwUTlYNzNjc3NWeXVIdUJUZDdyZmVnOUhtaEpFbzQyVytDV3FhdUFVampQUTlwOWpZZEs5U0ljMnlBR1V1ZGVYMmdrUDJCaE04RllMMVBuZmJlVWcyRURJZ1o0UGJOTGhhbklVWXhQVTQxMkpPMUp5ZmVZSU5sV2xDaDJLVHZHZG1BMnd4UkZLQVlOVDJRUml6SE9oa2Z0Q2dmWm0yNi9OQ2dlc0FFNncxbGs3MnlvbDlsS3kydG9LYnFaVnA4eXNxOUxlY2F6NURyTGJoVkRQRGlqR2lnT3FJMXJJZThKMGQxZDJpdUltREE9PSJ9";
        // 构造一个加密客户端(使用测试环境传入 false)（线上环时境请传入true）
        try {
            // 随机一个字符串
            Random r = new Random(11);
            long ri = r.nextLong() % 100000000000L;
            long phoneNumber = Math.abs(ri);
            String plstr = String.valueOf(phoneNumber);
            System.out.println("原文" + plstr);
            // 加密得到密文
            String enBase64Str = tdeClient.encryptString(plstr);
            System.out.println("密文" + enBase64Str);
            // 解密得到明文
            String deStr = tdeClient.decryptString(enBase64Str);
            System.out.println("解密得到的明文" + deStr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }



    /**
     * 加密.
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public String encrypt(final String str) {
        String res = null;
        try {
            res = this.tdeClient.encryptString(str);
        } catch (final Exception exp) {
            logger.error("encrypt error", exp);
        }
        return res;
    }

    /**
     * 解密.
     * @param str 需要解密的字符串
     * @return 解密后的字符串
     */
    public String decrypt(final String str) {
        String res = null;
        try {
            res = this.tdeClient.decryptString(str);
        } catch (final Exception exp) {
            logger.error("decrypt error", exp);
        }
        return res;
    }


}
