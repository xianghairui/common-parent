package com.xiang.demo.java.io.vcard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * @ClassNmae CardUtil
 * @Description 二维码图片生成的关键工具类
 * @author hairui
 * @Date 2017年3月24日 下午4:14:32
 */
public class CardDemo {

	public static void main(String[] args) throws IOException {
		int width = 235, height = 235;
		File directory = new File("test.jpeg");
		System.out.println(directory.getAbsolutePath());
		// 在缓存中创建一个图片对象
		BufferedImage bufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 通过内存中的图片对象拿到绘图工具类
		Graphics2D grap = bufImg.createGraphics();
		// 设置画笔颜色
		grap.setColor(Color.WHITE);
		// 填充一个矩形
		grap.fillRect(0, 0, width, height);

		/**
		 * 21X21 个模块 177*177个模块 每提高一个版本增加四个模块
		 * 
		 * 数据类型和容量 数字：7089个字符 字母：4296 8位字节的数据：2953 汉子：1817个汉子
		 * 
		 * 数据的表示方法：深色模块表示二进制1，浅色模块表示二进制0
		 * 
		 * 纠错能力：L(7%) M(15%) H(30%) 纠错级别越高能存储的信息越少
		 * 
		 * jar : qrcode.jar, zxing.jar
		 * 
		 */
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeEncodeMode('B');
		// 设置纠错率
		qrcode.setQrcodeErrorCorrect('M');
		// 设置版本号
		qrcode.setQrcodeVersion(15);
		// 需要加密图片保存到磁盘
		//String content = "www.baidu.com";
		String content = "BEGIN:VCARD\nFN:Harry\nTEL:15131506219\nEND:VCARD";
		boolean[][] bytes = qrcode.calQrcode(content.getBytes());
		// 设置画笔颜色为黑色
		grap.setColor(Color.BLACK);
		for (int i = 0; i < bytes.length; i++) {
			for (int j = 0; j < bytes.length; j++) {
				if (bytes[j][i]) {// 背景已经为浅色了，那么只需要将深色的方块画出来
					grap.fillRect(j*3+2, i*3+2, 3, 3);
				}
			}
		}
		String img = "F:/download/image/1.jpg";
		BufferedImage logo = ImageIO.read(new File(img));
		//二维码中的logo图片如何放置
		grap.drawImage(logo, (width-50)/2, (height-50)/2, 50, 50, null);
		// 将缓存中的图片保存到磁盘 
		ImageIO.write(bufImg, "JPEG", directory);

		/**
		 * vCard 电子名片
		 */
	}

}
