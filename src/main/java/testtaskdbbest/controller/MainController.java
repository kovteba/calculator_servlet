package testtaskdbbest.controller;

import testtaskdbbest.service.CalculatorDAO;
import testtaskdbbest.service.CalculatorDAOImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "mainController",
        urlPatterns = "/mainController"
)
public class MainController extends HttpServlet {

    private static CalculatorDAO calculatorDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        calculatorDAO = new CalculatorDAOImpl();
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
