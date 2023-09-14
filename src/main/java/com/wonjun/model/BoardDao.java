package com.wonjun.model;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardDao {
    public List<NoticeboardDto> selectAllArticles() throws DataAccessException;
    public void insertArticle(NoticeboardDto noticeboardDto) throws DataAccessException;
    public NoticeboardDto selectArticle(int articleNo) throws DataAccessException;
    public void updateArticle(NoticeboardDto noticeboardDto) throws DataAccessException;
    public void removeArticle(int articleNo) throws DataAccessException;
}