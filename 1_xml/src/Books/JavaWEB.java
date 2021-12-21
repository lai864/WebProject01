package Books;

public class JavaWEB {
    /*
    * 什么是JavaWEB
    *   JavaWEB是指，所有通过Java语言编写可以通过浏览器访问的总称
    *   JavaWEB是基于请求和响应来开发的
    *
    * 什么是请求
    *   请求是指客户端给服务端发送数据，叫请求Request
    *
    * 什么是响应
    *    响应是指服务器给客户端回传数据，叫响应Response
    *
    * 请求和响应的关系
    *   请求和响应是成对出现的，有请求就有响应
    *
    *
    *
    * Web资源的分类
    *   Web资源按实现的技术和呈现的效果的不同，有分为静态资源换和动态资源两种
    *
    *   静态资源：html,css,js,txt,mp4视频,jpg图片
    *   动态资源：jsp页面，Servlet程序
    *
    *
    *
    *   在Tomcat下部署Web工程的两种方式
    *       第一种：
    *   D:\TomCat8\apache-tomcat-8.0.50\webapps，即webapps下创建工程文件，放入项目文件
    *   在浏览器搜索：http://localhost:8080/工程名/项目文件名
    *
    *       第二种方式
    *   D:\TomCat8\apache-tomcat-8.0.50\conf\Catalina\localhost，即localhost文件下新建一个xml文件
    *   搜素把工程名换为xml文件名
    *
    *
    *
    *
    *
    *    Servlet技术
    *       什么是Servlet技术
    *           1.Servlet是javaEE规范之一，规范就是接口
    *           2.Servlet就是JavaWeb三大组件之一，三大组件分别是：Servlet程序，Filter过滤器，Listener监听器
    *           3.Servlet是运行在服务器上的一个java程序，它可以接收客户端发送的请求，并相应数据给客户端
    *
    *
    *    Servlet的生命周期
    *       1.执行Servlet构造器方法
            2.执行init初始化方法
            *
            * 第一，二步第一次访问会执行，第三步每次访问会执行
            3.执行service方法
            *
            * 第四步，在Web工程停止时执行
            4.执行destroy方法

     *
     * HttpServlet继承GenericServlet类，GenericServlet类实现Servlet接口
     * GenericServlet类做了比较:是POST/GET来分配地址
     *
     * ServletConfig类的三个作用
     *      1.可以获取Servlet程序的别名，servlet-name值
     *          servletConfig.getServletName()
     *      2.可以获取初始化参数init-param
     *          servletConfig.getInitParameter("username") username是参数名，方法得到到参数值
     *      3.可以ServletContext对象
     *          servletConfig.getServletContext()
     *
     *
     *  ServletContext类
     *      什么是ServletContext
     *      1.ServletContext是一个接口，它表示Servlet上下文对象
     *      2.一个web工程只有一个ServletContext对象实例
     *      3.ServletContext对象是一个域对象
     *
     *      什么是域对象
     *      域对象，是可以像Map一样存取数据的对象，叫域对象
     *      这里的域对象指的是存取数据的操作范围
     *
     *              存数据         取数据     ·   删除数据
     *  Map         put()           get()       remove()
     *  域对象      setAttribute   getAttribute    removeAttribute
     *
     *
     *
     *       //1.获取web.xml中配置的上下文参数context-param
            //2.获取当前工程路径， 格式：/工程路径，即Tomcat分配的artifact
            //3.获取工程部署后在服务器硬盘上的绝对路径
            //4.像Map一样存取数据
        *
        *
        *  //1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        System.out.println("context-param参数username的值是:"+context.getInitParameter("username"));
        System.out.println("context-param参数password的值是:"+context.getInitParameter("password"));
        //2.获取当前工程路径， 格式：/工程路径，即Tomcat分配的artifact
        System.out.println("当前工程路径："+context.getContextPath());
        //3.获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("工程部署的路径:"+context.getRealPath("/"));
        * D:\IUPO\IdeaJavaWebProjects\WebProject01\out\artifacts\Web_war_exploded\
        *4.像Map一样存取数据
        * 除了每次开启web工程或重新部署，更新，会让ServletContext对象实例一开始初始化为空，先存数据才能取数据.因为一个web工程只有一个ServletContext对象实例。
        * 一旦存入数据每次执行Servlet程序，都能取数据，见ContextServlet2/3
        *
        *           注意注意注意：在web.xml文件下给Servlet程序分配的地址前一定要加/ 它是服务器解析地址，即服务器网络访问地址
        *
        *
        *
        *
        *   HTTP协议请求和响应：Servlet程序接收客户端请求，doGet和doPost响应数据
        *
        *   HTTP协议请求：请求行，请求头，请求体
        *
        *   常用请求头的说明：
        *       Accept:表示客户端可以接收的数据类型
        *       Accept-Language:表示客户端可以接收的语言类型
        *       User-Agent:表示客户端浏览的信息
        *       Host:表示请求时的服务器ip和端口号
        *
        *
        *   哪些是GET请求，哪些是POST请求
        *
        *      GET请求有哪些：
        *           1，form标签，method=get
        *           2.a标签
        *           3.link标签引入css
        *           4.script标签引入js文件
        *           5.img标签引入图片
        *           6.iframe引入html页面
        *           7.在浏览器地址栏中输入地址后敲回车
        *
        *
        *       POST请求有哪些
        *           1.form标签，method=post
        *
        *
        *
        *
        *        HTTP协议响应：响应行（响应协议和状态码，描述），响应头，响应体
        *
        *          常用的响应码说明
        *           200     表示请求成功
        *           302     表示请求重定向
        *           404     表示请求服务器已收到，但是你要的数据不存在（请求地址错误或内容不存在）
        *           500     表示服务器已经收到请求，但是服务器内部错误（代码）
        *
        *           MIME是HTTP协议中的数据类型
        *
        *
        *           HttpServletRequest类
        *
        *               HttpServletRequest类有什么作用
        *           每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的HTTP协议请求信息解析封装好封装到Request对象中
        *           然后传递到service方法（doGet和doPost方法）中给我们使用，我们可以通过HttpServletRequest对象，获取到所有请求的信息
        *
        *
        *
        *           HttpServletRequest类的常用方法
        *               getRequestURI()     获取请求的资源路径
        *               getRequestURL()     获取请求的统一资源定位符（绝对路径）
        *               getRequestHost()    获取客户端的ip地址
        *               getHeader()         获取请求头
        *               getParameter()      获取请求的参数
        *               getParameterValues() 获取请求的参数（多个值的时候用）
        *               getMethod()         获取请求的方式GET或POST
        *               setAttribute(key,value) 设置域数据
        *               getAttribute(key)     获取域数据
        *               getRequestDispatcher() 获取请求转发对象
        *
        *
        *
        *           javaWeb相对路径和绝对路径
        *               相对路径    ..表示上一层目录 如有a/b/c 当a和b是目录，c不是，因为目录后有/，也就是/代表一级目录，上一层目录就少一/
        *                           .表示本目录
        *                           资源名表示本文件
        *
        *                绝对路径：http://localhost:8080/工程路径/资源名


        *
        *
        *
        *               在web中 斜杆/ 是一种绝对路径
        *
        *               /被浏览器解析是：http://ip:port
        *
        *               /被服务器解析是：http://ip:port/工程路径
        *             web.xml里：  <url-pattern>/</url-pattern>
        *                           servletContext.getRealPath("/")
        *                           req.getRequestDispatcher("/");
        *
        *
        *               特殊情况：response.sendRediect("/") 把斜杆/发送给浏览器解析，得到http://ip:port
        *
        *
        *
        *
        *
        *           HttpServletResponse类
        *
        *                HttpServletResponse类的作用
        *           HttpServletResponse类和HttpServletRequest类一样，每次请求进来，Tomcat服务器都会创建一个Response对象传递给
        *       Servlet程序去使用。HttpServletRequest表示请求过来的信息，HttpServletResponse表示所有响应的信息
        *       我们如果需要设置返回给客户端的信息，都可以通过HttpServletResponse对象来进行设置
        *
        *
        *       两个输出流说明：
        *           字节流：getOutputStream     常用于下载（传递二进制数据）
        *           字符流：getWriter           常用于回传字符串（常用）
        *       两个不能同时使用，只能使用一个在doGet/doPost
        *
        *
        *       如何给客户端回传数据
        *           忘客户端回传字符串，数据
        *               PrintWriter writer = resp.getWriter();
                        writer.write("response is content");

         *
         *
         *       响应重定向：
         *            resp.getWriter().write("response1到此一游");
                    //浏览器地址栏发生改变
                    //两次请求,废弃的接口不会回传字符串给客户端
                    //不共享Request对象数据，因为请求了两次，是两个不同的Request对象
                    req.setAttribute("key","value");

                    //给定状302态码表示废弃这个接口
                    resp.setStatus(302);

                    //重定向，浏览器发送新的请求地址
                    resp.setHeader("Location","http://localhost:8080/01_servlet/response2");

                     //不能访问WEB-INF目录下的内容，因为第二个请求的地址是浏览器发送的
                //    resp.setHeader("Location","http://localhost:8080/01_servlet/WEB-INF/1.html");
                    //可以访问web工程以外的资源
                        resp.setHeader("Location","https://www.baidu.com");
         *
         *
         *
         *
         *          //重定向第二种方式（推荐使用）
                    resp.sendRedirect("https://www.baidu.com");
         *
                    对比
          *
                    请求转发特点：
         *          浏览器地址栏没有变化
         *          它们是一次请求
         *          它们共享Request域中的数据
         *          不能访问工程外的资源
         *
         *
         *
         *      什么是Listener监听器
         *          1.Listener监听器是javaWeb的三大组件之一，javaWeb三大组件分别是：Servlet程序，Filter过滤器，Listener监听器
         *          2.Listener它是javaEE的规范，就是接口
         *          3.监听器的作用是，监听某种事物的变化，然后通过回调函数，反馈给客户(程序)，去做一些相应的处理
         *
         *
         *      ServletContextListener(接口)监听器
         *          ServletContextListener它可以监听ServletContext对象的创建和销毁
         *          ServletContext对象在web工程启动时创建，停止时销毁
         *          监听到创建和销毁后都会分别调用ServletContextListener监听器的方法和反馈
         *              public class MyServletContextListenerImpl implements ServletContextListener {
                        @Override
                            public void contextInitialized(ServletContextEvent servletContextEvent) {
                                 System.out.println("ServletContext对象被创建了");
                                    }

                            @Override
                            public void contextDestroyed(ServletContextEvent servletContextEvent) {
                            System.out.println("ServletContext对象被销毁了了");
                                        }
                                    }

         *
         *
         *
         *      MVC概念
         *          MVC 全称：Model 模型，  View 视图， Controller 控制器
         *          MVC 最早出现在javaEE三层中的Web层，它可以有效的指导Web层的代码如何有效分离，单独工作
         *
         *          View 视图：只负责数据和界面的显示，不接受任何与显示无关的代码，便于程序员和美工的分工合作--jsp/HTML
         *
         *          Controller 控制器：只负责接受请求。调用业务层的代码处理请求，然后派发页面，是一个调度者的角色--Servlet
         *
         *          Model:模型：将与业务逻辑相关的数据封装为具体的javaBean类，其中不掺杂任何与数据处理相关的代码--javaBean/domain/entity/pojo
         *
         *          MVC是一种思想
         *              MVC的理念是将软件代码拆分为组件，单独开发，组合使用(目的还是解耦合)
         *
         *
         *
         *          表单重复提交
         *              当用户提交完请求，浏览器会记录下最后一次请求的全部信息，当用户按下功能键F5，就会发起浏览器的最后一次请求
         *                  所以要使用响应重定向，而不是请求转发
         *
         *
         *
         *
         *
         *
         *          Cookie饼干
         *              什么是Cookie
         *                  1.Cookie是服务器通知客户端保存键值对的一种技术
         *                  2.客户端有了Cookie后，每次请求都发送给服务器
         *                  3.每个Cookie的大小都不超过4kb
         *
         *
         *          Cookie的创建
         *              在Servlet程序里创建Cookie，通过resp.add(cookie对象),即服务器通知浏览器保存cookie对象和它的键值对，
         *              可以一次创建多个Cookie
         *
         *
         *
         *          Cookie免用户登录
         *          让浏览器保存cookie对象，即使cookie被删除了，也会保存创建时设置的时间
         *          js 11个隐藏域中cookie域调用
         *
         *
         *
         *          Session会话
         *
         *          什么是Session会话
         *          1.Session会话就是一个接口（HttpSession）
         *          2.Session就是会话，它是用来维护一个客户端和服务器之间的一种技术
         *          3.每个客户端都有自己的一个Session会话
         *          4.Session会话中，我们经常用来保存用户登录之后的信息
         *
         *          Session设置值域
         *
         *          Session生命周期：session超时指的是，客户端两次请求的最大间隔时长，设置3秒，3秒内请求会重置超时时间
         *          所有Session的默认超时时间为30分钟，在Tomcat服务器的配置文件web.xml下有配置，可以在当前web工程的web.xml文件下修改：
         *          <session-config>
                        <session-timeout>20</session-timeout>
                     </session-config>
         *
         *          修改单个session的超时时间使用API： setMaxInactiveInterval(超时时间，单位秒);
         *
         *              值为正数，为设置超时时间，值为负数表示永不超时（极少使用）
         *
         *              马上销毁API：invalidate()   例如： session.invalidate();
         *
         *
         *
         *
         *          使用验证码解决表单重复提交
         *
         *
         *
         *          Filter过滤器（访问Web工程下的任何资源，都会先执行Filter程序）
         *          1.Filter过滤器是JavaWeb三大组件之一
         *          2.Filter过滤去是JavaEE的规范，也就是接口
         *          3.Filter过滤器它的作用是，拦截请求，过滤响应
         *
         *          拦截请求的应用场景有
         *          1.权限检查
         *          2.日记操作
         *          3.事务管理
         *              .....等等
         *
         *
         *          Filter过滤器的使用步骤
         *          1.编写一个类去实现Filter接口
         *          2.实现过滤方法doFilter（）
         *          3.到web.xml中去配置Filter的拦截路径
         *
         *
         *          Filter的生命周期类似Servlet,构造器和初始化方法先执行，执行一次，
         *          doFilter()方法,请求一次，执行一次，Web工程结束，执行销毁方法
         *
         *
         *          FilterConfig类
         *          FilterConfig类见名知义，它是Filter过滤器的配置文件
         *          tomcat每次创建Filter的时候，也会同时创建一个FilterConfig类，
         *          这里包含了Filter配置文件的配置信息
         *
         *          FilterConfig类的作用是获取Filter过滤器的配置信息，在Filter初始化方法里有FilterConfig类和对象
         *          1.获取Filter的名称 Filter-name的内容：filterConfig.getFilterName()
         *          2.获取在Filter中配置的init-param初始化信息,在web.xml文件里配置，<filter></filter>里配置param
         *          3.获取ServletContext对象：filterConfig.getServletContext()
         *
         *
         *          FilterChain
         *          访问Web工程下的任何资源，都会先执行Filter程序判断是否拦截，你不创建Filter程序默认不拦截，创建了不做判断，就执行了filterChain.doFilter()方法也是默认不拦截，
         *          只有创建了Filter且没有执行filterChain.doFilter(req,resp)代码表示被拦截了
         *              FilterChain.doFilter()方法的作用
         *               1.执行下一个Filter过滤器（如果有Filter都会被执行，可以有多个Filter程序）
         *               2.执行目标资源（没有Filter），
         *                  执行了filterChain.doFilter()表明访问的资源没有被拦截
         *                   没有执行这行代码表示被拦截了，不会访问资源，不管是否拦截了最后都会会层层回退到浏览器
         *                  浏览器=>服务器第一个Filter程序的filterChain.doFilter()前置（程序里前面）代码=>第二个Filter程序的filterChain.doFilter()=>等等Filter程序=>服务器Web资源
         *                  访问到资源或被拦截，开始回退到浏览器 假如有两个Filter程序：服务器Web资源=>服务器第二个Filter程序的filterChain.doFilter()后置（程序里后面）代码=>第一个Filter程序的filterChain.doFilter()=>浏览器
         *
         *              在多个Filter过滤器执行的时候，它们执行的优先顺序是由它们在web.xml中从上到下
         *              配置的顺序绝定
         *
         *              多个Filter过滤器执行的特点：
         *              1.所有Filter和目录资源默认都执行在同一个线程中
         *              2. 多个Filter共同执行的时候，它们都是使用同一个Request对象
         *
         *
         *              Filter的拦截路径(会做拦截判断，经过Filter程序，不在配置地址范围里默认不拦截)
         *              精确匹配
                        <url-pattern>/target.jsp</url-pattern>
                        以上配置表示请求地址必须为：http://ip:iport/工程路径/target.jsp


         *              目录匹配（目录要正确）
         *              <url-pattern>/admin/*</url-pattern>
                        以上配置表示请求地址必须为：http://ip:iport/工程路径/admin/*

                        后缀匹配（任意字符串,不能以斜杆开头）
                        <url-pattern>*.html</url-pattern>
                        以上配置表示请求地址必须为：http://ip:iport/工程路径/以.html结尾才会拦截
                        <url-pattern>*.do</url-pattern>
                        以上配置表示请求地址必须以.do结尾才会拦截

                        Filter过滤器只关心请求的地址是否匹配，不关心请求的地址是否存在





     */

    /*
    *           ThreadLocal的使用
    *       ThreadLocal的作用，它可以解决多线程的数据安全问题
    *
    *       ThreadLocal它可以给当前线程关联一个数据(可以是普通变量，也可以是对象，也可以是数组，集合)
    *
    *       ThreadLocal的特点
    *           1.ThreadLocal可以为当前线程关联一个数据，（它可以像Map一样存取数据，key为当前线程）
    *           2.每一个ThreadLocal对象，只能为当前线程关联一个数据，如果要为当前线程关联多个数据，就需要使用多个ThreadLocal对象实例
    *           3.每个ThreadLocal对象实例定义的时候，一般都是static类型
    *           4.ThreadLocal中保存数据，在线程销毁后，会由JVM虚拟机自动释放
    *                   一个ThreadLocal对象，只能为当前线程关联一个数据，key为当前线程
    *           static ThreadLocal<Object> local = new ThreadLocal<Object>();
    *               local.set(value)
    *               local.get()
    *
    *
    *
    *           什么是JSON？
    *           JSON(Javascript Object Notation)是一种轻量级的数据交换格式，易于人阅读和编写，也易于机器解析生成
    *           采用完全独立于语言的文本格式，是理想的数据交换格式
    *
    *           JSON是一种轻量级的数据交换格式
    *
    *           轻量级的是跟xml比较
    *
    *           数据交换指定是客户端和服务器之间业务数据的传输格式

                Json的访问
                    Json本身是一个对象
                    Json中的key我们可以理解为是对象的一个属性
                    Json中的key访问就跟访问对象的属性一样


                    Json的两个常用方法
                    Json的存在有两种形式
                    一种是：对象的形式存在，我们叫Json对象
                    一种是：字符串的形式存在，我们叫它Json字符串
                    一般我们要操作Json中的数据时，需要Json对象的格式
                    一般我们要在客户端和服务器之间进行数据交换的时候，使用Json字符串

                    方法JSON大写,HTML,jsp等页面里，java代码java对象里用Gson.toJson()转为json字符串，gson.fromJson()转为java对象
                    JSON.stringify() 把Json对象转换成Json字符串
                    JSON.parse() 把Json字符串转换为Json对象
    *
    *
    *
    *
    *
    *               什么是AJAX请求
    *
    *               AJAX即"Asynchronous Javascript And Xml"(异步Javascript和XML),是指一种
    *               创建交互式网页应用的网页开发技术
    *                   ajax是一种浏览器通过js异步发起请求，局部更新页面和技术
    *
    *
    *               AJAX同步和异步
    *               同步false,异步true，异步不会等待服务器返回数据给AJAX请求，优势大于同步，有更好的用户体验
    *
    *
    *
    *               jQuery中的AJAX请求
    *            $.ajax方法
    *               url             表示请求的地址
    *               type            表示请求的类型GET或POST请求
    *               data            表示发送给服务器的数据
    *                           data格式有两种：
    *                               一：name=value&name=value
    *                               二：{key:value}
    *
    *               success         请求成功，响应的回调函数
    *               dataType        响应的数据类型
    *                                   常用的数据类型有
    *                                       text 表示文本
                                            xml  表示xml数据
                                            json 表示json对象

                       $.get方法和$.post方法，相比$.ajax方法少了type

                       $.getJSON方法又少了dataType参数

                       把参数序列化 $().serialize()
                       *
    */

}
