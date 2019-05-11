package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(urlPatterns = { "/*" })
public class EncodingFilter implements Filter {

	//지역변수 만들기
	private String encoding;
	
	
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//request 요청이 들어왔을때 구현되는 보조 or 공통 관심
		if(request.getCharacterEncoding() == null) {
			System.out.println("before : " + request.getCharacterEncoding());

			request.setCharacterEncoding("UTF-8");
			System.out.println("after : " + request.getCharacterEncoding());
		}
		chain.doFilter(request, response); //************************;
	
		//response (응답할때 처리 되는 코드)
		System.out.println("reponse : " + "응답처리");
	}
	//처음 한번 시작할때 실행되는 함수 init
	public void init(FilterConfig fConfig) throws ServletException {
		//초기화 함수 ( 한번만 실행 )
		this.encoding = fConfig.getInitParameter("encoding");
		System.out.println("Filter init : " + encoding);
	}

}