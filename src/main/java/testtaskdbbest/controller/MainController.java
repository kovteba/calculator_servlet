package testtaskdbbest.controller;

import testtaskdbbest.service.CalculatorDAO;
import testtaskdbbest.service.CalculatorDAOImpl;

import javax.servlet.RequestDispatcher;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("before");
        String inputValue = req.getParameter("inputValue");
        System.out.println("INPUT : " + inputValue);

        String result = req.getParameter("result");
        System.out.println("RESULT : " + result);

        req.setAttribute("inputValue", inputValue);

        req.setAttribute("result", result);

        System.out.println("after");
        RequestDispatcher dispatcher = req.getRequestDispatcher(
                "/WEB-INF/templates/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputValue = req.getParameter("inputValue");
        System.out.println("!!!!!!!!!!! : " + inputValue);
        String result = null;
        try {
            result = calculatorDAO.catculate(inputValue);
        } catch (NumberFormatException e){
            e.printStackTrace();
            result = "Incorrect string";
        }


        req.setAttribute("inputValue", inputValue);

        req.setAttribute("result", result);

        RequestDispatcher dispatcher = req.getRequestDispatcher(
                "/WEB-INF/templates/index.jsp");
        dispatcher.forward(req, resp);

//        req.setAttribute("inputValue", inputValue);
//        req.setAttribute("result", result);
//
//        resp.sendRedirect("mainController?inputValue=" + inputValue + "&result=" + result);
    }
}
