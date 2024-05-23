package kr.ac.kopo.guestbook2024.controller;

import kr.ac.kopo.guestbook2024.dto.PageRequestDTO;
import kr.ac.kopo.guestbook2024.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestbookController {
    private final GuestbookService service;

    @GetMapping("/")
    public String index() {
        return "redirect:/guestbook/list";
    }

    @GetMapping({"/list"})
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        // list.html(View 계층)에 방명록 목록과 화면에 보여질 때 필요한 페이지 번호들 등의 정보를 전달하기 위한 것
        model.addAttribute("result", service.getList(pageRequestDTO));
    }
}
