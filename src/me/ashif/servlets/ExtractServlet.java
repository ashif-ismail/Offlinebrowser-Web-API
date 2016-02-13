package me.ashif.servlets;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 * Created by almukthar on 13/2/16.
 */
public class ExtractServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
//        out.println("URL to extract :" + url);
        try {

            String urlString = request.getParameter("url");
            URL url = new URL(urlString);
            String article = ArticleExtractor.INSTANCE.getText(url);
            out.println(article);
        } catch (BoilerpipeProcessingException e) {
            out.println("Sorry We Couldn't Scrape the URL you Entered,Verify that the URL you entered is prefixed with http://");
        } catch (IOException e) {
            out.println("Exception thrown" + e);
        }


    }
}
