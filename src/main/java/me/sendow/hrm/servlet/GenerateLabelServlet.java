package me.sendow.hrm.servlet;

import me.sendow.hrm.LabelBuilder;
import me.sendow.hrm.model.Font;
import me.sendow.hrm.model.GridType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GenerateLabelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String text = req.getParameter("text");
        if (text != null) {
            final String typeName = req.getParameter("type");
            GridType type = typeName != null ? GridType.byName(typeName) : GridType.DEFAULT;
            resp.setContentType("text/plain");
            final LabelBuilder labelBuilder = new LabelBuilder(Font.DEFAULT, type);
            labelBuilder.drawText(text);
            resp.getWriter().println(labelBuilder.encode());
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
