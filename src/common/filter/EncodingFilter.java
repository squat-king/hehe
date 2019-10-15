package common.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

	private String encoding = null;

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (encoding != null) {
			request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	public void destroy() {

	}
}
