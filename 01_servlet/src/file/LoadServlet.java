package file;

import jdk.nashorn.api.scripting.URLReader;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class LoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取要下载的文件
        String downLoadFileName = "QQ图片20200131210445.png";
        //2.读取要下载的文件内容(通过ServletContext对象可以获取)
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("/images/" + downLoadFileName);
        System.out.println("下载的文件类型"+mimeType);
        //4.在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //5.还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
        //Content-Disposition响应头，表示收到的数据怎么处理
        //attachment；表示附件，表示下载使用
        //filename:表示指定下载的文件名，即该文件名,如果是中文名，谷歌，IE浏览器需要转码操作URLEncoder.encode("女孩.png","UTF-8")，火狐浏览器也统一了
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("女孩.png","UTF-8"));
        //斜杆/由服务器解析
        InputStream resourceAsStream = servletContext.getResourceAsStream("/images/" + downLoadFileName);
       //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        //读取输入流的全部数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);
    }
}
