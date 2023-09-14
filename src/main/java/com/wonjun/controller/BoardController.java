package com.wonjun.controller;

import com.wonjun.model.NoticeboardDto;
import com.wonjun.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/sku")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private NoticeboardDto noticeboardDto;

    @RequestMapping({"/list", "/"})
    public String getArticleList(Model model) {
        List<NoticeboardDto> articleList = boardService.listArticles();
        model.addAttribute("dataList", articleList);
        return "list";
    }

    @GetMapping("/add")
    public String writeArticle() {
        return "write";
    }

    @PostMapping("/addarticle")
    public String addArticle(@RequestParam(value = "i_title") String title,
                             @RequestParam(value = "i_content") String content) {
        noticeboardDto.setTitle(title);
        noticeboardDto.setContent(content);
        noticeboardDto.setWrite_id("admin");
        // DB에 저장하는 서비스 호출
        boardService.addArticle(noticeboardDto);
        return "redirect:list";
    }

    @GetMapping("/view")
    public ModelAndView viewArticle(@RequestParam(value = "no") String articleNo) {
        noticeboardDto = boardService.viewArticle(Integer.parseInt(articleNo));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("view");
        mv.addObject("article", noticeboardDto);

        return mv;
    }

    @PostMapping("/edit")
    public String editArticle(@RequestParam(value = "articleNo") String articleNo,
                              @RequestParam(value = "title") String title,
                              @RequestParam(value = "content") String content,
                              RedirectAttributes attr) {
        noticeboardDto.setArticle_no(Integer.parseInt(articleNo));
        noticeboardDto.setTitle(title);
        noticeboardDto.setContent(content);
        boardService.editArticle(noticeboardDto);
        attr.addAttribute("no", articleNo);
        return "redirect:view";
    }

    @PostMapping("/remove")
    public String removeArticle(@RequestParam(value = "articleNo") String articleNo) {
        boardService.removeArticle(Integer.parseInt(articleNo));
        return "redirect:list";
    }

    @GetMapping("/info")
    @ResponseBody
    public Map<String, String> getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "sku project");
        map.put("version", "1.0");
        map.put("author", "Tom");

        return map;
    }
}