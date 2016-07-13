package gap_test;


import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{
    private String message;
    
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public void doTag() throws IOException, JspException{
        if(null != message){
            getJspContext().getOut().println(message);
        }else{
            StringWriter sw = new StringWriter();
            getJspBody().invoke(sw);
            getJspContext().getOut().println(sw.toString());
        }
    }
}
