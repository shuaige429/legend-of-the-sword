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

	//��������Ҳ���ǳ������ڷ���
	public static void main(String[] args) {
		// �����������ʵ��������
		JFrame chuangkou = new JFrame();
		//���ô��ڶ�����������
		chuangkou.setSize(1024,768);
		chuangkou.setTitle("�ɽ���Ϸ");
		//�ô��ھ�����ʾ�ķ���
		chuangkou.setLocationRelativeTo(null);
		//�ı䴰�ڹرյ�Ĭ�ϲ���ѡ��
		chuangkou.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		chuangkou.addWindowListener(new WindowAdapter() {
	        // ��������Ҫ�رյ�ʱ�򣬻��Զ����ø÷���
	        @Override
	        public void windowClosing(WindowEvent e) {
	            super.windowClosing(e);
	            // ����ȷ�϶Ի���
	            int ch = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���Ϸ��","��ʾ",JOptionPane.YES_NO_OPTION);
	            if (ch == JOptionPane.YES_OPTION) {
	                System.exit(0);
	            }
	        }
	    });
		
		//�����Զ��廭�����ʵ��������
		GamePanel1 huaban=new GamePanel1();
		//�������ڶ�����Զ��廭�����
		chuangkou.add(huaban);
		//�����߳����ʵ�������󣬲��ҹ����Զ��廭�����
		Thread xiancheng =new Thread(huaban);
		//�����̶߳���-->���Զ�ִ��run();����
		xiancheng.start();
		//�����Զ��廭�����еļ��̼����¼���Ӧ��������Ч��
		chuangkou.addKeyListener(huaban);
		huaban.addKeyListener(huaban);
         
		//�ô��ڶ�����ʾ����
		chuangkou.setVisible(true);
		
		read_or_save myRead_or_save = new read_or_save();
		myRead_or_save.startsave_or_read(chuangkou, huaban);
		
		MusicPlayer bgmplayer = new MusicPlayer("music/piantou_music.wav");  //�������ֲ����� 
	      
		//bgmplayer.start(true);  //�Կ�ʼ��ѭ������ʽ���ţ�player(false)Ϊ��ѭ������ 
	      
	}

	
	
}
