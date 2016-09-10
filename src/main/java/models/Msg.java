package models;

/**
 * Created by Roma on 10.09.2016.
 */
public class Msg {
    private String author;

    public Msg(String author, String msg) {
        this.author = author;
        this.msg = msg;
    }

    private String msg;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
