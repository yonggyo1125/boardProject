package org.koreait.controllers.members;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.koreait.commons.MemberUtil;
import org.koreait.entities.Member;
import org.koreait.models.member.MemberInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.koreait.commons.Utils;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final Utils utils;
    private final MemberUtil memberUtil;

    @GetMapping("/join")
    public String join() {

        return utils.tpl("member/join");
    }

    @GetMapping("/login")
    public String login(String redirectURL, Model model) {

        model.addAttribute("redirectURL", redirectURL);

        return utils.tpl("member/login");
    }

    @ResponseBody
    @GetMapping("/info")
    public void info() {

        Member member = memberUtil.getMember();
        if (memberUtil.isLogin()) {
            log.info(member.toString());
        }

        log.info("로그인 여부 : {}", memberUtil.isLogin());
    }
    /*
    public void info() {
        MemberInfo member = (MemberInfo)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info(member.toString());
    }
    */
    /*
    public void info(@AuthenticationPrincipal MemberInfo memberInfo) {
        log.info(memberInfo.toString());
    */
    /*
    public void info(Principal principal) {
        String email = principal.getName();
        log.info(email);
    }
     */
}
