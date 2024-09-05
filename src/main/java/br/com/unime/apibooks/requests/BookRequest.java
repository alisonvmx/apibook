package br.com.unime.apibooks.requests;

public class BookRequest {

    private String title;
    private String summary;
    private int numberPages;
    private String authors;
    private String category;

    public BookRequest() {
    }

    public BookRequest(String title, String summary, int numberPages, String authors, String category) {
        this.title = title;
        this.summary = summary;
        this.numberPages = numberPages;
        this.authors = authors;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
