package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.model.AMovieSechduel;
import xupt.se.ttms.model.Movie;
import xupt.se.ttms.model.Studio;
import xupt.se.util.DBUtil;

public class sellticketDAO {
	
	public static List<Movie> getScheduelMovie(){
		List<Movie> movieList = null;
		movieList=new LinkedList<Movie>();
		try {
			String sql = "select play_id, play_name, play_introduction, play_image,"
					+ " play_time,play_ticket_price,play_status from play"
					+ " where play_status = 1 ";
		
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return null ;
			}
			ResultSet rst = db.execQuery(sql);
			if (rst!=null) {
				while(rst.next()){
					Movie movie=new Movie();
					movie.setMovieId(rst.getInt("play_id"));
					movie.setMovieName(rst.getString("play_name"));
					movie.setMovieDesc(rst.getString("play_introduction"));
					movie.setMovieImage(rst.getString("play_image"));
					movie.setMoviePeice(rst.getDouble("play_ticket_price"));
					movie.setIsReleased(rst.getInt("play_status"));
					movieList.add(movie);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return movieList;
	}
	
	public static List<AMovieSechduel> getAMovieSechduel(int playid){
		List<AMovieSechduel> list = null;
		list=new LinkedList<AMovieSechduel>();
		try {
			String sql = "select sched_id, studio_id, play_id, sched_time,"
					+ " sched_ticket_price from schedules"
					+ " where play_id = "+playid;
		
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return null ;
			}
			ResultSet rst = db.execQuery(sql);
			if (rst!=null) {
				while(rst.next()){
					AMovieSechduel amovie = new AMovieSechduel();
					amovie.setSched_id(rst.getInt("sched_id"));
					amovie.setStudio_id(rst.getInt("studio_id"));
					amovie.setPlay_id(rst.getInt("play_id"));
					amovie.setSched_time(rst.getString("sched_time"));
					amovie.setPrice(rst.getDouble("sched_ticket_price"));
					list.add(amovie);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return list;
	}

	public static void main(String[] args) {
		List<AMovieSechduel> list = getAMovieSechduel(1);
		for(AMovieSechduel e:list){
			System.out.println(e.getSched_time());
		}

	}

}
