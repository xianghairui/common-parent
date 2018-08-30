//package com.xiang.demo.java.util.qrcode;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.Shape;
//import java.awt.geom.RoundRectangle2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//
//import javax.imageio.ImageIO;
//
//import com.swetake.util.Qrcode;
//
///**
// * @ClassNmae QrCardUtil
// * @Description 生成二维码图片工具类-qrcode.jar
// *              <p>
// *              http://www.qrcode.com/zh/
// *              <p>
// *              * 21X21 个模块 177*177个模块 每提高一个版本增加四个模块
// *              <p>
// *              QR码的各个版本结合数据量、字符类型和纠错级别，均设有相对应的最多输入字符数。
// *              也就是说，如果增加数据量，则需要使用更多的码元来组成QR码，QR码就会变得更大。
// *              <p>
// *              数据类型和容量 数字：7089个字符 字母：4296 8位字节的数据：2953 汉子：1817个汉子
// *              <p>
// *              数据的表示方法：深色模块表示二进制1，浅色模块表示二进制0
// *              <p>
// *              纠错能力：L(7%) M(15%) Q(25%) H(30%) “纠错能力”具备4个级别，用户可根据使用环境选择相应的级别。
// *              调高级别，纠错能力也相应提高，但由于数据量会随之增加，编码尺寸也也会变大。
// *              用户应综合考虑使用环境、编码尺寸等因素后选择相应的级别。 在工厂等容易沾染
// *              赃物的环境下，可以选择级别Q或H，在不那么脏的环境下，且数据量较多的时候，
// *              也可以选择级别L。一般情况下用户大多选择级别M(15%)。 纠错级别越高能存储的信息越少
// * @author hairui
// * @Date 2017年3月27日 下午9:50:52
// */
//public class QrCodeUtil2 {
//
//	/**
//	 * 字符编码
//	 */
//	private static final String CHARSET = "utf-8";
//
//	/**
//	 * 图片类型-jpg
//	 */
//	private static final String IMGAGE_TYPE_JPG = "JPG";
//
//	/**
//	 * 图片类型-jpeg
//	 */
//	private static final String IMGAGE_TYPE_JPEG = "JPEG";
//
//	/**
//	 * 二维码尺寸
//	 */
//	private static final int QRCODE_SIZE = 300;
//
//	/**
//	 * LOGO宽度
//	 */
//	private static final int LOG_WIDTH = 60;
//
//	/**
//	 * LOGO高度
//	 */
//	private static final int LOG_HEIGHT = 60;
//
//	/**
//	 * 生成二维码
//	 *
//	 * @param content
//	 *            内容
//	 * @param path
//	 *            存放地址
//	 * @return
//	 * @throws Exception
//	 */
//	private static BufferedImage createImage(String content, String path) throws Exception {
//		File directory = new File("test.jpeg");
//		// 在缓存中创建一个图片对象
//		BufferedImage bufImg = new BufferedImage(QRCODE_SIZE, QRCODE_SIZE, BufferedImage.TYPE_INT_RGB);
//		// 通过内存中的图片对象拿到绘图工具类
//		Graphics2D grap = bufImg.createGraphics();
//		// 设置画笔颜色
//		grap.setColor(Color.WHITE);
//		// 填充一个矩形
//		grap.fillRect(0, 0, QRCODE_SIZE, QRCODE_SIZE);
//
//		/**
//		 *
//		 * jar : qrcode.jar, zxing.jar
//		 *
//		 */
//		Qrcode qrcode = new Qrcode();
//		qrcode.setQrcodeEncodeMode('B');
//
//		qrcode.setQrcodeErrorCorrect('M');
//
//		// 设置版本号
//		qrcode.setQrcodeVersion(15);
//		// 需要加密图片保存到磁盘
//		boolean[][] bytes = qrcode.calQrcode(content.getBytes());
//		// 设置画笔颜色为黑色
//		grap.setColor(Color.BLACK);
//		for (int i = 0; i < bytes.length; i++) {
//			for (int j = 0; j < bytes.length; j++) {
//				if (bytes[j][i]) {// 背景已经为浅色了，那么只需要将深色的方块画出来
//					grap.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
//				}
//			}
//		}
//		// String img = "F:/download/image/1.jpg";
//		// BufferedImage logo = ImageIO.read(new File(img));
//		// 二维码中的logo图片如何放置
//		// int x = (QRCODE_SIZE - width) / 2;
//		// int y = (QRCODE_SIZE - height) / 2;
//		// grap.drawImage(logo, (width - 50) / 2, (height - 50) / 2, 50, 50,
//		// null);
//		// 将缓存中的图片保存到磁盘
//		// ImageIO.write(bufImg, "JPEG", directory);
//
//		return bufImg;
//	}
//
//	/**
//	 * 插入LOGO
//	 *
//	 * @param source
//	 *            二维码图片
//	 * @param imgPath
//	 *            LOGO图片地址
//	 * @param needCompress
//	 *            是否压缩
//	 * @throws Exception
//	 */
//	private static void insertImage(BufferedImage source, String imgPath, boolean needCompress) throws Exception {
//		File file = new File(imgPath);
//		if (!file.exists()) {
//			System.err.println("" + imgPath + "   该文件不存在！");
//			return;
//		}
//		Image src = ImageIO.read(new File(imgPath));
//		int width = src.getWidth(null);
//		int height = src.getHeight(null);
//		if (needCompress) { // 压缩LOGO
//			if (width > LOG_WIDTH) {
//				width = LOG_WIDTH;
//			}
//			if (height > LOG_HEIGHT) {
//				height = LOG_HEIGHT;
//			}
//			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//			Graphics g = tag.getGraphics();
//			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
//			g.dispose();
//			src = image;
//		}
//		// 插入LOGO
//		Graphics2D graph = source.createGraphics();
//		int x = (QRCODE_SIZE - width) / 2;
//		int y = (QRCODE_SIZE - height) / 2;
//		graph.drawImage(src, x, y, width, height, null);
//		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
//		graph.setStroke(new BasicStroke(3f));
//		graph.draw(shape);
//		graph.dispose();
//	}
//
//	/**
//	 * 生成二维码(QRCode)图片
//	 *
//	 * @param content
//	 *            二维码图片的内容
//	 * @param imgPath
//	 *            生成二维码图片完整的路径
//	 * @param ccbpath
//	 *            二维码图片中间的logo路径
//	 */
//	public static int createQRCode(String content, String imgPath, String ccbPath, int version) {
//		try {
//			Qrcode qrcodeHandler = new Qrcode();
//			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
//			qrcodeHandler.setQrcodeErrorCorrect('M');
//			// N代表数字,A代表字符a-Z,B代表其他字符
//			qrcodeHandler.setQrcodeEncodeMode('B');
//			// 设置设置二维码版本，取值范围1-40，值越大尺寸越大，可存储的信息越大
//			qrcodeHandler.setQrcodeVersion(version);
//			// 图片尺寸
//			int imgSize = 67 + 12 * (version - 1);
//
//			byte[] contentBytes = content.getBytes(QrCodeUtil2.CHARSET);
//			BufferedImage image = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
//			Graphics2D gs = image.createGraphics();
//
//			gs.setBackground(Color.WHITE);
//			gs.clearRect(0, 0, imgSize, imgSize);
//
//			// 设定图像颜色 > BLACK
//			gs.setColor(Color.BLUE);
//
//			// 设置偏移量 不设置可能导致解析出错
//			int pixoff = 2;
//			// 输出内容 > 二维码
//			if (contentBytes.length > 0 && contentBytes.length < 130) {
//				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
//				for (int i = 0; i < codeOut.length; i++) {
//					for (int j = 0; j < codeOut.length; j++) {
//						if (codeOut[j][i]) {
//							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
//						}
//					}
//				}
//			} else {
//				System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,125]. ");
//				return -1;
//			}
//			Image logo = ImageIO.read(new File(ccbPath));// 实例化一个Image对象。
//			int widthLogo = logo.getWidth(null) > image.getWidth() * 2 / 10 ? (image.getWidth() * 2 / 10)
//					: logo.getWidth(null),
//					heightLogo = logo.getHeight(null) > image.getHeight() * 2 / 10 ? (image.getHeight() * 2 / 10)
//							: logo.getWidth(null);
//
//			/**
//			 * logo放在中心
//			 */
//			int x = (image.getWidth() - widthLogo) / 2;
//			int y = (image.getHeight() - heightLogo) / 2;
//			gs.drawImage(logo, x, y, widthLogo, heightLogo, null);
//			gs.dispose();
//			image.flush();
//
//			// 生成二维码QRCode图片
//			File imgFile = new File(imgPath);
//			ImageIO.write(image, "png", imgFile);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return -100;
//		}
//
//		return 0;
//	}
//
//	public static void main(String[] args) {
//		String imgPath = "";
//		String logoPath = "D:/logo/logo3.jpg";
//		String encoderContent = "";
//		QrCodeUtil2 logo_Two_Code = new QrCodeUtil2();
//		logo_Two_Code.createQRCode(encoderContent, imgPath, logoPath, 8);
//	}
//
//}
