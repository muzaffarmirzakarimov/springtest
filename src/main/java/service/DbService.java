package service;

import Entity.PC;
import config.DbConfig;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbService {
    @SneakyThrows
    public List<PC> getPcList() {
        List<PC> pcList = new ArrayList<>();
        Connection connection = DbConfig.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "select * from b9_computer_db.public.pc");

        while (resultSet.next()) {
            PC pc = new PC();
            pc.setCode(resultSet.getInt(1));
            pc.setModel(resultSet.getString(2));
            pc.setSpeed(resultSet.getInt(3));
            pc.setRam(resultSet.getInt(4));
            pc.setHd(resultSet.getInt(5));
            pc.setCd(resultSet.getString(6));
            pc.setPrice(resultSet.getDouble(7));

            pcList.add(pc);
        }
        return pcList;
    }

    @SneakyThrows
    public static void save(HttpServletRequest request) {
        String code = request.getParameter("code");
        String model = request.getParameter("model");
        String speed = request.getParameter("speed");
        String ram = request.getParameter("ram");
        String hd = request.getParameter("hd");
        String cd = request.getParameter("cd");
        String price = request.getParameter("price");

        Connection connection = DbConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into b9_computer_db.public.pc values(?,?,?,?,?,?,?)");

        preparedStatement.setInt(1, Integer.parseInt(code));
        preparedStatement.setString(2, model);
        preparedStatement.setInt(3, Integer.parseInt(speed));
        preparedStatement.setInt(4, Integer.parseInt(ram));
        preparedStatement.setInt(5, Integer.parseInt(hd));
        preparedStatement.setString(6, cd);
        preparedStatement.setDouble(7, Double.parseDouble(price));

        preparedStatement.execute();
    }
}
