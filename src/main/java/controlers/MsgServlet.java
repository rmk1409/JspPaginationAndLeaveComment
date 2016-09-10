package controlers;

import models.DaoMsg;
import models.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Roma on 10.09.2016.
 */
@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String userMsg = request.getParameter("userMsg");

        if (!userMsg.trim().isEmpty()){
            userName = userName.trim().isEmpty() ? "Anonym": userName;
            DaoMsg.addMsg(new Msg(userName, userMsg));
        }

        DaoMsg.getRowCount();
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }
}
