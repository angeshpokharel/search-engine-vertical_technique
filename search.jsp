<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 10px;
}
.style2 {
	font-size: 16px;
	color: #9933FF;
	font-weight: bold;
}
.style3 {font-size: 15px}
.style5 {color: #66FF99}
-->
</style></head>


<script language="javascript">
function check()
{
        var keyword=document.form1.keyword.value;
        if(keyword.length==0)
	{
	  alert("Please enter keyword");
	  return false;
  	}

  	
return true;
}


</script>



<body bgcolor="white">



 
  
  <img src="images/search.gif" width="100" height="100" align="left"/>
  <img src="images/vs.jpg"  width="196" height="137"  border="2"  style="border-collapse:separate" style="border-color:#FFFFCC"    align="right" />
  <marquee behavior="alternate" scrollamount="3" direction="right"><img src="images/directory_giff.jpg"  width="130" height="80"/></marquee> 
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  
  <marquee align="baseline" bgcolor="#9933FF" height="30" direction="right" hspace="30" scrollamount="3"  behavior="alternate" vspace="20 "style="border:groove"><H2 class="style5">VERTICAL SEARCH WITH WEB-CRAWLER </H2>
  </marquee>
  <p>&nbsp;</p>
  
  
  

<%

             	String keywords=request.getParameter("keyword");

              	String cate=request.getParameter("cate");

			System.out.println("cate :: " +cate);
			System.out.println("kw :: " +keywords);

			String que="";

			if(!cate.equals("others"))
				que="select distinct urls from crawlurls where urls in (select url from addurl where category_id='"+ cate +"') and instr(upper(kw),'" + keywords.toUpperCase() +"')>0";
			else
				que="select distinct urls from crawlurls where instr(upper(kw),'" + keywords.toUpperCase() +"')>0";
		
	System.out.println(que);
	try
        {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          Connection 	con=DriverManager.getConnection("jdbc:odbc:vsearch","vsearch","search");
          Statement stmt=con.createStatement();
	  
          ResultSet rs=stmt.executeQuery(que);
		

	System.out.println("welcome11");

	boolean flag=false;
	
	while(rs.next())
	{
	//System.out.println("welcome00" + rs.getString(1));
	
String urllink=rs.getString(1);
	out.println("<br><br><h3><a href='http://"+ urllink + " ' target=_top>"+urllink+"</a> </h3>");

		flag=true;
	}


	if(!flag)
	out.println("No matched urls found");

	
	System.out.println("welcome22");
	rs.close();
	con.close();
    }

     catch(Exception ex)
	{
		System.out.println("Error from jsp : " + ex.toString());
	}	

%>
<form id="form1" name="form1" method="post" action="" onsubmit="return check()">
  
  <p align="center">
    <label for="textfield"> 
   <span class="style2"><img  src="images/web1.bmp" /><h2>SEARCH RESULTS</h2></span>  
   
   &nbsp;&nbsp;</label>
    <span class="style3">
   <label for="label3"></label>
    </span>
    <label for="select"></label>




    <label for="label4"></label>
  &nbsp;&nbsp;&nbsp;&nbsp; 
  </p><CENTER>
<a href="./SEARCH (main)-frame.html" target=_top><h3> BACK </h3></a> </CENTER>
  <p>&nbsp;</p>
  <p>&nbsp; </p>
</form>
<p>&nbsp; </p>


</body>
</html>
