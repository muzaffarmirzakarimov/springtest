package controller;

import Entity.PC;
import service.DbService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class PcController extends HttpServlet {
    public static DbService service = new DbService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PC> pcList = service.getPcList();
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even) {\n" +
                "  background-color: #dddddd;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>");
        writer.write("<a href=\"/addPc\">  PCga qo'shish</a>\n");
        writer.write("<h2>HTML Table PC</h2>");
        writer.write("<table>\n" +
                "  <tr>\n" +
                "    <th>Code</th>\n" +
                "    <th>Model</th>\n" +
                "    <th>Speed</th>\n" +
                "  </tr>\n");
        for (PC pc : pcList) {
            writer.write("<tr>\n" +
                    "    <td>" + pc.getCode() + "</td>\n" +
                    "    <td>" + pc.getModel() + "</td>\n" +
                    "    <td>" + pc.getSpeed() + "</td>\n" +
                    "  </tr>");
        }
        writer.write("</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        writer.close();
        resp.setContentType("text/html");
//        resp.sendRedirect("pc.html");
    }
}
