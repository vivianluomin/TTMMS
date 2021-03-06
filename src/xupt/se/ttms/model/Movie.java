package xupt.se.ttms.model;

public class Movie {
	
		private int movieId;//影片Id
		private String movieName;//影片名称
		private String movieDesc;//影片介绍
		private String movieImage;//影片海报
		private double moviePeice;
		private int isReleased;//是否是今日上映的？如果是0就不是今天上映的如果是1 就是今天上映的
		
		public Movie(){
			
		}
		
		
		public Movie(int movieId, String movieName, String movieDesc, String movieImage, double moviePeice,
				int isReleased) {
			
			this.movieId = movieId;
			this.movieName = movieName;
			this.movieDesc = movieDesc;
			this.movieImage = movieImage;
			this.moviePeice = moviePeice;
			this.isReleased = isReleased;
		}
		public double getMoviePeice() {
			return moviePeice;
		}
		public void setMoviePeice(double moviePeice) {
			this.moviePeice = moviePeice;
		}
		public int getIsReleased() {
			return isReleased;
		}
		public void setIsReleased(int isReleased) {
			this.isReleased = isReleased;
		}
		public String getMovieImage() {
			return movieImage;
		}
		public void setMovieImage(String movieImage) {
			this.movieImage = movieImage;
		}
		public int getMovieId() {
			return movieId;
		}
		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public String getMovieDesc() {
			return movieDesc;
		}
		public void setMovieDesc(String movieDesc) {
			this.movieDesc = movieDesc;
		}		
}
