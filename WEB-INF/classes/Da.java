import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class Da extends HttpServlet 
{

	static StringBuffer dupURL = new StringBuffer();
 	static int nurls=0,Furl=5,control=0,URLlist=0,Clist=0;	
 	static TreeSet trs;
 	Iterator it=null;
 	boolean flag=true;
 	static URLConnect u1=null,u2=null;
 	static String url="";
 	public static String[] list = new String[110];
 	static String URLtext="";
 	static HashMap pr = new HashMap();

	static String king;

	static int ucount=0;

   public void  doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
     {
	try
	{
		PrintWriter out=res.getWriter();
		
		
		String url=req.getParameter("url");

		this.king=url;
	
		crawl(url);


		if(ucount>0)
			out.println("<html><h1>New URL Inserted in the Server..<a href='http://localhost:8080//c1//SEARCH%20(main)-frame.html'>Home</a></h1></html>");
		else
		{
			out.println("<html><h1>URL Not Crawled Due To Security Reasons ..<a href='http://localhost:8080//c1//SEARCH%20(main)-frame.html'>Home</a></h1></html>");

	try
	{	
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("jdbc:odbc:vsearch","vsearch","search");
   
   Statement stmt1=con.createStatement();
			stmt1.executeUpdate("delete from addurl where url='" + url + "'");
			
		}
		catch(Exception ex)
		{
		}

		}



		

			
	}
	catch(Exception ex)
	{

		System.out.println(ex.toString());
	
	}
    }
public static void crawl(String cate) throws Exception 
	{
try
{
        
			url= "http://" + cate;	
			System.out.println("URL from crawl " + url);

			u1=new URLConnect(url,Furl);		
			u1.join();

}
catch(Exception e)
{
	System.out.println("Error in craw1" + e.toString());
}

	
} // end of crawl

public void enterpr(String s,int siz) throws Exception 
{
String s1="";
s1=s;

if(pr.containsKey(s1))
{
int n=Integer.parseInt(pr.get(s1).toString());
n++;
pr.put(s1,"" +n);
}
else
{
pr.put(s1,"1");
}
java.util.List list = new ArrayList(pr.entrySet());

Iterator it=list.iterator();
while(it.hasNext())
{
Map.Entry entry=(Map.Entry)it.next();
System.out.println("URL " + entry.getKey());

}
if(siz>0)
{
Runtime rt=null;
rt = rt.getRuntime();
rt.exec("C:/Program Files/Internet Explorer/IEXPLORE.EXE "+s1);
}
}//end enterpr	


	static class URLConnect extends Thread
	{   
		String URLPass;
		StringBuffer str;

		URLConnect(String URLName,int Furl)
		{
			try
			{
				URLPass=URLName;
				URL url = new URL(URLName);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.connect(); 
				if(connection.getResponseCode()!=200)
				{
					connection.disconnect();
					Furl++;				
				}
				else
				{
					BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
					String line;
					str = new StringBuffer();
					while((line=in.readLine())!=null)
					{
						str.append("*" + line);
						//System.out.println(URLName +" "+ " -- " + line);
						
					}
							
					in.close();
					start();
				}
			} // end of try			
			catch(Exception e)
			{
				System.out.println("Error in urlconnect " + e.toString());
				
			} // end of catch
		} // end of URLConnect constructor
		public void run()
		{
			try
			{
			
				search(str,URLPass);
//				System.out.println("URL Pass " + URLPass);
			}

			catch(Exception e)
			{
			}
			
		}
	}



	public static void search(StringBuffer str,String urlPass) throws Exception
	{
		
		
		
					
	
		try
		{
			int j=0,sav=0,v=0,p=0,flag=1;
			long i=0,len=0;

			String sov="";
			len = str.length(); // saves the length of source code
	 		
		

			relative(str.toString());
			absolute(str.toString());
					

			if(control>=0)
				connOther();
			else
				out();
		}

		
		catch(Exception e)
		{
				
			out();
		}
		
	}


public static void connOther()
	{
      
		if(control>=0)
		{
			control--;
			Clist++;

			if(Clist<=URLlist)
			{
							 
				u2=new URLConnect(list[Clist],0);  
			}
			else
				out();

		}
		else
		{
			out(); 
		} 	  

	}


public static void out()
	{
    connOther();
	
	}





	


	public static void relative(String str)
	{
		try
		{
			long i=0;
			int j=0,k=0,l=0;

			while(i<str.length())
			{
				j=str.indexOf("href=\"/",j);
				if(j!=-1)
				{
					j=j+6;
					k=0;
					k=str.indexOf("\"",j);

					if(k!=-1)
					{
						k=str.lastIndexOf("/",k);  
                   
						if(k!=-1)
						{ 
							k++;
							String bobby="";
							bobby=str.substring(j,k);
				   
							int a=0;
				  
							a=bobby.indexOf("?");

							if(a!=-1)
							{
								bobby=bobby.substring(0,a);
								a=bobby.lastIndexOf("/");
								if(a!=-1)
								{
									bobby=bobby.substring(0,a);
								}
							}

							int b=0;

							b=bobby.lastIndexOf("*");

							if(b!=-1)
							{
								bobby=bobby.substring(b+1,bobby.length());
								b=bobby.lastIndexOf("/");
								if(b!=-1)
								{
									bobby=bobby.substring(0,b);
								}
							}

							int c=0;

							c=bobby.indexOf("=");
							if(c!=-1)
							{
								bobby=bobby.substring(0,c);
								c=bobby.lastIndexOf("/");
								if(c!=-1)
								{
									bobby=bobby.substring(0,c);
								}
							} 
							// refine bobby
							if(bobby.equals(""))
							{
								bobby=" ";
							}
							else
								if(bobby.substring(bobby.length()-1).equals("/"))
								bobby=bobby.substring(0,bobby.length()-1);
							// refined bobby
							k=str.indexOf(">",k); 
							if(k!=-1)
							{
								l=str.indexOf("</a>",k);
								if(l!=-1)
								{
									String temp="";
									temp=str.substring(k,l);

									int p=0;
                
									p=dupURL.toString().indexOf(url+bobby);
									if(p==-1) // if found URL is not  a duplicate
									{

										int v=0;
										v=temp.indexOf("<");
										if(v==-1)
										{
											
										}
										else
										{
											
										}

										//System.out.println("ABS " + url+bobby+" ");

										storeKeywords(url+bobby);
											             



				 
										if(URLlist<100)
										{
											list[URLlist]=url+bobby;
											URLlist++;
										
											dupURL.append(url+bobby+" ");
										}
				 
									}
									 
								}
							}
						} 
					}
				}//if
				else
				i=str.length();
			}// end of while
		}
		catch(Exception e)
		{
		
		}		
	}







	public static void absolute(String str)
	{
		try
		{
			long i=0;
			int j=0,k=0,l=0,sav=0,vas=0,m=0;

			while(i<str.length())
			{		   
				sav=0;
				vas=0;
				j=str.indexOf("href=\"http://",j);

				if(j!=-1)
				{
					j=j+6;
					k=0;
					k=str.indexOf("\"",j);
                              
					if(k!=-1)
					{
						sav=k;
						k=str.lastIndexOf("/",k);  
						if(k!=-1)
						{ 
							if(k==(j+6))
								k=sav;
							else
							{
								m=str.substring(k,sav).indexOf(".");
								if(m==-1)
									k=sav;
							}
							
							String bobby="";
							bobby=str.substring(j,k);
					 
							
//							System.out.println(bobby);



							trs.add(bobby);							

						

							int a=0;
							a=bobby.indexOf("?");
							if(a!=-1)
							{
								bobby=bobby.substring(0,a);
								a=bobby.lastIndexOf("/");
								if(a!=-1)
								{
									bobby=bobby.substring(0,a);
								}
							}
							int b=0;
							b=bobby.lastIndexOf("*");
							if(b!=-1)
							{
								bobby=bobby.substring(b+1,bobby.length());
								b=bobby.lastIndexOf("/");
								if(b!=-1)
								{
									bobby=bobby.substring(0,b);
								}
							}
							int c=0;
							c=bobby.indexOf("=");
							if(c!=-1)
							{
								bobby=bobby.substring(0,c);
								c=bobby.lastIndexOf("/");
								if(c!=-1)
								{
									bobby=bobby.substring(0,c);
								}
							}

							// refine bobby
							if(bobby.substring(bobby.length()-1).equals("/"))
								bobby=bobby.substring(0,bobby.length()-1);

							// refined bobby

							k=str.indexOf(">",k); 
							if(k!=-1)
							{
								l=str.indexOf("</a>",k);
								if(l!=-1)
								{
                         
									String temp="";
									temp=str.substring(k,l);

									int p=0;
                
									p=dupURL.toString().indexOf(bobby);
									if(p==-1) // if found URL is not  a duplicate
									{
										int v=0;
										v=temp.indexOf("<");
										System.out.println("Relative :::::::::" + bobby);
								


										if(URLlist<100)
										{
											list[URLlist]=bobby;
											URLlist++;
											dupURL.append(bobby+" ");
			
										}
									}
								} // end of l 
							} // end of k
						}// end of k
					} // end of k
				}
				else
					i=str.length();
			}// end of while
		}
		catch(Exception e)
		{
			
		}
}



public static void storeKeywords(String url)
{


	try
	{	
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("jdbc:odbc:vsearch","vsearch","search");
   Connection con1=DriverManager.getConnection("jdbc:odbc:vsearch","vsearch","search");
   
   Statement stmt1=con1.createStatement();


				URL url2 = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
				connection.connect(); 
			if(connection.getResponseCode()!=200)
				{
					connection.disconnect();

				}
						
				
			else
				{
				
	BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
					String line;
					StringBuffer str = new StringBuffer();
ucount++;
					while((line=in.readLine())!=null)
					{
						str.append(" " + line);
						System.out.println(" "+ " -- " + line);

   PreparedStatement ps2=con.prepareStatement("insert into crawlurls values(?,?,?)");

   ps2.setString(1,king);
   ps2.setString(2,url);  
   ps2.setString(3,line);

   ps2.executeUpdate();
		System.out.println("welcome");

			}
	}

	}
	catch(Exception ex2)
	{
		System.out.println("err:: " + ex2.toString());
	}


}



}