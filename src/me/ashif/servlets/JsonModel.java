package me.ashif.servlets;

/**
 * Created by almukthar on 5/3/16.
 */
public class JsonModel {
    private String content;

    public JsonModel(String extractedResult) {
        this.content = extractedResult;
    }

    public JsonModel() {

    }

    public String getExtractedResult() {
        return content;
    }

    public void setExtractedResult(String extractedResult) {
        this.content = extractedResult;
    }
}
