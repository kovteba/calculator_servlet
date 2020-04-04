/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-04 15:26:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html lang=\"en\">\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>CALCULATOR </title>\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"webresources/bootstrap/css/bootstrap.css\">\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"webresources/bootstrap/css/bootstrap-grid.css\">\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"webresources/bootstrap/css/bootstrap-reboot.css\">\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"webresources/css/style.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
String beforeValue = (String) request.getAttribute("inputValue");
      out.write('\n');

    if (beforeValue == null) {
        beforeValue = " ";
    };

      out.write('\n');
String result = (String) request.getAttribute("result");
      out.write('\n');

    if (result == null) {
        result = " ";
    };

      out.write("\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    <div class=\"row calculator\" id=\"calculator\">\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("            <form method=\"post\" action=\"\">\n");
      out.write("                <table class=\"table table-borderless\">\n");
      out.write("                    <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"5\"><input name=\"inputValue\" id=\"inputValue\" class=\"inputValue\" value=\"");
      out.print(beforeValue);
      out.write("\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"1\"><label class=\"result\">RESULT:</label></td>\n");
      out.write("                        <td colspan=\"4\"><input name=\"resultValue\" id=\"resultValue\" class=\"resultValue\" value=\"");
      out.print(result);
      out.write("\" disabled></td>\n");
      out.write("                    </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                <table class=\"table table-borderless\">\n");
      out.write("                    <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\" id=\"seven\" class=\"btn btn-primary value button\" value=\"7\">7</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"eight\" class=\"btn btn-primary value button\" value=\"8\">8</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"nine\" class=\"btn btn-primary value button\" value=\"9\">9</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"plus\" class=\"btn btn-secondary value button\" value=\"+\">+</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"clear\" class=\"btn btn-danger value button\">C</button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"four\" class=\"btn btn-primary value button\" value=\"4\">4</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"five\" class=\"btn btn-primary value button\" value=\"5\">5</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"six\" class=\"btn btn-primary value button\" value=\"6\">6</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"minus\" class=\"btn btn-secondary value button\" value=\"-\">-</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  class=\"btn btn-danger value button\">R</button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"one\" class=\"btn btn-primary value button\" value=\"1\">1</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"two\" class=\"btn btn-primary value button\" value=\"2\">2</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"three\" class=\"btn btn-primary value button\" value=\"3\">3</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"multiplication\" class=\"btn btn-secondary value button\" value=\"*\">*</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"leftBracket\" class=\"btn btn-primary value button\" value=\"(\">(</button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"zero\" class=\"btn btn-primary value button\" value=\"0\">0</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\" id=\"point\" class=\"btn btn-primary value button\" value=\".\">.</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"submit\" id=\"equals\" class=\"btn btn-success value button\">=</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"division\" class=\"btn btn-secondary value button\" value=\"/\">/</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button type=\"button\"  id=\"rightBracket\" class=\"btn btn-primary value button\" value=\")\">)</button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<script src=\"webresources/jquery/jquery.js\"></script>\n");
      out.write("<script src=\"webresources/bootstrap/js/bootstrap.js\"></script>\n");
      out.write("<script src=\"webresources/bootstrap/js/bootstrap.bundle.js\"></script>\n");
      out.write("<script src=\"webresources/js/script.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
