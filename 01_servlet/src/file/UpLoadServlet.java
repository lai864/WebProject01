package file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UpLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("文件上传过来了");
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] bys = new byte[1024000];
//
//        int lend = inputStream.read(bys);
//
//        System.out.println(new String(bys,0,lend));

        resp.setContentType("text/html;charset=UTF-8");
        //先判断上传的数据是否多段数据(只有是多段的数据，才是文件上传的)
        if (ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传的数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //解析上传的数据，得到一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //循环判断每一个表单项，是普通类型，还是上传的文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值"+fileItem.getFieldName());
                        System.out.println("表单项的value属性值"+fileItem.getString("UTF-8"));
                    }else {
                        //上传的文件
                        System.out.println("上传文件的name属性值"+fileItem.getFieldName());
                        System.out.println("上传文件名"+fileItem.getName());

                        fileItem.write(new File("D:\\Download\\"+fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
/*
    ServletFileUpLoad类，用于解析上传数据，FileItem表示每一个表单项
*  boolean ServletFileUpLoad.isMultipartContent(HttpServletRequest req)
*   判断当前上传的数据格式是否是多段的格式

    public  List<FileItem> parseRequest(HttpServletRequest req),解析上传的数据
    List<FileItem> list = servletFileUpload.parseRequest( req);

    boolean FileItem.isFormField()
    判断当前表单项是否是普通的表单项(true)，还是上传的文件类型(false)

    String FileItem.getFileName()
    获得当前表单项的name属性

    String FileItem.getString()
    获得当前表单项的值

    String FileItem.getName()
    获取上传的文件名

    void FileItem.write(File file)
    将上传的文件，写到参数file所指向的磁盘位置

*
*
*
*
*
*
* */
