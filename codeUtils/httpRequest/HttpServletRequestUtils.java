import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequestUtils {

    public static ServletRequest getParamsMap(ServletRequest servletRequest, Map<String, String> paramsMap) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String contentType = httpServletRequest.getContentType();
        if (contentType != null && contentType.contains("application/x-www-form-urlencoded")) {
            Enumeration pNames = servletRequest.getParameterNames();
            while (pNames.hasMoreElements()) {
                String name = (String) pNames.nextElement();
                String value = servletRequest.getParameter(name);
                paramsMap.put(name, value);
            }
        } else {

        }
    }
}