package tmp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

/**
 * @author: jan
 * @date: 2018年6月19日 上午9:25:58
 */
public class GraphTwo {

	public void graphGenerate() throws IOException {
		Qrcode code = new Qrcode();
		code.setQrcodeErrorCorrect('M');
		code.setQrcodeEncodeMode('B');
		code.setQrcodeVersion(20);
		String data = "jan";
		int width = 67 + 12 * (20 - 1);
		int height = 67 + 12 * (20 - 1);
		BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = buff.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);
		int pixoff = 2;
		byte[] d = data.getBytes("gb2312");
		if (d.length > 0 && d.length < 120) {
			boolean[][] s = code.calQrcode(d);
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}
		}

		gs.dispose();
		buff.flush();
		ImageIO.write(buff, "png", new File("C:/Users/CVTE/Desktop/jar包/二维码/graph.png"));
	}

	public void decodeGraph() throws DecodingFailedException, IOException {
		File file = new File("C:/Users/CVTE/Desktop/jar包/二维码/graph.png");
		BufferedImage bufferedImage = ImageIO.read(file);
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		String result = new String(codeDecoder.decode(new QRCodeImage() {

			@Override
			public int getWidth() {
				// TODO Auto-generated method stub
				return bufferedImage.getWidth();
			}

			@Override
			public int getPixel(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return bufferedImage.getRGB(arg0, arg1);
			}

			@Override
			public int getHeight() {
				// TODO Auto-generated method stub
				return bufferedImage.getHeight();
			}
		}), "gb2312");
		System.out.println(result);
	}

	public void zxingGenerate() {
		int width = 300;
		int height = 300;

		String format = "png";
		// 这里如果你想自动跳转的话，需要加上https://
		String content = "jan-wa-wa";

		HashMap hits = new HashMap();
		hits.put(EncodeHintType.CHARACTER_SET, "utf-8");// 编码
		// 纠错等级，纠错等级越高存储信息越少
		hits.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		// 边距
		hits.put(EncodeHintType.MARGIN, 2);

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hits);
			// 如果做网页版输出可以用输出到流
			// MatrixToImageWriter.writeToStream(matrix, format, stream);
			Path path = new File("C:/Users/CVTE/Desktop/jar包/二维码/graph1.png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("that is all");
	}
	
	public void decodeZxing() {
		try {
			MultiFormatReader formatReader=new MultiFormatReader();
			File file=new File("C:/Users/CVTE/Desktop/jar包/二维码/graph1.png");
			BufferedImage image=ImageIO.read(file);
			BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			
			HashMap hints=new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//编码
			
			Result result=formatReader.decode(binaryBitmap, hints);
			System.out.println("解析结果："+result.toString());
			System.out.println("二维码格式类型："+result.getBarcodeFormat());
			System.out.println("二维码文本"+result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		GraphTwo two = new GraphTwo();
		two.graphGenerate();
		two.decodeGraph();
		two.zxingGenerate();
		two.decodeZxing();
	}

}
