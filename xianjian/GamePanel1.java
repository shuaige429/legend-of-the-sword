package xianjian;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


//-->效果1：运行程序程序后出现聊天背景和聊天内容<单句话>
//-->效果2通过空格按键控制效果1的出现和消失
//-->效果3
//java遵循单继承（类）多实现（接口）
public class GamePanel1 extends JPanel implements Runnable,KeyListener{
	//定义李家村图片的相关内容
	Image ljcImage;
	int ljcX;
	int ljcY;
	//定义阿旺婶图片的相关内容
	//用来存放阿旺婶所有图片的数组
	Image[] awsImage;
	int awsX;
	int awsY;
	//用来表示阿旺婶图片数组的下标
	int awsIndex;
	//啊朱
	Image[] azImage;
	int azX;
	int azY;
	int azIndex;
	//母鸡
	Image[] mjImage;
	int mjX;
	int mjY;
	int mjIndex;
	//旺财嫂
	Image[] wcsImage;
	int wcsX;
	int wcsY;
	int wcsIndex;
	//小孩
	Image[] xhImage;
	int xhX;
	int xhY;
	int xhIndex;
	//小鸡
	Image[] xjImage;
	int xjX;
	int xjY;
	int xjIndex;
	//小鸡
	Image[] xxjImage;
	int xxjX;
	int xxjY;
	int xxjIndex;
	//定义李逍遥图片的相关内容
	Image[] lxyDownImages;
	Image[] lxyLeftImages;
	Image[] lxyRightImages;
	Image[] lxyUpImages;
	int lxyX;
	int lxyY;
	int lxyIndex;
	int lxyworkspeed = 10;   //李逍遥移动速度
	//用来表示李逍遥的当前方向
	int lxyDir;//规定：上=1；下=2；左=3；右=4；
	//用来表示李逍遥的当前最新图片内容（注意当李逍遥移动时需要将值进行更新）
	Image lxyImage;
	//定义聊天功能所需的相关内容
	Image ltImage;
	int ltX;
	int ltY;
	String ltMessage;
	String[] awsltMessages;
	String[] azltMessages;
	String[] wcsltMessages;
	String[] xhltMessages;
	String faceman;
	int lxynow;
	int ltMessageIndex;
	//李逍遥骚话
		 String[] ltlxy0Messages;
		 int ltlxy0MessageIndex;
		 //阿旺婶骚话
		 String[] ltawsMessages;
		 int ltawsMessageIndex;
		 String[] ltaws2Messages;
		 int ltaws2MessageIndex;
		 String[] ltaws3Messages;
		 int ltaws3MessageIndex;
		 String[] ltaws33Messages;
		 int ltaws33MessageIndex;
		 String[] ltaws4Messages;
		 int ltaws4MessageIndex;
         String[] ltaws5Messages;
         int ltaws5MessageIndex;

		 //阿朱骚话
		 String ltaz0Message;
		 String[] ltazMessages;
		 int ltazMessageIndex;
		 String ltaz3Message;
		 //旺财嫂骚话
		 String ltwcs0Message;
		 String[] ltwcsMessages;
		 int ltwcsMessageIndex;
		 String[] ltwcs2Messages;
		 int ltwcs2MessageIndex;
		 String[] ltwcs3Messages;
		 int ltwcs3MessageIndex;
		 //小孩骚话
		 String ltxh0Message;
		 String[] ltxhMessages;
		 int ltxhMessageIndex;
		 String[] ltxh2Messages;
		 int ltxh2MessageIndex;
		 
	//用来表示聊天的相关内容是否出现的相关值
	boolean isLTShow;
	//定义障碍物功能所需的相关内容
	BufferedImage ljcDataMap;
	
	int mapID;     //0片头  1李家村  2渔村  3十里坡  4十里坡怪物  5李家村怪物   6离开
	//定义李家村商场-
	Image[] ljcscImage;
	int ljcscX;
	int ljcscY;
	int ljcscIndex;
	BufferedImage ljcscDataMap;
	//任务框
	 Image jzImage;
	 int jzX;
	 int jzY;
	 boolean Taskbox = true;
	 String zxrenwu;             //支线任务
	 String renwu0;
	 String renwu1;
	 String renwu2;
	 String renwu3;
	 String renwu4;
	 String renwu5;
	 String renwu6;
	 String renwu7;
	 //定义箭头
	 Image[] hereImages;
	 int hereImageIndex;
	 //定义通关片尾
	 Image[] endImages;
	 Image wmtgImage;            //完美胜利插图
	 int endImageIndex;
	 //状态栏
	 Image ztlImage;
	 Image saveImage;
	 int ztlX;
	 int ztlY;
	 boolean ztlchuxian = true; 
	 //定义技能
	 Image[] jn1Images;
	 int jn1Index;
	 boolean isjineng = false;
	 //定义攻击
	 Image[] gjImages;
	 int gjIndex;
	 boolean isgongji = false;
	 //定义物品
	 Image wplImage;
	 Image jianImage;      //剑图片
	 Image kuijiaImage;    //盔甲图片
	 int wplX;
	 int wplY;
	 Image hbImage;
	 boolean ishaszhuangbei = false;    //初始化未获得装备
	 boolean wplchuxian;
	//定义十里坡场景
	Image slpImage;
	int slpX;
	int slpY;
	BufferedImage slpDatamap;
	//定义李逍遥打怪场景
	Image bjImage;         //打怪背景
	Image lxygqImage;      //李逍遥光圈图
	int lxygqX,lxygqY;
	
	Image gwgqImage;       //怪物光圈图
	int gwgqX=170,gwgqY=270;
	
	Image BossgqImage;     //Boss光圈图
	Image lxydgImage;      //李逍遥打怪图
	int lxydgX,lxydgY;
	ImageIcon gwImage;         //怪物图片
	int gwX=160,gwY=0;
	Image jntxImage;     //技能特效图片
	
	BufferedImage fj1Datamap;        //障碍物
	Image fj1Image;
	int fj1X;
	int fj1Y;                //定义房间1
	
	BufferedImage fj2Datamap;        //障碍物
	Image fj2Image;
	Image bxImage;
	boolean bxcunzai = true;
	int bxX = 320;
	int bxY = 300;
	int fj2X;
	int fj2Y;                //定义房间2
	
	int lxydqsm;      //李逍遥血量
	int lxyzsm;       //李逍遥最大生命值
	int gwdqsm;       //怪物血量
	int gwzsm;         //怪物最大生命值
	int lxygjl;       //李逍遥攻击力
	int gwgjl;        //怪物攻击力
	int lxydj;        //李逍遥等级
	int cg;           //场景
	int dl;          //获得道具
	int wpqr;         
	int[] wp;
	int wpqs;
	boolean wpcx;
	int lxydqll;
    int lxyzll;
    int llbg;
    int lxydqjy;
    int lxyzjy;
    boolean lxysj = false;      //李逍遥升级
    int lxyflz;
    int lxyfyl;
    Image zdslImage;
    Image hdymImage;            //获得羽毛
    Image hdzbImage;
    Image sjImage;
    ImageIcon hgImage;
    Image llbz;
    int yrdqsm;
    int yrzsm;
    int yrgjl;
	//定义片头
    Image[] ptImages;
    int ptIndex;
    Image begin;
    Image jwImage;
    Image yqImage;
   
    
	
	//构造方法-->用来完成初始化操作
	public GamePanel1(){
		//初始化李家村的相关内容
		try {
			//相对路径：在程序编程中，从绝对路径中的工程名称后面开始写
			//绝对路径：以盘符或者根目录(/)开始的路径
			ljcImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCun/0.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		ljcX=-200;
		ljcY=-200;
		
		//初始化房间1
		try {
			fj1Image = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian1/beijing.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		fj1X=100;
		fj1Y=100;
		
		
		//初始化房间1障碍物
		try {
			fj1Datamap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian1/RedMap.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		
		//初始化房间2
		try {
			hdzbImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/huodezb.png"));
			bxImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/baoxiang.png"));
			fj2Image = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/beijing.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		fj2X=100;
		fj2Y=100;
		
		//初始化房间2障碍物
		try {
			fj2Datamap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/RedMap.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		
		//初始化阿旺婶图片的相关内容
		awsImage = new Image[17];
		for(int i=0;i<17;i++){
			//将i。png图片读取到图片内存中，保存在对应数组的第i个下标位置上
			try {
				awsImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/AWangShen/"+i+".png"));
				IOException e;
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
			
		awsX=650;
		awsY=500;
		awsIndex=0;
		//初始化啊朱的内容
		azImage = new Image[5];
		for(int i=0;i<5;i++){
			try {
				azImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/AZhu/"+i+".png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		azX=730;
		azY=250;
		azIndex=0;
		//初始化母鸡
		mjImage =new Image[5];
		for(int i=0;i<5;i++){
			try {
				mjImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/MuJi/"+i+".png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		mjX=azX+20;
		mjY=azY+80;
		mjIndex=0;
		//初始化旺财嫂
		wcsImage = new Image[14];
		for(int i=0;i<14;i++){
			try {
				wcsImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/WangCaiSao/"+i+".png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		wcsX=600;
		wcsY=650;
		wcsIndex=0;
		//初始化小孩
		xhImage = new Image[4];
		for(int i=0;i<4;i++){
			try {
				xhImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/XiaoHai/"+i+".png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}		
		}
		xhX=890;
		xhY=570;
		xhIndex=0;
		//初始化小鸡
		xjImage = new Image[2];
		for(int i=0;i<2;i++){
			try {
				xjImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/XiaoJi/"+i+".png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		xjX=mjX-20;
		xjY=mjY+30; 
		xjIndex=0;
		//初始化小鸡
		xxjImage = new Image[2];
		for(int i=0;i<2;i++){
		try {
				xxjImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/XiaoXiaoJi/"+i+".png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		
		}
		xxjX=xjX;
		xxjY=xjY+30;
		xxjIndex=0;
		//初始化李逍遥图片的相关内容
		lxyDownImages = new Image[8];
		lxyLeftImages = new Image[8];
		lxyRightImages = new Image[8];
		lxyUpImages= new Image[8];
		for(int i=0;i<lxyDownImages.length;i++){
			try {
				lxyDownImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiXiaoYao_Down/"+i+".png"));
				lxyLeftImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiXiaoYao_Left/"+i+".png"));
				lxyRightImages[i] = ImageIO.read(
						new File ("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiXiaoYao_Right/"+i+".png"));
				lxyUpImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiXiaoYao_Up/"+i+".png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			lxyX=1000;
			lxyY=500;
			lxyIndex=0;
//			lxyDir = KeyEvent.VK_DOWN;
			//lxyDir=2;
			lxyImage = lxyDownImages[lxyIndex];
		}
		//初始化聊天功能所需的相关内容
		 //初始化聊天功能所需的相关内容
		 faceman = "meiyou";
		 ltaz0Message = new String("小鸡.小鸡.快长大");
		 ltwcs0Message = new String("村外的蝙蝠经常横行霸道");
		 ltxh0Message = new String("十里坡的大怪兽真的是太可怕了");
		 ltaz3Message = new String("阿朱已经去找了吧");
		 ltlxy0Messages = new String[]{"我是李逍遥，欢迎来到李家村","我的梦想是走出李家村，跟我一起冒险吧！","我去和阿旺婶说一下"};
		 ltazMessages = new String[]{"李逍遥：阿朱~","阿朱：逍遥啊！什么事","李逍遥：你能不能帮我去把旺财领回家","阿朱：他在哪儿啊","李逍遥：在和小伙伴玩呢","一定要你去才肯回家","阿朱：好的，我这就去"};
		 ltawsMessages =new String[]{"李逍遥：阿旺婶","阿旺婶：哟，是逍遥啊！！","李逍遥：我跟你说个...","阿旺婶：你帮我去旺财嫂那边拿几件衣服来","李逍遥：那个...","阿旺婶：快点","李逍遥：好吧阿旺婶，我去去就回"};
		 ltaws3Messages = new String[]{"李逍遥：阿旺婶，你要的衣服","阿旺婶：谢谢逍遥啦","李逍遥：我想去外面的世界看看","阿旺婶你见多识广，我该怎样锻炼自己呢","阿旺婶：要是你能收集到村西蝙蝠怪的羽毛，","你就有本事去冒险了","李逍遥：我这就去！","阿旺婶：别急，总不能手无寸铁的去吧。","去村里的空屋子找找，没准有宝贝"};
		 ltaws33Messages = new String[]{"阿旺婶：怎么了？不敢","李逍遥：呵呵，等着"};
		 ltaws4Messages = new String[]{"李逍遥：婶，我把羽毛带回来了","阿旺婶：可以啊，逍遥","李逍遥：那我出去闯荡啦！！","阿旺婶：逍遥，你已经解锁了新的冒险，去村东的码头吧","打败了“他”，就开始你真正的闯荡了","李逍遥：好的阿旺婶，我走了","你保重"};
		 ltaws2Messages = new String[]{"阿旺婶：你怎么回来了？！！","李逍遥：溜了溜了.."};
		 ltwcsMessages = new String[]{"李逍遥：旺财嫂~~~","旺财嫂:去把我家旺财找回来","李逍遥：那个...","旺财嫂：他和别人去跳绳去了","李逍遥：哦~","李逍遥：就不能听我把话说完嘛(一脸无奈~~)"};
		 ltwcs3Messages = new String[]{"李逍遥：你家旺财回来了吧","旺财嫂：哦，回来了，你走吧","李逍遥：那我走了","等一下，我找你是阿旺婶要拿几件衣服","旺财嫂：就这点事？，你不早说","李逍遥：..."};
		 ltwcs2Messages = new String[]{"旺财嫂：快去快去","李逍遥：溜了溜了"};
		 ltxhMessages = new String[]{"李逍遥：喂，小屁孩，旺财呢","旺财：干嘛！","李逍遥：...现在小孩子讲话都这么diao的吗？","你妈找你回家吃饭！！","旺财：不去，除非...","你让我阿朱姐姐来带我回去","李逍遥：非得要阿朱吗？","旺财：不然我绝不回去","李逍遥：..."};
		 ltxh2Messages = new String[]{"旺财：嘿，你怎么还在这","李逍遥：迷路迷路"};

		 try {
				ltImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiaoTian/0.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		isLTShow=false;
		lxynow =0;
		//初始化任务框的相关内容
		 //任务栏初始
		 try {
			jzImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/RenWu/renwulan.png"));
			
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 jzX=625;
		 jzY=20;
		 zxrenwu=new String("击败海怪");
		 renwu1 = new String("找阿旺婶");
		 renwu2 = new String("找旺财嫂");
		 renwu3 = new String("找 旺 财");
		 renwu4 = new String("找 阿 朱");
		 renwu5 = new String("收集羽毛");
		 renwu6 = new String("回去找阿旺婶");
		 renwu7 = new String("开启村东码头");
		 //初始化箭头
		 hereImages = new Image[15];
		 for(int i=0;i<hereImages.length;i++){
			 try {
				int mid=i+1;
				hereImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/here/wenhao_"+mid+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 //初始化完美通关插图
		 try {
			wmtgImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/tongguan/happyending.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//初始化通关片尾
		 endImageIndex = 0;
		 endImages = new Image[150];
		 for(int i=0;i<endImages.length;i++){
			 try {
				int mid=i+1;
				endImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/tongguan/"+mid+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 //初始化攻击
		 gjIndex = 0;
		 gjImages = new Image[9];
		 for(int i=0;i<gjImages.length;i++){
			 try {
				 int mid = i+1;
				 gjImages[i] = ImageIO.read(new File("texiao/jineng2_"+mid+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 //初始化技能
		 jn1Index = 0;
		 jn1Images = new Image[26];
		 for(int i=0;i<jn1Images.length;i++){
			 try { 
				 int mid = i+1;
				 jn1Images[i] = ImageIO.read(new File("texiao/jineng1_"+mid+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		//状态栏初始
		 try {
			saveImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/save.png"));
			ztlImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/RenWu/ztl.png"));
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		 ztlX=10;
		 ztlY=10;
		 ztlchuxian = true;

		lxyfyl=10;
		lxyflz=100;
		//物品栏初始
		 try {
			 jianImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/jian.png"));
			 kuijiaImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/kuijia.png"));
			 wplImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/RenWu/wpl.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 wplX = 290;
		 wplY = 685;
		 wplchuxian = true;
		 try {
				hbImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/RenWu/yumao.png"));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		//初始化障碍物功能所需的相关内容
		try {
			ljcDataMap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCun/RedMap.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//初始化首个场景
		mapID=0;
		ljcscImage = new Image[3];
		for(int i=0;i<2;i++)
		{
				try {
					ljcscImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCunShiChang/"+i+".png"));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		ljcscX=200;
		ljcscY=200;
		ljcscIndex=0;
		//初始化障碍物功能所需的相关内容
			try {
				ljcscDataMap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCunShiChang/RedMap.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		//初始化十里坡
			try {
				slpImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/ShiLiPo/0.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			slpX=100;
			slpY=100;
			try {
				slpDatamap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/ShiLiPo/RedMap.jpg"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		//初始化战斗场景
			try {
				lxygqImage = ImageIO.read(new File("texiao/guangquan_1.png"));
				gwgqImage = ImageIO.read(new File("texiao/guangquan_2.png"));
				BossgqImage = ImageIO.read(new File("texiao/guangquan_3.png"));
				jntxImage = ImageIO.read(new File("texiao/texiao1_1.gif"));
				bjImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/pkbg.png"));
				
				gwImage = new ImageIcon("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/guaiwu_2.gif");
				//用ImageIcon 获取动图
				
				lxydgImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/lxyzd.png"));
				zdslImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/zdsl.png"));
				hdymImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/huodeym.png"));
				sjImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/shengji.png"));
				
				hgImage = new ImageIcon("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/haiguai.gif");
				//用ImageIcon 获取动图

				llbz = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/linglibuzu_2.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			lxydqsm=100;  
			lxyzsm=100;
			gwdqsm=50;
			gwzsm=50;
			lxygjl=5;
			gwgjl=15;
			lxydj=1;
			cg=0;
			dl=0;
			wp=new int[]{0,0,0,0,0,0,0,0,0,0,0};
			wpqs=0;
			wpcx=false;
			lxydqll=100;
			lxyzll=100;
			llbg=0;
			lxydj=1;
			lxydqjy=0;
			lxyzjy=50;
			lxysj=false;
			yrdqsm=150;
			yrzsm=150;
			yrgjl=15;
			//片头
			ptImages = new Image[60];
			for(int i1=0;i1<60;i1++){
				try {
					ptImages[i1] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/PianTou/"+i1+".png"));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			try {
				
				begin = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/PianTou/bg_15.jpg"));

				
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			//结尾 
			try {
				jwImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/zdsb.jpg"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				yqImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCun/yuanqu.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	
	//绘画方法
	public void paint(Graphics g){
		//绘画游戏项目的界面
		
		if(ishaszhuangbei) {
			lxygjl=10;
			gwgjl=5;
			lxyfyl = 20;
		}                      //如果拥有装备，怪物攻击力降低，lxy攻击力增加
		
		//g-->可以理解成一支画笔
		if(mapID==0){	
			
			g.drawImage(begin,0,0,this);
			
			g.drawImage(Toolkit.getDefaultToolkit().
					getImage(GamePanel1.class.getResource("guide.gif")), 0, 75, this);
			
			g.drawImage(Toolkit.getDefaultToolkit().
					getImage(GamePanel1.class.getResource("schedule.gif")), 35, 620, this);
			
			g.setColor(new Color(139,105,20));
			g.setFont(new Font("楷体",Font.BOLD,30));
			g.drawString("旧的回忆",800,600);    	
		    g.drawString("新的冒险",795,540);
			
		}
		if(mapID==1){
		
		//补充：更新李家村图片的坐标
		ljcX=(this.getWidth()-lxyImage.getWidth(null))/2-lxyX;
		ljcY=(this.getHeight()-lxyImage.getHeight(null))/2-lxyY;
		if(ljcX>0)ljcX=0;
		if(ljcX<-1920+1024)ljcX=-1920+1024;
		if(ljcY>0)ljcY=0;
		if(ljcY<-1440+768) ljcY=-1440+768; 
		//ljcX=(this)
		//将李家村图片的相关内容绘画到画板上
		g.drawImage(ljcImage,ljcX,ljcY,this);
		
		if(lxynow<=4){
			g.drawImage(azImage[azIndex],azX+ljcX,azY+ljcY,this);
			g.drawImage(mjImage[mjIndex], mjX+ljcX, mjY+ljcY, this);
			g.drawImage(xhImage[xhIndex],xhX+ljcX,xhY+ljcY,this);
		g.drawImage(xjImage[xjIndex], xjX+ljcX, xjY+ljcY, this);
		g.drawImage(xxjImage[xxjIndex],xxjX+ljcX, xxjY+ljcY, this);
		}
		g.drawImage(awsImage[awsIndex],awsX+ljcX,awsY+ljcY,this);
		g.drawImage(wcsImage[wcsIndex], wcsX+ljcX, wcsY+ljcY, this);
		//将李逍遥图片的相关内容呈现到画板上
		
		 //箭头
		 if(lxynow == 1||lxynow ==6||lxynow==8){
			 g.drawImage(hereImages[hereImageIndex],awsX+ljcX,awsY+ljcY-60,this);
		 }
		 if(lxynow == 2||lxynow ==5){
			 g.drawImage(hereImages[hereImageIndex],wcsX+ljcX,wcsY+ljcY-60,this);
		 }
		 if(lxynow ==3){
			 g.drawImage(hereImages[hereImageIndex],xhX+ljcX,xhY+ljcY-60,this);
		 }
		 if(lxynow == 4){
			 g.drawImage(hereImages[hereImageIndex],azX+ljcX,azY+ljcY-60,this);
		 }
		if(lxyX+ljcX<-30) lxyX=1024-ljcX;
		if(lxyY+ljcY<-108) lxyY=-108-ljcY;
		if(lxyX+ljcX>1024-30) lxyX=1024-30-ljcX;
		if(lxyY+ljcY>768-110) lxyY=768-110-ljcY;
		if(lxyX>=1750&&lxyY<=750 && lxynow>=9){
			mapID=2;
			lxyX=20;
			lxyY=650;
		}else if (lxyX<20) {
			mapID=3;
			lxyX=1350;
			lxyY=1600;
		} 
		else if(lxyX>=980&&lxyY<=430)
		{
			mapID=7;
			lxyX=250;
			lxyY=470;
		}
		else if(lxyX>=1100&&lxyX<=1200&&lxyY<=700)
		{
			mapID=8;
			lxyX=250;
			lxyY=470;
		}

		g.drawImage(lxyImage,lxyX+ljcX,lxyY+ljcY,this);
		//将聊天功能的相关内容话到画板上
		if(isLTShow){
			 //聊天框的位置
		     ltX = ((this.getWidth()-ltImage.getWidth(null)))/2;
		     ltY = this.getHeight()-ltImage.getHeight(null);

		    g.drawImage(ltImage,ltX,ltY,this);
			g.setColor(Color.white);
	    	g.setFont(new Font("楷体",Font.BOLD,25));
	    	int tx=20;
	    	int ty=55;
		    if(lxynow == 0){

			    g.drawString(ltlxy0Messages[ltlxy0MessageIndex],ltX+tx,ltY+ty);
		    }
		    if(faceman == "aws"){
	
		    		if(lxynow == 1){
		    			
					    g.drawString(ltawsMessages[ltawsMessageIndex],ltX+tx,ltY+ty);
		    		}
			    	if(lxynow >= 2&&lxynow<6){
			    		
					    g.drawString(ltaws2Messages[ltaws2MessageIndex],ltX+tx,ltY+ty);
			    	}
			    	if(lxynow==6){
			    		
					    g.drawString(ltaws3Messages[ltaws3MessageIndex],ltX+tx,ltY+ty);
			    	}
			    	if(lxynow==7||lxynow ==9){
			    	
					    g.drawString(ltaws33Messages[ltaws33MessageIndex],ltX+tx,ltY+ty);
			    	}
			    	if(lxynow == 8){
			    
					    g.drawString(ltaws4Messages[ltaws4MessageIndex],ltX+tx,ltY+ty);
			    	}
//			    	if(lxynow == 10){
//			  
//					    g.drawString(ltaws5Messages[ltaws5MessageIndex],ltX+tx,ltY+ty);
//			    	}
			    }
		    if(faceman == "az"){
		    	        if(lxynow <4){
		    	    
					    	g.drawString(ltaz0Message,ltX+tx,ltY+ty);
		    	        }
				    	if(lxynow == 4){
	
					    	g.drawString(ltazMessages[ltazMessageIndex],ltX+tx,ltY+ty);
				    	}
				    	if(lxynow >4){
					    	g.drawString(ltaz3Message,ltX+tx,ltY+ty);
				    	}
				    }
				    
			if(faceman == "xh"){
				if(lxynow <2){

			    	g.drawString(ltxh0Message,ltX+tx,ltY+ty);
				}
				if(lxynow == 3){

			    	g.drawString(ltxhMessages[ltxhMessageIndex],ltX+tx,ltY+ty);
				}
				 if(lxynow >=4){

				    	g.drawString(ltxh2Messages[ltxh2MessageIndex],ltX+tx,ltY+ty);
				 }
				 }
			if(faceman == "wcs"){
				if(lxynow<2||lxynow>5){

			    	g.drawString(ltwcs0Message,ltX+tx,ltY+ty);
				}
				 	if(lxynow == 2){

				    	g.drawString(ltwcsMessages[ltwcsMessageIndex],ltX+tx,ltY+ty);
				 	}
				    if(lxynow >=3&&lxynow<5){

				    	g.drawString(ltwcs2Messages[ltwcs2MessageIndex],ltX+tx,ltY+ty);
				    }
				    if(lxynow ==5){

				    	g.drawString(ltwcs3Messages[ltwcs3MessageIndex],ltX+tx,ltY+ty);
				    }
			}
		
		 } 
		//任务系统
		 if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("时尚中黑简体",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("楷体",Font.BOLD,20));
			 if(lxynow == 1){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 2){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 3){
			    	g.drawString(renwu3,jzX+200,jzY+250);
			 }
			 if(lxynow == 4){

			    	g.drawString(renwu4,jzX+200,jzY+250);
			 }
			 if(lxynow == 5){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 6){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 7){
			    	g.drawString(renwu5,jzX+200,jzY+250);
			 }
			 if(lxynow == 8||lxynow ==10){
			    	g.drawString(renwu6,jzX+200,jzY+250);
			 }
			 if(lxynow == 9){
			    	g.drawString(renwu7,jzX+200,jzY+250);
			 }

		 }
		
		//状态系统
		 if(ztlchuxian){
			 g.drawImage(saveImage, ztlX+180, ztlY, this);
			 g.drawImage(ztlImage,ztlX,ztlY,this);
			 g.setColor(Color.WHITE);
			 g.setFont(new Font("楷体",Font.BOLD,20));
		     g.drawString(lxydj+" ",ztlX+68,ztlY+145);
		     g.setFont(new Font("楷体",Font.BOLD,15));
			 g.drawString(lxyzsm+" ",ztlX+230,ztlY+62);
			 g.drawString(lxydqjy+"/"+lxyzjy,ztlX+350,ztlY+62);
			 g.drawString(lxygjl+" ",ztlX+230,ztlY+87);
			 g.drawString(lxyfyl+" ",ztlX+230,ztlY+112);
			 g.drawString(lxyzll+" ",ztlX+350,ztlY+87);
			 g.drawString(lxyflz+" ",ztlX+350,ztlY+112);
		 }
		//物品栏
		 if(wplchuxian){
			 g.drawImage(wplImage,wplX,wplY,this);
			 if(ishaszhuangbei) {
				 g.drawImage(kuijiaImage,wplX+416,wplY+4,this);
				 g.drawImage(jianImage,wplX+460,wplY+4,this);
			 }
			 if(wp[1]>0)
			 {
				g.drawImage(hbImage,wplX+7,wplY+4,this);
				g.setColor(Color.white);
			    g.setFont(new Font("楷体",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 if (wp[2]>0) {
				g.setColor(Color.white);
				   g.setFont(new Font("楷体",Font.BOLD,20));
				    g.drawString(" "+wp[2],wplX+68,wplY+42);
			}
		 }

		//g.fillRect(ljcX+1750 , ljcY+750, 500, 500);
	}else if(mapID == 2){
		//绘画李家村市场场景
		ljcscX=(1024-60)/2-lxyX;
		ljcscY=(768-108)/2-lxyY;
		if(ljcscX>0)ljcscX=0;
		if(ljcscX<-1920+1024)ljcscX=-1920+1024;
		if(ljcscY>0)ljcscY=0;
		if(ljcscY<-1200+768) ljcscY=-1200+768; 
		g.drawImage(ljcscImage[ljcscIndex],ljcscX,ljcscY,this);
		
		if(lxyX+ljcscX<-30) lxyX=-30-ljcscX;
		if(lxyY+ljcscY<-108) lxyY=-108-ljcscY;
		if(lxyX+ljcscX>1024-30) lxyX=1024-30-ljcscX;
		if(lxyY+ljcscY>768-110) lxyY=768-110-ljcscY;
		if(lxyX<10){
			mapID=1;
			lxyX=1730;
			lxyY=750;
		}
		g.drawImage(lxyImage,lxyX+ljcscX,lxyY+ljcscY,this);
		g.drawImage(hgImage.getImage(),ljcscX+1450,ljcscY+280,this);
		//g.fillRect(ljcscX+1470 , ljcscY+320, 130, 130);
		//任务系统
		if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("时尚中黑简体",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("楷体",Font.BOLD,20));
			 if(lxynow == 1){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 2){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 3){
			    	g.drawString(renwu3,jzX+200,jzY+250);
			 }
			 if(lxynow == 4){

			    	g.drawString(renwu4,jzX+200,jzY+250);
			 }
			 if(lxynow == 5){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 6){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 7){
			    	g.drawString(renwu5,jzX+200,jzY+250);
			 }
			 if(lxynow == 8||lxynow ==10){
			    	g.drawString(renwu6,jzX+200,jzY+250);
			 }
			 if(lxynow == 9){
			    	g.drawString(renwu7,jzX+200,jzY+250);
			 }

		 }
		
		//状态系统
		 if(ztlchuxian){
			 g.drawImage(saveImage, ztlX+180, ztlY, this);
			 g.drawImage(ztlImage,ztlX,ztlY,this);
			 g.setColor(Color.WHITE);
			 g.setFont(new Font("楷体",Font.BOLD,20));
		     g.drawString(lxydj+" ",ztlX+68,ztlY+145);
		     g.setFont(new Font("楷体",Font.BOLD,15));
			 g.drawString(lxyzsm+" ",ztlX+230,ztlY+62);
			 g.drawString(lxydqjy+"/"+lxyzjy,ztlX+350,ztlY+62);
			 g.drawString(lxygjl+" ",ztlX+230,ztlY+87);
			 g.drawString(lxyfyl+" ",ztlX+230,ztlY+112);
			 g.drawString(lxyzll+" ",ztlX+350,ztlY+87);
			 g.drawString(lxyflz+" ",ztlX+350,ztlY+112);
		 }
		//物品栏
		 if(wplchuxian){
			 g.drawImage(wplImage,wplX,wplY,this);
			 if(ishaszhuangbei) {
				 g.drawImage(kuijiaImage,wplX+416,wplY+4,this);
				 g.drawImage(jianImage,wplX+460,wplY+4,this);
			 }
			 if(wp[1]>0)
			 {
				g.drawImage(hbImage,wplX+7,wplY+4,this);
				g.setColor(Color.white);
			    g.setFont(new Font("楷体",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 if (wp[2]>0) {
				g.setColor(Color.white);
				   g.setFont(new Font("楷体",Font.BOLD,20));
				    g.drawString(" "+wp[2],wplX+68,wplY+42);
			}
		 }

	}else if(mapID==3){
		slpX=(1024-60)/2-lxyX;
		slpY=(768-108)/2-lxyY;
		if(slpX>0)slpX=0;
		if(slpX<-1697+1024)slpX=-1697+1024;
		if(slpY>0)slpY=0;
		if(slpY<-1815+768) slpY=-1815+768; 
		g.drawImage(slpImage,slpX,slpY,this);
		
		if(lxyX+slpX<-30) lxyX=-30-slpX;
		if(lxyY+slpY<-108) lxyY=-108-slpY;
		if(lxyX+slpX>1024-30) lxyX=1024-30-slpX;
		if(lxyY+slpY>768-110) lxyY=768-110-slpY;
		if(lxyY>1650&&lxyX>1200){
			mapID=1;
			lxyX=30;
			lxyY=620;	
		}
		
		g.drawImage(lxyImage,lxyX+slpX,lxyY+slpY,this);
		
		if(lxysj) {
			g.drawImage(sjImage,270,210,this);
		}
		
		//g.fillRect(slpX+2 , slpY+1750, 500, 5000);
		//任务系统
		if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("时尚中黑简体",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("楷体",Font.BOLD,20));
			 if(lxynow == 1){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 2){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 3){
			    	g.drawString(renwu3,jzX+200,jzY+250);
			 }
			 if(lxynow == 4){

			    	g.drawString(renwu4,jzX+200,jzY+250);
			 }
			 if(lxynow == 5){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 6){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 7){
			    	g.drawString(renwu5,jzX+200,jzY+250);
			 }
			 if(lxynow == 8||lxynow ==10){
			    	g.drawString(renwu6,jzX+200,jzY+250);
			 }
			 if(lxynow == 9){
			    	g.drawString(renwu7,jzX+200,jzY+250);
			 }

		 }
		
		//状态系统
		 if(ztlchuxian){
			 g.drawImage(saveImage, ztlX+180, ztlY, this);
			 g.drawImage(ztlImage,ztlX,ztlY,this);
			 g.setColor(Color.WHITE);
			 g.setFont(new Font("楷体",Font.BOLD,20));
		     g.drawString(lxydj+" ",ztlX+68,ztlY+145);
		     g.setFont(new Font("楷体",Font.BOLD,15));
			 g.drawString(lxyzsm+" ",ztlX+230,ztlY+62);
			 g.drawString(lxydqjy+"/"+lxyzjy,ztlX+350,ztlY+62);
			 g.drawString(lxygjl+" ",ztlX+230,ztlY+87);
			 g.drawString(lxyfyl+" ",ztlX+230,ztlY+112);
			 g.drawString(lxyzll+" ",ztlX+350,ztlY+87);
			 g.drawString(lxyflz+" ",ztlX+350,ztlY+112);
		 }
		//物品栏
		 if(wplchuxian){
			 g.drawImage(wplImage,wplX,wplY,this);
			 if(ishaszhuangbei) {
				 g.drawImage(kuijiaImage,wplX+416,wplY+4,this);
				 g.drawImage(jianImage,wplX+460,wplY+4,this);
			 }
			 if(wp[1]>0)
			 {
				g.drawImage(hbImage,wplX+7,wplY+4,this);
				g.setColor(Color.white);
			    g.setFont(new Font("楷体",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 if (wp[2]>0) {
				g.setColor(Color.white);
				   g.setFont(new Font("楷体",Font.BOLD,20));
				    g.drawString(" "+wp[2],wplX+68,wplY+42);
			}
		 }

	}else if (mapID==4) {
		g.drawImage(bjImage,0,0,this);
		
		g.drawImage(gwgqImage, gwgqX, gwgqY, this);				 //怪物初始化
		g.drawImage(gwImage.getImage(), gwX, gwY, this);    
		//将ImageIcon 转置成Image 通过画笔实现gif图
		
		//技能
		if(isjineng) {
			for(int i=0;i<jn1Images.length;i++) {
				g.drawImage(jn1Images[jn1Index], gwX-100, gwY-60, this);		
			}
		}
		
		//攻击
		if(isgongji) {
			for(int i=0;i<gjImages.length;i++) {
				g.drawImage(gjImages[gjIndex], gwX-150, gwY+100, this);			
			}
		}
		
		g.drawImage(lxygqImage, 700, 550, this);			 //李逍遥初始化
		g.drawImage(lxydgImage, 760, 490, this);           
		
		
		g.drawRoundRect(590,5,400,120,20,30); 
		g.setFont(new Font("微软雅黑",Font.BOLD,45));
		g.setColor(Color.WHITE);
		g.drawString("李逍遥："+lxydqsm+"/"+lxyzsm, 600, 50);
		g.drawString("李逍遥："+lxydqll+"/"+lxyzll, 600, 100);
		g.drawString("蝙蝠怪："+gwdqsm+"/"+gwzsm, 600, 170);
		g.setColor(Color.white); 
		g.fillRoundRect(40,400,150,60,20,30); 
		g.fillRoundRect(40,470,150,60,20,30);
		g.fillRoundRect(40,540,150,60,20,30);
		g.fillRoundRect(40,610,150,60,20,30);
		g.setColor(Color.BLUE);
		g.setFont(new Font("百度综艺简体",Font.BOLD,35));
		g.drawString("攻击(Q)", 50, 440);
		g.drawString("技能(W)", 50, 510);
		g.drawString("物品(E)", 50, 580);
		g.drawString("逃跑(R)", 50, 650);
		if (wpcx==true) {
			g.drawImage(wplImage,wplX,wplY,this);
			 if(wp[1]>=0)
			 {
				g.drawImage(hbImage,wplX+7,wplY+4,this);
				g.setColor(Color.GRAY);
			    g.setFont(new Font("楷体",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 
		}
		if (wpqs==1) {
			g.drawString("物品不足", 550, 400);
		}
		if (llbg==1) {
			g.drawImage(llbz, 0, 290, this);
		}
		if(cg==1){
			g.drawImage(zdslImage, 405, 200, this);
			if(dl==1){
				g.drawImage(hdymImage, 0, 30, this);
			}	
		}
	}
	else if (mapID==5) {
		g.drawImage(bjImage,0,0,this);
		g.drawImage(BossgqImage, gwgqX, gwgqY, this);	         //怪物初始化
		g.drawImage(hgImage.getImage(), 220, 190, this);

		g.drawImage(lxygqImage, 700, 550, this);			 //李逍遥初始化
		g.drawImage(lxydgImage, 760, 490, this);    
		
		//技能
		if(isjineng) {
			for(int i=0;i<jn1Images.length;i++) {
				g.drawImage(jn1Images[jn1Index], gwX-100, gwY-60, this);		
			}
		}
		
		//攻击
		if(isgongji) {
			for(int i=0;i<gjImages.length;i++) {
				g.drawImage(gjImages[gjIndex], gwX-150, gwY+100, this);			
			}
		}
		
		g.drawRoundRect(490,5,500,120,20,30); 
		g.setFont(new Font("微软雅黑",Font.BOLD,45));
		g.setColor(Color.WHITE);
		g.drawString("李逍遥：生命"+lxydqsm+"/"+lxyzsm, 505, 55);
		g.drawString("李逍遥：灵力"+lxydqll+"/"+lxyzll, 505, 105);
		g.drawString("海  怪 ：生命"+yrdqsm+"/"+yrzsm, 510, 170);
		g.setColor(Color.white); 
		g.fillRoundRect(40,400,150,60,20,30); 
		g.fillRoundRect(40,470,150,60,20,30);
		g.fillRoundRect(40,540,150,60,20,30);
		g.fillRoundRect(40,610,150,60,20,30);
		g.setColor(Color.BLUE);
		g.setFont(new Font("百度综艺简体",Font.BOLD,35));
		g.drawString("攻击(Q)", 50, 440);
		g.drawString("技能(W)", 50, 510);
		g.drawString("物品(E)", 50, 580);
		g.drawString("逃跑(R)", 50, 650);
		if (wpcx==true) {
			g.drawImage(wplImage,wplX,wplY,this);
			 if(wp[1]>=0)
			 {
				g.drawImage(hbImage,wplX+7,wplY+4,this);
				g.setColor(Color.white);
			    g.setFont(new Font("楷体",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 
		}
		if (wpqs==1) {
			g.drawString("物品缺少", 550, 400);
		}
		if (llbg==1) {
			g.drawImage(llbz, 0, 290, this);
		}
		if(cg==1){
			g.drawImage(zdslImage, 405, 200, this);
			if(dl==1){
				g.drawImage(hdymImage, 0, 30, this);
			}	
		}
	}
	else if(mapID==7)
	{
		fj1X=(600-60)/2-fj1X;
		fj1Y=(768-108)/2-fj1Y;
		if(fj1X>0)fj1X=0;
		if(fj1X<-1697+1024)fj1X=-1697+1024;
		if(fj1Y>0)fj1Y=0;
		if(fj1Y<-1815+768) fj1Y=-1815+768; 
		g.drawImage(fj1Image,0,0,this);
		
		if(lxyX+fj1X<-30) lxyX=-30-fj1X;
		if(lxyY+fj1Y<-108) lxyY=-108-fj1Y;
		if(lxyX+fj1X>1024-30) lxyX=1024-30-fj1X;
		if(lxyY+fj1Y>768-110) lxyY=768-110-fj1Y;
		if(lxyX<300&&lxyY>480){
			mapID=1;
			lxyX=1000;
			lxyY=450;	
		}
		
		g.drawImage(lxyImage,lxyX+fj1X,lxyY+fj1Y,this);
		//g.fillRect(slpX+2 , slpY+1750, 500, 5000);
		//任务系统
		if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("时尚中黑简体",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("楷体",Font.BOLD,20));
			 if(lxynow == 1){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 2){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 3){
			    	g.drawString(renwu3,jzX+200,jzY+250);
			 }
			 if(lxynow == 4){

			    	g.drawString(renwu4,jzX+200,jzY+250);
			 }
			 if(lxynow == 5){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 6){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 7){
			    	g.drawString(renwu5,jzX+200,jzY+250);
			 }
			 if(lxynow == 8||lxynow ==10){
			    	g.drawString(renwu6,jzX+200,jzY+250);
			 }
			 if(lxynow == 9){
			    	g.drawString(renwu7,jzX+200,jzY+250);
			 }

		 }
		
		//状态系统
		 if(ztlchuxian){
			 g.drawImage(saveImage, ztlX+180, ztlY, this);
			 g.drawImage(ztlImage,ztlX,ztlY,this);
			 g.setColor(Color.WHITE);
			 g.setFont(new Font("楷体",Font.BOLD,20));
		     g.drawString(lxydj+" ",ztlX+68,ztlY+145);
		     g.setFont(new Font("楷体",Font.BOLD,15));
			 g.drawString(lxyzsm+" ",ztlX+230,ztlY+62);
			 g.drawString(lxydqjy+"/"+lxyzjy,ztlX+350,ztlY+62);
			 g.drawString(lxygjl+" ",ztlX+230,ztlY+87);
			 g.drawString(lxyfyl+" ",ztlX+230,ztlY+112);
			 g.drawString(lxyzll+" ",ztlX+350,ztlY+87);
			 g.drawString(lxyflz+" ",ztlX+350,ztlY+112);
		 }
		//物品栏
		 if(wplchuxian){
			 g.drawImage(wplImage,wplX,wplY,this);
			 if(ishaszhuangbei) {
				 g.drawImage(kuijiaImage,wplX+416,wplY+4,this);
				 g.drawImage(jianImage,wplX+460,wplY+4,this);
			 }
			 if(wp[1]>0)
			 {
				g.drawImage(hbImage,wplX+7,wplY+4,this);
				g.setColor(Color.white);
			    g.setFont(new Font("楷体",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 if (wp[2]>0) {
				g.setColor(Color.white);
				   g.setFont(new Font("楷体",Font.BOLD,20));
				    g.drawString(" "+wp[2],wplX+68,wplY+42);
			}
		 }
	}
	else if(mapID==8)
	{
		fj2X=(600-60)/2-fj2X;
		fj2Y=(768-108)/2-fj2Y;
		if(fj2X>0)fj2X=0;
		if(fj2X<-1697+1024)fj2X=-1697+1024;
		if(fj2Y>0)fj2Y=0;
		if(fj2Y<-1815+768) fj2Y=-1815+768; 
		g.drawImage(fj2Image,fj2X,fj2Y,this);
		if(bxcunzai)
			g.drawImage(bxImage,bxX,bxY,this);
		
		if(lxyX+fj2X<-30) lxyX=-30-fj2X;
		if(lxyY+fj2Y<-108) lxyY=-108-fj2Y;
		if(lxyX+fj2X>1024-30) lxyX=1024-30-fj2X;
		if(lxyY+fj2Y>768-110) lxyY=768-110-fj2Y;
		if(lxyX<300&&lxyY>480){
			mapID=1;
			lxyX=1210;
			lxyY=710;	
		}
		
		g.drawImage(lxyImage,lxyX+fj2X,lxyY+fj2Y,this);
		//g.fillRect(slpX+2 , slpY+1750, 500, 5000);
		//任务系统
		if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("时尚中黑简体",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("楷体",Font.BOLD,20));
			 if(lxynow == 1){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 2){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 3){
			    	g.drawString(renwu3,jzX+200,jzY+250);
			 }
			 if(lxynow == 4){

			    	g.drawString(renwu4,jzX+200,jzY+250);
			 }
			 if(lxynow == 5){
			    	g.drawString(renwu2,jzX+200,jzY+250);
			 }
			 if(lxynow == 6){
			    	g.drawString(renwu1,jzX+200,jzY+250);
			 }
			 if(lxynow == 7){
			    	g.drawString(renwu5,jzX+200,jzY+250);
			 }
			 if(lxynow == 8||lxynow ==10){
			    	g.drawString(renwu6,jzX+200,jzY+250);
			 }
			 if(lxynow == 9){
			    	g.drawString(renwu7,jzX+200,jzY+250);
			 }

		 }
		if(dl==2) {
			ishaszhuangbei = true;
			g.drawImage(hdzbImage, 0, 30, this);
		}

		 }else if(mapID==9) {
			 g.drawImage(bjImage,0,0,this);
			 g.drawImage(endImages[endImageIndex], 0, 0, this);
			 g.drawImage(wmtgImage, 330, 90, this);
		 }

		if (mapID==6) {
			g.drawImage(jwImage,0, 0, this);
			g.setColor(new Color(238, 59, 59));
			g.setFont(new Font("楷体",Font.BOLD,30));
			g.drawString("返回存档", 810, 582);
		}
//	}
	}
//运动方法
	@Override	
	public void run(){
		//实现配角的运动效果
		//也就是不断的循环切换图片内容，也就是不不断的循环修改对应数组的下标
		
		while(true){
			awsIndex++;
			if(awsIndex>= awsImage.length){
				awsIndex = 0;
			}
			azIndex++;
			if(azIndex>=azImage.length){
				azIndex=0;
			}
			mjIndex++;
			if(mjIndex>=mjImage.length){
				mjIndex=0;
			}
			wcsIndex++;
			if(wcsIndex>=wcsImage.length){
				wcsIndex=0;
			}
			xhIndex++;
			if(xhIndex>=xhImage.length){
				xhIndex=0;
			}
			xjIndex++;
			if(xjIndex>=xjImage.length){
				xjIndex=0;
			}
			xxjIndex++;
			if(xxjIndex>=xxjImage.length){
				xxjIndex=0;
			}
			ljcscIndex++;
			if(ljcscIndex>=ljcscImage.length){
				ljcscIndex=0;
			}
			hereImageIndex++;
			 if(hereImageIndex>=hereImages.length){
				 hereImageIndex=0;
			 }
			 
			 //通关片尾
			 endImageIndex++;
			 if(endImageIndex>=endImages.length) {
				 endImageIndex = endImages.length-1;
			 }
			 
			 //技能只释放一次
			 jn1Index++;
			 if(jn1Index>=jn1Images.length){
				 jn1Index=jn1Images.length-1;
			 }
			 
			 //攻击只攻击一次
			 gjIndex++;
			 if(gjIndex>=gjImages.length){
				 gjIndex=gjImages.length-1;
			 }
			 
			 ptIndex++;
			 if(ptIndex>=ptImages.length){
				 ptIndex=ptImages.length-1;
			 }

			//停顿操作
			try{
                Thread.sleep(130);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			
			//重画命令-->会自动调用执行paint();方法
			repaint();
		}
	}
	//keylistener接口中的方法
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		//e-->可以理解成事件源
		//System.out.print("键盘按键被按下");
		int keyCode = e.getKeyCode();
		if (mapID!=4){
			if(isLTShow){
				//聊天内容的切换+聊天结束的判断
				if(keyCode == KeyEvent.VK_SPACE&&lxynow == 0){
					ltlxy0MessageIndex++;
					if(ltlxy0MessageIndex>= ltlxy0Messages.length){
						ltlxy0MessageIndex = 0;
						lxynow = 1;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="aws"&&lxynow==1){
					ltawsMessageIndex++;
					if(ltawsMessageIndex>= ltawsMessages.length){
						lxynow = 2;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="aws"&&lxynow>=2&&lxynow <6){
					ltaws2MessageIndex++;
					if(ltaws2MessageIndex>= ltaws2Messages.length){
						ltaws2MessageIndex = 0;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="aws"&&lxynow==6){
					ltaws3MessageIndex++;
					if(ltaws3MessageIndex>= ltaws3Messages.length){
						lxynow=7;
						ltaws3MessageIndex = 0;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="aws"&&lxynow==7){
					ltaws33MessageIndex++;
					if(ltaws33MessageIndex>= ltaws33Messages.length){
						
						ltaws33MessageIndex = 0;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="aws"&&lxynow==8){
					ltaws4MessageIndex++;
					if(ltaws4MessageIndex>= ltaws4Messages.length){
						lxynow=9;
						wp[1]=wp[1]-2;
						ltaws4MessageIndex = 0;
						isLTShow = false;
					}
					repaint();
				}
//				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="aws"&&lxynow==10){
//					ltaws5MessageIndex++;
//					if(ltaws5MessageIndex>= ltaws5Messages.length){
//						lxynow=11;
//						wp[2]=wp[2]-1;
//						ltaws5MessageIndex = 0;
//						isLTShow = false;
////						lxynow=11;
//					}
//				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="az"&&lxynow==4){
					ltazMessageIndex++;
					if(ltazMessageIndex>= ltazMessages.length){
						lxynow = 5;
						ltazMessageIndex = 0;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="wcs"&&lxynow==2){
					ltwcsMessageIndex++;
					if(ltwcsMessageIndex>= ltwcsMessages.length){
						lxynow=3;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="wcs"&&lxynow>=3&&lxynow<5){
					ltwcs2MessageIndex++;
					if(ltwcs2MessageIndex>= ltwcs2Messages.length){
						ltwcs2MessageIndex = 0;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="wcs"&&lxynow==5){
					ltwcs3MessageIndex++;
					if(ltwcs3MessageIndex>= ltwcs3Messages.length){
						lxynow = 6;
						ltwcs3MessageIndex = 0;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="xh"&&lxynow == 3){
					ltxhMessageIndex++;
					if(ltxhMessageIndex>= ltxhMessages.length){
						ltxhMessageIndex = 0;
						lxynow = 4;
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="xh"&&lxynow >=4){
					ltxh2MessageIndex++;
					if(ltxh2MessageIndex>= ltxh2Messages.length){
						ltxh2MessageIndex = 0;
						
						isLTShow = false;
					}
					repaint();
				}
				else if(keyCode == KeyEvent.VK_SPACE &&faceman =="xh") {
					bxcunzai = false;
					repaint();
				}
				else{
					isLTShow = false;
				}
			}

				
			else{
				//李逍遥的移动+聊天开始的判断+场景切换的判断
				//实现主角的运动效果
				//也就是需要玩家按下的键盘按键，进行对应的操作(移动或者原地不动)
		
				//实现主角的运动效果
				//也就是需要玩家按下的键盘按键，进行对应的操作（移动或者原地不动）
				//System.out.print(keyCode);
				//上=38，下=40，左=37，右=39；w=87,s=83,a=65,d=68，空格=32；
				if(keyCode==38){
					//李逍遥需要向上移动
					//图片位置发生改变
					lxyY-=lxyworkspeed;
					repaint();
					//图片内容发生改变
					lxyIndex++;
					if(lxyIndex>=lxyUpImages.length){
						lxyIndex=0;
					}
					lxyImage=lxyUpImages[lxyIndex];	
					//方向发生改变
					lxyDir = KeyEvent.VK_UP;
					//补充：判断李逍遥是否进入障碍物区域
					int x = lxyX + lxyImage.getWidth(null) / 2;
					int y = lxyY + lxyImage.getHeight(null);
					
					if(mapID == 1){
						if(ljcDataMap.getRGB(x, y) == -521461){
							lxyY += lxyworkspeed;
							}
					}else if(mapID == 2){
						if(ljcscDataMap.getRGB(x, y) == -65536){
							lxyY += lxyworkspeed;
							//System.out.println(ljcscDataMap.getRGB(x, y));
						}
					}else if(mapID==3){
						if(slpDatamap.getRGB(x,y)== -131072){
							lxyY+=lxyworkspeed;
						}else if(Math.random()<0.02){
							mapID=4;
						}
					}else if(mapID == 7) {
						if(fj1Datamap.getRGB(x, y) < -60000){
							lxyY += lxyworkspeed;
						}
					}else if(mapID==8){
						if(fj2Datamap.getRGB(x,y)<-1000000){
							lxyY+=lxyworkspeed;
						}
					}

					
						/*lxyIndex--;
						if(lxyIndex <= -1){
							lxyIndex = 7;
						}
						lxyImage = lxyUpImages[lxyIndex];*/
					
					}
					if(keyCode==40){
						lxyY+=lxyworkspeed;
						repaint();
						lxyIndex++;
						if(lxyIndex>=lxyDownImages.length){
							lxyIndex=0;
						}
						lxyImage=lxyDownImages[lxyIndex];
						lxyDir = KeyEvent.VK_DOWN;
						int x = lxyX + lxyImage.getWidth(null) / 2;
						int y = lxyY + lxyImage.getHeight(null);
						
						if(mapID == 1){

							if(ljcDataMap.getRGB(x,y) == -521461){
								lxyY -= lxyworkspeed;
							}
						}else if(mapID == 2){
							if(ljcscDataMap.getRGB(x,y) == -65536){
								lxyY -= lxyworkspeed;
							}
						}else if(mapID==3){
							if(slpDatamap.getRGB(x,y)== -131072){
								lxyY-=lxyworkspeed;
							}else if(Math.random()<0.03){
								mapID=4;	
							}
						}else if(mapID == 7) {
							if(fj1Datamap.getRGB(x, y) < -60000){
								lxyY -= lxyworkspeed;
							}
						}else if(mapID==8){
							if(fj2Datamap.getRGB(x,y)<-1000000){
								lxyY-=lxyworkspeed;
							}
						}
					}
					if(keyCode==37){
						lxyX-=lxyworkspeed;
						repaint();
						lxyIndex++;
						if(lxyIndex>=lxyLeftImages.length){
							lxyIndex=0;
						}
						lxyImage=lxyLeftImages[lxyIndex];
						lxyDir = KeyEvent.VK_LEFT;
						int x = lxyX+lxyImage.getWidth(null)/2;
						int y = lxyY+lxyImage.getHeight(null);
						if(mapID==1&&ljcDataMap.getRGB(x,y)==-521461){
						lxyX +=lxyworkspeed;
						
						}else if(mapID == 2){
							if(ljcscDataMap.getRGB(x,y) == -65536){
								lxyX +=lxyworkspeed;
							}
						}else if(mapID==3){
							if(slpDatamap.getRGB(x,y)== -131072){
								lxyX+=lxyworkspeed;
							}else if(Math.random()<0.03){
								mapID=4;
							}
						}else if(mapID == 7) {
							if(fj1Datamap.getRGB(x, y) < -60000){
								lxyX+=lxyworkspeed;
							}
						}else if(mapID==8){
							if(fj2Datamap.getRGB(x,y)<-1000000){
								lxyX +=lxyworkspeed;
							}
						}
					}
					else if(keyCode==39){
						lxyX+=lxyworkspeed;
						repaint();
						lxyIndex++;
						if(lxyIndex>=lxyRightImages.length){
							lxyIndex=0;
						}
						lxyImage=lxyRightImages[lxyIndex];
						lxyDir = KeyEvent.VK_RIGHT;
						int x = lxyX+lxyImage.getWidth(null)/2;
						int y = lxyY+lxyImage.getHeight(null);
						if(mapID==1){
						if(ljcDataMap.getRGB(x,y)==-521461){
							lxyX -=lxyworkspeed;
							}
						}else if (mapID==2) {
							if(ljcscDataMap.getRGB(x, y)==-65536){
								lxyX -= lxyworkspeed;
							}
							
						}else if(mapID==3){
							if(slpDatamap.getRGB(x,y)== -131072){
								lxyX-=lxyworkspeed;
							}else if(Math.random()<0.03){
								mapID=4;
							}
						}else if(mapID == 7) {
							if(fj1Datamap.getRGB(x, y) < -60000){
								lxyX-=lxyworkspeed;
							}
						}else if(mapID==8){
							if(fj2Datamap.getRGB(x,y)<-1000000){
								lxyX -=lxyworkspeed;
							}
						}
						
					}

					if(mapID==1){
						if(keyCode == KeyEvent.VK_SPACE){
							if(lxynow == 0){
								isLTShow=!isLTShow;
							}
							//判断李逍遥是否走到其他角色面前
							int x = lxyX;
							int y = lxyY + lxyImage.getHeight(null);
							int x2 = awsX + awsImage[awsIndex].getWidth(null);
							int y2 = awsY +awsImage[awsIndex].getHeight(null);
							int x1 = x2-50;
							int y1 = y2-50;
							//李逍遥的方向==向左&&x>x1&&x<x2&&y>y1&&y<y2
							if(lxyDir == KeyEvent.VK_LEFT && x>=x1 && x<=x2 && y>=y1 && y<=y2){
								//控制效果一的出现和消失
								isLTShow=!isLTShow; 
								faceman = "aws";
								repaint();
							}
							
							int zy = lxyY;
							int zy2 = azY +azImage[azIndex].getHeight(null)+50;
							if(lxyDir == KeyEvent.VK_UP && zy<=zy2){
								isLTShow=!isLTShow;
								faceman = "az";
								repaint();
							}
							
							int wcsx = lxyX+lxyImage.getWidth(null);
							int wcsy = lxyY+lxyImage.getHeight(null);
							int wcsx2 = wcsX;
							int wcsy2 = wcsY +wcsImage[wcsIndex].getHeight(null)+50;
							int wcsx1 = wcsx2 + 50;
							int wcsy1 = wcsy2 - 100;
							if(lxyDir == KeyEvent.VK_RIGHT && wcsx>=wcsx2 && wcsx<=wcsx1 && wcsy>=wcsy1 && wcsy<=wcsy2){
								isLTShow=!isLTShow;
								faceman = "wcs";
								repaint();
							}
							
							int xhx = lxyX+lxyImage.getWidth(null);
							int xhy = lxyY+lxyImage.getHeight(null);
							int xhx2 = xhX;
							int xhy2 = xhY +xhImage[xhIndex].getHeight(null)+50;
							int xhx1 = xhx2 + 50;
							int xhy1 = xhy2 - 50;
							if(lxyDir == KeyEvent.VK_RIGHT && xhx>=xhx2 && xhx<=xhx1 && xhy>=xhy1 && xhy<=xhy2){
								isLTShow=!isLTShow;
								faceman = "xh";
								repaint();
							}
							
}
					
					
					}
					if(mapID==2){
						int yrx = lxyX+lxyImage.getWidth(null);
							int yry= lxyY+lxyImage.getHeight(null);
							int yrx2 = 1470;
							int yry2 = 320;
							int yrx1 = yrx2 + 130;
							int yry1 = yry2 + 130;
							
						    if(lxyDir == KeyEvent.VK_RIGHT&& yrx>=yrx2&&yrx<=yrx1&&yry>=yry2&&yry<=yry1){
						    	
									mapID=5;
			
						    }
					}
		}
		};
		if(mapID == 3 && lxysj)
		{
			if(keyCode == KeyEvent.VK_SPACE)
			{
				lxysj = false;
			}
			repaint();        //重绘十里坡
		}
		if (mapID==4) {
			if (wpqs==0&&cg!=1&&llbg==0) {
					if(keyCode == KeyEvent.VK_R){
					mapID=3;
					lxydqsm=lxyzsm;
					gwdqsm=gwzsm;
			}else if (keyCode == KeyEvent.VK_Q) {
				gwdqsm=gwdqsm-lxygjl;
				lxydqsm=lxydqsm-gwgjl;
				
				isgongji = true;
				gjIndex = 0;              //重新初始化攻击
				if(lxydqsm<=0) {
					lxydqsm = 0;
					mapID = 6;
				}
				else {
					if (gwdqsm<=0) {
						lxydqsm=lxydqsm+gwgjl;
						gwdqsm=0;
						cg=1;
						
						if (Math.random()<0.8) {
							dl=1;
							wp[1]++;
							if(wp[1]>=2){
								lxynow=8;
							}
						}
						lxydqjy+=20;
						if(lxydqjy>=lxyzjy){
							lxysj=true;
							lxydqjy=lxydqjy-lxyzjy;
							lxydj++;
							lxygjl=lxygjl+5;
							lxyzsm=lxyzsm+20;
							lxyzjy+=50;
							
						}
						if(lxydqsm<=0){
						mapID=6;
						}
					}
				}
				
			}else if (keyCode == KeyEvent.VK_W) {
				if(lxydqll>30){
					
					gwdqsm=gwdqsm-lxygjl*2;
					lxydqsm=lxydqsm-gwgjl;
					lxydqll=lxydqll-30;
					
					isjineng = true;
					jn1Index = 0;          //初始化技能
				}
				else {
					llbg=1;
				}
					 if (gwdqsm<=0) {
						lxydqsm=lxydqsm+gwgjl;
						gwdqsm=0;
						cg=1;
					if (Math.random()<0.8) {
						dl=1;
						wp[1]++;
						if(wp[1]>=2){
							lxynow=8;
						}

					}
					lxydqjy+=20;
					if(lxydqjy>=lxyzjy){
						lxysj=true;
						lxydqjy=lxydqjy-lxyzjy;
						lxydj++;
						lxygjl=lxygjl+5;
						lxyzsm=lxyzsm+20;
						lxyzjy+=50;
						
					}
					if(lxydqsm<=0){
						lxydqsm = 0;
						mapID=6;
					}
				}
				
			}else if(keyCode == KeyEvent.VK_E) {
				wpcx=!wpcx;	
				}
					System.out.print(keyCode);
				if (wpcx==true) {
					if(keyCode == KeyEvent.VK_1){
						if(wp[1]>0){
						wp[1]=wp[1]-1;
						lxydqsm=lxydqsm+50;
						if (lxydqsm>lxyzsm) {
							lxydqsm=lxyzsm;
						}
						lxydqsm=lxydqsm-gwgjl;
					}else {
						wpqs=1;
					}
				} 
				
			}
				}
				if(keyCode == KeyEvent.VK_SPACE){
				if (cg==1) {
					cg=0;dl=0;
					mapID=3;
					lxydqsm=lxyzsm;
					gwdqsm=gwzsm;
					lxydqll=lxyzll;
				}
				if(wpqs==1){
					wpqs=0;
				}
				if(llbg==1){
					llbg=0;
				}
			}
			repaint();
		}
		if (mapID==5) {
			if (wpqs==0&&cg!=1&&llbg==0) {
					if(keyCode == KeyEvent.VK_R){
					mapID=2;
					lxydqsm=lxyzsm;
					yrdqsm=yrzsm;
			}else if (keyCode == KeyEvent.VK_Q) {
				yrdqsm=yrdqsm-lxygjl;
				lxydqsm=lxydqsm-yrgjl;
				
				isgongji = true;
				gjIndex = 0;                //初始化攻击
				if(lxydqsm<=0) {
					lxydqsm=0;
					mapID = 6;
				}
				else {
					if (yrdqsm<=0) {
						lxydqsm=lxydqsm+yrgjl;
						yrdqsm=0;
						cg=1;
						if (Math.random()<1) {
							dl=1;
							wp[2]++;
							lxynow=10;
							mapID = 9;
							endImageIndex = 0;
						}
						lxydqjy+=20;
						if(lxydqjy>=lxyzjy){
							lxysj=true;
							lxydqjy=lxydqjy-lxyzjy;
							lxydj++;
							lxygjl=lxygjl+5;
							lxyzsm=lxyzsm+20;
							lxyzjy+=50;
							
						}else	if(lxydqsm<=0){
						mapID=6;
						}
					}
				}
				
			}else if (keyCode == KeyEvent.VK_W) {
				if(lxydqll>30){
					yrdqsm=yrdqsm-lxygjl*2;
					lxydqsm=lxydqsm-yrgjl;
					lxydqll=lxydqll-30;
					
					isjineng = true;
					jn1Index = 0;          //初始化技能
					
					if(lxydqsm<=0) {
						lxydqsm = 0;
						mapID = 6;
					}
					else {
						if (yrdqsm<=0) {
							lxydqsm=lxydqsm+yrgjl;
							yrdqsm=0;
							cg=1;
							if (Math.random()<1) {
								dl=1;
								wp[2]++;
								lxynow=10;
							}
							lxydqjy+=20;
							if(lxydqjy>=lxyzjy){
								lxysj=true;
								lxydqjy=lxydqjy-lxyzjy;
								lxydj++;
								lxygjl=lxygjl+5;
								lxyzsm=lxyzsm+20;
								lxyzjy+=50;
								
							}
						 }
					}
				}
				
				else {
					llbg=1;
				}
				
			}else if(keyCode == KeyEvent.VK_E) {
				wpcx=!wpcx;	
				}
					System.out.print(keyCode);
				if (wpcx==true) {
					if(keyCode == KeyEvent.VK_1){
						if(wp[1]>0){
						wp[1]=wp[1]-1;
						lxydqsm=lxydqsm+100;
						if (lxydqsm>lxyzsm) {
							lxydqsm=lxyzsm;
						}
						lxydqsm=lxydqsm-gwgjl;
					}else {
						wpqs=1;
					}
				} 
				
			}
				}
				if(keyCode == KeyEvent.VK_SPACE){
				if (cg==1) {
					cg=0;dl=0;
					mapID=2;
					lxydqsm=lxyzsm;
					yrdqsm=yrzsm;
					lxydqll=lxyzll;
				}
				if(wpqs==1){
					wpqs=0;
				}
				if(llbg==1){
					llbg=0;
				}
			}
			repaint();
		}
		if(mapID==8) {
			if(keyCode == KeyEvent.VK_SPACE) {
				if(bxcunzai) {
					int x = lxyX;
					int y = lxyY;
					int x2 = 400;
					int y2 = 350;
					int x1 = 350;
					int y1 = 320;
					//李逍遥的方向==向左&&x>x1&&x<x2&&y>y1&&y<y2
					if(lxyDir == KeyEvent.VK_UP && x>=x1 && x<=x2 && y>=y1 && y<=y2){
						//控制效果一的出现和消失 
						bxcunzai = false;
						dl = 2;
						//Out baoxiang;
					}
				}
				else{
					if(dl==2) {
						dl=0;
					}
				}
			}
			repaint();
		}
		if(keyCode == KeyEvent.VK_T){
			Taskbox= !Taskbox;
		}
		if(keyCode == KeyEvent.VK_Y){
			ztlchuxian=!ztlchuxian;
		}
		if(keyCode == KeyEvent.VK_P){
			wplchuxian = !wplchuxian;
		}
		if (mapID==0) {
			if(keyCode == KeyEvent.VK_SPACE){
				mapID=1;
			}
		}


}		


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO 自动生成的方法存根
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根
	}
}
