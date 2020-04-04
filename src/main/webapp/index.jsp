<html lang="en">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CALCULATOR </title>
    <link type="text/css" rel="stylesheet" href="webresources/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="webresources/bootstrap/css/bootstrap-grid.css">
    <link type="text/css" rel="stylesheet" href="webresources/bootstrap/css/bootstrap-reboot.css">
    <link type="text/css" rel="stylesheet" href="webresources/css/style.css">
</head>
<body>
<%String beforeValue = "";%>
<%
    if ("".equals(beforeValue)) {
        beforeValue = "";
    }
    ;
%>
<%String result = "";%>
<%
    if ("".equals(result)) {
        result = "";
    }
    ;
%>

<div class="container-fluid">
    <div class="row calculator" id="calculator">
        <div class="col-md-12">
            <form method="post" action="mainController">
                <table class="table table-borderless">
                    <tbody>
                    <tr>
                        <td colspan="5"><input id="inputValue" class="inputValue" value="<%=beforeValue%>"></td>
                    </tr>
                    <tr>
                        <td colspan="1"><label class="result">RESULT:</label></td>
                        <td colspan="4"><input id="resultValue" class="resultValue" value="<%=result%>" disabled></td>
                    </tr>
                    </tbody>
                </table>
                <table class="table table-borderless">
                    <tbody>
                    <tr>
                        <td>
                            <button id="seven" class="btn btn-primary value button" value="7">7</button>
                        </td>
                        <td>
                            <button id="eight" class="btn btn-primary value button" value="8">8</button>
                        </td>
                        <td>
                            <button id="nine" class="btn btn-primary value button" value="9">9</button>
                        </td>
                        <td>
                            <button id="plus" class="btn btn-secondary value button" value="+">+</button>
                        </td>
                        <td>
                            <button class="btn btn-danger value button">C</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button id="four" class="btn btn-primary value button" value="4">4</button>
                        </td>
                        <td>
                            <button id="five" class="btn btn-primary value button" value="5">5</button>
                        </td>
                        <td>
                            <button id="six" class="btn btn-primary value button" value="6">6</button>
                        </td>
                        <td>
                            <button id="minus" class="btn btn-secondary value button" value="-">-</button>
                        </td>
                        <td>
                            <button class="btn btn-danger value button">R</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button id="one" class="btn btn-primary value button" value="1">1</button>
                        </td>
                        <td>
                            <button id="two" class="btn btn-primary value button" value="2">2</button>
                        </td>
                        <td>
                            <button id="three" class="btn btn-primary value button" value="3">3</button>
                        </td>
                        <td>
                            <button id="multiplication" class="btn btn-secondary value button" value="*">*</button>
                        </td>
                        <td>
                            <button id="leftBracket" class="btn btn-primary value button" value="(">(</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button id="zero" class="btn btn-primary value button" value="0">0</button>
                        </td>
                        <td>
                            <button id="point" class="btn btn-primary value button" value=".">.</button>
                        </td>
                        <td>
                            <button id="equals" class="btn btn-success value button">=</button>
                        </td>

                        <td>
                            <button id="division" class="btn btn-secondary value button" value="/">/</button>
                        </td>
                        <td>
                            <button id="rightBracket" class="btn btn-primary value button" value=")">)</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<script src="webresources/jquery/jquery.js"></script>
<script src="webresources/bootstrap/js/bootstrap.js"></script>
<script src="webresources/bootstrap/js/bootstrap.bundle.js"></script>
<script src="webresources/js/script.js"></script>
</body>
</html>