//Nick Keirstead
class OCR {
	public static char ocr(int[][] image) {
		int h = OCR_Templates.HEIGHT, w = OCR_Templates.WIDTH;
		int darkestBandTopRow = findVertPosition(image, h);
		int darkestBandLeftCol = findHorzPosition(image, darkestBandTopRow, h, w);
		
		double bestMatch = -Double.MAX_VALUE;
		char bestLetter = '0';
		for (int i = 0; i < OCR_Templates.letters.length; i++) {
			int[][] temp = OCR_Templates.letters[i].getTemplate();
			double matchVal = match(image, temp, darkestBandTopRow, darkestBandLeftCol);
			if (matchVal > bestMatch) {
				bestMatch = matchVal;
				bestLetter = OCR_Templates.letters[i].getRep();
			}
			//System.out.println("MatchVal For " + OCR_Templates.letters[i].getRep() + " = " + matchVal);
		}
		return bestLetter;
	}
	
	private static int findVertPosition(int[][] image, int h) {
		int minSum = Integer.MAX_VALUE;
		Rect best = null;
		for (int bandTopRow = 0; bandTopRow < image.length - h; bandTopRow++) {
			Rect r = new Rect(image, bandTopRow, 0, h, image[0].length);
			int sum = r.getSum();
			if (sum < minSum) {
				minSum = sum;
				best = r;
			}
		}
		return best.getStartRow();
	}
	private static int findHorzPosition(int[][] image, int row0, int h, int w) {
		Rect best = null;
		int min = Integer.MAX_VALUE;
		for (int startCol = 0; startCol < image[0].length - w; startCol++) {
			Rect r = new Rect(image, row0, startCol, h, w);
			int rSum = r.getSum();
			if (rSum < min) {
				min = rSum;
				best = r;
			}
		}
		return best.getStartCol();
	}
	
	//I had to make match return a double instead of an int,
	//because the match values are coming out as between 0 and 1 or 0 and -1,
	//so they would be made 0 if cast to an int.
	private static double match(int[][] image, int[][] template, int row, int col) {
		Rect imageCovered = new Rect(image, row, col, template.length, template[0].length);
		Rect templateRect = new Rect(template, 0, 0, template.length, template[0].length);
		double corr = correlation(imageCovered, templateRect);
		return corr;
	}
	
	private static double correlation(Rect a, Rect b) {
		double corr = covariance(a, b) / (a.sigma() * b.sigma());
		return corr;
	}
	private static double covariance(Rect a, Rect b) {
		double sum = 0;
		int n = a.widthHeightProd(); //same for a and b
		int[][] aData = a.getData(), bData = b.getData();
		double aAvg = a.getAvg(), bAvg = b.getAvg();
		for (int i = 0; i < aData.length; i++) {
			for (int j = 0; j < aData[i].length; j++) {
				sum += (aData[i][j] - aAvg) * (bData[i][j] - bAvg);
			}
		}
		double cov = sum / (double) n;
		return cov;
	}
	
	static class Rect {
		private int row0, col0, h, w;
		private int sum;
		private int[][] data;
		private double avg;
		public Rect(int[][] sourceImage, int row0, int col0, int h, int w) {
			this.row0 = row0;
			this.col0 = col0;
			this.h = h;
			this.w = w;
			this.data = new int[h][w];
			for (int row = row0; row < row0 + h; row++) {
				for (int col = col0; col < col0 + w; col++) {
					this.data[row-row0][col - col0] = sourceImage[row][col];
				}
			}
			this.sum = 0;
			for (int[] row : data) {
				for (int num : row) {
					this.sum += num;
				}
			}
			this.avg = (double)this.sum / (this.h * this.w);
		}
		public int[][] getData() {
			return this.data;
		}
		public double getAvg() {
			return this.avg;
		}
		public double sigma() {
			double n = (double)widthHeightProd();
			double sum = 0;
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					sum += Math.pow((data[i][j] - this.avg), 2);
				}
			}
			double sig = Math.sqrt(sum / n);
			return sig;
		}
		
		public int getSum() {
			int sum = 0;
			for (int[] row : data) {
				for (int num : row) {
					sum += num;
				}
			}
			return sum;
		}
		public int getStartRow() {
			return row0;
		}
		public int getStartCol() {
			return col0;
		}
		public int widthHeightProd() {
			return w * h;
		}
		public int getHeight() {
			return h;
		}
	}
}