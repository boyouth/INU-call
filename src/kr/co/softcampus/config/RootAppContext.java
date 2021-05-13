package kr.co.softcampus.config;

import kr.co.softcampus.beans.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {

    @Bean("loginUserInfo")
    @SessionScope
    public UserBean loginUserBEan() {
        return new UserBean();
    }

}
