package kosta.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.domain.Board;
import kosta.domain.Search;

public interface BoardMapper {
	int insertBoard(Board board);
	int insertReferenceroom(Board board);
	List<Board> listBoard(Search search,RowBounds row);
	List<Board> listReferenceroom(Search search,RowBounds row);
	
	Board detailBoard(int b_no);
	int updateBoard(Board board);
	int deleteBoard(int b_no);
	int deleteReferenceroom(int b_no);
	int countBoard(Search search); 
}
