package com.accumulate.personal.httpserver;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestController
 *
 * @author zhutao
 * @date 2021/12/16 8:18 下午
 */
@Controller
public class TestController {

    @RequestMapping("/test/{name}")
    public void test(HttpServletResponse httpServletResponse,@PathVariable(name = "name") String name) throws IOException {

        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        FileInputStream fileInputStream = new FileInputStream(
                "/Users/zhutao/Desktop/"+name);
        int size = fileInputStream.available();
        final byte[] data = new byte[size];
        int offset = 0;
        int read;

        while (offset < size && (read = fileInputStream.read(data, offset, size - offset)) != -1) {
            offset += read;
        }
        bufferedOutputStream.write(data);
        bufferedOutputStream.flush();
    }
}
