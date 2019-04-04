<%@ page import="com.github.robertlocke.Database" %>
<%@ page import="com.github.robertlocke.Configuration" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
</head>

<script type="text/javascript">



    fetch('/highchartFormatter?for=question1')
        .then(function(response) {
           return response.json();
        })
        .then(function(json) {
            console.log(json);
            showChart1(json);
        });

    fetch('/highchartFormatter?for=question2')
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
            console.log(json);
            showChart2(json);
        });

    fetch('/highchartFormatter?for=question3')
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
            console.log(json);
            showChart3(json);
        });
    fetch('/highchartFormatter?for=question41')
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
            console.log(json);
            showChart41(json);
        });
     fetch('/highchartFormatter?for=question42')
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
            console.log(json);
            showChart42(json);
        });
    fetch('/highchartFormatter?for=question43')
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
            console.log(json);
            showChart43(json);
        });
    fetch('/highchartFormatter?for=question5')
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
            console.log(json);
            showChart5(json);
        });
    fetch('/highchartFormatter?for=question6')
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
            console.log(json);
            showChart6(json);
        });



</script>


<body onload="showQuestion('table1');">
<a id="tableLink1" onclick="showQuestion('table1');" href="#">Question 1</a>
<a id="tableLink2" onclick="showQuestion('table2');" href="#">Question 2</a>
<a id="tableLink3" onclick="showQuestion('table3');" href="#">Question 3</a>
<a id="tableLink4" onclick="showQuestion('table4');" href="#">Question 4</a>
<a id="tableLink5" onclick="showQuestion('table5');" href="#">Question 5</a>
<a id="tableLink6" onclick="showQuestion('table6');" href="#">Question 6</a>


<table id="table1" class="question hide">
    <tr>
        <td><h1>Question 1</h1></td>
    </tr>

    <tr>
        <td>What is the average total read performance for each of the sites?</td>
    </tr>
    <tr>
        <th>Site</th>
        <th>Average Total Speed</th>
    </tr>
    <c:forEach var="result" items="${data1}">
        <tr>
            <td>${result.site}</td>
            <td><fmt:formatNumber maxFractionDigits="3" value="${result.total}" /></td>

        </tr>
    </c:forEach>
  <tr>  <td><div id="container">
        <div class="row">
            <div class="col-sm-6 col-md-6"></div>
        </div>
    </div>
  </td></tr>
</table>


<table id="table2" class="question hide">
    <tr>
        <td><h1>Question 2</h1></td>
    </tr>
    <tr>
        <td>What is the minimum total create performance for each of the sites?</td>
    </tr>
    <tr>
        <th>Site</th>
        <th>Minimum Total Create Performance</th>
    </tr>
    <c:forEach var="result" items="${data2}">
        <tr>
            <td>${result.site}</td>
            <td>${result.total}</td>
        </tr>
    </c:forEach>
    <tr>  <td><div id="container2">
        <div class="row">
            <div class="col-sm-6 col-md-6"></div>
        </div>
    </div>
    </td></tr>

</table>

<table id="table3" class="question hide">
    <tr>
        <td><h1>Question 3</h1></td>
    </tr>
    <tr>
        <td>What is the maximum total truncate performance for each of the sites?</td>
    </tr>
    <tr>
        <th>Site</th>
        <th>Maximum Total Create Performance</th>
    </tr>
    <c:forEach var="result" items="${data3}">
        <tr>
            <td>${result.site}</td>
            <td>${result.total}</td>
        </tr>
    </c:forEach>
    <tr>  <td><div id="container3">
        <div class="row">
            <div class="col-sm-6 col-md-6"></div>
        </div>
    </div>
    </td></tr>
</table>


<table id="table4" class="question hide">
    <tr>
        <td><h1>Question 4</h1></td>
    </tr>
    <tr>
        <td>At each of the sites, what database nodes have the fastest and slowest average total read performance?</td>
    </tr>
    <tr>
        <th>Site</th>
        <th>Config</th>
        <th>Average Total Speed</th>
        <th>Rank</th>
    </tr>
    <c:forEach var="result" items="${data4}">
        <tr>
            <td>${result.site}</td>
            <td>${result.config}</td>
            <td><fmt:formatNumber maxFractionDigits = "2" value="${result.total}"/></td>
            <td>${result.rank}</td>
        </tr>
    </c:forEach>
    <tr>  <td><div id="container4.1">
        <div class="row">
            <div class="col-sm-6 col-md-6"></div>
        </div>
    </div>
    </td>
    </tr>
    <tr><td><div id="container4.2">
        <div class="row">
            <div class="col-sm-6 col-md-6"></div>
        </div>
    </div>
    </td>
    </tr>
    <tr>  <td><div id="container4.3">
        <div class="row">
            <div class="col-sm-6 col-md-6"></div>
        </div>
    </div>
    </td>
    </tr>
</table>


<table id="table5" class="question hide">
    <tr>
        <td><h1>Question 5</h1></td>
    </tr>
    <tr>
        <td>When was the database the fastest for each site (min total performance)?</td>
    </tr>
    <tr>
        <th>Site</th>
        <th>CreateTime</th>
        <th>Fastest Performance For Each Site</th>
    </tr>
    <c:forEach var="result" items="${data5}">
        <tr>
            <td>${result.site}</td>
            <td> <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${result.createTime}"/></td>
            <td>${result.total}</td>
        </tr>
    </c:forEach>
    <tr>  <td><div id="container5">
        <div class="row">
            <div class="col-sm-6 col-md-6"></div>
        </div>
    </div>
    </td></tr>
</table>


<table id="table6" class="question hide">
    <tr>
        <td><h1>Question 6</h1></td>
    </tr>
    <tr>
        <td>What is the percentage of total read times less than 300 milliseconds for each of the sites?</td>
    </tr>
    <tr>
        <th>Site</th>
        <th>% of Total Read Times < 300 Milliseconds For Each Site?</th>
    </tr>
    <c:forEach var="result" items="${data6}">
        <tr>
            <td id="site6">${result.site}</td>
            <td id="data6"><fmt:formatNumber pattern="##.00%" value="${result.total/100}"/></td>
        </tr>
    </c:forEach>
    <tr>  <td><div id="container6">
        <div class="row">
            <div class="col-sm-6 col-md-6"></div>
        </div>
    </div>
    </td></tr>
</table>

<style>
.hide { display: none; }
</style>



<script>



    function showQuestion(id) {
        var list = document.getElementsByClassName("question");
        for(var i = 0; i < list.length; i++) {
            list[i].classList.add('hide');
        }

        var ele = document.getElementById(id);
        ele.classList.remove('hide');
    }




   function showChart1(data) {
        Highcharts.chart('container', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Average Config Read Speed'
            },

            xAxis: {
                categories: [],
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Site Speed (ms)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.3f} ms</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },

            series: data
        });
    }
    function showChart2(data) {
        Highcharts.chart('container2', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Minimum Config Create Time '
            },

            xAxis: {
                categories: [],
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Site Speed (ms)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.3f} ms</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },

            series: data
        });
    }
    function showChart3(data) {
        Highcharts.chart('container3', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Maxmimum Config Total Create Time'
            },

            xAxis: {
                categories: [],
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Site Speed (ms)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.3f} ms</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },

            series: data
        });
    }

    function showChart41(data) {
    Highcharts.chart('container4.1', {
        chart: {
            type: 'column'
        },
        title: {
            text: "hcanfllive"
        },

        xAxis: {
            categories: [

            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Site Speed (ms)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.3f} ms</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },

        series: data
    });
    }
    function showChart42(data) {
    Highcharts.chart('container4.2', {
        chart: {
            type: 'column'
        },
        title: {
            text: "hcaefladvclive"
        },

        xAxis: {
            categories: [

            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Site Speed (ms)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.3f} ms</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },

        series: data
    });
    }
        function showChart43(data) {
    Highcharts.chart('container4.3', {
        chart: {
            type: 'column'
        },
        title: {
            text: "hcatristaradvclive"
        },

        xAxis: {
            categories: [

            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Site Speed (ms)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.3f} ms</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },

        series: data
    });
        }
            function showChart5(data) {
    Highcharts.chart('container5', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Fastest Individual Total Performance'
        },

        xAxis: {
            categories: [

            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Site Speed (ms)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.3f} ms</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },

        series: data
    });
}

        function showChart6(data) {
            Highcharts.chart('container6', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Percentage of Read Times under 300 milliseconds'
                },

                xAxis: {
                    categories: [],
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Site Speed (ms)'
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.3f} %</b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },

                series: data
            });
        }

</script>

</body>
</html>
