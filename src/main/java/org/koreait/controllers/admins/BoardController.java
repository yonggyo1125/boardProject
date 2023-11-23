package org.koreait.controllers.admins;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminBoardController")
@RequestMapping("/admin/board")
@RequiredArgsConstructor
public class BoardController {
    @GetMapping
    public String list() {

        return "admin/board/list";
    }

    @GetMapping("/add")
    public String register() {

        return "admin/board/add";
    }

    @GetMapping("/edit/{bId}")
    public String update(@PathVariable String bId) {

        return "admin/board/edit";
    }

    @PostMapping("/save")
    public String save() {

        return "redirect:/admin/board";
    }
}
