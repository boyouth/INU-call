package org.zerock.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zerock.spring.MemberInfoPrinter2;
import org.zerock.spring.MemberPrinter;

@Configuration
public class AppCtx2 {
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("mprinter")
	public MemberPrinter printer2() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter2 infoPrinter() {
		MemberInfoPrinter2 infoPrinter = new MemberInfoPrinter2();
		return infoPrinter;
	}

}
