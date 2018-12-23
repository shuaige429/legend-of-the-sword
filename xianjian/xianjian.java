package xianjian;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class xianjian {

	//主方法，也就是程序的入口方法
	public static void main(String[] args) {
		// 创建窗口类的实例化对象
		JFrame chuangkou = new JFrame();
		//设置窗口对象的相关属性
		chuangkou.setSize(1024,768);
		chuangkou.setTitle("仙剑游戏");
		//让窗口居中显示的方法
		chuangkou.setLocationRelativeTo(null);
		//改变窗口关闭的默认操作选项
		chuangkou.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		chuangkou.addWindowListener(new WindowAdapter() {
	        // 当窗口正要关闭的时候，会自动调用该方法
	        @Override
	        public void windowClosing(WindowEvent e) {
	            super.windowClosing(e);
	            // 弹出确认对话框
	            int ch = JOptionPane.showConfirmDialog(null,"确认要退出游戏吗？","提示",JOptionPane.YES_NO_OPTION);
	            if (ch == JOptionPane.YES_OPTION) {
	                System.exit(0);
	            }
	        }
	    });
		
		//创建自定义画板类的实例化对象
		GamePanel1 huaban=new GamePanel1();
		//关联窗口对象和自定义画板对象
		chuangkou.add(huaban);
		//创建线程类的实例化对象，并且关联自定义画板对象
		Thread xiancheng =new Thread(huaban);
		//启动线程对象-->会自动执行run();方法
		xiancheng.start();
		//声明自定义画板类中的键盘监听事件对应方法的有效性
		chuangkou.addKeyListener(huaban);
		huaban.addKeyListener(huaban);
         
		//让窗口对象显示出来
		chuangkou.setVisible(true);
		
		read_or_save myRead_or_save = new read_or_save();
		myRead_or_save.startsave_or_read(chuangkou, huaban);
		
		MusicPlayer bgmplayer = new MusicPlayer("music/piantou_music.wav");  //创建音乐播放器 
	      
		//bgmplayer.start(true);  //以开始以循环的形式播放，player(false)为不循环播放 
	      
	}

	
	
}
