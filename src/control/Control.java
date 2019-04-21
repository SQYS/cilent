package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import dao.view.View;
import util.UserInput;

public class Control {
	private View v;
	private UserInput ui;
	//创建套接字对象
	private Socket client;
	//创建输入输出流
	private Scanner in;
	private PrintWriter out;
	public static final String IP="10.10.49.193";
	public static final int PORT=6666;
	public Control() {
		
		this.v=new View();
		this.ui = new UserInput();
		try {
			this.client=new Socket(IP, PORT);
			//实例化输入输出流
			in=new Scanner(client.getInputStream());
			out=new PrintWriter(client.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//创建方法  接收整数的方法  接收字符串的方法 发送字符串的方法 发送整数的方法
			private int getInt(){
				return Integer.parseInt(in.nextLine());
			}
			private String getString(){
				return in.nextLine();
			}
			private void sendString(String msg){
				out.println(msg);
				out.flush();
			}
			private void sendInt(int i){
				out.println(i);
				out.flush();
			}
			//创建一个接收对象的方法
			private Object getObject(){
				try {
					ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
					return ois.readObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			//自定义方法-项目流程方法
		    public void start(){
		    	while(true){
					this.v.welcome();
					int select=this.ui.getInt("请选择：");
					//将指令发送给服务器端
					this.sendInt(select);
					if(select==1){
						this.eEenter();
						this.v.eScreen();
						int select1=this.ui.getInt("请选择：");
						this.sendInt(select);
						if(select1==1){//点菜
						this.v.eScreen101();
						}else if(select1==2){
							this.eCard();
						}else if(select1==3){
							this.eDeposit();
						}else if(select1==4){
							this.eDeposit();
						}
					}else if(select==2){
						this.mEenter();
						this.v.mScreen();
					}
					}
		    	
		    	
	}
		
			//创建员工登录的方法
		    public void eEenter(){
	    		int id = this.ui.getInt("请输入账号：");
	    		String password = this.ui.getString("请输入密码：");
	    	} 
		  //创建经理登录的方法
		    public void mEenter(){
	    		int id = this.ui.getInt("请输入账号：");
	    		String password = this.ui.getString("请输入密码：");
	    	} 
		    //创建办理会员卡的方法
		   public void eCard(){
			   String name = this.ui.getString("请输入姓名：");
			   String sex = this.ui.getString("请输入性别");
			   int money = this.ui.getInt("请输入充值金额：");
			   this.ui.getString("请选择会员级别：");
		   }
		  //创建会员卡充值的方法
		   public void eDeposit() {
				int id = this.ui.getInt("请输入会员卡id：");
				v.println("----------会员信息如下----------");
				v.println("会员卡id\t\t姓名\t\t性别\t\t余额\t\t级别");
				int money = this.ui.getInt("请输入充值金额：");
				this.ui.getString("是否确认充值：(y/n)");
				
			}
}
