package xianjian;



	import java.applet.Applet;
	import java.applet.AudioClip;
import java.awt.Frame;
import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
	import java.awt.image.BufferedImage;
	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.net.MalformedURLException;
	import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JOptionPane;
	public class read_or_save {


		//主方法，也就是程序的入口方法
		public static void startsave_or_read(Frame chuangkou,GamePanel1 huaban) {
	
			JButton jButton=new JButton();
			jButton.setBounds(huaban.ztlX+180, huaban.ztlY, 150, 35);
			jButton.setContentAreaFilled(false);
			chuangkou.add(jButton);
				chuangkou.setLayout(null);
				jButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					    int ch = JOptionPane.showConfirmDialog(null,"确认保存游戏吗？","提示",JOptionPane.YES_NO_OPTION);
					    if(ch == JOptionPane.YES_OPTION) {
					    
						    try {
						    	DataOutputStream out = new DataOutputStream(new  FileOutputStream("data.txt"));
								out.write(new String("").getBytes());  
								 out.writeInt(huaban.ljcX);
								 out.writeInt(huaban.ljcY);
								 out.writeInt(huaban.awsX);
								 out.writeInt(huaban.awsY);
								 out.writeInt(huaban.awsIndex);
								 out.writeInt(huaban.azX);
								 out.writeInt(huaban.azY);
								 out.writeInt(huaban.azIndex);
								 out.writeInt(huaban.mjX);
								 out.writeInt(huaban.mjY);
								 out.writeInt(huaban.mjIndex);
								 out.writeInt(huaban.wcsX);
								 out.writeInt(huaban.wcsY);
								 out.writeInt(huaban.wcsIndex);
								 out.writeInt(huaban.xhX);
								 out.writeInt(huaban.xhY);
								 out.writeInt(huaban.xhIndex);
								 out.writeInt(huaban.xjX);
								 out.writeInt(huaban.xjY);
								 out.writeInt(huaban.xjIndex);
								 out.writeInt(huaban.xxjX);
								 out.writeInt(huaban.xxjY);
								 out.writeInt(huaban.xxjIndex);
								 out.writeInt(huaban.lxyX);
								 out.writeInt(huaban.lxyY);
								 out.writeInt(huaban.lxyIndex);
								 out.writeInt(huaban.lxyworkspeed);
								 out.writeInt(huaban.lxyDir);
								 out.writeInt(huaban.ltX);
								 out.writeInt(huaban.ltY);

								 out.writeInt(huaban.lxynow);
								 out.writeInt(huaban.ltMessageIndex);
									 out.writeInt(huaban.ltlxy0MessageIndex);
									 out.writeInt(huaban.ltawsMessageIndex);
									 out.writeInt(huaban.ltaws2MessageIndex);
									 out.writeInt(huaban.ltaws3MessageIndex);									
									 out.writeInt(huaban.ltaws33MessageIndex);
									 out.writeInt(huaban.ltaws4MessageIndex);
							         out.writeInt(huaban.ltaws5MessageIndex);
									 out.writeInt(huaban.ltazMessageIndex);
									 out.writeInt(huaban.ltwcsMessageIndex);;
									 out.writeInt(huaban.ltwcs2MessageIndex);
									 out.writeInt(huaban.ltwcs3MessageIndex);
									 out.writeInt(huaban.ltxhMessageIndex);
									 out.writeInt(huaban.ltxh2MessageIndex);
								 out.writeBoolean(huaban.isLTShow);
								 out.writeInt(huaban.mapID);
								 out.writeInt(huaban.ljcscX);
								 out.writeInt(huaban.ljcscY);
								 out.writeInt(huaban.ljcscIndex);
								 out.writeInt(huaban.jzX);
								 out.writeInt(huaban.jzY);
								 out.writeBoolean(huaban.Taskbox);
								 out.writeInt(huaban.hereImageIndex);
								 out.writeInt(huaban.ztlX);
								 out.writeInt(huaban.ztlY);
								 out.writeBoolean(huaban.ztlchuxian);
								 out.writeInt(huaban.wplX);
								 out.writeInt(huaban.wplY);
								 out.writeBoolean(huaban.wplchuxian);;
								 out.writeInt(huaban.slpX);
								 out.writeInt(huaban.slpY);
								 out.writeInt(huaban.lxydqsm);
								 out.writeInt(huaban.lxyzsm);
								 out.writeInt(huaban.gwdqsm);
								 out.writeInt(huaban.gwzsm);
								 out.writeInt(huaban.lxygjl);
								 out.writeInt(huaban.gwgjl);
								 out.writeInt(huaban.lxydj);
								 out.writeInt(huaban.cg);
								 out.writeInt(huaban.dl);
								 out.writeInt(huaban.wpqr);
							    out.writeInt(huaban.wpqs);
							    out.writeBoolean(huaban.wpcx);
							    out.writeInt(huaban.lxydqll);
							    out.writeInt(huaban.lxyzll);
							    out.writeInt(huaban.llbg);
							    out.writeInt(huaban.lxydqjy);
							    out.writeInt(huaban.lxyzjy);
							    out.writeBoolean(huaban.lxysj);
							    out.writeInt(huaban.lxyflz);
							    out.writeInt(huaban.lxyfyl);
							    out.writeInt(huaban.yrdqsm);
							    out.writeInt(huaban.yrzsm);
							    out.writeInt(huaban.yrgjl);;
							    out.writeInt(huaban.ptIndex);	
							    
							    out.writeInt(huaban.wp[0]);
							    out.writeInt(huaban.wp[1]);
							    out.writeInt(huaban.wp[2]);
							    out.writeInt(huaban.wp[3]);
							    out.writeInt(huaban.wp[4]);	//138
							
							    out.writeBoolean(huaban.bxcunzai);
								 out.writeBoolean(huaban.ishaszhuangbei);
							
															
						    out.close();
						
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						    System.out.println(huaban.lxyX);
						    System.out.println(huaban.lxyY);
						
					}
					    huaban.requestFocus();	}
				});
				
				
				JButton startjbutton=new JButton();
				startjbutton.setBounds(800, 500, 150, 40);
				chuangkou.add(startjbutton);
				startjbutton.setContentAreaFilled(false);
				startjbutton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						huaban.mapID=1;
						huaban.requestFocus();
						
					}
				});
				
				
				
				JButton readjButton=new JButton();
				readjButton.setBounds(810, 560, 150, 40);
//				if(huaban.mapID!=0)
				readjButton.setContentAreaFilled(false);
				chuangkou.add(readjButton);
					chuangkou.setLayout(null);
//					if(huaban.mapID!=0)
//						jButton.setEnabled(false);
					readjButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							try {DataInputStream out = new DataInputStream(new  FileInputStream("data.txt"));
							
//							huaban.lxyfyl=out.readInt();
							huaban.ljcX=out.readInt();
							huaban.ljcY=out.readInt();
							huaban.awsX=out.readInt();
							huaban.awsY=out.readInt();
							huaban.awsIndex=out.readInt();
							huaban.azX=out.readInt();							
							huaban.azY=out.readInt();
							huaban.azIndex=out.readInt();
							huaban.mjX=out.readInt();
							huaban.mjY=out.readInt();
							huaban.mjIndex=out.readInt();
							huaban.wcsX=out.readInt();
							huaban.wcsY=out.readInt();
							huaban.wcsIndex=out.readInt();
							huaban.xhX=out.readInt();
							huaban.xhY=out.readInt();
							huaban.xhIndex=out.readInt();
							huaban.xjX=out.readInt();
							huaban.xjY=out.readInt();
							huaban.xjIndex=out.readInt();
							huaban.xxjX=out.readInt();
							huaban.xxjY=out.readInt();
							huaban.xxjIndex=out.readInt();
							huaban.lxyX=out.readInt();
							
							huaban.lxyY=out.readInt();
							huaban.lxyIndex=out.readInt();
							huaban.lxyworkspeed=out.readInt();
							huaban.lxyDir=out.readInt();
							huaban.ltX=out.readInt();
							huaban.ltY=out.readInt();							

							huaban.lxynow=out.readInt();						
							huaban.ltMessageIndex=out.readInt();							
							huaban.ltlxy0MessageIndex=out.readInt();
							huaban.ltawsMessageIndex=out.readInt();
							huaban.ltaws2MessageIndex=out.readInt();
							huaban.ltaws3MessageIndex=out.readInt();
							huaban.ltaws33MessageIndex=out.readInt();
							huaban.ltaws4MessageIndex=out.readInt();
							huaban.ltaws5MessageIndex=out.readInt();
							huaban.ltazMessageIndex=out.readInt();
							huaban.ltwcsMessageIndex=out.readInt();
							huaban.ltwcs2MessageIndex=out.readInt();
							huaban.ltwcs3MessageIndex=out.readInt();							
							huaban.ltxhMessageIndex=out.readInt();
							huaban.ltxh2MessageIndex=out.readInt();
							huaban.isLTShow=out.readBoolean();							
							huaban.mapID=out.readInt();
							huaban.ljcscX=out.readInt();
							huaban.ljcscY=out.readInt();
							huaban.ljcscIndex=out.readInt();
							huaban.jzX=out.readInt();														
							huaban.jzY=out.readInt();
							huaban.Taskbox=out.readBoolean();
							huaban.hereImageIndex=out.readInt();
							huaban.ztlX=out.readInt();
							huaban.ztlY=out.readInt();							
							huaban.ztlchuxian=out.readBoolean();												
							huaban.wplX=out.readInt();
							huaban.wplY=out.readInt();
							huaban.wplchuxian=out.readBoolean();
							huaban.slpX=out.readInt();
							huaban.slpY=out.readInt();							
							huaban.lxydqsm=out.readInt();
							huaban.lxyzsm=out.readInt();						
							huaban.gwdqsm=out.readInt();
							huaban.gwzsm=out.readInt();
							huaban.lxygjl=out.readInt();
							huaban.gwgjl=out.readInt();
							huaban.lxydj=out.readInt();							
							huaban.cg=out.readInt();
							huaban.dl=out.readInt();
							huaban.wpqr=out.readInt();
							huaban.wpqs=out.readInt();
							huaban.wpcx=out.readBoolean();							
							huaban.lxydqll=out.readInt();
							huaban.lxyzll=out.readInt();
							huaban.llbg=out.readInt();
							huaban.lxydqjy=out.readInt();
							huaban.lxyzjy=out.readInt();						
							huaban.lxysj=out.readBoolean();
							huaban.lxyflz=out.readInt();
							huaban.lxyfyl=out.readInt();
							huaban.yrdqsm=out.readInt();						
							huaban.yrzsm=out.readInt();
							huaban.yrgjl=out.readInt();
							huaban.ptIndex=out.readInt();	
							
							huaban.wp[0]=out.readInt();
					
							huaban.wp[1]=out.readInt();
							huaban.wp[2]=out.readInt();
							huaban.wp[3]=out.readInt();
							huaban.wp[4]=out.readInt();
							huaban.bxcunzai=out.readBoolean();
							huaban.ishaszhuangbei=out.readBoolean();
							//276-189=87
							out.close();
							jButton.setEnabled(true);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
//								e1.printStackTrace();
								System.err.println(e1.getMessage());
								   int ch = JOptionPane.showConfirmDialog(null,"没有存档，重新开始游戏吗？","提示",JOptionPane.YES_NO_OPTION);
								
								  
								    if(ch == JOptionPane.YES_OPTION) {
								    	
								    	huaban.mapID=1;
								    	huaban.lxyX=1000;
								    	huaban.lxyY=500;
								    	huaban.lxynow =0;
								    	huaban.lxyDir = KeyEvent.VK_DOWN;
								    	huaban.requestFocus();
								    }
								   
								   
								   
							}
							
							huaban.requestFocus();
						}
					});
		}
		
		
		
		
		
	}
		

	

