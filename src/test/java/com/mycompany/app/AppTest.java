package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static org.mockito.Mockito.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testAppConstructor() {
        App app1 = new App();
        App app2 = new App();
        assertEquals(app1.getMessage(), app2.getMessage());
    }

    @Test
    public void testAppMessage()
    {
        App app = new App();
        assertEquals("Hello World!", app.getMessage());
    }
    
    @Test
    public void testDoGet() throws IOException, ServletException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        PrintWriter writer = Mockito.mock(PrintWriter.class);
        
        // Stubbing for response.getWriter() to return our mocked PrintWriter
        when(response.getWriter()).thenReturn(writer);

        // Call the method under test
        App servlet = new App();
        servlet.doGet(request, response);

        // Verify that the correct content type is set
        verify(response).setContentType("text/html");

        // Verify that the expected HTML is written to the PrintWriter
        verify(writer).println("<html><body>");
        verify(writer).println("<h2>Hello" + servlet.getMessage() + "</h2>");
        verify(writer).println("</body></html>");

        
    }
}
