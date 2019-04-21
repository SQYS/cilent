package dao.view;

public class View {
	public void welcome(){
		System.out.println("----------欢迎光临亚惠餐厅管理系统----------");
		System.out.println();
		System.out.println();
		System.out.print("1、员工登录\t\t\t2、经理登录");
	}
	public void eScreen(){
		System.out.println("1、点菜");
		System.out.println("2、办理会员卡");
		System.out.println("3、会员卡充值");
		System.out.println("4、会员卡挂失");
	}
	public void eScreen101(){
		System.out.println("1、选择菜品");
		System.out.println("2、删除菜品");
		System.out.println("3、结账");
	}
	public void eScreen02(){
		
	}
	public void println(String msg){
		System.out.println(msg);
	}
	public void mScreen(){
		System.out.println("1、员工管理");
		System.out.println("2、菜品管理");
		System.out.println("3、菜品种类管理");
		System.out.println("4、会员卡管理");
		System.out.println("5、统计信息");
	}
	public void mScreen01(){
		System.out.println("1、增加员工信息");
		System.out.println("2、查询员工信息");
		System.out.println("3、修改员工信息");
		System.out.println("4、删除员工信息");
	}
	public void mScreen02(){
		System.out.println("1、增加菜品信息");
		System.out.println("2、查询菜品信息");
		System.out.println("3、修改菜品信息");
		System.out.println("4、删除菜品信息");
		System.out.println("4、设置特价菜品");
	}
	public void mScreen03(){
		System.out.println("1、添加菜品种类");
		System.out.println("2、查询菜品种类");
		System.out.println("3、修改菜品种类");
		System.out.println("4、删除菜品种类");
	}
	public void mScreen04(){
		System.out.println("冻结会员卡");
		System.out.println("会员卡解挂");
		System.out.println("修改会员卡额度");
	}
}
