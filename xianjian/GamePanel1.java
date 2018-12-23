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


//-->Ч��1�����г�������������챳������������<���仰>
//-->Ч��2ͨ���ո񰴼�����Ч��1�ĳ��ֺ���ʧ
//-->Ч��3
//java��ѭ���̳У��ࣩ��ʵ�֣��ӿڣ�
public class GamePanel1 extends JPanel implements Runnable,KeyListener{
	//������Ҵ�ͼƬ���������
	Image ljcImage;
	int ljcX;
	int ljcY;
	//���尢����ͼƬ���������
	//������Ű���������ͼƬ������
	Image[] awsImage;
	int awsX;
	int awsY;
	//������ʾ������ͼƬ������±�
	int awsIndex;
	//����
	Image[] azImage;
	int azX;
	int azY;
	int azIndex;
	//ĸ��
	Image[] mjImage;
	int mjX;
	int mjY;
	int mjIndex;
	//����ɩ
	Image[] wcsImage;
	int wcsX;
	int wcsY;
	int wcsIndex;
	//С��
	Image[] xhImage;
	int xhX;
	int xhY;
	int xhIndex;
	//С��
	Image[] xjImage;
	int xjX;
	int xjY;
	int xjIndex;
	//С��
	Image[] xxjImage;
	int xxjX;
	int xxjY;
	int xxjIndex;
	//��������ңͼƬ���������
	Image[] lxyDownImages;
	Image[] lxyLeftImages;
	Image[] lxyRightImages;
	Image[] lxyUpImages;
	int lxyX;
	int lxyY;
	int lxyIndex;
	int lxyworkspeed = 10;   //����ң�ƶ��ٶ�
	//������ʾ����ң�ĵ�ǰ����
	int lxyDir;//�涨����=1����=2����=3����=4��
	//������ʾ����ң�ĵ�ǰ����ͼƬ���ݣ�ע�⵱����ң�ƶ�ʱ��Ҫ��ֵ���и��£�
	Image lxyImage;
	//�������칦��������������
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
	//����ңɧ��
		 String[] ltlxy0Messages;
		 int ltlxy0MessageIndex;
		 //������ɧ��
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

		 //����ɧ��
		 String ltaz0Message;
		 String[] ltazMessages;
		 int ltazMessageIndex;
		 String ltaz3Message;
		 //����ɩɧ��
		 String ltwcs0Message;
		 String[] ltwcsMessages;
		 int ltwcsMessageIndex;
		 String[] ltwcs2Messages;
		 int ltwcs2MessageIndex;
		 String[] ltwcs3Messages;
		 int ltwcs3MessageIndex;
		 //С��ɧ��
		 String ltxh0Message;
		 String[] ltxhMessages;
		 int ltxhMessageIndex;
		 String[] ltxh2Messages;
		 int ltxh2MessageIndex;
		 
	//������ʾ�������������Ƿ���ֵ����ֵ
	boolean isLTShow;
	//�����ϰ��﹦��������������
	BufferedImage ljcDataMap;
	
	int mapID;     //0Ƭͷ  1��Ҵ�  2���  3ʮ����  4ʮ���¹���  5��Ҵ����   6�뿪
	//������Ҵ��̳�-
	Image[] ljcscImage;
	int ljcscX;
	int ljcscY;
	int ljcscIndex;
	BufferedImage ljcscDataMap;
	//�����
	 Image jzImage;
	 int jzX;
	 int jzY;
	 boolean Taskbox = true;
	 String zxrenwu;             //֧������
	 String renwu0;
	 String renwu1;
	 String renwu2;
	 String renwu3;
	 String renwu4;
	 String renwu5;
	 String renwu6;
	 String renwu7;
	 //�����ͷ
	 Image[] hereImages;
	 int hereImageIndex;
	 //����ͨ��Ƭβ
	 Image[] endImages;
	 Image wmtgImage;            //����ʤ����ͼ
	 int endImageIndex;
	 //״̬��
	 Image ztlImage;
	 Image saveImage;
	 int ztlX;
	 int ztlY;
	 boolean ztlchuxian = true; 
	 //���弼��
	 Image[] jn1Images;
	 int jn1Index;
	 boolean isjineng = false;
	 //���幥��
	 Image[] gjImages;
	 int gjIndex;
	 boolean isgongji = false;
	 //������Ʒ
	 Image wplImage;
	 Image jianImage;      //��ͼƬ
	 Image kuijiaImage;    //����ͼƬ
	 int wplX;
	 int wplY;
	 Image hbImage;
	 boolean ishaszhuangbei = false;    //��ʼ��δ���װ��
	 boolean wplchuxian;
	//����ʮ���³���
	Image slpImage;
	int slpX;
	int slpY;
	BufferedImage slpDatamap;
	//��������ң��ֳ���
	Image bjImage;         //��ֱ���
	Image lxygqImage;      //����ң��Ȧͼ
	int lxygqX,lxygqY;
	
	Image gwgqImage;       //�����Ȧͼ
	int gwgqX=170,gwgqY=270;
	
	Image BossgqImage;     //Boss��Ȧͼ
	Image lxydgImage;      //����ң���ͼ
	int lxydgX,lxydgY;
	ImageIcon gwImage;         //����ͼƬ
	int gwX=160,gwY=0;
	Image jntxImage;     //������ЧͼƬ
	
	BufferedImage fj1Datamap;        //�ϰ���
	Image fj1Image;
	int fj1X;
	int fj1Y;                //���巿��1
	
	BufferedImage fj2Datamap;        //�ϰ���
	Image fj2Image;
	Image bxImage;
	boolean bxcunzai = true;
	int bxX = 320;
	int bxY = 300;
	int fj2X;
	int fj2Y;                //���巿��2
	
	int lxydqsm;      //����ңѪ��
	int lxyzsm;       //����ң�������ֵ
	int gwdqsm;       //����Ѫ��
	int gwzsm;         //�����������ֵ
	int lxygjl;       //����ң������
	int gwgjl;        //���﹥����
	int lxydj;        //����ң�ȼ�
	int cg;           //����
	int dl;          //��õ���
	int wpqr;         
	int[] wp;
	int wpqs;
	boolean wpcx;
	int lxydqll;
    int lxyzll;
    int llbg;
    int lxydqjy;
    int lxyzjy;
    boolean lxysj = false;      //����ң����
    int lxyflz;
    int lxyfyl;
    Image zdslImage;
    Image hdymImage;            //�����ë
    Image hdzbImage;
    Image sjImage;
    ImageIcon hgImage;
    Image llbz;
    int yrdqsm;
    int yrzsm;
    int yrgjl;
	//����Ƭͷ
    Image[] ptImages;
    int ptIndex;
    Image begin;
    Image jwImage;
    Image yqImage;
   
    
	
	//���췽��-->������ɳ�ʼ������
	public GamePanel1(){
		//��ʼ����Ҵ���������
		try {
			//���·�����ڳ������У��Ӿ���·���еĹ������ƺ��濪ʼд
			//����·�������̷����߸�Ŀ¼(/)��ʼ��·��
			ljcImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCun/0.png"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} 
		ljcX=-200;
		ljcY=-200;
		
		//��ʼ������1
		try {
			fj1Image = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian1/beijing.png"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		fj1X=100;
		fj1Y=100;
		
		
		//��ʼ������1�ϰ���
		try {
			fj1Datamap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian1/RedMap.png"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		
		//��ʼ������2
		try {
			hdzbImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/huodezb.png"));
			bxImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/baoxiang.png"));
			fj2Image = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/beijing.png"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		fj2X=100;
		fj2Y=100;
		
		//��ʼ������2�ϰ���
		try {
			fj2Datamap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/fangjian2/RedMap.png"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		
		//��ʼ��������ͼƬ���������
		awsImage = new Image[17];
		for(int i=0;i<17;i++){
			//��i��pngͼƬ��ȡ��ͼƬ�ڴ��У������ڶ�Ӧ����ĵ�i���±�λ����
			try {
				awsImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/AWangShen/"+i+".png"));
				IOException e;
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
			
		awsX=650;
		awsY=500;
		awsIndex=0;
		//��ʼ�����������
		azImage = new Image[5];
		for(int i=0;i<5;i++){
			try {
				azImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/AZhu/"+i+".png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		azX=730;
		azY=250;
		azIndex=0;
		//��ʼ��ĸ��
		mjImage =new Image[5];
		for(int i=0;i<5;i++){
			try {
				mjImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/MuJi/"+i+".png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		mjX=azX+20;
		mjY=azY+80;
		mjIndex=0;
		//��ʼ������ɩ
		wcsImage = new Image[14];
		for(int i=0;i<14;i++){
			try {
				wcsImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/WangCaiSao/"+i+".png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		wcsX=600;
		wcsY=650;
		wcsIndex=0;
		//��ʼ��С��
		xhImage = new Image[4];
		for(int i=0;i<4;i++){
			try {
				xhImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/XiaoHai/"+i+".png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}		
		}
		xhX=890;
		xhY=570;
		xhIndex=0;
		//��ʼ��С��
		xjImage = new Image[2];
		for(int i=0;i<2;i++){
			try {
				xjImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/XiaoJi/"+i+".png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		xjX=mjX-20;
		xjY=mjY+30; 
		xjIndex=0;
		//��ʼ��С��
		xxjImage = new Image[2];
		for(int i=0;i<2;i++){
		try {
				xxjImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/XiaoXiaoJi/"+i+".png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		
		}
		xxjX=xjX;
		xxjY=xjY+30;
		xxjIndex=0;
		//��ʼ������ңͼƬ���������
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			lxyX=1000;
			lxyY=500;
			lxyIndex=0;
//			lxyDir = KeyEvent.VK_DOWN;
			//lxyDir=2;
			lxyImage = lxyDownImages[lxyIndex];
		}
		//��ʼ�����칦��������������
		 //��ʼ�����칦��������������
		 faceman = "meiyou";
		 ltaz0Message = new String("С��.С��.�쳤��");
		 ltwcs0Message = new String("��������𾭳����аԵ�");
		 ltxh0Message = new String("ʮ���µĴ���������̫������");
		 ltaz3Message = new String("�����Ѿ�ȥ���˰�");
		 ltlxy0Messages = new String[]{"��������ң����ӭ������Ҵ�","�ҵ��������߳���Ҵ壬����һ��ð�հɣ�","��ȥ�Ͱ�����˵һ��"};
		 ltazMessages = new String[]{"����ң������~","���죺��ң����ʲô��","����ң�����ܲ��ܰ���ȥ��������ؼ�","���죺�����Ķ���","����ң���ں�С�������","һ��Ҫ��ȥ�ſϻؼ�","���죺�õģ������ȥ"};
		 ltawsMessages =new String[]{"����ң��������","��������Ӵ������ң������","����ң���Ҹ���˵��...","�������������ȥ����ɩ�Ǳ��ü����·���","����ң���Ǹ�...","�����������","����ң���ðɰ���������ȥȥ�ͻ�"};
		 ltaws3Messages = new String[]{"����ң������������Ҫ���·�","��������лл��ң��","����ң������ȥ��������翴��","�����������ʶ�㣬�Ҹ����������Լ���","��������Ҫ�������ռ�����������ֵ���ë��","����б���ȥð����","����ң�������ȥ��","���������𼱣��ܲ������޴�����ȥ�ɡ�","ȥ����Ŀ��������ң�û׼�б���"};
		 ltaws33Messages = new String[]{"����������ô�ˣ�����","����ң���Ǻǣ�����"};
		 ltaws4Messages = new String[]{"����ң�������Ұ���ë��������","�����������԰�����ң","����ң�����ҳ�ȥ����������","����������ң�����Ѿ��������µ�ð�գ�ȥ�嶫����ͷ��","����ˡ��������Ϳ�ʼ�������Ĵ�����","����ң���õİ�������������","�㱣��"};
		 ltaws2Messages = new String[]{"������������ô�����ˣ�����","����ң����������.."};
		 ltwcsMessages = new String[]{"����ң������ɩ~~~","����ɩ:ȥ���Ҽ������һ���","����ң���Ǹ�...","����ɩ�����ͱ���ȥ����ȥ��","����ң��Ŷ~","����ң���Ͳ������Ұѻ�˵����(һ������~~)"};
		 ltwcs3Messages = new String[]{"����ң��������ƻ����˰�","����ɩ��Ŷ�������ˣ����߰�","����ң����������","��һ�£��������ǰ�����Ҫ�ü����·�","����ɩ��������£����㲻��˵","����ң��..."};
		 ltwcs2Messages = new String[]{"����ɩ����ȥ��ȥ","����ң����������"};
		 ltxhMessages = new String[]{"����ң��ι��Сƨ����������","���ƣ����","����ң��...����С���ӽ�������ôdiao����","��������ؼҳԷ�����","���ƣ���ȥ������...","�����Ұ����������һ�ȥ","����ң���ǵ�Ҫ������","���ƣ���Ȼ�Ҿ�����ȥ","����ң��..."};
		 ltxh2Messages = new String[]{"���ƣ��٣�����ô������","����ң����·��·"};

		 try {
				ltImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiaoTian/0.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		isLTShow=false;
		lxynow =0;
		//��ʼ���������������
		 //��������ʼ
		 try {
			jzImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/RenWu/renwulan.png"));
			
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 jzX=625;
		 jzY=20;
		 zxrenwu=new String("���ܺ���");
		 renwu1 = new String("�Ұ�����");
		 renwu2 = new String("������ɩ");
		 renwu3 = new String("�� �� ��");
		 renwu4 = new String("�� �� ��");
		 renwu5 = new String("�ռ���ë");
		 renwu6 = new String("��ȥ�Ұ�����");
		 renwu7 = new String("�����嶫��ͷ");
		 //��ʼ����ͷ
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
		 //��ʼ������ͨ�ز�ͼ
		 try {
			wmtgImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/tongguan/happyending.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//��ʼ��ͨ��Ƭβ
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
		 //��ʼ������
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
		 //��ʼ������
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
		//״̬����ʼ
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
		//��Ʒ����ʼ
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

		//��ʼ���ϰ��﹦��������������
		try {
			ljcDataMap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCun/RedMap.png"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//��ʼ���׸�����
		mapID=0;
		ljcscImage = new Image[3];
		for(int i=0;i<2;i++)
		{
				try {
					ljcscImage[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCunShiChang/"+i+".png"));
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
		ljcscX=200;
		ljcscY=200;
		ljcscIndex=0;
		//��ʼ���ϰ��﹦��������������
			try {
				ljcscDataMap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCunShiChang/RedMap.png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		//��ʼ��ʮ����
			try {
				slpImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/ShiLiPo/0.png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			slpX=100;
			slpY=100;
			try {
				slpDatamap = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/ShiLiPo/RedMap.jpg"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		//��ʼ��ս������
			try {
				lxygqImage = ImageIO.read(new File("texiao/guangquan_1.png"));
				gwgqImage = ImageIO.read(new File("texiao/guangquan_2.png"));
				BossgqImage = ImageIO.read(new File("texiao/guangquan_3.png"));
				jntxImage = ImageIO.read(new File("texiao/texiao1_1.gif"));
				bjImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/pkbg.png"));
				
				gwImage = new ImageIcon("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/guaiwu_2.gif");
				//��ImageIcon ��ȡ��ͼ
				
				lxydgImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/lxyzd.png"));
				zdslImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/zdsl.png"));
				hdymImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/huodeym.png"));
				sjImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/shengji.png"));
				
				hgImage = new ImageIcon("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/haiguai.gif");
				//��ImageIcon ��ȡ��ͼ

				llbz = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/linglibuzu_2.png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
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
			//Ƭͷ
			ptImages = new Image[60];
			for(int i1=0;i1<60;i1++){
				try {
					ptImages[i1] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/PianTou/"+i1+".png"));
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			try {
				
				begin = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/PianTou/bg_15.jpg"));

				
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			//��β 
			try {
				jwImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/DaGuai/zdsb.jpg"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			try {
				yqImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCun/yuanqu.png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
	
	//�滭����
	public void paint(Graphics g){
		//�滭��Ϸ��Ŀ�Ľ���
		
		if(ishaszhuangbei) {
			lxygjl=10;
			gwgjl=5;
			lxyfyl = 20;
		}                      //���ӵ��װ�������﹥�������ͣ�lxy����������
		
		//g-->��������һ֧����
		if(mapID==0){	
			
			g.drawImage(begin,0,0,this);
			
			g.drawImage(Toolkit.getDefaultToolkit().
					getImage(GamePanel1.class.getResource("guide.gif")), 0, 75, this);
			
			g.drawImage(Toolkit.getDefaultToolkit().
					getImage(GamePanel1.class.getResource("schedule.gif")), 35, 620, this);
			
			g.setColor(new Color(139,105,20));
			g.setFont(new Font("����",Font.BOLD,30));
			g.drawString("�ɵĻ���",800,600);    	
		    g.drawString("�µ�ð��",795,540);
			
		}
		if(mapID==1){
		
		//���䣺������Ҵ�ͼƬ������
		ljcX=(this.getWidth()-lxyImage.getWidth(null))/2-lxyX;
		ljcY=(this.getHeight()-lxyImage.getHeight(null))/2-lxyY;
		if(ljcX>0)ljcX=0;
		if(ljcX<-1920+1024)ljcX=-1920+1024;
		if(ljcY>0)ljcY=0;
		if(ljcY<-1440+768) ljcY=-1440+768; 
		//ljcX=(this)
		//����Ҵ�ͼƬ��������ݻ滭��������
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
		//������ңͼƬ��������ݳ��ֵ�������
		
		 //��ͷ
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
		//�����칦�ܵ�������ݻ���������
		if(isLTShow){
			 //������λ��
		     ltX = ((this.getWidth()-ltImage.getWidth(null)))/2;
		     ltY = this.getHeight()-ltImage.getHeight(null);

		    g.drawImage(ltImage,ltX,ltY,this);
			g.setColor(Color.white);
	    	g.setFont(new Font("����",Font.BOLD,25));
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
		//����ϵͳ
		 if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("ʱ���кڼ���",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("����",Font.BOLD,20));
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
		
		//״̬ϵͳ
		 if(ztlchuxian){
			 g.drawImage(saveImage, ztlX+180, ztlY, this);
			 g.drawImage(ztlImage,ztlX,ztlY,this);
			 g.setColor(Color.WHITE);
			 g.setFont(new Font("����",Font.BOLD,20));
		     g.drawString(lxydj+" ",ztlX+68,ztlY+145);
		     g.setFont(new Font("����",Font.BOLD,15));
			 g.drawString(lxyzsm+" ",ztlX+230,ztlY+62);
			 g.drawString(lxydqjy+"/"+lxyzjy,ztlX+350,ztlY+62);
			 g.drawString(lxygjl+" ",ztlX+230,ztlY+87);
			 g.drawString(lxyfyl+" ",ztlX+230,ztlY+112);
			 g.drawString(lxyzll+" ",ztlX+350,ztlY+87);
			 g.drawString(lxyflz+" ",ztlX+350,ztlY+112);
		 }
		//��Ʒ��
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
			    g.setFont(new Font("����",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 if (wp[2]>0) {
				g.setColor(Color.white);
				   g.setFont(new Font("����",Font.BOLD,20));
				    g.drawString(" "+wp[2],wplX+68,wplY+42);
			}
		 }

		//g.fillRect(ljcX+1750 , ljcY+750, 500, 500);
	}else if(mapID == 2){
		//�滭��Ҵ��г�����
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
		//����ϵͳ
		if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("ʱ���кڼ���",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("����",Font.BOLD,20));
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
		
		//״̬ϵͳ
		 if(ztlchuxian){
			 g.drawImage(saveImage, ztlX+180, ztlY, this);
			 g.drawImage(ztlImage,ztlX,ztlY,this);
			 g.setColor(Color.WHITE);
			 g.setFont(new Font("����",Font.BOLD,20));
		     g.drawString(lxydj+" ",ztlX+68,ztlY+145);
		     g.setFont(new Font("����",Font.BOLD,15));
			 g.drawString(lxyzsm+" ",ztlX+230,ztlY+62);
			 g.drawString(lxydqjy+"/"+lxyzjy,ztlX+350,ztlY+62);
			 g.drawString(lxygjl+" ",ztlX+230,ztlY+87);
			 g.drawString(lxyfyl+" ",ztlX+230,ztlY+112);
			 g.drawString(lxyzll+" ",ztlX+350,ztlY+87);
			 g.drawString(lxyflz+" ",ztlX+350,ztlY+112);
		 }
		//��Ʒ��
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
			    g.setFont(new Font("����",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 if (wp[2]>0) {
				g.setColor(Color.white);
				   g.setFont(new Font("����",Font.BOLD,20));
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
		//����ϵͳ
		if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("ʱ���кڼ���",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("����",Font.BOLD,20));
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
		
		//״̬ϵͳ
		 if(ztlchuxian){
			 g.drawImage(saveImage, ztlX+180, ztlY, this);
			 g.drawImage(ztlImage,ztlX,ztlY,this);
			 g.setColor(Color.WHITE);
			 g.setFont(new Font("����",Font.BOLD,20));
		     g.drawString(lxydj+" ",ztlX+68,ztlY+145);
		     g.setFont(new Font("����",Font.BOLD,15));
			 g.drawString(lxyzsm+" ",ztlX+230,ztlY+62);
			 g.drawString(lxydqjy+"/"+lxyzjy,ztlX+350,ztlY+62);
			 g.drawString(lxygjl+" ",ztlX+230,ztlY+87);
			 g.drawString(lxyfyl+" ",ztlX+230,ztlY+112);
			 g.drawString(lxyzll+" ",ztlX+350,ztlY+87);
			 g.drawString(lxyflz+" ",ztlX+350,ztlY+112);
		 }
		//��Ʒ��
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
			    g.setFont(new Font("����",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 if (wp[2]>0) {
				g.setColor(Color.white);
				   g.setFont(new Font("����",Font.BOLD,20));
				    g.drawString(" "+wp[2],wplX+68,wplY+42);
			}
		 }

	}else if (mapID==4) {
		g.drawImage(bjImage,0,0,this);
		
		g.drawImage(gwgqImage, gwgqX, gwgqY, this);				 //�����ʼ��
		g.drawImage(gwImage.getImage(), gwX, gwY, this);    
		//��ImageIcon ת�ó�Image ͨ������ʵ��gifͼ
		
		//����
		if(isjineng) {
			for(int i=0;i<jn1Images.length;i++) {
				g.drawImage(jn1Images[jn1Index], gwX-100, gwY-60, this);		
			}
		}
		
		//����
		if(isgongji) {
			for(int i=0;i<gjImages.length;i++) {
				g.drawImage(gjImages[gjIndex], gwX-150, gwY+100, this);			
			}
		}
		
		g.drawImage(lxygqImage, 700, 550, this);			 //����ң��ʼ��
		g.drawImage(lxydgImage, 760, 490, this);           
		
		
		g.drawRoundRect(590,5,400,120,20,30); 
		g.setFont(new Font("΢���ź�",Font.BOLD,45));
		g.setColor(Color.WHITE);
		g.drawString("����ң��"+lxydqsm+"/"+lxyzsm, 600, 50);
		g.drawString("����ң��"+lxydqll+"/"+lxyzll, 600, 100);
		g.drawString("����֣�"+gwdqsm+"/"+gwzsm, 600, 170);
		g.setColor(Color.white); 
		g.fillRoundRect(40,400,150,60,20,30); 
		g.fillRoundRect(40,470,150,60,20,30);
		g.fillRoundRect(40,540,150,60,20,30);
		g.fillRoundRect(40,610,150,60,20,30);
		g.setColor(Color.BLUE);
		g.setFont(new Font("�ٶ����ռ���",Font.BOLD,35));
		g.drawString("����(Q)", 50, 440);
		g.drawString("����(W)", 50, 510);
		g.drawString("��Ʒ(E)", 50, 580);
		g.drawString("����(R)", 50, 650);
		if (wpcx==true) {
			g.drawImage(wplImage,wplX,wplY,this);
			 if(wp[1]>=0)
			 {
				g.drawImage(hbImage,wplX+7,wplY+4,this);
				g.setColor(Color.GRAY);
			    g.setFont(new Font("����",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 
		}
		if (wpqs==1) {
			g.drawString("��Ʒ����", 550, 400);
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
		g.drawImage(BossgqImage, gwgqX, gwgqY, this);	         //�����ʼ��
		g.drawImage(hgImage.getImage(), 220, 190, this);

		g.drawImage(lxygqImage, 700, 550, this);			 //����ң��ʼ��
		g.drawImage(lxydgImage, 760, 490, this);    
		
		//����
		if(isjineng) {
			for(int i=0;i<jn1Images.length;i++) {
				g.drawImage(jn1Images[jn1Index], gwX-100, gwY-60, this);		
			}
		}
		
		//����
		if(isgongji) {
			for(int i=0;i<gjImages.length;i++) {
				g.drawImage(gjImages[gjIndex], gwX-150, gwY+100, this);			
			}
		}
		
		g.drawRoundRect(490,5,500,120,20,30); 
		g.setFont(new Font("΢���ź�",Font.BOLD,45));
		g.setColor(Color.WHITE);
		g.drawString("����ң������"+lxydqsm+"/"+lxyzsm, 505, 55);
		g.drawString("����ң������"+lxydqll+"/"+lxyzll, 505, 105);
		g.drawString("��  �� ������"+yrdqsm+"/"+yrzsm, 510, 170);
		g.setColor(Color.white); 
		g.fillRoundRect(40,400,150,60,20,30); 
		g.fillRoundRect(40,470,150,60,20,30);
		g.fillRoundRect(40,540,150,60,20,30);
		g.fillRoundRect(40,610,150,60,20,30);
		g.setColor(Color.BLUE);
		g.setFont(new Font("�ٶ����ռ���",Font.BOLD,35));
		g.drawString("����(Q)", 50, 440);
		g.drawString("����(W)", 50, 510);
		g.drawString("��Ʒ(E)", 50, 580);
		g.drawString("����(R)", 50, 650);
		if (wpcx==true) {
			g.drawImage(wplImage,wplX,wplY,this);
			 if(wp[1]>=0)
			 {
				g.drawImage(hbImage,wplX+7,wplY+4,this);
				g.setColor(Color.white);
			    g.setFont(new Font("����",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 
		}
		if (wpqs==1) {
			g.drawString("��Ʒȱ��", 550, 400);
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
		//����ϵͳ
		if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("ʱ���кڼ���",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("����",Font.BOLD,20));
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
		
		//״̬ϵͳ
		 if(ztlchuxian){
			 g.drawImage(saveImage, ztlX+180, ztlY, this);
			 g.drawImage(ztlImage,ztlX,ztlY,this);
			 g.setColor(Color.WHITE);
			 g.setFont(new Font("����",Font.BOLD,20));
		     g.drawString(lxydj+" ",ztlX+68,ztlY+145);
		     g.setFont(new Font("����",Font.BOLD,15));
			 g.drawString(lxyzsm+" ",ztlX+230,ztlY+62);
			 g.drawString(lxydqjy+"/"+lxyzjy,ztlX+350,ztlY+62);
			 g.drawString(lxygjl+" ",ztlX+230,ztlY+87);
			 g.drawString(lxyfyl+" ",ztlX+230,ztlY+112);
			 g.drawString(lxyzll+" ",ztlX+350,ztlY+87);
			 g.drawString(lxyflz+" ",ztlX+350,ztlY+112);
		 }
		//��Ʒ��
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
			    g.setFont(new Font("����",Font.BOLD,20));
			    g.drawString(" "+wp[1],wplX+25,wplY+42);
			 }
			 if (wp[2]>0) {
				g.setColor(Color.white);
				   g.setFont(new Font("����",Font.BOLD,20));
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
		//����ϵͳ
		if(Taskbox){
			 g.drawImage(jzImage,jzX,jzY,this);					    
			 if(lxynow > 0){
				 g.setColor(new Color(184, 134, 11));
				 g.setFont(new Font("ʱ���кڼ���",Font.BOLD,25));
				 g.drawString(zxrenwu, jzX+200, jzY+370);
			 }
			 g.setColor(new Color(139, 69, 19));
			 g.setFont(new Font("����",Font.BOLD,20));
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
			g.setFont(new Font("����",Font.BOLD,30));
			g.drawString("���ش浵", 810, 582);
		}
//	}
	}
//�˶�����
	@Override	
	public void run(){
		//ʵ����ǵ��˶�Ч��
		//Ҳ���ǲ��ϵ�ѭ���л�ͼƬ���ݣ�Ҳ���ǲ����ϵ�ѭ���޸Ķ�Ӧ������±�
		
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
			 
			 //ͨ��Ƭβ
			 endImageIndex++;
			 if(endImageIndex>=endImages.length) {
				 endImageIndex = endImages.length-1;
			 }
			 
			 //����ֻ�ͷ�һ��
			 jn1Index++;
			 if(jn1Index>=jn1Images.length){
				 jn1Index=jn1Images.length-1;
			 }
			 
			 //����ֻ����һ��
			 gjIndex++;
			 if(gjIndex>=gjImages.length){
				 gjIndex=gjImages.length-1;
			 }
			 
			 ptIndex++;
			 if(ptIndex>=ptImages.length){
				 ptIndex=ptImages.length-1;
			 }

			//ͣ�ٲ���
			try{
                Thread.sleep(130);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			
			//�ػ�����-->���Զ�����ִ��paint();����
			repaint();
		}
	}
	//keylistener�ӿ��еķ���
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		//e-->���������¼�Դ
		//System.out.print("���̰���������");
		int keyCode = e.getKeyCode();
		if (mapID!=4){
			if(isLTShow){
				//�������ݵ��л�+����������ж�
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
				//����ң���ƶ�+���쿪ʼ���ж�+�����л����ж�
				//ʵ�����ǵ��˶�Ч��
				//Ҳ������Ҫ��Ұ��µļ��̰��������ж�Ӧ�Ĳ���(�ƶ�����ԭ�ز���)
		
				//ʵ�����ǵ��˶�Ч��
				//Ҳ������Ҫ��Ұ��µļ��̰��������ж�Ӧ�Ĳ������ƶ�����ԭ�ز�����
				//System.out.print(keyCode);
				//��=38����=40����=37����=39��w=87,s=83,a=65,d=68���ո�=32��
				if(keyCode==38){
					//����ң��Ҫ�����ƶ�
					//ͼƬλ�÷����ı�
					lxyY-=lxyworkspeed;
					repaint();
					//ͼƬ���ݷ����ı�
					lxyIndex++;
					if(lxyIndex>=lxyUpImages.length){
						lxyIndex=0;
					}
					lxyImage=lxyUpImages[lxyIndex];	
					//�������ı�
					lxyDir = KeyEvent.VK_UP;
					//���䣺�ж�����ң�Ƿ�����ϰ�������
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
							//�ж�����ң�Ƿ��ߵ�������ɫ��ǰ
							int x = lxyX;
							int y = lxyY + lxyImage.getHeight(null);
							int x2 = awsX + awsImage[awsIndex].getWidth(null);
							int y2 = awsY +awsImage[awsIndex].getHeight(null);
							int x1 = x2-50;
							int y1 = y2-50;
							//����ң�ķ���==����&&x>x1&&x<x2&&y>y1&&y<y2
							if(lxyDir == KeyEvent.VK_LEFT && x>=x1 && x<=x2 && y>=y1 && y<=y2){
								//����Ч��һ�ĳ��ֺ���ʧ
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
			repaint();        //�ػ�ʮ����
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
				gjIndex = 0;              //���³�ʼ������
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
					jn1Index = 0;          //��ʼ������
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
				gjIndex = 0;                //��ʼ������
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
					jn1Index = 0;          //��ʼ������
					
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
					//����ң�ķ���==����&&x>x1&&x<x2&&y>y1&&y<y2
					if(lxyDir == KeyEvent.VK_UP && x>=x1 && x<=x2 && y>=y1 && y<=y2){
						//����Ч��һ�ĳ��ֺ���ʧ 
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
		// TODO �Զ����ɵķ������
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
	}
}
