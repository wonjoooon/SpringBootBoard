package com.wonjun.service;

import com.wonjun.model.BoardDao;
import com.wonjun.model.NoticeboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    public List<NoticeboardDto> listArticles() throws DataAccessException {
        List<NoticeboardDto> articleList = boardDao.selectAllArticles();
        return articleList;
    }

    public void addArticle(NoticeboardDto article) throws DataAccessException {
        // DB에 저장하는 DAO 메서드 호출
        boardDao.insertArticle(article);
    }

    public NoticeboardDto viewArticle(int articleNo) throws DataAccessException {
        NoticeboardDto article = boardDao.selectArticle(articleNo);
        return article;
    }

    public void editArticle(NoticeboardDto article) throws DataAccessException {
        boardDao.updateArticle(article);
    }

    public void removeArticle(int articleNo) throws DataAccessException {
        boardDao.removeArticle(articleNo);
    }
}