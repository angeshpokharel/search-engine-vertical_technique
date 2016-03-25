import  javax.servlet.http.*;
import  javax.servlet.*;
import  java.io.*;

public class addURL extends HttpServlet
{

public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	PrintWriter out=res.getWriter();
out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
out.println("<html>");
out.println("<head>");
out.println("<title>Smart  Search</title>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'>");
out.println("</head>");

out.println("<body bgcolor='#FFFFFF'> ");
out.println("<table width='950' border='0' align='center'>");
out.println(" <tr>");
out.println(" <td><table width='950' border='0' cellpadding='0' cellspacing='0'>");
out.println("        <tr>");
 out.println("         <td><img src='images/smartq_01.gif' width='950' height='129'></td>");
  out.println("      </tr>");
   out.println("     <tr>");
    out.println("      <td><img src='images/smartq_02.gif' width='950' height='50'></td>");
     out.println("   </tr>");
       out.println(" <tr>");
        out.println("  <td><table width='100%' border='0' cellspacing='0' cellpadding='0'>");
         out.println("     <tr>");
           out.println("     <td width='32%'><img src='images/inn1_02.gif' width='304' height='63'></td>");
            out.println("    <td width='68%'><form name='form1' method='post' action=''>");
              out.println("      <input name='textfield' type='text' size='50'>");
               out.println("   </form></td>");
     out.println("         </tr>");
       out.println("     </table></td>");
       out.println(" </tr>");
      out.println(" <tr>");
       out.println("   <td><table width='100%' border='0' cellspacing='0' cellpadding='0'>");
        out.println("      <tr> ");
          out.println("      <td width='32%'><img src='images/inn1_04.gif' width='304' height='74'></td>");
           out.println("     <td width='68%'><form name='form2' method='post' action=''>");
             out.println("       <select name='select'>");
               out.println("       <option>Catergory</option>");
                 out.println("   </select>");
                  out.println("</form></td>");
out.println("              </tr>");
  out.println("          </table></td>");
   out.println("     </tr>");
     out.println("   <tr>");
       out.println("   <td><table width='100%' border='0' cellspacing='0' cellpadding='0'>");
         out.println("     <tr> ");
           out.println("     <td width='32%'><img src='images/inn1_05.gif' width='304' height='71'></td>");
             out.println("   <td width='68%'><form name='form1' method='post' action=''>");
               out.println("     <input name='textfield3' type='text' size='50'>");
                 out.println(" </form></td>");
out.println("              </tr>");
  out.println("          </table></td>");
    out.println("    </tr>");
      out.println("  <tr>");
        out.println("  <td><table width='100%' border='0' cellspacing='0' cellpadding='0'>");
          out.println("    <tr> ");
            out.println("    <td width='32%'><img src='images/inn1_06.gif' width='304' height='70'></td>");
              out.println("  <td width='68%'><form name='form3' method='post' action=''>");
                out.println("    <textarea name='textarea' cols='50' rows='6'></textarea>");
                  out.println("</form></td>");
out.println("              </tr>");
  out.println("          </table></td>");
    out.println("    </tr>");
      out.println("  <tr>");
        out.println("  <td><img src='images/inn1_08.gif' width='950' height='72' border='0' usemap='#Map'></td>");
out.println("        </tr>");
  out.println("    </table></td>");
out.println("  </tr>");
out.println("</table>");
out.println("<map name='Map'>");
  out.println("<area shape='rect' coords='360,14,510,65' href='#'>");
out.println("</map>");
out.println("</body>");
out.println("</html>");
}
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{}


}
