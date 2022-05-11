package kosta.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.domain.Community;
import kosta.domain.Reply;
import kosta.domain.Search;

public interface CommunityMapper {
	List<Community> listCommunity(Search search, RowBounds row);
	int insertCommunityTrade(Community community);
	Community detailCommunityTrade(int cm_no);
	int updateCommunityTrade(Community community);
	int deleteCommunityTrade(Community community);
	int countTrade(Search search);
	int countClub(Search search);
	int countCarfull(Search search);
	
	int insertReply(Reply reply);
	List<Reply> listReply(int cm_no);
	
	List<Community> listCommunityClub(Search search, RowBounds row);
	int insertCommunityClub(Community community);
	int updateCommunityClub(Community community);
	
	List<Community> listCommunityCarfull(Search search, RowBounds row);
	int insertCommunityCarfull(Community community);
	int updateCommunityCarfull(Community community);
	
	List<Community> noticeCommunity();
	
	int insertNoticeTrade(Community community);
	int insertNoticeClub(Community community);
	int insertNoticeCarfull(Community community);
	
}
