package util;

import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class Resize {
	
	public static void resizeImg(String path) throws IOException {
		Thumbnails.of(path).size(256, 256).keepAspectRatio(false).toFile(
				"C:/Users/CVTE/Desktop/nn/1.jpg");
	}

	public static void main(String[] args) throws IOException {
		Resize.resizeImg("C:/Users/CVTE/Desktop/nn/jan_0_20184228_104246_Color_R_45_000001.jpg");
	}
	
}
