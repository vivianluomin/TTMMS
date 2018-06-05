package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.model.AMovieSechduel;
import xupt.se.ttms.model.Movie;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.model.Ticket;
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
	
	public static Studio getStudioSeat(int studio_id){
		int[] seats = new int[2];
		Studio studio = new Studio();
		try {
			String sql = "select studio_id,studio_name "
					+ ",studio_row_count,studio_col_count,studio_introduction"
					+ " from studio"
					+ " where studio_id = "+studio_id;
		
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return null ;
			}
			ResultSet rst = db.execQuery(sql);
		
			if (rst!=null) {
				while(rst.next()){
					studio.setID(rst.getInt("studio_id"));
					studio.setName(rst.getString("studio_name"));
					studio.setRowCount(rst.getInt("studio_row_count"));
					studio.setColCount(rst.getInt("studio_col_count"));
					studio.setIntroduction(rst.getString("studio_introduction"));
				}
			}else{
				return null;
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return studio;
	}
	
	public static List<Ticket> getAStudioTicket(int seched_id){
		
		List<Ticket> tickets = new LinkedList<>();
		try {
			String sql = " select  ticket_id,ticket.seat_id,"
					+"ticket.sched_id,ticket.play_id,ticket_price,"
					+"seat_row,seat_column,studio_id"
					+" from ticket,seat"
					+" where ticket.sched_id = "+seched_id+" and ticket.seat_id = seat.seat_id;";
		
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return null ;
			}
			ResultSet rst = db.execQuery(sql);
		
			if (rst!=null) {
				while(rst.next()){
					Ticket ticket = new Ticket();
					ticket.setTicket_id(rst.getInt("ticket_id"));
					ticket.setSeat_id(rst.getInt("seat_id"));
					ticket.setSched_id(rst.getInt("sched_id"));
					ticket.setPlay_id(rst.getInt("play_id"));
					ticket.setTicket_price(rst.getDouble("ticket_price"));
					ticket.setRow(rst.getInt("seat_row"));
					ticket.setCol(rst.getInt("seat_column"));
					ticket.setStudio_id(rst.getInt("studio_id"));
					tickets.add(ticket);
				}
			}else{
				return null;
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return tickets;
		
	}

	public static void main(String[] args) {
		List<Ticket> list = getAStudioTicket(1);
		for(Ticket t:list){
			System.out.println(t.getRow()+" ---"+t.getCol());
		}

	}

}
