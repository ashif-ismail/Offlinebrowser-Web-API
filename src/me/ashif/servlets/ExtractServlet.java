package me.ashif.servlets;

import de.l3s.boilerpipe.BoilerpipeExtractor;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.extractors.CommonExtractors;
import de.l3s.boilerpipe.extractors.KeepEverythingExtractor;
import de.l3s.boilerpipe.sax.HTMLFetcher;
import de.l3s.boilerpipe.sax.HTMLHighlighter;
import org.xml.sax.SAXException;

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
        String urlString = request.getParameter("url");
        String listOUtput = request.getParameter("OutputType");
        URL url = new URL(urlString);
        switch (listOUtput) {
            case "1":
                if(request.getParameter("ExtractorType").equals("1"))
                    //when the extractor is ArticleExtractor and the
                    //output mode is Plain Text
                        try {
                            String mainArticle = ArticleExtractor.INSTANCE.getText(url);
                            out.println(mainArticle);
                        } catch (BoilerpipeProcessingException ex) {
                            out.println(ex.getMessage());
                        }
                else if(request.getParameter("ExtractorType").equals("2"))
                    //when the extractor is KeepEverythingExtractor and the
                    //output mode is Plain Text
                    try {
                        String fullArticle = KeepEverythingExtractor.INSTANCE.getText(url);
                        out.println(fullArticle);
                    } catch (BoilerpipeProcessingException ex) {
                        out.println(ex.getMessage());
                    }
                break;
            case "2":
                if(request.getParameter("ExtractorType").equals("1"))
                    //when the extractor is Article Extractor
                    //and the output mode is HTML Text
                    try
                    {
                        final BoilerpipeExtractor extractor = CommonExtractors.ARTICLE_EXTRACTOR;
                        final boolean includeImages = false;
                        final boolean bodyOnly = true;
                        final HTMLHighlighter hh = HTMLHighlighter.newExtractingInstance(includeImages, bodyOnly);
                        out.println("<base href=\"" + url + "\" >");
                        out.println("<meta http-equiv=\"Content-Type\" content=\"text-html; charset=utf-8\" />");
                        String extractedHtml = hh.process(url, extractor);
                        out.println(extractedHtml);
                    } catch (SAXException | BoilerpipeProcessingException ex) {
                        out.println(ex.getMessage());
                    }

                else if(request.getParameter("ExtractorType").equals("2"))
                    //when the extractor is KeepEverything Extractor
                    //and the output mode is HTML
                        try {
                            final BoilerpipeExtractor extractor = CommonExtractors.LARGEST_CONTENT_EXTRACTOR;
                            final boolean includeImages = false;
                            final boolean bodyOnly = true;
                            final HTMLHighlighter hh = HTMLHighlighter.newExtractingInstance(includeImages, bodyOnly);
                            out.println("<base href=\"" + url + "\" >");
                            out.println("<meta http-equiv=\"Content-Type\" content=\"text-html; charset=utf-8\" />");
                            String extractedHtml = hh.process(url, extractor);
                            out.println(extractedHtml);
                        } catch (SAXException | BoilerpipeProcessingException ex) {
                            out.println(ex.getMessage());
                        }

                }
        }
    }







